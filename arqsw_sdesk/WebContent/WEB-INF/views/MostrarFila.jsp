<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mostrar Fila</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
    	<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
	    <!-- Container Principal -->
	    <div id="main" class="container">
	    	<h3 class="page-header"><c:out value="${fila.nome }"></c:out></h3>
	    	<div class="row">
                <div class="form-group col-md-4">
                    <label for="id">Id:</label>
                    <input type="text" class="form-control" name="id" value="${fila.id }" disabled="disabled">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" name="nome" value="${fila.nome }" disabled="disabled">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="img">Figura:</label>
                    <img class="img-responsive" alt="?" src="img/${fila.caminhoFigura }" >
                </div>
            </div>
    	</div>
    	<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>