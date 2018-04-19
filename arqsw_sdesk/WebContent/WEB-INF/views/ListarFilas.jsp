<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Filas</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
		<div id="main" class="container">
			<h3 class="page-header">Filas Cadastradas</h3>
			<c:if test="${empty filas}">
				<div class="row">
    				<div class="col-md-4">
		    			<p style="padding: 15px; border-radius: 10px;" class="bg-info">Não Há Filas Cadastradas</p>
		    		</div>
		    	</div>
			</c:if>
			<c:if test="${not empty filas}">
				<c:if test="${not empty chamadosAbertosFila }">
					<div class="row">
    				<div class="col-md-6">
		    			<p style="padding: 15px; border-radius: 10px;" class="bg-info">Não é Possível Excluir Fila Pois Há Chamados Abertos.</p>
		    		</div>
		    	</div>
				</c:if>
				<div class="row"> 
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Figura</th>
								<th>Editar</th>
								<th>Excluir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fila" items="${filas }">
								<tr>
									<td><a href="mostrar_fila?id=${fila.id }" class="button button-primary">${fila.nome }</a></td>
									<td><img alt="?" src="img/${fila.caminhoFigura }" height="48" width="48" class="img-circle"></td>
									<td><a href="form_edita_fila?id=${fila.id }" class="button button-primary">Editar</a>
									<td><a href="excluir_fila?id=${fila.id }" class="button button-danger">Excluir</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>