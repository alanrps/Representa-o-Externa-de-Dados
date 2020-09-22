/**
* Res.java
* Classe Res, ou seja, a resposta para o cliente
* Autores: Lucas Souza Santos & Alan Rodrigo Patriarca 
* Data de Criação: 01/09/2020
* Ultima atualização: 22/09/2020
 */

import java.util.ArrayList;

public class Res{
  String retorno;
  ArrayList<Aluno> alunos = new ArrayList<Aluno>();

  public void setRetorno(String retorno) {
    this.retorno = retorno;
  }

  public void setAlunos(Aluno aluno) {
    this.alunos.add(aluno);
  }
}