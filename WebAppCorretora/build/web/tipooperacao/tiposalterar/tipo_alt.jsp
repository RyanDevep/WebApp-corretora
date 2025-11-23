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
        <h1>Alteração de Operação</h1>
        <%
            // Instância do Objeto
            TipoOperacao tipo = new TipoOperacao();
            
            // Atrib. valores ao objeto           
            tipo.setNome_op( request.getParameter("nome_op"));
            tipo.setStatus_op( request.getParameter("status_op"));
            tipo.setDescricao( request.getParameter("descricao"));
            
            //Gravar...
            TipoOperacaoDAO tipoDAO = new TipoOperacaoDAO();
            if (tipoDAO.alterar(tipo)){
                out.println("Operacão alterada com sucesso!");
                //Saída
                out.println("<br> <b>Operação__: </b>" + tipo.getNome_op());
                out.println("<br> <b>Status____: </b>" + tipo.getStatus_op());
                out.println("<br> <b>Descrição_: </b>" + tipo.getDescricao());
            }else{
                out.println("Operacão não alterada!");
            }
        %>
        <a href="../tiposcadastrar/index.html">Voltar</a>
    </body>
</html>
