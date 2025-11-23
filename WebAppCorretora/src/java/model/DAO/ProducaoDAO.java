/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import model.Producao;
import Config.ConectaBanco;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
 */
public class ProducaoDAO {
        // + cadastrar( Produto ): boolean
    public boolean cadastrar( Producao produ ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            String de inserção das informações da Produção no banco de dados
            String sql = "INSERT INTO producao (" +
                    "id_segurado, id_seguradora, id_produtor, id_produto, id_op, " +
                    "num_apolice, vigencia, premio_liquido, percent_comissao, pl_a_receber, " +
                    "situacao, forma_pgto" +
                    ") VALUES (" +
                    produ.getId_segurado() + ", " +
                    produ.getId_seguradora() + ", " +
                    produ.getId_produtor() + ", " +
                    produ.getId_produto() + ", " +
                    produ.getId_op() + ", '" +
                    produ.getNum_apolice() + "', '" +
                    produ.getVigencia() + "', " +
                    produ.getPremio_liquido() + ", " +
                    produ.getPercent_comissao() + ", " +
                    produ.getPl_a_receber() + ", '" +
                    produ.getSituacao() + "', '" +
                    produ.getForma_pgto() + "'" +
                    ")";
            stmt.executeUpdate(sql); // GO - RUN -> INSERT, UPDATE, DELETE
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }
        return true;
    }
    
    public List consultar_geral( ) throws ClassNotFoundException{
        List listaProducao = new ArrayList();
        
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Retorna todas os registros da tabela producao
            String sql = "SELECT * FROM produtos";
            ResultSet rs = stmt.executeQuery(sql); // SELECT
            
            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));
                
                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();
            
            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public List consultar_segurado(String cpfCnpj) throws ClassNotFoundException{
        List listaProducao = new ArrayList();

        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Consulta da producao pelo CPF/CNPJ do segurado
            String sql = "SELECT p.* FROM producao p JOIN segurado s ON p.id_segurado = s.id_segurado WHERE s.cpf_cnpj LIKE '" + cpfCnpj + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));

                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();

            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public List consultar_produto(String nomeProduto) throws ClassNotFoundException{
        List listaProducao = new ArrayList();

        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Consulta da Producao pelo nome do Produto.
            String sql = "SELECT p.* FROM producao p JOIN produtos prod ON p.id_produto = prod.id_produto WHERE prod.nome_produto LIKE '" + nomeProduto + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));

                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();

            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public List consultar_produtor(String nomeProdutor) throws ClassNotFoundException{
        List listaProducao = new ArrayList();

        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Consulta da Producao pelo nome do Produtor.
            String sql = "SELECT p.* FROM producao p JOIN produtor prod ON p.id_produtor = prod.id_produtor WHERE prod.nome LIKE '" + nomeProdutor + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));

                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();

            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public List consultar_seguradora(String nomeSeguradora) throws ClassNotFoundException{
        List listaProducao = new ArrayList();

        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Consulta da Producao pelo nome do Produtor.
            String sql = "SELECT p.* FROM producao p JOIN seguradora s ON p.id_seguradora = s.id_seguradora WHERE s.nome LIKE '" + nomeSeguradora + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));

                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();

            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public List consultar_situacao(String situacao) throws ClassNotFoundException{
        List listaProducao = new ArrayList();

        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Consulta da Producao pela situação.
            String sql = "SELECT * FROM producao WHERE situacao LIKE '" + situacao + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));

                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();

            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }
    
    public List consultar_vigencia(String vigencia) throws ClassNotFoundException{
        List listaProducao = new ArrayList();

        Connection conn = null;
        try{
            conn = ConectaBanco.conectar();
            Statement stmt = conn.createStatement();
            //            Consulta da Producao pela vigencia.
            String sql = "SELECT * FROM producao WHERE vigencia LIKE '" + vigencia + "%'";
            ResultSet rs = stmt.executeQuery(sql); // SELECT

            int n_reg = 0;
            while (rs.next()){
                Producao prod = new Producao();
                prod.setId_producao(rs.getInt("id_producao"));
                prod.setId_segurado(rs.getInt("id_segurado"));
                prod.setId_seguradora(rs.getInt("id_seguradora"));
                prod.setId_produtor(rs.getInt("id_produtor"));
                prod.setId_produto(rs.getInt("id_produto"));
                prod.setId_op(rs.getInt("id_op"));
                prod.setNum_apolice(rs.getString("num_apolice"));
                prod.setVigencia(rs.getDate("vigencia"));
                prod.setPremio_liquido(rs.getFloat("premio_liquido"));
                prod.setPercent_comissao(rs.getFloat("percent_comissao"));
                prod.setPl_a_receber(rs.getFloat("pl_a_receber"));
                prod.setSituacao(rs.getString("situacao"));
                prod.setForma_pgto(rs.getString("forma_pgto"));

                listaProducao.add(prod);
                n_reg++;
            }
            conn.close();

            if (n_reg == 0){
                return null;
            }else{
                return listaProducao;
            }                                   
        }catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return null;
        }        
    }

}


