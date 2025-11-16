/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/** @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 * Data: 15/11/2025
 */
public class Produtores {
    //Atributos
    private int id_produtor;
    private String cpf;
    private String nome_produtor;

    //Métodos

    public int getId_produtor() {
        return id_produtor;
    }

    public void setId_produtor(int id_produtor) {
        this.id_produtor = id_produtor;
    }

    public String getNome_produtor() {
        return nome_produtor;
    }

    public void setNome_produtor(String nome_produtor) {
        this.nome_produtor = nome_produtor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
}
