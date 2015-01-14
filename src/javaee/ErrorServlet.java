package javaee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductListServiceImpl;
import service.ProductListService;

public class ErrorServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws 
    ServletException,IOException{
        PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Error</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2 align=\"center\">Error</h2>");
		out.println("	<hr>");
		out.println("	System Error," + req.getAttribute("message") + "!");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	}


