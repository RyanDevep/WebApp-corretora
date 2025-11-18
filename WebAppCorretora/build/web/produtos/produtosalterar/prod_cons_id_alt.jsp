<%-- 
    Document   : prod_cons_geral.jsp
    Created on : 22 de set. de 2025, 20:15:05
    Author     : alunocmc
--%>

<%@page import="model.Produtos"%>
<%@page import="model.DAO.ProdutosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consulta de Produtos Geral</h2>        
        <%                     
            // Instância do Objeto           
            Produtos prod = new Produtos();

            prod.setNome_produto(request.getParameter("produto"));            
            
            //Consultar nome...
            ProdutosDAO prodDAO = new ProdutosDAO();            
            prod = prodDAO.consultar_nome(prod);
            
            if (prod == null){
                out.println("Produto não encontrado!");
            }else{
               //Saída
        %>
                <form method="post" action="prod_alt.jsp">
                    <input type="hidden" name="id_produto" value="<%=prod.getId_produto()%>">
                    <p>Produto: <input type="text" name="produto" value="<%=prod.getNome_produto()%>"></p>

                    <input type="submit" value="Alterar">
                    <input type="reset" value="Limpar">
            
                </form>
        <%
                out.println("<br> <b>Produto...: </b>" + prod.getNome_produto());
            }
        %>
    </body>
</html>
