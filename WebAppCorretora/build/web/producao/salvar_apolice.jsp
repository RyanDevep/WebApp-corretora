<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="model.DAO.ProducaoDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Producao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
    </head>
    <body>
        <h1>Cadastro de Segurados</h1>
        <%
        // Instância do Objeto
        Producao produc = new Producao();
        produc.setId_segurado(Integer.parseInt(request.getParameter("id_segurado")));
        produc.setId_op(Integer.parseInt(request.getParameter("id_op")));
        produc.setId_produto(Integer.parseInt(request.getParameter("id_produto")));
        produc.setVigencia(java.sql.Date.valueOf(request.getParameter("vigencia")));
        produc.setId_seguradora(Integer.parseInt(request.getParameter("id_seguradora")));
        produc.setId_produtor(Integer.parseInt(request.getParameter("id_produtor")));
        produc.setPremio_liquido(Float.parseFloat(request.getParameter("premio_liquido")));
        produc.setPercent_comissao(Float.parseFloat(request.getParameter("percent_comissao")));
        produc.setPl_a_receber(Float.parseFloat(request.getParameter("pl_a_receber")));
        produc.setNum_apolice(request.getParameter("num_apolice"));
        produc.setSituacao(request.getParameter("situacao"));
        produc.setForma_pgto(request.getParameter("forma_pgto"));
      
        //Gravar...
        ProducaoDAO producDAO = new ProducaoDAO();
        if (producDAO.cadastrar(produc)) {
            out.println("<h3>Apólice cadastrada com sucesso!</h3>");
        } else {
            out.println("<h3>Erro: Apólice não pode ser cadastrado!</h3>");
        }
        %>
        <a href="../principal.html">Voltar</a>
    </body>
</html>