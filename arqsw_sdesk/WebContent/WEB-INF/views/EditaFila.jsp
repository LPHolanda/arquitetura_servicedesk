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
		<title>Edita Fila</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
		<div id="main" class="container">
			<h3 class="page-header">Edita Fila</h3>
			<form action="edita_fila" method="post">
				<input type="hidden" name="id" value="${fila.id }">
				<div class="row">
					<div class="form-group col-md-4">
						<label for="nome">Nome:</label>
						<form:errors path="fila.nome" cssStyle="color:red"/><br>
						<input type="text" class="form-control" name="nome" maxlength="45" value="${fila.nome }">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="caminhoFigura">Figura:</label>
						<input type="file" class="form-control" name="caminhoFigura" value="${fila.caminhoFigura }">
					</div>
				</div>
				<div id="actions" class="row">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" >Salvar Fila</button>
	                    <a href="index" class="btn btn-default">Cancelar</a>
	                </div>
	            </div>
			</form>
		</div>
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>