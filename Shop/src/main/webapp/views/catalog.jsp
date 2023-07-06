<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="views/style.css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		function addToBasket(id){
			e.preventDefault()			//отмена перезагрузки от btn
			let query = "?add_id="+id
			$.ajax({
				type: "GET",
				url: "catalog",
				data: query,
				success: function(){
					// сообщение: товар добавленЦ
				}
			})
		}
	</script>
	<title>Каталог</title>
</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="wrapper">
			<table class="wrapper">
				<tr>
					<th>Номер товара</th>
			        <th>Название товара</th>
			        <th>Стоимость товара</th>
			        <th>Фото товара</th>
			        <th></th>
				</tr>
				<c:forEach var="item" items="${catalog}" varStatus="num">
					<tr>
						<td>${num.count}</td> 							
		    			<td>${item.title}</td>
		    			<td>${item.price}</td>
		    			<td><img width="200" src="img/${item.photoName}"></td>
		    			<td><button onclick="addToBasket(${item.id})">Добавить товар в корзину</button></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>