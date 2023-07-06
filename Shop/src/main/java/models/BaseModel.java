package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.Cookie;

public class BaseModel {
	static BaseModel obj;
	static Connection connection;	
	static Statement statement;		
	public static ArrayList<Good> goods = new ArrayList<Good>();
	// Коннект к БД
	private BaseModel() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/BGshop";
		connection = DriverManager.getConnection(url, "root", "");
		statement = connection.createStatement();
	}

	public static BaseModel getInstance() throws SQLException {
		if(obj==null) {
			obj = new BaseModel();
		}
//System.out.println(obj);
		return obj;
	}
	
	// коллекция для каталога
	public static ArrayList<Good> selectCatalog() throws SQLException{
		String query = "SELECT good_id, title, price, photo_name FROM catalog JOIN photos USING (good_id) ORDER BY good_id";
		ResultSet rs = statement.executeQuery(query);
		goods.clear();
		while(rs.next()) {
			int id = rs.getInt("good_id");
			String title = rs.getString("title");
			int price = rs.getInt("price");
			String photoName = rs.getString("photo_name");
			goods.add(new Good(id, title, price, photoName));
		}
		return goods; 
	}

	// поиск пользователя пологину и паролю
	public static boolean findUser(String login) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT user_id FROM users WHERE login="+login);
		if(rs.next()) {//хотя, можно было через COUNT 
			return true;
		}
		return false;
	}
	
	public static boolean findUser(String login, String pass) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT `user_id` FROM `users` WHERE `login`='"+login + "' AND `password`='"+pass+"'");
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	
	
	
	//добавление нового пользователя в БД 
	public static boolean addNewUser(String fio, String login, String pass, String phone) throws SQLException {
		String query = "INSERT INTO users(user_name, login, password, phone) VALUES ("+ fio +", "+ login +", "+ pass +", "+ phone + ")";
		if(statement.executeUpdate(query) == 1) {
			return true;
		}
		return false;
	}
	
	//кука логин/пароль
	public static Cookie newCookie(String login, String pass) {
		return new Cookie("_auth_", login+"_"+pass);
	}
	
	public static String getLoginFromCookie(Cookie c) {
		return c.getValue().split("_")[0];
	}
	public static String getPassFromCookie(Cookie c) {
		return c.getValue().split("_")[1];
	}
	


	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		//BaseModel.getInstance();
		
		}








}
