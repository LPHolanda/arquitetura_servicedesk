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
		<title>Novo Chamado</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
		<div id="main" class="container">
			<h3 class="page-header">Novo Chamado</h3>
			<form action="criar_chamado" method="post">
				<div class="row">
	                <div class="form-group col-md-4">
	                    <label for="chamado">Descrição:</label>
	                    <form:errors path="chamado.descricao" cssStyle="color:red"/><br>
	                    <input class="form-control" type="text" name="descricao" maxlength="100">
	                </div>
	            </div>
	            <div class="row">
	                <div class="form-group col-md-4">
	                    <label for="fila">Fila:</label>
	                    <form:errors path="chamado.idFila.id" cssStyle="color:red"/><br>
	                    <select class="form-control" name="idFila.id">
	                        <option value="0"></option>
	                        <c:forEach var="fila" items="${filas}">
	                            <option value="${fila.id}">${fila.nome}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="row">
	                <div class="form-group col-md-4">
	                    <label for="cliente">Cliente:</label>
	                    <select class="form-control" name="id_rh">
	                        <option value="0"></option>
	                        <c:forEach var="fila" items="${filas}">
	                            <option value="${fila.id}">${fila.nome}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div id="actions" class="row">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" >Salvar Chamado</button>
	                    <a href="index" class="btn btn-default">Cancelar</a>
	                </div>
	            </div>
        	</form>
		</div>
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>