package org.openjfx;

public class Produto {
    private Integer codigo, quantidade;
    private String nome;
    private String tamanho;
    private Double custoProd, varejo, atacado;

    public Produto(Integer codigo, String nome, String tamanho, int quantidade, double custoProd, double varejo, double atacado){
        this.codigo = codigo;
        this.nome = nome;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.custoProd = custoProd;
        this.varejo = varejo;
        this.atacado = atacado;
    }

    public String getCodigo() {
        return codigo.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getCustoProd() {
        return custoProd;
    }

    public double getVarejo() {
        return varejo;
    }

    public double getAtacado() {
        return atacado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCustoProd(double custoProd) {
        this.custoProd = custoProd;
    }

    public void setVarejo(double varejo) {
        this.varejo = varejo;
    }

    public void setAtacado(double atacado) {
        this.atacado = atacado;
    }
}
