<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="model.DAO.SeguradoDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Segurado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
    </head>
    <body>
        <h1>Cadastro de Segurados</h1>
        <%
        // Instância do Objeto
        Segurado segu = new Segurado();
        segu.setNome(request.getParameter("nome"));
        segu.setCpf_cnpj(request.getParameter("cpf_cnpj"));
        segu.setTelefone(request.getParameter("telefone"));
        segu.setEmail(request.getParameter("email"));
        segu.setEndereco(request.getParameter("endereco"));
      
        //Gravar...
        SeguradoDAO seguDAO = new SeguradoDAO();
        if (seguDAO.cadastrar(segu)) {
            out.println("<h3>Segurado cadastrado com sucesso!</h3>");
            //Exibição dos dados que foram cadastrados
            out.println("<b>Nome_________: </b>" + segu.getNome());
            out.println("<br><b>CPF/CNPJ_: </b>" + segu.getCpf_cnpj());
            out.println("<br><b>Telefone_: </b>" + segu.getTelefone());
            out.println("<br><b>Email____: </b>" + segu.getEmail());
            out.println("<br><b>Endereço_: </b>" + segu.getEndereco());
        } else {
            out.println("<h3>Erro: Segurado não pode ser cadastrado!</h3>");
        }
        %>
        <a href="index.html">Voltar</a>
    </body>
</html>
