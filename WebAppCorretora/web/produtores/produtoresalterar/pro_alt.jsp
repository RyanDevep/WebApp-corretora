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
        <link rel="stylesheet" href="../../style_geral/sucesso.css"/>
        <title>Controle</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <div class="container">
        <%
            // Instância do Objeto
            Produtor pro = new Produtor();
            
            // Atrib. valores ao objeto           
            pro.setCpf( request.getParameter("cpf"));
            pro.setNome_produtor( request.getParameter("nome_produtor"));
            pro.setTelefone( request.getParameter("telefone"));
            pro.setEmail( request.getParameter("email"));
            
            //Gravar...
            ProdutorDAO proDAO = new ProdutorDAO();
            if (proDAO.alterar(pro)){
                out.println("Produtor alterado com sucesso!");
                //Saída
                out.println("<br> <b>Nome_____: </b>" + pro.getNome_produtor());
                out.println("<br> <b>CPF______: </b>" + pro.getCpf());
                out.println("<br> <b>Telefone_: </b>" + pro.getTelefone());
                out.println("<br> <b>Email____: </b>" + pro.getEmail());
            }else{
                out.println("Produtor não alterado!");
            }
        %>
        </div>
        <div class="botao">
            <a href="../produtorescadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
