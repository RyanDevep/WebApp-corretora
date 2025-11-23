<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.TipoOperacao"%>
<%@page import="model.DAO.TipoOperacaoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle</title>
    </head>
    <body>
        <h1>Excluir Operação</h1>
        <%
            // Instância do Objeto
            TipoOperacao tipo = new TipoOperacao();
            
            // Atrib. valores ao obj
            tipo.setNome_op(request.getParameter("nome_op"));
           
            
            //Excluir...
            TipoOperacaoDAO tipoDAO = new TipoOperacaoDAO();
            if (tipoDAO.excluir(tipo)){
                out.println("Operação excluída com sucesso!");
            }else{
                out.println("Operação não excluída!");
            }
        %>
        <a href="../tiposcadastrar/index.html">Voltar</a>
    </body>
</html>
