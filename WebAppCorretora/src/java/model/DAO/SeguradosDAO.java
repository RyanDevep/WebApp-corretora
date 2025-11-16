/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Segurados;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class SeguradosDAO {
    // + cadastrar( Segurados ): boolean
    public boolean cadastrar( Segurados segurado ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos segurados no banco de dados
            String sql = "INSERT INTO segurados(nome, cpf_cnpj) VALUES('" + segurado.getNome() + "', '" + segurado.getCpf_cnpj()+ "')";
            stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
    
    public List consultar_geral( ) throws ClassNotFoundException{
        List listaSegurados = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Retorna todas os registros da tabela segurados
            String sql = "SELECT * from segurados";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Segurados segurado = new Segurados();
                segurado.setId_segurado(Integer.parseInt(rs.getString("id")));
                segurado.setNome(rs.getString("nome"));
                segurado.setCpf_cnpj(rs.getString("cpf_cnpj"));
                
                listaSegurados.add(segurado);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaSegurados;
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
    
    public Segurados consultar_nome( Segurados s_segurado ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();        
             //           SELECT * FROM produtos WHERE nome like 'Mou%'
            String sql = "SELECT * FROM segurados WHERE nome like '" + s_segurado.getNome() + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Segurados segurado = new Segurados(); // Instância
                segurado.setId_segurado(Integer.parseInt(rs.getString("id")));
                segurado.setNome(rs.getString("nome"));
                segurado.setCpf_cnpj(rs.getString("cpf_cnpj"));
                
                conn.close();
                return segurado;
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
        List listaSegurados = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * from segurados WHERE nome like '%" + s_nome + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Segurados segurado = new Segurados();
                segurado.setId_segurado(Integer.parseInt(rs.getString("id")));
                segurado.setNome(rs.getString("nome"));
                segurado.setCpf_cnpj(rs.getString("cpf_cnpj"));
                
                listaSegurados.add(segurado);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaSegurados;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public boolean excluirCpfCnpj( Segurados segurado ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
                    
            String sql = "DELETE FROM segurados WHERE cpf_cnpj = " + segurado.getCpf_cnpj();
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
    
    public boolean alterar( Segurados segurado ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            UPDATE produtos SET nome = 'Mouse Microsoft', valor = 250.75, qtd = 50 WHERE pk_id = 1;
            String sql = "UPDATE segurados SET nome ='" + segurado.getNome() + "' WHERE cpf_cnpj='" + segurado.getCpf_cnpj()+"';";
            
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
