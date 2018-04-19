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
		<title>Criar Fila</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
		<div id="main" class="container">
			<h3 class="page-header">Criar Fila</h3>
			<form action="criar_fila" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="form-group col-md-4">
						<label for="nome">Nome:</label>
						<form:errors path="fila.nome" cssStyle="color:red"/><br>
						<input type="text" class="form-control" name="nome" maxlength="45">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="figura">Figura(jpg):</label>
						<input type="file" class="file" name="file" id="figura">
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