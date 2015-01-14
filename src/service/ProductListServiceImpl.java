package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Product;



public class ProductListServiceImpl implements ProductListService{
     public List getProductList(){
    		List productList = new ArrayList();
    		
    		Connection conn = null;
    		
    		Statement stmt = null;
    		
    		ResultSet rs = null;
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
    			
    			stmt = conn.createStatement();
 			
 			rs = stmt.executeQuery("select * from product");
 			
 			while(rs.next()){
 				Product p = new Product();
 				
 				p.setName(rs.getString("name"));
 				p.setbasePrice(rs.getFloat("basePrice"));
 				p.setPublish(rs.getString("publish"));
 				p.setPages(rs.getString("pages"));
 				p.setCategoryid(rs.getInt("categoryid"));
 				p.setDescription(rs.getString("description"));
 				
				
 				productList.add(p);
 				
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			
 			throw new RuntimeException("error when querying students ",e);
 		} finally {
 			try {
 				rs.close();
 				stmt.close();
 				conn.close();
 			} catch (Exception e) {
 				e.printStackTrace();
 				
 				throw new RuntimeException("error when querying students ",e);
 			}
 		}
    	 return productList;
 	}


}
