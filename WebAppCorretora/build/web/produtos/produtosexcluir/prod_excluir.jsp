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
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <div class="container">
        <%
            // Instância do Objeto
            Produto prod = new Produto();
            
            // Atrib. valores ao obj
            prod.setTipo_seguro(request.getParameter("tipo_seguro"));
           
            
            //Excluir...
            ProdutoDAO prodDAO = new ProdutoDAO();
            if (prodDAO.excluir(prod)){
                out.println("Produto excluído com sucesso!");
            }else{
                out.println("Produto não excluído!");
            }
        %>
        </div>
        <div class="botao">
            <a href="../produtoscadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
