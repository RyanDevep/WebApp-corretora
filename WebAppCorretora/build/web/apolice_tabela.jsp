<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>

<%@page import="java.util.*"%>
<%@page import="model.Producao"%>
<%@page import="model.DAO.ProducaoDAO"%>
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
        <h1>ADS Corretora</h1>
        <h2>Apólices</h2>
        <a href="producao/cad_apolice.jsp">Cadastrar Apólice</a>
        <%
            List<Producao> lista = new ArrayList();
                    
            // Instância do Objeto           
            //Consultar Geral...
            ProducaoDAO producDAO = new ProducaoDAO();
            lista = producDAO.consultar_geral();
            if (producDAO.consultar_geral() == null){
                out.println("Nenhum produto encontrado!");
            }else{
               //Saída
        %>       
            <table class="table table-hover">
                <tr>
                    <th>Nº Apolice</th>
                    <th>Tipo</th>
                    <th>Produto</th>
                    <th>Segurado</th>
                    <th>CPF/CNPJ</th>
                    <th>Vigência</th>
                    <th>Seguradora</th>
                    <th>Prêmio Liquido</th>
                    <th>Comissão %</th>
                    <th>PL. a Receber</th>
                    <th>Situação</th>
                    <th>Forma de Pagamento</th>
                    <th>Corretor</th>
                </tr>
                
        <%
               for(int i=0; i <= lista.size() - 1; i++){ 
        %>
                    <tr>
                        <td><%=lista.get(i).getNum_apolice()%></td>
                        <td><%=lista.get(i).getTipoOperacao()%></td>
                        <td><%=lista.get(i).getNomeProduto()%></td>
                        <td><%=lista.get(i).getNomeSegurado()%></td>
                        <td><%=lista.get(i).getCpf_cnpj()%></td>
                        <td><%=lista.get(i).getVigencia()%></td>
                        <td><%=lista.get(i).getNomeSeguradora()%></td>
                        <td><%=lista.get(i).getPremio_liquido()%></td>
                        <td><%=lista.get(i).getPercent_comissao()%></td>
                        <td><%=lista.get(i).getPl_a_receber()%></td>
                        <td><%=lista.get(i).getSituacao()%></td>
                        <td><%=lista.get(i).getForma_pgto()%></td>
                        <td><%=lista.get(i).getNomeProdutor()%></td>
                    </tr>
        <%       
                    }
                }
        %>
            </table>
    </body>
</html>
