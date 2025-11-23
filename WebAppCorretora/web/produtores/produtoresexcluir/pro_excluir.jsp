<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Produtor"%>
<%@page import="model.DAO.ProdutorDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle</title>
    </head>
    <body>
        <h1>Excluir Produtor</h1>
        <%
            // Instância do Objeto
            Produtor pro = new Produtor();
            
            // Atrib. valores ao obj
            pro.setCpf(request.getParameter("cpf"));
           
            
            //Excluir...
            ProdutorDAO proDAO = new ProdutorDAO();
            if (proDAO.excluir(pro)){
                out.println("Produtor excluído com sucesso!");
            }else{
                out.println("Produtor não excluído!");
            }
        %>
        <a href="../produtorescadastrar/index.html">Voltar</a>
    </body>
</html>
