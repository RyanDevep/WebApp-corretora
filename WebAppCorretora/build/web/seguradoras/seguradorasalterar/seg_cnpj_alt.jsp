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
        <link rel="stylesheet" href="../../style_geral/cadastro_geral.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Alterar Seguradora</h2>        
        <%                     
            // Instância do Objeto           
            Seguradora segu = new Seguradora();
            // Atribui valores ao objeto.
            segu.setCnpj(request.getParameter("cnpj"));            
            
            //Consultar CNPJ...
            SeguradoraDAO seguDAO = new SeguradoraDAO();            
            segu = seguDAO.consultar_Cnpj(segu);
            
            if (segu == null){
                out.println("Seguradora não encontrada!");
            }else{
               //Saída
        %>
        <div class="form-container">
            <form method="post" action="seg_alt.jsp">
                <div id="cpf" class="row">
                    <label>CNPJ:</label> 
                    <input type="text" name="cnpj" readonly="true" value="<%=segu.getCnpj()%>">
                </div>
                <div class="row">
                    <label>Razão Social:</label> 
                    <input type="text" name="nome_seguradora" required value="<%=segu.getNome_seguradora()%>">
                </div>
                <div id="tel" class="row">
                    <label>Telefone:</label> 
                    <input type="text" name="telefone" required value="<%=segu.getTelefone()%>">
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
            <a href="../seguradorascadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
