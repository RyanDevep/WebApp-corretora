<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="model.TipoOperacao"%>
<%@page import="model.DAO.TipoOperacaoDAO"%>
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
        <h2>Alterar Operações </h2>        
        <%                     
            // Instância do Objeto           
            TipoOperacao tipo = new TipoOperacao();
            // Atribui valores ao objeto
            tipo.setNome_op(request.getParameter("nome_op"));            
            
            //Consultar CPF...
            TipoOperacaoDAO tipoDAO = new TipoOperacaoDAO();            
            tipo = tipoDAO.consultar_tipo(tipo);
            
            if (tipo == null){
                out.println("Operação não encontrada!");
            }else{
               //Saída
        %>
        <div class="form-container">
            <form method="post" action="tipo_alt.jsp">
                <div id="tel" class="row">
                    <label>Operação:</label> 
                    <input type="text" name="nome_op" required value="<%=tipo.getNome_op()%>">
                </div>
                <div id="tel" class="row">
                    <label>Status:</label> 
                    <input type="text" name="status_op" required value="<%=tipo.getStatus_op()%>">
                </div>
                <div class="row">
                    <label>Descrição:</label>
                    <input type="text" name="descricao"required value="<%=tipo.getDescricao()%>">
                </div>
                <button class="save" type="submit">Salvar</button>
                <button type="reset">Limpar</button>
            </form>
        <%
            }
        %>
        </div>
        <div class="botao">
            <a href="../tiposcadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
