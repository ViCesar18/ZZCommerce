package com.uel.ZZCommerce.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contato implements Serializable {
  private int id;
  private String nome;
  private String apelido;
  private String empresa;
  private String endereco;
  private String bairro;
  private String cidade;
  private String telefone1;
  private String telefone2;
  private String observacao;
  private int cliente;
  private String username;
  private String password;

  public Contato() {}

  public Contato(
      String username,
      String password,
      String nome,
      String apelido,
      String empresa,
      String endereco,
      String bairro,
      String cidade,
      String telefone1,
      String telefone2,
      String observacao) {
    this.username = username;
    this.password = password;
    this.nome = nome;
    this.apelido = apelido;
    this.empresa = empresa;
    this.endereco = endereco;
    this.bairro = bairro;
    this.cidade = cidade;
    this.telefone1 = telefone1;
    this.telefone2 = telefone2;
    this.observacao = observacao;
  }

  public Contato(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getTelefone1() {
    return telefone1;
  }

  public void setTelefone1(String telefone1) {
    this.telefone1 = telefone1;
  }

  public String getTelefone2() {
    return telefone2;
  }

  public void setTelefone2(String telefone2) {
    this.telefone2 = telefone2;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public int getCliente() {
    return cliente;
  }

  public void setCliente(int i) {
    this.cliente = i;
  }

  @Override
  public boolean equals(Object obj) {
    Contato p = ((Contato) obj);
    if (p.id == this.id) {
      return true;
    }
    return false;
  }
}
