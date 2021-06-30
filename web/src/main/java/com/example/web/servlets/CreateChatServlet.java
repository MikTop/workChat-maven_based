package com.example.web.servlets;

import com.example.database.entity.Chat;
import com.example.services.service.ChatService;
import com.example.services.service.UserService;
import com.example.web.util.JspPath;
import com.example.database.util.PropertiesUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/createChat")
public class CreateChatServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private final UserService userService = UserService.getInctance();
	private final ChatService chatService = ChatService.getInctance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", userService.findAll());
		
		req.getRequestDispatcher(JspPath.getPath("createChat"))
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> chatMembersId =  Arrays.asList(req.getParameterValues("chatMembers"));
		chatService.createNewChat(chatMembersId);
		resp.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + "/chatList" );
	}
	
	@SneakyThrows
	private void onCreateSucces(Chat chat, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("chat", chat);
		response.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + "/chatList" );
	}
	
	@SneakyThrows
	private void onCreateFail(HttpServletRequest request, HttpServletResponse response) {
			response.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + "/createChat&createError");
		}
	

}
