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
        <link rel="stylesheet" href="../../style_geral/sucesso.css"/>
        <title>Controle</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <div class="container">
        <%
            // Instância do Objeto
            Seguradora segu = new Seguradora();
            
            // Atrib. valores ao obj           
            segu.setCnpj( request.getParameter("cnpj"));
            segu.setNome_seguradora( request.getParameter("nome_seguradora"));
            segu.setTelefone( request.getParameter("telefone"));
            segu.setEndereco( request.getParameter("endereco"));
            
            //Gravar alteração...
            SeguradoraDAO seguDAO = new SeguradoraDAO();
            if (seguDAO.alterar(segu)){
                out.println("Seguradora alterada com sucesso!");
                //Saída
                out.println("<br> <b>Razão Social: </b>" + segu.getNome_seguradora());
                out.println("<br> <b>CNPJ________: </b>" + segu.getCnpj());
                out.println("<br> <b>Telefone____: </b>" + segu.getTelefone());
                out.println("<br> <b>Endereço____: </b>" + segu.getEndereco()); 
            }else{
                out.println("Segurado não alterado!");
            }
        %>
        </div>
        <div class="botao">
            <a href="../seguradorascadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
