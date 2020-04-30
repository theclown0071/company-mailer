package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/ComposeServletProcess")
@Controller
public class ComposeServletProcessController {

	 
	protected void doGet(@RequestParam String receiver,String subject,String message,String email, HttpServletResponse response)
			throws Exception{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		
		message=message.replaceAll("\n","<br/>");
		email=(String)request.getSession(false).getAttribute("email");
		
		int i=ComposeDao.save(email, receiver, subject, message);
		if(i>0){
			request.setAttribute("msg","message successfully sent");
			request.getRequestDispatcher("ComposeServlet").forward(request, response);
		}
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
