<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="model.Produto"%>
<%@page import="model.DAO.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consultar Produto </h2>        
        <%                     
            // Instância do Objeto           
            Produto prod = new Produto();

            prod.setTipo_seguro(request.getParameter("tipo_seguro"));            
            
            //Consultar CPF...
            ProdutoDAO prodDAO = new ProdutoDAO();            
            prod = prodDAO.consultar_prod(prod);
            
            if (prod == null){
                out.println("Produto não encontrado!");
            }else{
               //Saída
        %>
                <form method="post" action="prod_alt.jsp">
                    <p>Produto: <input type="text" name="tipo_seguro" readonly="true" value="<%=prod.getTipo_seguro()%>"></p>
                    <p>Descricao: <input type="text" name="descricao" required value="<%=prod.getDescricao()%>"></p>
                    <p>Cobertura: <input type="text" name="cobertura" required value="<%=prod.getCobertura()%>"></p>
                    <input type="submit" value="Alterar">
                    <input type="reset" value="Limpar">
                </form>
        <%
                out.println("<br> <b>Produto___: </b>" + prod.getTipo_seguro());
                out.println("<br> <b>Descricao_: </b>" + prod.getDescricao());
                out.println("<br> <b>Cobertura_: </b>" + prod.getCobertura());
            }
        %>
        <a href="../produtoscadastrar/index.html">Voltar</a>
    </body>
</html>
