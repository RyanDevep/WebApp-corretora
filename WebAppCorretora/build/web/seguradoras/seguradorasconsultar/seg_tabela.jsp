<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="java.util.*"%>
<%@page import="model.Seguradora"%>
<%@page import="model.DAO.SeguradoraDAO"%>
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
        <h2>Todas as Seguradoras</h2>
        <a href="../seguradorascadastrar/index.html">Voltar</a>
        <%
            List<Seguradora> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
            SeguradoraDAO seguDAO = new SeguradoraDAO();
            lista = seguDAO.consultar_geral();
            if (seguDAO.consultar_geral() == null){
                out.println("Nenhuma seguradora encontrada!");
            }else{
               //Saída
        %>       
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Razão Social</th>
                    <th>CNPJ</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
                </tr>
                
        <%
               for(int i=0; i <= lista.size() - 1; i++){ 
        %>
                    <tr>
                        <td><%=lista.get(i).getId_seguradora()%></td>
                        <td><%=lista.get(i).getNome_seguradora()%></td>
                        <td><%=lista.get(i).getCnpj()%></td>
                        <td><%=lista.get(i).getTelefone()%></td>
                        <td><%=lista.get(i).getEndereco()%></td>
                    </tr>
        <%       
                    }
                }
        %>
            </table>
    </body>
</html>
