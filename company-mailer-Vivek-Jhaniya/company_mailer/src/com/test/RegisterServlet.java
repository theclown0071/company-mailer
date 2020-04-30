package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RequestMapping("/RegisterServlet")
@Controller
public class RegisterServletController {
	@RequestStatus(RequestStatus.OK)
	protected void doPost(@RequestParam String email,@RequestParam String name,@RequestParam String password,@RequestParam String gender,@RequestParam String dob,@RequestParam String addressLine,@RequestParam String city,@RequestParam String state,@RequestParam String country,@RequestParam String contact, HttpServletResponse response) 
			throws Exception {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		int status=RegisterDao.save(name, email+"@cmailer.com", password, gender, dob, addressLine, city, state, country, contact);
		if(status>0){
			out.print("<p>You are successfully registered!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
			
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
