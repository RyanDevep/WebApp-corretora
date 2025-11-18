/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Produto;
import Config.ConectaBanco;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class ProdutoDAO {
    // + cadastrar( Produto ): boolean
    public boolean cadastrar( Produto prod ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações dos produtos no banco de dados
            String sql = "INSERT INTO produtos (tipo_seguro, descricao, cobertura) VALUES ('"
                    + prod.getTipo_seguro() + "', '"
                    + prod.getDescricao() + "', '"
                    + prod.getCobertura() + "')";
            stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
    
    public List consultar_geral( ) throws ClassNotFoundException{
        List listaProdutos = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Retorna todas os registros da tabela produtos
            String sql = "SELECT * FROM produtos";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Produto prod = new Produto();
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setTipo_seguro(rs.getString("tipo_seguro"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setCobertura(rs.getString("cobertura"));
                
                listaProdutos.add(prod);
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

    public boolean excluir( int id ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //        Recebe o id e concatena na String para concluir o delete
            String sql = "DELETE FROM produtos WHERE id_produto =" + id;
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
    
    public boolean alterar( Produto pro ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            
            String sql = "UPDATE produtos SET "
                    + "tipo_seguro='" + pro.getTipo_seguro()
                    + "', descricao='" + pro.getDescricao()
                    + "', cobertura='" + pro.getCobertura()
                    + "' WHERE id_produto=" + pro.getId_produto();
            
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
