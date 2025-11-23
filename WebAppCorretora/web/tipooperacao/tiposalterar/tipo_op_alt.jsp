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
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consultar Operações </h2>        
        <%                     
            // Instância do Objeto           
            TipoOperacao tipo = new TipoOperacao();

            tipo.setNome_op(request.getParameter("nome_op"));            
            
            //Consultar CPF...
            TipoOperacaoDAO tipoDAO = new TipoOperacaoDAO();            
            tipo = tipoDAO.consultar_tipo(tipo);
            
            if (tipo == null){
                out.println("Operação não encontrada!");
            }else{
               //Saída
        %>
                <form method="post" action="tipo_alt.jsp">
                    <p>Operação: <input type="text" name="nome_op" required value="<%=tipo.getNome_op()%>"></p>
                    <p>Status: <input type="text" name="status_op" required value="<%=tipo.getStatus_op()%>"></p>
                    <p>Descrição: <input type="text" name="descricao"required value="<%=tipo.getDescricao()%>"></p>
                    <input type="submit" value="Alterar">
                    <input type="reset" value="Limpar">
                </form>
        <%
                out.println("<br> <b>Operação__: </b>" + tipo.getNome_op());
                out.println("<br> <b>Status____: </b>" + tipo.getStatus_op());
                out.println("<br> <b>Descricao_: </b>" + tipo.getDescricao());
            }
        %>
        <a href="../tiposcadastrar/index.html">Voltar</a>
    </body>
</html>
