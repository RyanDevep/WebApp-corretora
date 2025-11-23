<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="model.Produtor"%>
<%@page import="model.DAO.ProdutorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consulta Produtor - CPF</h2>        
        <%                     
            // Instância do Objeto           
            Produtor pro = new Produtor();

            pro.setCpf(request.getParameter("cpf"));            
            
            //Consultar CPF...
            ProdutorDAO proDAO = new ProdutorDAO();            
            pro = proDAO.consultar_Cpf(pro);
            
            if (pro == null){
                out.println("Produtor não encontrado!");
            }else{
               //Saída
        %>
                <form method="post" action="pro_alt.jsp">
                    <p>CPF: <input type="text" name="cpf" readonly="true" value="<%=pro.getCpf()%>"></p>
                    <p>Nome: <input type="text" name="nome_produtor" required value="<%=pro.getNome_produtor()%>"></p>
                    <p>Telefone: <input type="text" name="telefone" required value="<%=pro.getTelefone()%>"></p>
                    <p>Email: <input type="text" name="email" required value="<%=pro.getEmail()%>"></p>
                    <input type="submit" value="Alterar">
                    <input type="reset" value="Limpar">
            
                </form>
        <%
                out.println("<br> <b>Nome_____: </b>" + pro.getNome_produtor());
                out.println("<br> <b>CPF______: </b>" + pro.getCpf());
                out.println("<br> <b>Telefone_: </b>" + pro.getTelefone());
                out.println("<br> <b>Email____: </b>" + pro.getEmail());
            }
        %>
        <a href="../produtorescadastrar/index.html">Voltar</a>
    </body>
</html>
