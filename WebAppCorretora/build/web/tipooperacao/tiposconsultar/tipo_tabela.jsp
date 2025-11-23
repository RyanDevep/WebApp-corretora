<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="java.util.*"%>
<%@page import="model.TipoOperacao"%>
<%@page import="model.DAO.TipoOperacaoDAO"%>
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
        <h2>Todas as Operações</h2>
        <a href="../tiposcadastrar/index.html">Voltar</a>
        <%
            List<TipoOperacao> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
            TipoOperacaoDAO tipoDAO = new TipoOperacaoDAO();
            lista = tipoDAO.consultar_geral();
            if (tipoDAO.consultar_geral() == null){
                out.println("Nenhuma operação encontrada!");
            }else{
               //Saída
        %>       
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Operação</th>
                    <th>Status</th>
                    <th>Descricao</th>
                </tr>
                
        <%
               for(int i=0; i <= lista.size() - 1; i++){ 
        %>
                    <tr>
                        <td><%=lista.get(i).getId_op()%></td>
                        <td><%=lista.get(i).getNome_op()%></td>
                        <td><%=lista.get(i).getStatus_op()%></td>
                        <td><%=lista.get(i).getDescricao()%></td>
                    </tr>
        <%       
                    }
                }
        %>
            </table>
    </body>
</html>
