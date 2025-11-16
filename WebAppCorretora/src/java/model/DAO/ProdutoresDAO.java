/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Produtores;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class ProdutoresDAO {
    // + cadastrar( Produtores ): boolean
    public boolean cadastrar( Produtores produtor ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos produtores no banco de dados
            String sql = "INSERT INTO produtores(nome_produtor, cpf) VALUES('" + produtor.getNome_produtor() + "', '" + produtor.getCpf()+ "')";
            stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
    
    public List consultar_geral( ) throws ClassNotFoundException{
        List listaProdutores = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Retorna todas os registros da tabela produtores
            String sql = "SELECT * from produtores";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Produtores produtor = new Produtores();
                produtor.setId_produtor(Integer.parseInt(rs.getString("id")));
                produtor.setNome_produtor(rs.getString("nome"));
                produtor.setCpf(rs.getString("cpf"));
                
                listaProdutores.add(produtor);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaProdutores;
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
        
    }   */ 
    
    public Produtores consultar_nome( Produtores p_produtor ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();        
             //           
            String sql = "SELECT * FROM produtores WHERE nome_produtor like '" + p_produtor.getNome_produtor() + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Produtores produtor = new Produtores(); // Instância
                produtor.setId_produtor(Integer.parseInt(rs.getString("id")));
                produtor.setNome_produtor(rs.getString("nome"));
                produtor.setCpf(rs.getString("cpf"));
                
                conn.close();
                return produtor;
            } else {
                conn.close();
                return null;                               
            }
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    } 
    
    public List consultar_nome(String s_nome) throws ClassNotFoundException{
        List listaProdutores = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * from produtores WHERE nome_produtor like '%" + s_nome + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Produtores produtor = new Produtores();
                produtor.setId_produtor(Integer.parseInt(rs.getString("id")));
                produtor.setNome_produtor(rs.getString("nome"));
                produtor.setCpf(rs.getString("cpf"));
                
                listaProdutores.add(produtor);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaProdutores;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public boolean excluirCpf( Produtores produtor ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
                    
            String sql = "DELETE FROM produtores WHERE cpf = " + produtor.getCpf();
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
    
    public boolean alterar( Produtores produtor ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE produtores SET nome_produtor ='" + produtor.getNome_produtor() + "' WHERE cpf='" + produtor.getCpf()+"';";
            
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
