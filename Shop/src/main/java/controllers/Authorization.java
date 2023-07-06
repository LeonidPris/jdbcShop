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


@WebServlet({ "/Registration", "/auth" })
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void init(ServletConfig config) throws ServletException {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("views/Authorization.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//данные из сериализованной формы. авторизация
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		if(login.equals("") || pass.equals("")) {
			response.getWriter().append("Заполните все поля!");
		}
		
		try {
			if(BaseModel.findUser(login, pass)) {
				HttpSession session = request.getSession();
			    session.setAttribute("login", login);
			    session.setAttribute("pass", pass);
			} else {
				response.getWriter().append("Такого пользователя не существует!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	
}
