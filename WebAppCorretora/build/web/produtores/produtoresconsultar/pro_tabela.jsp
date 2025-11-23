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
        
        <style>
            table {
                border-collapse: collapse;
                width: 100%
            }
            th{
                padding: 8px;
                text-align: left;
                border: 1px solid #DDD;
                background-color: lightseagreen;
                color: white;
            }
            td{
                padding: 8px;
                text-align: left;
                border: 1px solid #DDD
            }
            tr:hover {background-color: #D6EEEE}
        </style>
        
    </head>
    <body>
        <h2>Todos os Produtores</h2>
        <a href="../produtorescadastrar/index.html">Voltar</a>
        <%
            List<Produtor> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
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
