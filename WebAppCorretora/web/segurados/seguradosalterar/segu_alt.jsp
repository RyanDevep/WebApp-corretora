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
        <link rel="stylesheet" href="../../style_geral/sucesso.css"/>
        <title>Controle</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <div class="container">
        <%
            // Instância do Objeto
            Segurado segu = new Segurado();
            
            // Atrib. valores ao obj           
            segu.setCpf_cnpj( request.getParameter("cpf_cnpj"));
            segu.setNome( request.getParameter("nome"));
            segu.setTelefone( request.getParameter("telefone"));
            segu.setEmail( request.getParameter("email"));
            segu.setEndereco( request.getParameter("endereco"));
            
            //Gravar...
            SeguradoDAO seguDAO = new SeguradoDAO();
            if (seguDAO.alterar(segu)){
                out.println("Segurado alterado com sucesso!");
                //Saída
                out.println("<br> <b>Nome....: </b>" + segu.getNome());
                out.println("<br> <b>CPF/CNPJ....: </b>" + segu.getCpf_cnpj());
                out.println("<br> <b>Telefone...: </b>" + segu.getTelefone());
                out.println("<br> <b>Email.....: </b>" + segu.getEmail());
                out.println("<br> <b>Endereço </b>" + segu.getEndereco()); 
            }else{
                out.println("Segurado não alterado!");
            }
        %>
        </div>
        <div class="botao">
            <a href="../seguradoscadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
