<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="java.util.*"%>
<%@page import="model.Produto"%>
<%@page import="model.DAO.ProdutoDAO"%>
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
        <h2>Todos os Produtos</h2>
        <a href="../produtoscadastrar/index.html">Voltar</a>
        <%
            List<Produto> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
            ProdutoDAO prodDAO = new ProdutoDAO();
            lista = prodDAO.consultar_geral();
            if (prodDAO.consultar_geral() == null){
                out.println("Nenhum produto encontrado!");
            }else{
               //Saída
        %>       
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Produto</th>
                    <th>Descricao</th>
                    <th>Cobertura</th>
                </tr>
                
        <%
               for(int i=0; i <= lista.size() - 1; i++){ 
        %>
                    <tr>
                        <td><%=lista.get(i).getId_produto()%></td>
                        <td><%=lista.get(i).getTipo_seguro()%></td>
                        <td><%=lista.get(i).getDescricao()%></td>
                        <td><%=lista.get(i).getCobertura()%></td>
                    </tr>
        <%       
                    }
                }
        %>
            </table>
    </body>
</html>
