<%-- 
    Document   : cons_ap_segurado
    Created on : 25 de nov. de 2025, 15:03:19
    Author     : ryanb
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.Producao"%>
<%@page import="model.DAO.ProducaoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f0f2f5;
                margin: 0;
                padding: 20px;
            }
            h1 { color: #2c3e50; margin-bottom: 5px; text-align: center; }
            h2 { color: #7f8c8d; font-weight: normal; margin-top: 0; margin-bottom: 20px; text-align: center; }

            /* Botão Voltar */
            a.btn-voltar {
                display: inline-block;
                padding: 8px 15px;
                background-color: #3498db;
                color: white;
                text-decoration: none;
                border-radius: 4px;
                margin-bottom: 15px;
                font-size: 14px;
            }
            a.btn-voltar:hover { background-color: #2980b9; }

            /* Tabela */
            table {
                width: 100%;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 1px 3px rgba(0,0,0,0.2);
                font-size: 13px;
            }
            th {
                background-color: #2c3e50;
                color: white;
                padding: 12px;
                text-align: left;
            }
            td {
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }
            tr:hover { background-color: #f1f1f1; }
            tr:nth-child(even) { background-color: #f9f9f9; }
        </style>
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Apólices</h2>
        <a class="btn-voltar" href="../apolice_tabela.jsp">Voltar</a>
        <%
        String vigencia = request.getParameter("vigencia");
        List<Producao> lista = new ArrayList<>();

        ProducaoDAO producDAO = new ProducaoDAO();
        lista = producDAO.consultar_vigencia(vigencia);// passando o parâmetro

        if (lista == null || lista.isEmpty()) {
            out.println("Nenhuma apólice encontrada!");
        } else {
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
                    <th>Prêmio Liq.(R$)</th>
                    <th>Comissão %</th>
                    <th>PL. a Receber(R$)</th>
                    <th>Situação</th>
                    <th>Forma de Pagamento</th>
                    <th>Corretor</th>
                </tr>
        <%
                for (int i = 0; i < lista.size(); i++) {
                    Producao p = lista.get(i);
        %>
                <tr>
                    <td><%= p.getNum_apolice() %></td>
                    <td><%= p.getTipoOperacao() %></td>
                    <td><%= p.getNomeProduto() %></td>
                    <td><%= p.getNomeSegurado() %></td>
                    <td><%= p.getCpf_cnpj() %></td>
                    <td><%= p.getVigencia() %></td>
                    <td><%= p.getNomeSeguradora() %></td>
                    <td><%= p.getPremio_liquido() %></td>
                    <td><%= p.getPercent_comissao() %></td>
                    <td><%= p.getPl_a_receber() %></td>
                    <td><%= p.getSituacao() %></td>
                    <td><%= p.getForma_pgto() %></td>
                    <td><%= p.getNomeProdutor() %></td>
                </tr>
        <%
                }
        }
        %>
            </table>
    </body>
</html>
