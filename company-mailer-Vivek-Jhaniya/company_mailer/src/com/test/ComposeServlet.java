package com.test;

import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("/ComposeServlet")
@Controller
public class ComposeServletController {
	@RequestStatus(RequestStatus.OK)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.html");
		}else{
			String email=(String)session.getAttribute("email");
			out.print("<span style='float:right'>Hi, "+email+"</span>");
			
			String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				out.print("<p>"+msg+"</p>");
			}
		request.getRequestDispatcher("composeform.html").include(request, response);
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
