package com.tka;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name =request.getParameter("name");
	String Lname =request.getParameter("Lname");
	String Gender =request.getParameter("Gender");
	String Phno =request.getParameter("Phno");
	String Email =request.getParameter("Email");
	}

}
