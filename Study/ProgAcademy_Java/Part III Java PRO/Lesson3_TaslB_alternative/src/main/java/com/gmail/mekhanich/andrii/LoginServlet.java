package com.gmail.mekhanich.andrii;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="loginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private VerificationService service = new VerificationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		RegistrationServlet.readUsers();
		System.out.println(RegistrationServlet.readUsers());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		request.setAttribute("login", login);

		boolean isValidUser = service.validateUser(login, password);

		if (isValidUser) {
			request.setAttribute("login", login);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

	
}