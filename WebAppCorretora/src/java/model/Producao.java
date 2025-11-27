/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
/** @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 * Data: 15/11/2025
 */
public class Producao {
    //atributos
    private int id_producao;
    private int id_segurado;
    private int id_seguradora;
    private int id_produtor;
    private int id_produto;
    private int id_op;
    private String nomeSegurado;
    private String cpf_cnpj;
    private String nomeSeguradora;
    private String nomeProdutor;
    private String nomeProduto;
    private String tipoOperacao;
    private String num_apolice;
    private java.sql.Date vigencia;
    private double premio_liquido;
    private double percent_comissao;
    private double pl_a_receber;
    private String situacao;
    private String forma_pgto;
    
    // getters e setters
    public int getId_producao() {
        return id_producao;
    }

    public void setId_producao(int id_producao) {
        this.id_producao = id_producao;
    }

    public int getId_segurado() {
        return id_segurado;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public void setId_segurado(int id_segurado) {
        this.id_segurado = id_segurado;
    }

    public int getId_seguradora() {
        return id_seguradora;
    }

    public void setId_seguradora(int id_seguradora) {
        this.id_seguradora = id_seguradora;
    }

    public int getId_produtor() {
        return id_produtor;
    }

    public void setId_produtor(int id_produtor) {
        this.id_produtor = id_produtor;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_op() {
        return id_op;
    }

    public void setId_op(int id_op) {
        this.id_op = id_op;
    }

    public String getNum_apolice() {
        return num_apolice;
    }

    public void setNum_apolice(String num_apolice) {
        this.num_apolice = num_apolice;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public double getPremio_liquido() {
        return premio_liquido;
    }

    public void setPremio_liquido(double premio_liquido) {
        this.premio_liquido = premio_liquido;
    }

    public double getPercent_comissao() {
        return percent_comissao;
    }

    public void setPercent_comissao(double percent_comissao) {
        this.percent_comissao = percent_comissao;
    }

    public double getPl_a_receber() {
        return pl_a_receber;
    }

    public void setPl_a_receber(double pl_a_receber) {
        this.pl_a_receber = pl_a_receber;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getForma_pgto() {
        return forma_pgto;
    }

    public void setForma_pgto(String forma_pgto) {
        this.forma_pgto = forma_pgto;
    }

    public String getNomeSegurado() {
        return nomeSegurado;
    }

    public void setNomeSegurado(String nomeSegurado) {
        this.nomeSegurado = nomeSegurado;
    }

    public String getNomeSeguradora() {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getNomeProdutor() {
        return nomeProdutor;
    }

    public void setNomeProdutor(String nomeProdutor) {
        this.nomeProdutor = nomeProdutor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }
    
    
}
