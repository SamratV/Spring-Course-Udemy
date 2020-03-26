package com.vs.testdb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestDbServlet", urlPatterns = { "/TestDbServlet" })
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// Setup connection variables.
		String user = "springstudent";
		String pass = "springstudent";
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";

		// Get connection to database.
		try {
			PrintWriter out = response.getWriter();
			out.println("Trying to connect to database: " + url + "<br><br>");

			Class.forName(driver);
			Connection link = DriverManager.getConnection(url, user, pass);

			out.println("Conection successful: " + link);

			link.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
