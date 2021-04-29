package com.uel.ZZCommerce.model;

public class Pesquisa {
    private String pesquisa;

    private Integer idProduto;
    private String nomeProduto;
    private Double precoProduto;
    private Integer quantidadeProduto;
    private Integer idAnuncianteProduto;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Integer getIdAnuncianteProduto() {
        return idAnuncianteProduto;
    }

    public void setIdAnuncianteProduto(Integer idAnuncianteProduto) {
        this.idAnuncianteProduto = idAnuncianteProduto;
    }
}
