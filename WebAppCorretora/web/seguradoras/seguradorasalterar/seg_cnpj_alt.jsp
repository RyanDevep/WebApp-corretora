<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="model.Seguradora"%>
<%@page import="model.DAO.SeguradoraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consulta Seguradora CNPJ</h2>        
        <%                     
            // Instância do Objeto           
            Seguradora segu = new Seguradora();

            segu.setCnpj(request.getParameter("cnpj"));            
            
            //Consultar CNPJ...
            SeguradoraDAO seguDAO = new SeguradoraDAO();            
            segu = seguDAO.consultar_Cnpj(segu);
            
            if (segu == null){
                out.println("Seguradora não encontrada!");
            }else{
               //Saída
        %>
                <form method="post" action="seg_alt.jsp">
                    <p>CNPJ: <input type="text" name="cnpj" readonly="true" value="<%=segu.getCnpj()%>"></p>
                    <p>Razão Social: <input type="text" name="nome_seguradora" required value="<%=segu.getNome_seguradora()%>"></p>
                    <p>Telefone: <input type="text" name="telefone" required value="<%=segu.getTelefone()%>"></p>
                    <p>Endereço: <input type="text" name="endereco" required value="<%=segu.getEndereco()%>"></p>
                    <input type="submit" value="Alterar">
                    <input type="reset" value="Limpar">
            
                </form>
        <%
                out.println("<br> <b>Razão Socil: </b>" + segu.getNome_seguradora());
                out.println("<br> <b>CNPJ_______: </b>" + segu.getCnpj());
                out.println("<br> <b>Telefone___: </b>" + segu.getTelefone());
                out.println("<br> <b>Endereço___: </b>" + segu.getEndereco()); 
            }
        %>
        <a href="../seguradorascadastrar/index.html">Voltar</a>
    </body>
</html>
