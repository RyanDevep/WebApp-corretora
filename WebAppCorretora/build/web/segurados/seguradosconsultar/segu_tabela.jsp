<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="java.util.*"%>
<%@page import="model.Segurado"%>
<%@page import="model.DAO.SeguradoDAO"%>
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
        <h2>Todos os Segurados</h2>
        <a href="../seguradoscadastrar/index.html">Voltar</a>
        <%
            List<Segurado> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
            SeguradoDAO seguDAO = new SeguradoDAO();
            lista = seguDAO.consultar_geral();
            if (seguDAO.consultar_geral() == null){
                out.println("Segurado não encontrado!");
            }else{
               //Saída
        %>       
            <table class="table table-hover">
                <tr>
                    <th>Nome</th>
                    <th>CPF/CNPJ</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Endereço</th>
                </tr>
                
        <%
               for(int i=0; i <= lista.size() - 1; i++){ 
        %>
                    <tr>
                        <td><%=lista.get(i).getNome()%></td>
                        <td><%=lista.get(i).getCpf_cnpj()%></td>
                        <td><%=lista.get(i).getTelefone()%></td>
                        <td><%=lista.get(i).getEmail()%></td>
                        <td><%=lista.get(i).getEndereco()%></td>
                    </tr>
        <%       
                    }
                }
        %>
            </table>
    </body>
</html>
