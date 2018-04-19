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
		<title>Fechar Chamados</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
		<div id="main" class="container">
			<h3 class="page-header"><c:out value="${fila.nome }"></c:out></h3>
			<c:if test="${empty chamadosAbertos}">
				<div class="row">
    				<div class="col-md-4">
		    			<p style="padding: 15px; border-radius: 10px;" class="bg-info">Não há chamados abertos nessa fila</p>
		    		</div>
		    	</div>
			</c:if>
			<c:if test="${not empty chamadosAbertos}">
				<div class="row">
					<p> Selecione os chamados que quiser fechar: </p>
				</div>
				<form action="fechar_chamados" method="get">
					<div class="row">
						<table border="1" class="table table-striped">
							<thead>
								<tr>
									<th>Fechar</th>
									<th>Número</th>
									<th>Descrição</th>
									<th>Abertura</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="chamado" items="${chamadosAbertos }">
									<tr>
										<td><input type="checkbox" class="" name="chamados" value="${chamado.numero }"></td>
										<td>${chamado.numero }</td>
										<td>${chamado.descricao }</td>
										<td><fmt:formatDate value="${chamado.dtAbertura }" pattern="dd/MM/yyyy"/>
									</tr>
								</c:forEach>
							</tbody>
						</table>
		            </div>
		            <div id="actions" class="row">
		                <div class="col-md-12">
		                    <button type="submit" class="btn btn-primary" >Fechar Chamados</button>
		                </div>
		            </div>
				</form>
			</c:if>
		</div>
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>