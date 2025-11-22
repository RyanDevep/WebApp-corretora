<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Seguradora"%>
<%@page import="model.DAO.SeguradoraDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle</title>
    </head>
    <body>
        <h1>Excluir Seguradora</h1>
        <%
            // Instância do Objeto
            Seguradora segu = new Seguradora();
            
            // Atrib. valores ao obj
            segu.setCnpj(request.getParameter("cnpj"));
           
            
            //Excluir...
            SeguradoraDAO seguDAO = new SeguradoraDAO();
            if (seguDAO.excluir(segu)){
                out.println("Seguradora excluída com sucesso!");
            }else{
                out.println("Seguradora não excluída!");
            }
        %>
        <a href="index.html">Voltar</a>
    </body>
</html>
