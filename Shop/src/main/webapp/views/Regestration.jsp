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
	function goReg(){
		$.ajax({
			type: "POST",
			url: "reg",
			data: $("form").serialize(),
			success: function(answer){
				if(answer==="Регистрация успешна!"){
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
				<p>Введите имя</p>
				<input type="text" name="fio">
				<p>Введите логин</p>
				<input type="text" name="login">
				<p>Введите пароль</p>
				<input type="text" name="pass">
				<p>Введите телефон</p>
				<input type="text" name="phone">
			</form><br>
			<button onclick="goReg()">Зарегистрироваться</button>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>