'''
clientJson.py
* Cliente TCP de um serviço de gerenciamento de notas de alunos usando Json
* Autores: Lucas Souza Santos & Alan Rodrigo Patriarca 
* Data de Criação: 01/09/2020
* Ultima atualização: 22/09/2020
'''

import socket 
import sys
import jsonpickle

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(("localhost", 7000))

class Req:
    def __init__(self, opCode = "", RA = -1, nota = -1, discCode = "", ano = -1, semestre = -1):
        self.opCode = opCode
        self.nota = nota
        self.RA = RA
        self.discCode = discCode
        self.ano = ano
        self.semestre = semestre

print("[addNota] Adiciona nota a um aluno")
print("[rmNota] Remove a nota de um aluno")
print("[listAlunos] Lista os alunos de uma disciplina em um ano/semestre\n")

while(True):
  opCode = input("Que operação deseja fazer? > ")
  if (opCode == "addNota"):
    RA = input("RA do aluno > ")
    discCode = input("Disciplina > ")
    ano = input("Ano > ")
    semestre = input("Semestre > ")
    nota = input("Nota > ")
    # Preencher a estrutura
    req = Req(opCode , RA = int(RA), nota = float(nota), discCode = str(discCode), ano = int(ano), semestre = int(semestre))

  elif (opCode == "rmNota"):
    RA = input("RA do aluno > ")
    discCode = input("Disciplina > ")
    ano = input("Ano > ")
    semestre = input("Semestre > ")

    # Preencher a estrutura
    req = Req(opCode , RA = int(RA), discCode = str(discCode), ano = int(ano), semestre = int(semestre))

  elif (opCode == "listAlunos"):
    discCode = input("Codigo da disciplina > ")
    ano = input("Ano > ")
    semestre = input("semestre > ")

    # Preencher a estrutura
    req = Req(opCode, discCode = str(discCode), ano = int(ano), semestre = int(semestre))

  elif (opCode == "exit"):
    break
  else:
    continue

  # Codifica o objeto Req para Json
  msg = jsonpickle.encode(req)
  size = len(msg)

  # Enviando
  client_socket.sendall((str(size) + "\n").encode()) 
  client_socket.sendall(bytes(msg,encoding="utf-8"))

  # Recebendo tamanho da resposta
  receive = client_socket.recv(1024)
  bufferSize = int((receive.decode()).split(" ")[0]) 
  
  # Recebendo resposta
  response = client_socket.recv(bufferSize)  

  # Decodifica a mensagem codificada em UTF-8
  response = response.decode(encoding='UTF-8')
  
  # Converte o Json em um dicionário
  res = jsonpickle.decode(response)

  if (res['retorno'] == "1"):
    if (opCode == "listAlunos"):
      for aluno in res['alunos']:
        print("\nRA:", aluno['RA'])
        print("Nome:", aluno['nome'])
        print("Periodo:", aluno['periodo'])
        print("Nota:", aluno['nota'])
        print("Faltas:", aluno['faltas'])
        print("--------------------")
    else:
      print("Operação realizada com sucesso")
  else:
    print(res['retorno'])

client_socket.close()