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
            conn = ConectaBanco.conectar();// Abre uma conexão com o banco de dados.
            Statement stmt = conn.createStatement();
            //            String de inserção das informações das seguradoras no banco de dados
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
    
    public Seguradora consultar_Cnpj(Seguradora segu) throws ClassNotFoundException{
 
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Seleciona as informações da Seguradora a partir do CNPJ informado.
            String sql = "SELECT * from seguradoras WHERE cnpj = '" + segu.getCnpj() + "'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            if (rs.next()){
                Seguradora seg = new Seguradora();
                seg.setId_seguradora(rs.getInt("id_seguradora"));
                seg.setNome_seguradora(rs.getString("nome_seguradora"));
                seg.setCnpj(rs.getString("cnpj"));
                seg.setTelefone(rs.getString("telefone"));
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
            
    public boolean excluir(Seguradora segu) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            
            Seguradora buscar = consultar_Cnpj(segu);// A busca recupera o id_seguradora correto para realizar o UPDATE/DELETE.
            if (buscar == null) {
            return false;// não encontrou nada
            }
            //          Apaga uma seguradora a partir do id_seguradora informado.
            String sql = "DELETE FROM seguradoras WHERE id_seguradora =" + buscar.getId_seguradora();
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
            //            Atualiza os dados da seguradora a partir do CNPJ informado.
            String sql = "UPDATE seguradoras SET "
                    + "nome_seguradora='" + segu.getNome_seguradora()
                    + "', cnpj='" + segu.getCnpj()
                    + "', telefone='" + segu.getTelefone()
                    + "', endereco='" + segu.getEndereco()
                    + "' WHERE cnpj= '" + segu.getCnpj() +"'";
            
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
