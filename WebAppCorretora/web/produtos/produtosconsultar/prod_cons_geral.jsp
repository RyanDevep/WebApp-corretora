<%-- 
    Document   : prod_cons_geral.jsp
    Created on : 22 de set. de 2025, 20:15:05
    Author     : alunocmc
--%>

<%@page import="java.util.*"%>
<%@page import="model.Produtos"%>
<%@page import="model.DAO.ProdutosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Corretora</title>
    </head>
    <body>
        <h2>Todos os Produtos</h2>
        
        <%
            List<Produtos> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
            ProdutosDAO prodDAO = new ProdutosDAO();
            lista = prodDAO.consultar_geral();
            if (prodDAO.consultar_geral() == null){
                out.println("Produto não encontrado!");
            }else{
               //Saída
               out.println("<br> <b>| Produto |</b> <br>");
               for(int i=0; i <= lista.size() - 1; i++){ 
                    out.println( lista.get(i).getNome_produto()+ "<br>");               
               }
            }
        %>
    </body>
</html>
