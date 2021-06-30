package com.example.web.servlets;

import com.example.database.dto.UserDto;
import com.example.services.service.UserService;
import com.example.web.util.JspPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private final UserService userService = UserService.getInctance();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspPath.getPath("login"))
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		userService.getUserByEmailAndPassword(req.getParameter("email"), req.getParameter("password"))
		.ifPresentOrElse(user -> onLoginSuccess(user, req, resp), () -> onLoginFail(req, resp));
		
	}
	@SneakyThrows
	private void onLoginSuccess(UserDto user, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", user);
		response.sendRedirect("/profile");
	}
	@SneakyThrows
	private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
		resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
	}
}
