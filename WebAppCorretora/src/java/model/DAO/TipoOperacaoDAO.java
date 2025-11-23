/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.TipoOperacao;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class TipoOperacaoDAO {
    // + cadastrar( TipoOperacao ): boolean
    public boolean cadastrar( TipoOperacao tipo_op ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações de tipo no banco de dados
            String sql = "INSERT INTO tipoOperacao (nome_op, status_op, descricao) VALUES ('"
                    + tipo_op.getNome_op() + "', '"
                    + tipo_op.getStatus_op()+ "', '"
                    + tipo_op.getDescricao() + "')";
            stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
    
    public List consultar_geral( ) throws ClassNotFoundException{
        List listaTipos = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Retorna todas os registros da tabela tipoOperacao
            String sql = "SELECT * from tipoOperacao";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                TipoOperacao tipo_op = new TipoOperacao();
                tipo_op.setId_op(rs.getInt("id_op"));
                tipo_op.setNome_op(rs.getString("nome_op"));
                tipo_op.setStatus_op(rs.getString("status_op"));
                tipo_op.setDescricao(rs.getString("descricao"));
                
                listaTipos.add(tipo_op);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaTipos;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }

    public TipoOperacao consultar_tipo(TipoOperacao t_tipo) throws ClassNotFoundException{
 
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * from tipoOperacao WHERE nome_op = '" + t_tipo.getNome_op() + "'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            if (rs.next()){
                TipoOperacao tipo = new TipoOperacao();
                tipo.setId_op(rs.getInt("id_op"));
                tipo.setNome_op(rs.getString("nome_op"));
                tipo.setStatus_op(rs.getString("status_op"));
                tipo.setDescricao(rs.getString("descricao"));
                
                return tipo;
            } else {
                return null;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }

    public boolean excluir(TipoOperacao tipo) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            
            TipoOperacao buscar = consultar_tipo(tipo);
            if (buscar == null) {
            return false;// não encontrou ninguém
            }
                    
            String sql = "DELETE FROM tipoOperacao WHERE id_op =" + buscar.getId_op();
            int result = stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            if (result == 0) {
                return false;
            } else {
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
    }
    
    public boolean alterar( TipoOperacao tipo ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            
            TipoOperacao buscar = consultar_tipo(tipo);
            if (buscar == null) {
            return false;// não encontrou ninguém
            }
            //            
            String sql = "UPDATE tipoOperacao SET nome_op ='" + tipo.getNome_op()
                    + "', status_op ='" + tipo.getStatus_op()
                    + "', descricao ='" + tipo.getDescricao()
                    + "' WHERE id_op = '" + buscar.getId_op() +"'";
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
}
