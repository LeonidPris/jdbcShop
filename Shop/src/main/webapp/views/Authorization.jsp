<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Регестрация</title>
<link rel="stylesheet" href="views/style.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	function goAuth(){
		$.ajax({
			type: "POST",
			url: "auth",
			data: $("form").serialize(),
			success: function(answer){
				if(answer==="Авторизация успешна!"){
					alert(answer);
					window.location='catalog';
				}else{
					alert(answer);
				}
			}
		})
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
		<div class="reg">
			<form action="reg" method="POST">
				<p>Введите логин</p>
				<input type="text" name="login">
				<p>Введите пароль</p>
				<input type="text" name="pass">
			</form><br>
			<button onclick="goAuth()">Войти</button>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>