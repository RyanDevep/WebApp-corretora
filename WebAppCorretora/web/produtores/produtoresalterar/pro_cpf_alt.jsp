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
        <link rel="stylesheet" href="../../style_geral/cadastro_geral.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Alterar Produtor</h2>        
        <%                     
            // Instância do Objeto           
            Produtor pro = new Produtor();

            pro.setCpf(request.getParameter("cpf"));  //armazena o valor informado anteriormente          
            
            //Consulta o CPF...
            ProdutorDAO proDAO = new ProdutorDAO();            
            pro = proDAO.consultar_Cpf(pro);
            
            if (pro == null){
                out.println("Produtor não encontrado!");
            }else{
               //Saída
        %>
        <div class="form-container">
            <form method="post" action="pro_alt.jsp">
                <div id="cpf" class="row">
                    <label>CPF:</label> 
                    <input type="text" name="cpf" readonly="true" value="<%=pro.getCpf()%>">
                </div>
                <div class="row">
                    <label>Nome:</label> 
                    <input type="text" name="nome_produtor" required value="<%=pro.getNome_produtor()%>">
                </div>
                <div id="tel" class="row">
                    <label>Telefone:</label> 
                    <input type="text" name="telefone" required value="<%=pro.getTelefone()%>">
                </div>
                <div class="row">
                    <label>Email:</label> 
                    <input type="text" name="email" required value="<%=pro.getEmail()%>">
                </div>
                <button class="save" type="submit">Salvar</button>
                <button type="reset">Limpar</button>
            </form>
        <%
            }
        %>
        </div>
        <div class="botao">
            <a href="../produtorescadastrar/index.html">Voltar</a>
        </div>
    </body>
</html>
