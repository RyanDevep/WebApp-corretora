<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="java.util.*"%>
<%@page import="model.Produtor"%>
<%@page import="model.DAO.ProdutorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela</title>
        <link rel="stylesheet" href="../../style_geral/tabelas.css"/>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Todos os Produtores</h2>
        <a href="../produtorescadastrar/index.html">Voltar</a>
        <%
            List<Produtor> lista = new ArrayList(); // Cria uma lista para armazenar objeto
                    
            // Instância do Objeto           
            //Consulta Geral...
            ProdutorDAO proDAO = new ProdutorDAO();
            lista = proDAO.consultar_geral();
            if (proDAO.consultar_geral() == null){
                out.println("Nenhum produtor encontrado!");
            }else{
               //Saída
        %>       
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Telefone</th>
                    <th>Email</th>
                </tr>
                
        <%
               for(int i=0; i <= lista.size() - 1; i++){ 
        %>
                    <tr>
                        <td><%=lista.get(i).getId_produtor()%></td>
                        <td><%=lista.get(i).getNome_produtor()%></td>
                        <td><%=lista.get(i).getCpf()%></td>
                        <td><%=lista.get(i).getTelefone()%></td>
                        <td><%=lista.get(i).getEmail()%></td>
                    </tr>
        <%       
                    }
                }
        %>
            </table>
    </body>
</html>
