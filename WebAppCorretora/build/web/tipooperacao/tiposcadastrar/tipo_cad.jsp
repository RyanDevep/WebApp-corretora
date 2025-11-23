<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="model.DAO.TipoOperacaoDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.TipoOperacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
    </head>
    <body>
        <h1>Cadastro de Operações</h1>
        <%
        // Instância do Objeto
        TipoOperacao tipo = new TipoOperacao();
        tipo.setNome_op(request.getParameter("nome_op"));
        tipo.setStatus_op(request.getParameter("status_op"));
        tipo.setDescricao(request.getParameter("descricao"));
        
        //Gravar...
        TipoOperacaoDAO tipoDAO = new TipoOperacaoDAO();
        if (tipoDAO.cadastrar(tipo)) {
            out.println("<h3>Operação cadastrada com sucesso!</h3>");
            //Exibição dos dados que foram cadastrados
            out.println("<b>Operação______: </b>" + tipo.getNome_op());
            out.println("<br><b>Status____: </b>" + tipo.getStatus_op());
            out.println("<br><b>Descricao_: </b>" + tipo.getDescricao());
        } else {
            out.println("<h3>Erro: Operação não pode ser cadastrada!</h3>");
        }
        %>
        <a href="index.html">Voltar</a>
    </body>
</html>
