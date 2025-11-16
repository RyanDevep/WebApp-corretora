/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/** @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 * Data: 15/11/2025
 */
public class Seguradoras {
    //Atributos
    private int id_seguradora;
    private String cnpj;
    private String nome_seguradora;

    //Métodos
    public int getId_seguradora() {
        return id_seguradora;
    }

    public void setId_seguradora(int id_seguradora) {
        this.id_seguradora = id_seguradora;
    }

    public String getNome_seguradora() {
        return nome_seguradora;
    }

    public void setNome_seguradora(String nome_seguradora) {
        this.nome_seguradora = nome_seguradora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
   
}
