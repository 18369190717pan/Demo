package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.User;
import pojo.Contactinfo;
import service.ContactinfoService;
import service.UserService;
import service.UserServiceImpl;

public class ContactinfoServiceImpl implements ContactinfoService{
	
	@Override
	public List getContactinfoList() {
		List contactinfoList = new ArrayList();
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from contactinfo,users where userid = 'aaaa' and contactinfo.userid = users.userid");
			
			while(rs.next()){
				Contactinfo contactinfo = new Contactinfo();
				User user = new User();
				contactinfo.setContactid(rs.getString("contactid"));
				contactinfo.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				contactinfo.setStreet1(rs.getString("street1"));
				contactinfo.setStreet2(rs.getString("street2"));
				contactinfo.setCity(rs.getString("city"));
				contactinfo.setProvince(rs.getString("province"));
				contactinfo.setCountry(rs.getString("country"));
				contactinfo.setZip(rs.getString("zip"));
				contactinfo.setEmail(rs.getString("email"));
				contactinfo.setHomephone(rs.getString("homephone"));
				contactinfo.setCellphone(rs.getString("cellphone"));
				contactinfo.setOfficephone(rs.getString("officephone"));
				
				contactinfoList.add(contactinfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying contactinfo ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying contactinfo ",e);
			}
		}

		return contactinfoList;
	}
}


