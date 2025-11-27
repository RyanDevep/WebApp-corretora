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
        // + cadastrar( Producao ): boolean
    public boolean cadastrar( Producao produ ) throws ClassNotFoundException{    
        Connection conn = null;
        try{
            conn = ConectaBanco.conectar(); // Abre uma conexão com o banco de dados.
            Statement stmt = conn.createStatement();
            //            String de inserção das informações da Produção no banco de dados.
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
    
    public List consultar_geral() throws ClassNotFoundException {
    List listaProducao = new ArrayList();

    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
        // SELECT utilizando JOIN para captar todas as informações relacionadas na tabela de lançamento.
        String sql =
            "SELECT p.*, s.nome AS nome_segurado, s.cpf_cnpj, " +
            "se.nome_seguradora, pr.tipo_seguro, " +
            "prod.nome_produtor, op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op";
        ResultSet rs = stmt.executeQuery(sql);
        int n_reg = 0;
        while (rs.next()) {
            Producao prod = new Producao(); // instância objt. (prod)
            // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
            // Campos relacionados
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));
            listaProducao.add(prod); // listaProducao recebe dados do (prod)
            n_reg++;
        }
        conn.close();
        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}

    public List consultar_cpf_cnpj(String cpf_cnpj) throws ClassNotFoundException {
    List listaProducao = new ArrayList();
    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
            // SELECT com JOIN para buscar as apólices relacionadas ao(CPF/CNPJ) informados.
        String sql =
            "SELECT p.*,s.nome AS nome_segurado, " +
            "s.cpf_cnpj, se.nome_seguradora, " +
            "pr.tipo_seguro,prod.nome_produtor,op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op " +
            "WHERE s.cpf_cnpj = '" + cpf_cnpj + "'"; 
        ResultSet rs = stmt.executeQuery(sql);

        int n_reg = 0;
        while (rs.next()) { 
            Producao prod = new Producao();
            // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
            // Campos relacionados
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));
            listaProducao.add(prod);
            n_reg++;
        }
        conn.close();

        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}
    
    public List consultar_produto(String tipo_seguro) throws ClassNotFoundException {
    List listaProducao = new ArrayList();
    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
        String sql = // SELECT com JOIN para buscar as apólices relacionadas ao (Produto) informado.
            "SELECT p.*, s.nome AS nome_segurado, " +
            "s.cpf_cnpj,se.nome_seguradora, " +
            "pr.tipo_seguro,prod.nome_produtor, " +
            "op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op " +
            "WHERE pr.tipo_seguro LIKE '" + tipo_seguro + "%'";
        ResultSet rs = stmt.executeQuery(sql);

        int n_reg = 0;
        while (rs.next()) {
            Producao prod = new Producao();
            // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
            // Campos relacionados
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));
            listaProducao.add(prod);
            n_reg++;
        }
        conn.close();
        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}
    
    public List consultar_seguradora(String seguradora) throws ClassNotFoundException {
    List listaProducao = new ArrayList();
    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
        // SELECT com JOIN para buscar as apólices relacionadas a (Seguradora) informada.
        String sql =
            "SELECT p.*,s.nome AS nome_segurado, " +
            "s.cpf_cnpj,se.nome_seguradora, " +
            "pr.tipo_seguro,prod.nome_produtor, " +
            "op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op " +
            "WHERE se.nome_seguradora LIKE '" + seguradora + "%'";
        ResultSet rs = stmt.executeQuery(sql);
        
        int n_reg = 0;
        while (rs.next()) {
            Producao prod = new Producao();
            // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
            // Campos relacionados
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));
            listaProducao.add(prod);
            n_reg++;
        }
        conn.close();
        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}
    
    public List consultar_produtor(String produtor) throws ClassNotFoundException {
    List listaProducao = new ArrayList();
    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
        String sql = // SELECT com JOIN para buscar as apólices relacionadas ao (Produtor) informado.
            "SELECT p.*, s.nome AS nome_segurado, " +
            "s.cpf_cnpj,se.nome_seguradora, " +
            "pr.tipo_seguro, prod.nome_produtor, " +
            "op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op " +
            "WHERE prod.nome_produtor LIKE '" + produtor + "%'";
        ResultSet rs = stmt.executeQuery(sql);

        int n_reg = 0;
        while (rs.next()) {
            Producao prod = new Producao();
            // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
            // Campos relacionados
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));

            listaProducao.add(prod);
            n_reg++;
        }

        conn.close();
        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}

    public List consultar_situacao(String situacao) throws ClassNotFoundException {
    List listaProducao = new ArrayList();
    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
        // SELECT com JOIN para buscar as apólices relacionadas a (situação) informada.
        String sql =
            "SELECT p.*, s.nome AS nome_segurado, " +
            "s.cpf_cnpj,se.nome_seguradora, " +
            "pr.tipo_seguro,prod.nome_produtor, " +
            "op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op " +
            "WHERE p.situacao LIKE '" + situacao + "%'";
        ResultSet rs = stmt.executeQuery(sql);

        int n_reg = 0;
        while (rs.next()) {
            Producao prod = new Producao();
            // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
            // Campos relacionados
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));
            listaProducao.add(prod);
            n_reg++;
        }

        conn.close();
        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}
    
    public List consultar_vigencia(String vigencia) throws ClassNotFoundException {
    List listaProducao = new ArrayList();
    Connection conn = null;
    try {
        conn = ConectaBanco.conectar();
        Statement stmt = conn.createStatement();
            // SELECT com JOIN para buscar as apólices relacionadas a (vigência) informada.
        String sql =
            "SELECT p.*,s.nome AS nome_segurado, " +
            "s.cpf_cnpj,se.nome_seguradora, " +
            "pr.tipo_seguro,prod.nome_produtor, " +
            "op.nome_op FROM producao p " +
            "JOIN segurados s ON p.id_segurado = s.id_segurado " +
            "JOIN seguradoras se ON p.id_seguradora = se.id_seguradora " +
            "JOIN produtos pr ON p.id_produto = pr.id_produto " +
            "JOIN produtores prod ON p.id_produtor = prod.id_produtor " +
            "JOIN tipoOperacao op ON p.id_op = op.id_op " +
            "WHERE p.vigencia = '" + vigencia + "'";
        ResultSet rs = stmt.executeQuery(sql);

        int n_reg = 0;
        while (rs.next()) {
            Producao prod = new Producao();
             // Campos da tabela producao
            prod.setId_producao(rs.getInt("id_producao"));
            prod.setNum_apolice(rs.getString("num_apolice"));
            prod.setVigencia(rs.getDate("vigencia"));
            prod.setPremio_liquido(rs.getDouble("premio_liquido"));
            prod.setPercent_comissao(rs.getDouble("percent_comissao"));
            prod.setPl_a_receber(rs.getDouble("pl_a_receber"));
            prod.setSituacao(rs.getString("situacao"));
            prod.setForma_pgto(rs.getString("forma_pgto"));
             // Campos da tabela producao
            prod.setNomeSegurado(rs.getString("nome_segurado"));
            prod.setCpf_cnpj(rs.getString("cpf_cnpj"));
            prod.setNomeSeguradora(rs.getString("nome_seguradora"));
            prod.setNomeProdutor(rs.getString("nome_produtor"));
            prod.setNomeProduto(rs.getString("tipo_seguro"));
            prod.setTipoOperacao(rs.getString("nome_op"));
            listaProducao.add(prod);
            n_reg++;
        }
        conn.close();
        return (n_reg == 0) ? null : listaProducao;

    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    }
}



}


