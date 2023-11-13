<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppVenda</title>
	
	<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/dbInfnet"
         user = "root"  password = ""/>
      <sql:query dataSource = "${snapshot}" sql = "..." var = "result" />
      
	
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/">AppVenda</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/vendedor/lista">Vendedores</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/produto/lista">Produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/roupas/lista">Roupas</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/sapatos/lista">Sapatos</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container mt-3">
	
		<span class="badge rounded-pill bg-primary">Vendedor: ${qtdeVendedor}</span>
	  	<span class="badge rounded-pill bg-secondary">Produto: ${qtdeProduto}</span>
	  	<span class="badge rounded-pill bg-success">Roupas: ${qtdeRoupas}</span>
	  	<span class="badge rounded-pill bg-danger">Sapatos: ${qtdeSapatos}</span>
  	
  		<c:if test="${not empty listagem}">
			<h2>AppVenda</h2>
			<p>Gestão de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
					  <th>${titulo}</th>
					  <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
						  <td>${item}</td>
						  <td><a href="/${rota}/${item.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>