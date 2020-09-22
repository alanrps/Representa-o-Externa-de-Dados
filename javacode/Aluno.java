/**
* Aluno.java
* Classe Aluno
* Autores: Lucas Souza Santos & Alan Rodrigo Patriarca 
* Data de Criação: 01/09/2020
* Ultima atualização: 22/09/2020
 */

public class Aluno {
  private Integer RA;
  private String nome;
  private Integer periodo;
  private float nota;
  private Integer faltas;

  public Integer getRA() {
    return RA;
  }

  public Integer getFaltas() {
    return faltas;
  }

  public void setFaltas(Integer faltas) {
    this.faltas = faltas;
  }

  public float getNota() {
    return nota;
  }

  public void setNota(float nota) {
    this.nota = nota;
  }

  public Integer getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Integer periodo) {
    this.periodo = periodo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setRA(Integer rA) {
    this.RA = rA;
  }
}