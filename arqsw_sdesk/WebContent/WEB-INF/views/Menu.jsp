 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">Sistema de Chamados</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="form_criar_fila">Criar Fila</a></li>
					<li><a href="listar_filas">Listar Filas</a></li>
                	<li><a href="novo_chamado">Criar Chamado</a></li>
                    <li><a href="listar_filas_exibir">Consultar Chamados</a></li>
                    <li><a href="listar_filas_fechar">Fechar Chamados</a></li>
                    <li><a href="logout">Logout</a></li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>