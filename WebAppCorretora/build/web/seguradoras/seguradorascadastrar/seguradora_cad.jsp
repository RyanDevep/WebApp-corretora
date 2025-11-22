<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="model.DAO.SeguradoraDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Seguradora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle</title>
    </head>
    <body>
        <h1>Cadastro de Seguradora</h1>
        <%
        // Instância do Objeto
        Seguradora segu = new Seguradora();
        segu.setNome_seguradora(request.getParameter("nome_seguradora"));
        segu.setCnpj(request.getParameter("cnpj"));
        segu.setTelefone(request.getParameter("telefone"));
        segu.setEndereco(request.getParameter("endereco"));
      
        //Gravar...
        SeguradoraDAO seguDAO = new SeguradoraDAO();
        if (seguDAO.cadastrar(segu)) {
            out.println("<h3>Seguradora cadastrada com sucesso!</h3>");
            //Exibição dos dados que foram cadastrados
            out.println("<b>Nome_________: </b>" + segu.getNome_seguradora());
            out.println("<br><b>CNPJ_: </b>" + segu.getCnpj());
            out.println("<br><b>Telefone_: </b>" + segu.getTelefone());
            out.println("<br><b>Endereço_: </b>" + segu.getEndereco());
        } else {
            out.println("<h3>Erro: Seguradora não pode ser cadastrada!</h3>");
        }
        %>
        <a href="index.html">Voltar</a>
    </body>
</html>
