/**
* Req.java
* Classe Req, ou seja, a classe requisição
* Autores: Lucas Souza Santos & Alan Rodrigo Patriarca 
* Data de Criação: 01/09/2020
* Ultima atualização: 22/09/2020
 */

public class Req{
  private String opCode;
  private Integer RA;
  private Integer nota;
  private String discCode;
  private String nome;
  private Integer ano;
  private Integer semestre;

  public Integer getSemestre() {
    return semestre;
  }

  public void setSemestre(Integer semestre) {
    this.semestre = semestre;
  }

  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }
  
  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }
  
  public String getDiscCode() {
    return discCode;
  }
  
  public void setDiscCode(String discCode) {
    this.discCode = discCode;
  }
  
  public Integer getRA() {
    return RA;
  }
  
  public void setRA(Integer RA) {
    this.RA = RA;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getOpCode() {
    return opCode;
  }
  
  public void setOpCode(String opCode) {
    this.opCode = opCode;
  }
}