package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaseModel;


@WebServlet({ "/Registration", "/reg" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void init(ServletConfig config) throws ServletException {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("views/Regestration.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//данные из сериализованной формы. Добавление нового юзера
		String fio = request.getParameter("fio");
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		
		if(fio.equals("") || login.equals("") || pass.equals("") || phone.equals("")) {
			response.getWriter().append("Заполните все поля!");
		}
		try {
			if(!BaseModel.findUser(login)) {
				if(BaseModel.addNewUser(fio, login, pass, phone)) {
					response.getWriter().append("Регистрация успешна!");
					
					HttpSession session = request.getSession();
			        session.setAttribute("login", login);
			        session.setAttribute("pass", pass);
					
				}
			} else {
				response.getWriter().append("Пользователь с таким логином уже существует...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
