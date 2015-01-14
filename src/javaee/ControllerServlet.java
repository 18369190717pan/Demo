

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



public class ControllerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String path = req.getServletPath();
	
		
		// path = path.substring(0,path.indexOf("."));

		if("productDetail".equals(path)){
			try{
				ProductListService productListService = new ProductListServiceImpl();
				
				List productList = productListService.getProductList();
				
				req.setAttribute("productDetail", productList);
				
				getServletContext().getRequestDispatcher("/productDetail").forward(req, resp);
				
			} catch (Exception e){
				req.setAttribute("message", e.getMessage());
				
				getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}			
		}else {
			resp.sendError(resp.SC_NOT_FOUND);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
