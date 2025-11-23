<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="model.DAO.ProdutoDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Processos</title>
    </head>
    <body>
        <h1>Cadastro de Produto</h1>
        <%
        // Instância do Objeto
        Produto prod = new Produto();
        prod.setTipo_seguro(request.getParameter("tipo_seguro"));
        prod.setDescricao(request.getParameter("descricao"));
        prod.setCobertura(request.getParameter("cobertura"));
        
        //Gravar...
        ProdutoDAO prodDAO = new ProdutoDAO();
        if (prodDAO.cadastrar(prod)) {
            out.println("<h3>Produto cadastrado com sucesso!</h3>");
            //Exibição dos dados que foram cadastrados
            out.println("<b>Produto_______: </b>" + prod.getTipo_seguro());
            out.println("<br><b>Descricao_: </b>" + prod.getDescricao());
            out.println("<br><b>Cobertura_: </b>" + prod.getCobertura());
        } else {
            out.println("<h3>Erro: Produto não pode ser cadastrado!</h3>");
        }
        %>
        <a href="index.html">Voltar</a>
    </body>
</html>
