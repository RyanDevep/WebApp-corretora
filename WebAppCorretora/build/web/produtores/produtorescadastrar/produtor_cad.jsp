<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="model.DAO.ProdutorDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Produtor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
        <link rel="stylesheet" href="../../style_geral/sucesso.css"/>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <div class="container">
        <%
        // Instância do Objeto
        Produtor pro = new Produtor();
        pro.setNome_produtor(request.getParameter("nome_produtor"));
        pro.setCpf(request.getParameter("cpf"));
        pro.setTelefone(request.getParameter("telefone"));
        pro.setEmail(request.getParameter("email"));
      
        //Gravar...
        ProdutorDAO proDAO = new ProdutorDAO();
        if (proDAO.cadastrar(pro)) {
            out.println("<h3>Produtor cadastrado com sucesso!</h3>");
            //Exibição dos dados que foram cadastrados
            out.println("<b>Nome_________: </b>" + pro.getNome_produtor());
            out.println("<br><b>CPF______: </b>" + pro.getCpf());
            out.println("<br><b>Telefone_: </b>" + pro.getTelefone());
            out.println("<br><b>Email____: </b>" + pro.getEmail());
        } else {
            out.println("<h3>Erro: Produtor não pode ser cadastrado!</h3>");
        }
        %>
        </div>
        <div class="botao">
            <a href="index.html">Voltar</a>
        </div>
    </body>
</html>
