package com.gmail.mekhanich.andrii;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ConcurrentHashMap<String, User> userList = new ConcurrentHashMap<String, User>();
	
	public static ConcurrentHashMap<String, User> getUserList() {
		System.out.println(readUsers ());
		return readUsers ();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
			String name = request.getParameter("name");
			String nickName = request.getParameter("nickName");
			String login = request.getParameter("login");
			String password = request.getParameter("pass");
			String gender = request.getParameter("gender");
			String role= request.getParameter("role");
			
			System.out.println(name + " " + nickName);
			
			User newUser = new User(name, nickName, login, password, gender, role);
			
			System.out.println(newUser.getLogin() + " " + newUser.getGender());
			
			if(checker(newUser)) {
				readUsers ().put(login, newUser);
				saveUsers();
				
				request.setAttribute("welcomeMessage", "Welcome!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "This login is present!!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
			
	}
	
	public boolean checker (User newUser) {
		boolean checker;
		if (!readUsers ().containsKey(newUser.getLogin())) {
			checker = true;
		} else {
			checker = false;
		}
		
		return checker;
	}

	public static void saveUsers () {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userList"))){
			oos.writeObject(userList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Save!");
	}
	
	public static ConcurrentHashMap<String, User> readUsers (){
		ConcurrentHashMap<String, User> users = new ConcurrentHashMap<String, User> ();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userList"))) {
			users= (ConcurrentHashMap<String, User> )ois.readObject();
			System.out.println("Load!");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
}
