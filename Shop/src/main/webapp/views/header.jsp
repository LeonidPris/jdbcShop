<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<header class="nav wrapper">
	<ul class="nav_ul">
		<li class="nav_li"><a href="catalog">Каталог</a></li>
<%
	session = request.getSession();

%>
		<%if(session.getAttribute("login") != null && session.getAttribute("pass") != null){
				if(session.getAttribute("login") == "admin"){			%> 
					<li class="nav_li"><a href="Orders">Заказы</a></li>
					<li class="nav_li"><a href="Clients">Клиенты</a></li>
					<li class="nav_li"><a href="Exit">Выход</a></li>
				<%} else {%>
					<li class="nav_li"><a href="Basket">Корзина</a></li>
					<li class="nav_li"><a  href="Exit">Выход</a></li>
				<%}
			} else {//если не авторизован%>
				<li class="nav_li"><a href="auth">Авторизация</a></li>
				<li class="nav_li"><a href="reg">Регестрация</a></li>
			<%}
		%>
	</ul>
</header>
