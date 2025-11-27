<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="model.Produto"%>
<%@page import="model.DAO.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../style_geral/cadastro_geral.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Alterar Produto</h2>        
        <%                     
            // Instância do Objeto           
            Produto prod = new Produto();
            // atribui valor ao objeto.
            prod.setTipo_seguro(request.getParameter("tipo_seguro"));            
            
            //Consultar CPF...
            ProdutoDAO prodDAO = new ProdutoDAO();            
            prod = prodDAO.consultar_prod(prod);
            
            if (prod == null){
                out.println("Produto não encontrado!");
            }else{
               //Saída
        %>
        <div class="form-container">
            <form method="post" action="prod_alt.jsp">
                <div id="tel" class="row">
                    <label>Produto:</label>
                    <input type="text" name="tipo_seguro" readonly="true" value="<%=prod.getTipo_seguro()%>">
                </div>
                <div class="row">
                    <label>Descricao:</label>
                    <input type="text" name="descricao" required value="<%=prod.getDescricao()%>">
                </div>
                <div class="row">
                    <label>Cobertura:</label>
                    <input type="text" name="cobertura" required value="<%=prod.getCobertura()%>">
                </div>
                <button class="save" type="submit">Salvar</button>
                <button type="reset">Limpar</button>
            </form>
        <%
            }
        %>
        </div>
        <div class="botao">
            <a href="../produtoscadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
