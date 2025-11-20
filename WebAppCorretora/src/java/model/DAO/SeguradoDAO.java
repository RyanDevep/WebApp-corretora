/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Segurado;
import Config.ConectaBanco;
import java.sql.*;
import java.util.*;

/**
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class SeguradoDAO {
    // + cadastrar( Segurado ): boolean
    public boolean cadastrar( Segurado seg ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos segurados no banco de dados
            String sql = "INSERT INTO segurados(nome, cpf_cnpj, telefone, email, endereco) VALUES('" 
           + seg.getNome() + "', '" 
           + seg.getCpf_cnpj() + "', '" 
           + seg.getTelefone() + "', '" 
           + seg.getEmail() + "', '" 
           + seg.getEndereco() + "')";
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
                Segurado seg = new Segurado();
                seg.setId_segurado(rs.getInt("id_segurado"));
                seg.setNome(rs.getString("nome"));
                seg.setCpf_cnpj(rs.getString("cpf_cnpj"));
                seg.setTelefone(rs.getString("telefone"));
                seg.setEmail(rs.getString("email"));
                seg.setEndereco(rs.getString("endereco"));
                
                listaSegurados.add(seg);
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
    
    public Segurado consultar_id( Segurado s_seg ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * FROM segurados WHERE id_segurado = " + s_seg.getId_segurado();
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Segurado seg = new Segurado(); // Instância
                seg.setId_segurado(rs.getInt("id_segurado"));
                seg.setNome(rs.getString("nome"));
                seg.setCpf_cnpj(rs.getString("cpf_cnpj"));
                seg.setTelefone(rs.getString("telefone"));
                seg.setEmail(rs.getString("email"));
                seg.setEndereco(rs.getString("endereco"));
                conn.close();
                return seg;
            } else {
                conn.close();
                return null;                               
            }
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }
        
    }   
    
    public Segurado consultar_nome( Segurado s_seg ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();        
             //           Consulta por nome (Mais específico)
            String sql = "SELECT * FROM segurados WHERE nome like '" + s_seg.getNome() + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            if(rs.next()){ 
                Segurado segurado = new Segurado(); // Instância
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
    
    public Segurado consultar_CpfCnpj(String cpfCnpj) throws ClassNotFoundException{
 
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "SELECT * from segurados WHERE cpf_cnpj = '" + cpfCnpj + "'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            if (rs.next()){
                Segurado seg = new Segurado();
                seg.setId_segurado(rs.getInt("id_segurado"));
                seg.setNome(rs.getString("nome"));
                seg.setCpf_cnpj(rs.getString("cpf_cnpj"));
                seg.setTelefone(rs.getString("telefone"));
                seg.setEmail(rs.getString("email"));
                seg.setEndereco(rs.getString("endereco"));
                
                return seg;
            } else {
                return null;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public boolean excluirCpfCnpj( Segurado seg ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
                    
            String sql = "DELETE FROM segurados WHERE cpf_cnpj = " + seg.getCpf_cnpj();
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
    
    public boolean alterar( Segurado seg ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE segurados SET nome='" + seg.getNome()
                    + "', telefone='" + seg.getTelefone()
                    + "', email='" + seg.getEmail()
                    + "', endereco='" + seg.getEndereco()
                    + "' WHERE cpf_cnpj= '" + seg.getCpf_cnpj() +"'";
            
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
