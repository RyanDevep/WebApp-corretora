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
        <link rel="stylesheet" href="../../style_geral/cadastro_geral.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Alterar Segurado CPF/CNPJ</h2>        
        <%                     
            // Instância do Objeto           
            Segurado segu = new Segurado();
            // atribui valores ao objeto
            segu.setCpf_cnpj(request.getParameter("cpf_cnpj"));            
            
            //Consultar CPF/CNPJ...
            SeguradoDAO seguDAO = new SeguradoDAO();            
            segu = seguDAO.consultar_CpfCnpj(segu);
            
            if (segu == null){
                out.println("Segurado não encontrado!");
            }else{
               //Saída
        %>
        <div class="form-container">
            <form method="post" action="segu_alt.jsp">
                <div id="cpf" class="row">
                    <label>CPF/CNPJ:</label> 
                    <input type="text" name="cpf_cnpj" readonly="true" value="<%=segu.getCpf_cnpj()%>">
                </div>
                <div class="row">
                    <label>Nome:</label> 
                    <input type="text" name="nome" required value="<%=segu.getNome()%>">
                </div>
                <div id="tel" class="row">
                    <label>Telefone:</label> 
                    <input type="text" name="telefone" required value="<%=segu.getTelefone()%>">
                </div>
                <div class="row">
                    <label>Email:</label> 
                    <input type="text" name="email" required value="<%=segu.getEmail()%>">
                </div>
                <div class="row">
                    <label>Endereço:</label> 
                    <input type="text" name="endereco" required value="<%=segu.getEndereco()%>">
                </div>
                <button class="save" type="submit">Salvar</button>
                <button type="reset">Limpar</button>
            </form>
        <%
            }
        %>
        </div>
        <div class="botao">
            <a href="../seguradoscadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
