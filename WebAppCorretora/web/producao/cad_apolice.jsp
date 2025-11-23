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
    <style>
        .form-container { max-width: 100%; margin: 20px; font-family: Arial, sans-serif; }
        .row { display: flex; gap: 20px; margin-bottom: 15px; }
        .col { flex: 1; display: flex; flex-direction: column; }
        label { font-weight: bold; margin-bottom: 5px; }
        input, select { padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
        button { background-color: #28a745; color: white; padding: 10px 20px; border: none; cursor: pointer; font-size: 16px; }
        button:hover { background-color: #218838; }
        .resultado-box {
        position: absolute;
        top: 100%;
        left: 0;
        width: 100%;
        background: white;
        border: 1px solid #ccc;
        max-height: 200px;
        overflow-y: auto;
        z-index: 1000;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }
    .item-resultado {
        padding: 10px;
        border-bottom: 1px solid #eee;
        cursor: pointer;
    }
    .item-resultado:hover {
        background-color: #f0f8ff;
    }
    </style>
</head>
<body>

    <% 
        // 2. BUSCANDO DADOS DO BANCO (Lógica Java dentro do JSP)
        // Instancie seus DAOs aqui
        SeguradoraDAO seguradoraDAO = new SeguradoraDAO();
        ProdutorDAO produtorDAO = new ProdutorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        SeguradoDAO seguradoDAO = new SeguradoDAO();
        TipoOperacaoDAO tiposDAO = new TipoOperacaoDAO();
        
        // Carregue as listas
        List<Seguradora> listaSeguradoras = seguradoraDAO.consultar_geral(); // Verifique o nome do seu método no DAO
        List<Produtor> listaProdutores = produtorDAO.consultar_geral();
        List<Produto> listaProdutos = produtoDAO.consultar_geral();
        List<TipoOperacao> listaTipos = tiposDAO.consultar_geral();
        
        String termoPesquisa = request.getParameter("termo");
    
        List<Segurado> listaSeguradosFiltrada = new ArrayList<>();

        // Se o usuário digitou algo, buscamos no banco
        if (termoPesquisa != null && !termoPesquisa.trim().isEmpty()) {
            listaSeguradosFiltrada = seguradoDAO.consultar_nome(termoPesquisa);
        } 
        // Se não digitou nada, a lista fica vazia (ou você pode carregar todos se preferir)

    %>

    <div class="form-container">
        <h2>Cadastro de Apólice</h2>
        <div class="row">
            <div class="box-busca">
                <form action="cad_apolice.jsp" method="GET">
                    <label>Nome do Segurado:</label>
                    <input type="text" name="termo" value="<%= (termoPesquisa != null) ? termoPesquisa : "" %>" placeholder="Digite o nome do segurado">

                    <button type="submit">Pesquisar</button>
                </form>
            </div>
        </div>
        <form action="salvar_apolice.jsp" method="post">
            <div class="row">
                <div class="col">
                    <label>Segurado Selecionado:</label>
                    <select name="id_segurado" required>
                        <% 
                        // Se a lista estiver vazia e houve pesquisa, avisa que não achou
                        if (listaSeguradosFiltrada.isEmpty() && termoPesquisa != null) { 
                        %>
                            <option value="">Nenhum segurado encontrado com esse nome.</option>

                        <% } else if (listaSeguradosFiltrada.isEmpty()) { %>
                            <option value="">Utilize a busca acima</option>

                        <% } else { %>
                            <option value="">Selecione o segurado...</option>

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
                        <% for(Seguradora seg : listaSeguradoras) { %>
                            <option value="<%= seg.getId_seguradora() %>"><%= seg.getNome_seguradora() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="col">
                    <label>Produtor:</label>
                    <select name="id_produtor" required>
                        <option value="">Selecione...</option>
                        <% for(Produtor prod : listaProdutores) { %>
                            <option value="<%= prod.getId_produtor() %>"><%= prod.getNome_produtor() %></option>
                        <% } %>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <label>Prêmio Líquido (R$):</label>
                    <input type="number" step="0.01" name="premio_liquido" id="premioLiq" oninput="calcularComissao()" required>
                </div>
                <div class="col">
                    <label>Comissão (%):</label>
                    <input type="number" step="0.01" name="percent_comissao" id="percentualComissao" oninput="calcularComissao()" required>
                </div>
                <div class="col">
                    <label>PL. a Receber (R$):</label>
                    <input type="number" step="0.01" name="pl_a_receber" id="valorComissao" readonly>
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
            <button type="submit">Salvar Apólice</button>
        </form>
        </div>
    <script>
        function calcularComissao() {
            var premio = parseFloat(document.getElementById('premioLiq').value) || 0;
            var porcentagem = parseFloat(document.getElementById('percentualComissao').value) || 0;
            
            // Cálculo simples
            var resultado = premio * (porcentagem / 100);
            
            // Coloca o resultado no campo e fixa em 2 casas decimais
            document.getElementById('valorComissao').value = resultado.toFixed(2);
        }
    </script>

</body>
</html>