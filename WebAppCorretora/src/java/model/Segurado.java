/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/** @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 * Data: 15/11/2025
 */
public class Segurado {
    private int id_segurado;
    private String nome;
    private String cpf_cnpj;
    private String telefone;
    private String email;
    private String endereco;

    // getters e setters
    public int getId_segurado() {
        return id_segurado;
    }

    public void setId_segurado(int id_segurado) {
        this.id_segurado = id_segurado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
