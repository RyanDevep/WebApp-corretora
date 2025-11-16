/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Seguradoras;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class SeguradorasDAO {
    // + cadastrar( Seguradoras ): boolean
    public boolean cadastrar( Seguradoras seguradora ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos segurados no banco de dados
            String sql = "INSERT INTO seguradoras(nome, cnpj) VALUES('" + seguradora.getNome_seguradora() + "', '" + seguradora.getCnpj()+ "')";
            stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
    
    public List consultar_geral( ) throws ClassNotFoundException{
        List listaSeguradoras = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Retorna todas os registros da tabela segurados
            String sql = "SELECT * from seguradoras";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Seguradoras seguradora = new Seguradoras();
                seguradora.setId_seguradora(Integer.parseInt(rs.getString("id")));
                seguradora.setNome_seguradora(rs.getString("nome"));
                seguradora.setCnpj(rs.getString("cnpj"));
                
                listaSeguradoras.add(seguradora);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaSeguradoras;
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
    
    public Seguradoras consultar_nome( Seguradoras s_seguradora ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();        
             //           
            String sql = "SELECT * FROM seguradoras WHERE nome_seguradora like '" + s_seguradora.getNome_seguradora()+ "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Seguradoras seguradora = new Seguradoras(); // Instância
                seguradora.setId_seguradora(Integer.parseInt(rs.getString("id")));
                seguradora.setNome_seguradora(rs.getString("nome"));
                seguradora.setCnpj(rs.getString("cnpj"));
                
                conn.close();
                return seguradora;
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
        List listaSeguradoras = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * from segurados WHERE nome_seguradora like '%" + s_nome + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Seguradoras seguradora = new Seguradoras();
                seguradora.setId_seguradora(Integer.parseInt(rs.getString("id")));
                seguradora.setNome_seguradora(rs.getString("nome"));
                seguradora.setCnpj(rs.getString("cnpj"));
                
                listaSeguradoras.add(seguradora);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaSeguradoras;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public boolean excluirCnpj( Seguradoras seguradora ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
                    
            String sql = "DELETE FROM seguradoras WHERE cnpj = " + seguradora.getCnpj();
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
    
    public boolean alterar( Seguradoras seguradora ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE seguradoras SET nome_seguradora ='" + seguradora.getNome_seguradora() + "' WHERE cnpj='" + seguradora.getCnpj()+"';";
            
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
