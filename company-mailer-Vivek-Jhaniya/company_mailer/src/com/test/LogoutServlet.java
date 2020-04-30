package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/LogoutServlet")
@Controller
public class LogoutServletController {
	@RequestStatus(RequestStatus.OK)
	protected void doGet(@RequestParam String request, HttpServletResponse response) 
			throws Exception {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		request.getSession().invalidate();
		out.print("<p>You are successfully logged out!</p>");
		
		request.getRequestDispatcher("login.html").include(request, response);
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
