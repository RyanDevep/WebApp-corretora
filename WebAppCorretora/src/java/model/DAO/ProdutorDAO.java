/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Produtor;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class ProdutorDAO {
    // + cadastrar( Produtor ): boolean
    public boolean cadastrar( Produtor pro ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos produtores no banco de dados
            String sql = "INSERT INTO produtores (nome_produtor, cpf, telefone, email) VALUES ('"
                    + pro.getNome_produtor() + "', '"
                    + pro.getCpf() + "', '"
                    + pro.getTelefone() + "', '"
                    + pro.getEmail() + "')";
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
                Produtor pro = new Produtor();
                pro.setId_produtor(rs.getInt("id_produtor"));
                pro.setNome_produtor(rs.getString("nome_produtor"));
                pro.setCpf(rs.getString("cpf"));
                pro.setTelefone(rs.getString("telefone"));
                pro.setEmail(rs.getString("email"));
                
                listaProdutores.add(pro);
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
    
    public Produtor consultar_cpf( Produtor pro ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * FROM produtores WHERE cpf = '" + pro.getCpf()+"'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Produtor prod = new Produtor(); // Instância
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setNome_produtor(rs.getString("nome_produtor"));
                prod.setCpf(rs.getString("cpf"));
                prod.setTelefone(rs.getString("telefone"));
                prod.setEmail(rs.getString("email"));
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
            
    public boolean excluir_cpf( Produtor pro ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
                    
            String sql = "DELETE FROM produtores WHERE cpf = " + pro.getCpf();
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
    
    public boolean alterar( Produtor pro ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE produtores SET nome_produtor ='" + pro.getNome_produtor() + "' WHERE cpf='" + pro.getCpf()+"';";
            
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
