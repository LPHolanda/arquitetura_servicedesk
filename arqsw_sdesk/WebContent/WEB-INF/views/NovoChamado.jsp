<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Chamado</title>
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