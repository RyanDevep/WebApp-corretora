<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Segurado"%>
<%@page import="model.DAO.SeguradoDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle</title>
    </head>
    <body>
        <h1>Excluir Segurado</h1>
        <%
            // Instância do Objeto
            Segurado segu = new Segurado();
            
            // Atrib. valores ao obj
            segu.setCpf_cnpj(request.getParameter("cpf_cnpj"));
           
            
            //Excluir...
            SeguradoDAO seguDAO = new SeguradoDAO();
            if (seguDAO.excluir(segu)){
                out.println("Segurado excluído com sucesso!");
            }else{
                out.println("Segurado não excluído!");
            }
        %>
        
    </body>
</html>
