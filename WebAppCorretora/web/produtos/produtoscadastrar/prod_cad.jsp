<%-- 
    Document   : Controle de Produtos
    Created on : 8 de set. de 2025, 21:08:37
    Author     : Adilson Lima
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Produtos"%>
<%@page import="model.DAO.ProdutosDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Produtos</title>
    </head>
    <body>
        <h1>Cadastro de Produtos</h1>
        <%
            // Instância do Objeto
            Produtos produto = new Produtos();
            
            // Atrib. valores ao obj
            produto.setNome_produto(request.getParameter("nome"));            
            //Gravar...
            ProdutosDAO prodDAO = new ProdutosDAO();
            if (prodDAO.cadastrar(produto)){
                out.println("Produto inserido com sucesso!");
                //Saída
                out.println("<br> <b>Produto......: </b>" + produto.getNome_produto());
            }else{
                out.println("Produto não inserido!");
            }
        %>
        
    </body>
</html>
