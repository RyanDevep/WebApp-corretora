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
            conn = ConectaBanco.conectar();// Abre uma conexão com o banco de dados.
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
            //            Retorna todas os registros da tabela produtores.
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
    
    public Produtor consultar_Cpf(Produtor prod) throws ClassNotFoundException{
 
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Seleciona um Produtor a partir do CPF informado.
            String sql = "SELECT * from produtores WHERE cpf = '" + prod.getCpf() + "'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            if (rs.next()){
                Produtor pro = new Produtor(); // Instância do ojeto.
                pro.setId_produtor(rs.getInt("id_produtor"));
                pro.setNome_produtor(rs.getString("nome_produtor"));
                pro.setCpf(rs.getString("cpf"));
                pro.setTelefone(rs.getString("telefone"));
                pro.setEmail(rs.getString("email"));
                
                return pro;
            } else {
                return null;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }  
            
    public boolean excluir(Produtor pro) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            
            Produtor buscar = consultar_Cpf(pro); // A busca recupera o id_produtor correto para realizar o UPDATE/DELETE.
            if (buscar == null) {
            return false;// não encontrou ninguém
            }
                    //      Apaga o produtor a partir do id_produtor informado
            String sql = "DELETE FROM produtores WHERE id_produtor =" + buscar.getId_produtor();
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
            //            Atualiza os dados do produtor a partir do CPF informado.
            String sql = "UPDATE produtores SET nome_produtor='" + pro.getNome_produtor()
                    + "', telefone='" + pro.getTelefone()
                    + "', email='" + pro.getEmail()
                    + "' WHERE cpf = '" + pro.getCpf() +"'";
            
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
