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
        <h1>Excluir Produtos</h1>
        <%
            // Instância do Objeto
            Produtos prod = new Produtos();
            
            // Atrib. valores ao obj
            prod.setNome_produto(request.getParameter("produto"));
           
            
            //Excluir...
            ProdutosDAO prodDAO = new ProdutosDAO();
            if (prodDAO.excluirProduto(prod)){
                out.println("Produto excluído com sucesso!");
            }else{
                out.println("Produto não excluído!");
            }
        %>
        
    </body>
</html>
