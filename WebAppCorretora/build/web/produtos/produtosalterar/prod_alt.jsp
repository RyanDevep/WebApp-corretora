<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Produto"%>
<%@page import="model.DAO.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../style_geral/sucesso.css"/>
        <title>Controle</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <div class="container">
        <%
            // Instância do Objeto
            Produto prod = new Produto();
            
            // Atrib. valores ao objeto           
            prod.setTipo_seguro( request.getParameter("tipo_seguro"));
            prod.setDescricao( request.getParameter("descricao"));
            prod.setCobertura( request.getParameter("cobertura"));
            
            //Gravar...
            ProdutoDAO proDAO = new ProdutoDAO();
            if (proDAO.alterar(prod)){
                out.println("Produto alterado com sucesso!");
                //Saída
                out.println("<br> <b>Produto___: </b>" + prod.getTipo_seguro());
                out.println("<br> <b>Descricao_: </b>" + prod.getDescricao());
                out.println("<br> <b>Cobertura_: </b>" + prod.getCobertura());
            }else{
                out.println("Produto não alterado!");
            }
        %>
        </div>
        <div class="botao">
            <a href="../produtoscadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
