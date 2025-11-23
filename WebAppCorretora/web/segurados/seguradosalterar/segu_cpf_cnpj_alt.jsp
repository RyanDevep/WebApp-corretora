<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="model.Segurado"%>
<%@page import="model.DAO.SeguradoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consulta Segurado CPF/CNPJ</h2>        
        <%                     
            // Instância do Objeto           
            Segurado segu = new Segurado();

            segu.setCpf_cnpj(request.getParameter("cpf_cnpj"));            
            
            //Consultar CPF/CNPJ...
            SeguradoDAO seguDAO = new SeguradoDAO();            
            segu = seguDAO.consultar_CpfCnpj(segu);
            
            if (segu == null){
                out.println("Segurado não encontrado!");
            }else{
               //Saída
        %>
                <form method="post" action="segu_alt.jsp">
                    <p>CPF/CNPJ: <input type="text" name="cpf_cnpj" readonly="true" value="<%=segu.getCpf_cnpj()%>"></p>
                    <p>Nome: <input type="text" name="nome" required value="<%=segu.getNome()%>"></p>
                    <p>Telefone: <input type="text" name="telefone" required value="<%=segu.getTelefone()%>"></p>
                    <p>Email: <input type="text" name="email" required value="<%=segu.getEmail()%>"></p>
                    <p>Endereço: <input type="text" name="endereco" required value="<%=segu.getEndereco()%>"></p>
                    <input type="submit" value="Alterar">
                    <input type="reset" value="Limpar">
            
                </form>
        <%
                out.println("<br> <b>Nome....: </b>" + segu.getNome());
                out.println("<br> <b>CPF/CNPJ....: </b>" + segu.getCpf_cnpj());
                out.println("<br> <b>Telefone...: </b>" + segu.getTelefone());
                out.println("<br> <b>Email.....: </b>" + segu.getEmail());
                out.println("<br> <b>Endereço </b>" + segu.getEndereco()); 
            }
        %>
        <a href="../seguradoscadastrar/index.html">Voltar</a>
    </body>
</html>
