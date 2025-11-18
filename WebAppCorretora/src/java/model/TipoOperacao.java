/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/** @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 * Data: 15/11/2025
 */
public class TipoOperacao {
    private int id_op;
    private String nome_op;
    private String status_op;
    private String descricao;
    
    // getters e setters
    public int getId_op() {
        return id_op;
    }

    public void setId_op(int id_op) {
        this.id_op = id_op;
    }

    public String getNome_op() {
        return nome_op;
    }

    public void setNome_op(String nome_op) {
        this.nome_op = nome_op;
    }

    public String getStatus_op() {
        return status_op;
    }

    public void setStatus_op(String status_op) {
        this.status_op = status_op;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
