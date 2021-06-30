package com.example.web.servlets;

import com.example.database.dto.UserCreate;
import com.example.database.entity.Role;
import com.example.services.service.UserService;
import com.example.web.util.JspPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024*1024)
@SuppressWarnings("serial")
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private final UserService userService = UserService.getInctance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", Role.values());
		
		req.getRequestDispatcher(JspPath.getPath("registration"))
		.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException  {
		
		UserCreate user = UserCreate.builder()
				.firstName(req.getParameter("firstName"))
				.secondName(req.getParameter("secondName"))
				.email(req.getParameter("email"))
				.password(req.getParameter("password"))
				.birthday(req.getParameter("birthday"))
				.role(req.getParameter("role"))
				.image(req.getPart("image"))
				.build();
		
		userService.createUser(user);
		
		try {
			resp.sendRedirect("/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	
	

}
