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
        <title>Apólices</title>
        <link rel="stylesheet" href="../style_geral/tabela_apolice.css"/>
        <style>
            /* Filtros de consulta personalizada*/
            .filtros {
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                align-items: center;
                margin-bottom: 25px;
            }

            .filtros form {
                display: flex;
                align-items: center;
                gap: 8px;
                background: #fff;
                padding: 8px 12px;
                border-radius: 6px;
                border: 1px solid #ddd;
                box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            }

            .filtros label {
                font-weight: bold;
                font-size: 14px;
            }

            .filtros input {
                padding: 6px 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .filtros button {
                background: #2c3e50;
                color: #fff;
                border: none;
                padding: 6px 10px;
                border-radius: 4px;
                cursor: pointer;
                transition: background 0.3s;
            }

            .filtros button:hover {
                background: #0056b3;
            }
        </style>
        
    </head>
    <body>
        <h1>ADS Corretora</h1>
        <h2>Todas as Apólices</h2>
        <!-- Cada formulário envia para o .JSP da consulta escolhida -->
        <a href="producaocadastrar/cad_apolice.jsp">Cadastrar nova Apólice</a>
        <div class="filtros">
            <form action="producaoconsultar/cons_ap_segurado.jsp" method="POST">
                <label>CPF/CNPJ:</label>
                <input type="text" name="cpf_cnpj" placeholder="Digite CPF ou CNPJ">
                <button type="submit">🔍︎</button>
            </form>
            <form action="producaoconsultar/cons_ap_produto.jsp" method="POST">
                <label>Produto:</label>
                <input type="text" name="tipo_seguro" placeholder="Nome do produto">
                <button type="submit">🔍︎</button>
            </form>
            <form action="producaoconsultar/cons_ap_produtor.jsp" method="POST">
                <label>Corretor:</label>
                <input type="text" name="nome_produtor" placeholder="Nome do corretor">
                <button type="submit">🔍︎</button>
            </form>
            <form action="producaoconsultar/cons_ap_seguradora.jsp" method="POST">
                <label>Seguradora:</label>
                <input type="text" name="nome_seguradora" placeholder="Nome da seguradora">
                <button type="submit">🔍︎</button>
            </form>
            <form action="producaoconsultar/cons_ap_situacao.jsp" method="POST">
                <label>Situação:</label>
                <input type="text" name="situacao" placeholder="Ex: Ativa, Cancelada...">
                <button type="submit">🔍︎</button>
            </form>
            <form action="producaoconsultar/cons_ap_vigencia.jsp" method="POST">
                <label>Vigência:</label>
                <input type="date" name="vigencia">
                <button type="submit">🔍︎</button>
            </form>
        </div>
        <%
        List<Producao> lista = new ArrayList(); // Cria uma lista para armazenar objeto

        // Instância do Objeto
        ProducaoDAO producDAO = new ProducaoDAO();
        lista = producDAO.consultar_geral(); // Lista recebe todos os dados da Consulta geral.

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
