
/**
* ServidorTcpJson.java
* Servidor TCP de um serviço de gerenciamento de notas de alunos usando Json
* Autores: Lucas Souza Santos & Alan Rodrigo Patriarca 
* Data de Criação: 01/09/2020
* Ultima atualização: 22/09/2020
 */

import com.google.gson.*;
import java.net.*;
import java.io.*;
import java.sql.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ServidorTcpJson {
  static Connection dbConnection;
  private static Charset UTF8_CHARSET = Charset.forName("UTF-8");
  public static void main(String args[]) {
    // Conexao com banco de dados
    dbConnection = SQLiteJDBCDriverConnection.connect();

    try {
      int serverPort = 7000;
      ServerSocket listenSocket = new ServerSocket(serverPort);

      Socket clientSocket = listenSocket.accept();
      while (true) {
        DataInputStream inClient = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream outClient = new DataOutputStream(clientSocket.getOutputStream());

        /* Recebe a mensagem */
        String valueStr = inClient.readLine();
        int sizeBuffer = Integer.valueOf(valueStr);
        byte[] buffer = new byte[sizeBuffer];
        inClient.read(buffer);

        /* realiza o unmarshalling */
        String decode = new String(buffer, UTF8_CHARSET);

        /* Instância classe Gson */
        Gson gson = new Gson();

        /* Faz a conversão de Json para Req */
        Req req = gson.fromJson(decode, Req.class);

        String opCode = req.getOpCode();

        /* Instancia a resposta */
        Res res = new Res();

        /* Chama a funcionalidade de acordo com o opCode */
        switch (opCode) {
          case "addNota":
            Functionalities.addNotaForJson(req, res, dbConnection);
            break;

          case "rmNota":
            Functionalities.rmNotaForJson(req, res, dbConnection);
            break;

          case "listAlunos":
            Functionalities.listAlunosForJson(req, res, dbConnection);
            break;

          default:
            res.setRetorno("opCode invalido!");
            break;
        }

        /* Formata a resposta para Json */
          String msg = gson.toJson(res);

          /*  Codifica a mensagem para UTF8 */
          byte [] msgEncode = msg.getBytes("UTF8");
  
          /* Manda tamanho da resposta */
          String msgSize = String.valueOf(msgEncode.length) + " \n";
          byte[] size = msgSize.getBytes();
          outClient.write(size);
   
          /* Manda resposta */
          outClient.write(msgEncode);

      } // while
    } catch (IOException e) {
      System.out.println("Listen_Socket:" + e.getMessage());
    } // catch
  } // main
} //class
