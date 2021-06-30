package com.example.web.servlets;

import com.example.database.dto.UserDto;
import com.example.web.util.JspPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("serial")
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspPath.getPath("profile"))
		.forward(req, resp);
	}
		@Override
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			resp.setContentType("image/jpg");
			UserDto userDto = (UserDto)req.getSession().getAttribute("user");
			
			InputStream imageStream = Files.newInputStream(Path.of(userDto.getImage()));
			resp.getOutputStream().write(imageStream.readAllBytes());
			
			
		}
}
