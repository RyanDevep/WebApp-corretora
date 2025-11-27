<%-- 
    Document   : Corretora
    Created on : 20 de nov. de 2025, 17:44:08
    Author: Ryan B. | Camila S. | Miguel L. | Murilo C. | Fernando R.
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Produtor"%>
<%@page import="model.DAO.ProdutorDAO"%>
<%@page import="model.Produto"%>
<%@page import="model.DAO.ProdutoDAO"%>
<%@page import="model.Segurado"%>
<%@page import="model.DAO.SeguradoDAO"%>
<%@page import="model.Seguradora"%>
<%@page import="model.DAO.SeguradoraDAO"%>
<%@page import="model.TipoOperacao"%>
<%@page import="model.DAO.TipoOperacaoDAO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Apólice</title>
    <link rel="stylesheet" href="../../style_geral/cadastro.css"/>
</head>
<body>
    <% 
        // Instancia dos DAOs
        SeguradoraDAO seguradoraDAO = new SeguradoraDAO();
        ProdutorDAO produtorDAO = new ProdutorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        SeguradoDAO seguradoDAO = new SeguradoDAO();
        TipoOperacaoDAO tiposDAO = new TipoOperacaoDAO();
        
        // Listas necessárias
        List<Seguradora> listaSeguradoras = seguradoraDAO.consultar_geral();
        List<Produtor> listaProdutores = produtorDAO.consultar_geral();
        List<Produto> listaProdutos = produtoDAO.consultar_geral();
        List<TipoOperacao> listaTipos = tiposDAO.consultar_geral();
        // Pega o valor digitado pelo usuário no campo "termo".
        String termoPesquisa = request.getParameter("termo");
    
        List<Segurado> listaSeguradosFiltrada = new ArrayList<>();

        // (Busca um Segurado existente)Se o usuário digitar algo, busca no banco
        if (termoPesquisa != null && !termoPesquisa.trim().isEmpty()) {
            listaSeguradosFiltrada = seguradoDAO.consultar_nome(termoPesquisa);
        } 
        // Se não digitou, a lista fica vazia

    %>
        <h1>ADS Corretora</h1>
        <h2>Cadastro de Apólices</h2>
        <div class="container">
            <a href="../apolice_tabela.jsp">MENU 🏠︎</a>
        </div>
        <div class="form-container">
            <div class="row-prin">
                <div class="box-busca">
                    <!-- formulário para encontrar um segurado cadastrado -->
                    <form action="cad_apolice.jsp" method="GET">
                        <label>Nome do Segurado:</label>
                        <input type="text" name="termo" value="<%= (termoPesquisa != null) ? termoPesquisa : "" %>" placeholder="Digite o nome do segurado">

                        <button type="submit">Pesquisar</button>
                    </form>
                </div>
                <div class="botao">
                    <a href="../../segurados/seguradoscadastrar/index.html">+ Cadastrar novo Segurado</a>
                </div>
            </div>
            <form action="salvar_apolice.jsp" method="post">
                <div class="row">
                    <div class="col">
                        <label>Segurado Selecionado:</label>
                        <select name="id_segurado" required>
                            <% 
                            // Se a lista estiver vazia e fez a pesquisa, mostra que não achou.
                            if (listaSeguradosFiltrada.isEmpty() && termoPesquisa != null) { 
                            %>
                                <option value="">Nenhum segurado encontrado com esse nome.</option>

                            <% } else if (listaSeguradosFiltrada.isEmpty()) { %>
                                <option value="">Utilize a busca acima</option>

                            <% } else { %>
                                <option value="">Selecione o segurado...</option>
                                <!-- Achou segurados preenche o select com os nomes-->
                                <% for(Segurado s : listaSeguradosFiltrada) { %>
                                    <option value="<%= s.getId_segurado() %>">
                                        <%= s.getNome() %> (CPF: <%= s.getCpf_cnpj() %>)
                                    </option>
                                <% } %>

                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label>Tipo de Operação:</label>
                        <select name="id_op" required>
                            <option value="">Selecione...</option>
                            <!-- Preenche o select com os dados da lista -->
                            <% for(TipoOperacao t : listaTipos) { %>
                                <option value="<%= t.getId_op() %>"><%= t.getNome_op() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col">
                        <label>Produto:</label>
                        <select name="id_produto" required>
                            <option value="">Selecione...</option>
                            <% for(Produto p : listaProdutos) { %>
                            <!-- Preenche o select com os dados da lista -->
                                <option value="<%= p.getId_produto() %>"><%= p.getTipo_seguro() %></option>
                            <% } %>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label>Vigência:</label>
                        <input type="date" name="vigencia" required>
                    </div>
                    <div class="col">
                        <label>Nº Apólice:</label>
                        <input type="text" name="num_apolice" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <label>Seguradora:</label>
                        <select name="id_seguradora" required>
                            <option value="">Selecione...</option>
                            <!-- Preenche o select com os dados da lista -->
                            <% for(Seguradora seg : listaSeguradoras) { %>
                                <option value="<%= seg.getId_seguradora() %>"><%= seg.getNome_seguradora() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col">
                        <label>Produtor:</label>
                        <select name="id_produtor" required>
                            <option value="">Selecione...</option>
                            <!-- Preenche o select com os dados da lista -->
                            <% for(Produtor prod : listaProdutores) { %>
                                <option value="<%= prod.getId_produtor() %>"><%= prod.getNome_produtor() %></option>
                            <% } %>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <label>Prêmio Líquido (R$):</label>
                        <input type="number" step="0.01" name="premio_liquido" required>
                    </div>
                    <div class="col">
                        <label>Comissão (%):</label>
                        <input type="number" step="0.01" name="percent_comissao" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <label>Situação:</label>
                        <select name="situacao">
                            <option value="ATIVA">Ativa</option>
                            <option value="PENDENTE">Pendente</option>
                            <option value="CANCELADA">Cancelada</option>
                        </select>
                    </div>
                    <div class="col">
                        <label>Forma de Pagamento:</label>
                        <select name="forma_pgto">
                            <option value="BOLETO">Boleto</option>
                            <option value="DEBITO">Débito em Conta</option>
                            <option value="CREDITO">Cartão de Crédito</option>
                        </select>
                    </div>
                </div>
                <br>
                <button class="save" type="submit">Salvar Apólice</button>
            </form>
        </div>   
</body>
</html>