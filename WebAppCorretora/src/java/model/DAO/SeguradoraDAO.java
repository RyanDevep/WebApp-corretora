/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Seguradora;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class SeguradoraDAO {
    // + cadastrar( Seguradora ): boolean
    public boolean cadastrar( Seguradora segu ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos segurados no banco de dados
            String sql = "INSERT INTO seguradoras (nome_seguradora, cnpj, telefone, endereco) VALUES ('"
                    + segu.getNome_seguradora() + "', '"
                    + segu.getCnpj() + "', '"
                    + segu.getTelefone() + "', '"
                    + segu.getEndereco() + "')";
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
                Seguradora segu = new Seguradora();
                segu.setId_seguradora(rs.getInt("id_seguradora"));
                segu.setNome_seguradora(rs.getString("nome_seguradora"));
                segu.setCnpj(rs.getString("cnpj"));
                segu.setTelefone(rs.getString("telefone"));
                segu.setEndereco(rs.getString("endereco"));
                
                listaSeguradoras.add(segu);
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
            
    public boolean excluir( int id ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            // Excluir seguradora por ID
            String sql = "DELETE FROM seguradoras WHERE id_seguradora=" + id;
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
    
    public boolean alterar( Seguradora segu ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE seguradoras SET "
                    + "nome_seguradora='" + segu.getNome_seguradora()
                    + "', cnpj='" + segu.getCnpj()
                    + "', telefone='" + segu.getTelefone()
                    + "', endereco='" + segu.getEndereco()
                    + "' WHERE id_seguradora=" + segu.getId_seguradora();
            
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
