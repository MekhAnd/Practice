package com.gmail.mekhanich.andrii;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "greetingServlet", urlPatterns = "/greetings.do")
public class GreetingsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/greetings.jsp").forward(request, response);
		RegistrationServlet.readUsers();
		System.out.println(RegistrationServlet.readUsers());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RegistrationServlet.readUsers();
		System.out.println(RegistrationServlet.readUsers());
		String status = request.getParameter("status");
		
		
		if (status.equals("registration")) {
			request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
