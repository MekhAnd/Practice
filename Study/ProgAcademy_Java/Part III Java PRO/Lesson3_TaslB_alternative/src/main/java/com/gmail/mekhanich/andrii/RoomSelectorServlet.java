package com.gmail.mekhanich.andrii;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet (name = "roomSelectorServlet", urlPatterns = "/roomSelector.do")
public class RoomSelectorServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/roomSelector.jsp").forward(request, response);
		RegistrationServlet.readUsers();
		System.out.println(RegistrationServlet.readUsers());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RegistrationServlet.readUsers();
		System.out.println(RegistrationServlet.readUsers());
		String status = request.getParameter("room");
		
		
		if (status.equals("java")) {
			request.getRequestDispatcher("/WEB-INF/views/java.jsp").forward(request, response);
		} else if (status.equals("python")){
			request.getRequestDispatcher("/WEB-INF/views/python.jsp").forward(request, response);
		} else if (status.equals("javaScript")){
			request.getRequestDispatcher("/WEB-INF/views/javaScript.jsp").forward(request, response);
		} else if (status.equals("css")){
			request.getRequestDispatcher("/WEB-INF/views/css.jsp").forward(request, response);
		} else if (status.equals("qaAuto")){
			request.getRequestDispatcher("/WEB-INF/views/qaAuto.jsp").forward(request, response);
		} else if (status.equals("qaManual")){
			request.getRequestDispatcher("/WEB-INF/views/qaManual.jsp").forward(request, response);
		} else if (status.equals("projects")){
			request.getRequestDispatcher("/WEB-INF/views/projects.jsp").forward(request, response);
		} else if (status.equals("flow")){
			request.getRequestDispatcher("/WEB-INF/views/flow.jsp").forward(request, response);
		} 
			String name = request.getAttribute(login);
	}
	
}
