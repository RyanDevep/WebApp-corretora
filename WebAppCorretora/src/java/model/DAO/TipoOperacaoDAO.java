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
            String sql = "INSERT INTO tipoOperacao(tipo) VALUES('" + tipo_op.getTipo() + "')";
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
                tipo_op.setId_tipo(Integer.parseInt(rs.getString("id")));
                tipo_op.setTipo(rs.getString("tipo"));
                
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
    
    /*public Segurados consultar_id( Segurados p_prod ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            SELECT * FROM produtos WHERE pk_id = 3
            String sql = "SELECT * FROM produtos WHERE pk_id = " + p_prod.getId();
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Segurados prod = new Segurados(); // Instância
                prod.setId(Integer.parseInt(rs.getString("pk_id")));
                prod.setNome(rs.getString("nome"));
                prod.setValor(Float.parseFloat(rs.getString("valor")));
                prod.setQtd(Integer.parseInt(rs.getString("qtd")));
                conn.close();
                return prod;
            } else {
                conn.close();
                return null;                               
            }
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }
        
    }  
    
    public Produtos consultar_nome( Produtos p_produto ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();        
             //           
            String sql = "SELECT * FROM produtos WHERE nome_produto like '" + p_produto.getNome_produto() + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Produtos produto = new Produtos(); // Instância
                produto.setId_produto(Integer.parseInt(rs.getString("id")));
                produto.setNome_produto(rs.getString("nome"));
                
                conn.close();
                return produto;
            } else {
                conn.close();
                return null;                               
            }
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    } 
    
    public List consultar_nome(String p_nome) throws ClassNotFoundException{
        List listaProdutos = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * from produtos WHERE nome_produto like '%" + p_nome + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Produtos produto = new Produtos();
                produto.setId_produto(Integer.parseInt(rs.getString("id")));
                produto.setNome_produto(rs.getString("nome"));
                
                listaProdutos.add(produto);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaProdutos;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    */
    public boolean excluirTipoId( TipoOperacao tipo_op ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
                    
            String sql = "DELETE FROM tipoOperacao WHERE id_tipo = " + tipo_op.getId_tipo() + ")";
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
    
    public boolean alterar( TipoOperacao tipo_op ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE tipoOperacao SET tipo ='" + tipo_op.getTipo() + "' WHERE id_tipo= " + tipo_op.getId_tipo() + ")";
            
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
