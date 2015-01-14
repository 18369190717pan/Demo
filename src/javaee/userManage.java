package javaee;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserService;
import service.UserServiceImpl;

public class userManage extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		try{
			UserService userService = new UserServiceImpl();
			
//			StudentService studentService = ServiceFactory.getStudentService();
			
			List userList = userService.getUserList();

			toUserList(resp, userList);
		} catch (Exception e){
			toError(resp,e.getMessage());
		}
		
	}
		
	private void toError(HttpServletResponse resp, String message) throws IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Error</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2 align=\"center\">Error</h2>");
		out.println("	<hr>");
		out.println("	System Error," + message + "!");
		out.println("</body>");
		out.println("</html>");
			
		out.close();
	}

	
	private void toUserList(HttpServletResponse resp, List userList)
			throws IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\"./css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\"./images/top_bg.gif\"><img src=\"./images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\"./images/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\"./images/top_bg.gif\" align=\"right\"><img src=\"./images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("");
		out.println("			<tr>");
		out.println("				<td background=\"./images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/productList\"><img name=\"Image1\" border=\"0\" src=\"./images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/userManage\"><img name=\"Image2\" border=\"0\" src=\"./images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/shoppingCart\"><img name=\"Image4\" border=\"0\" src=\"./images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/orderList\"><img name=\"Image5\" border=\"0\" src=\"./images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"/Demo/productList\"><img name=\"Image6\" border=\"0\" src=\"./images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("");
		out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("</html>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		out.println("<form method=\"post\" name=\"reg\"  action=\"/ecport/user/modify.do\">");
		out.println("	<input type=\"hidden\" name=\"userid\" value=\"admin\"/>");
		out.println("");
		out.println("	<input type=\"hidden\" name=\"contactid\" value=\"1\"/>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\"./images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=../../index.jsp>达内电子商务门户</a> →用户列表");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"../images/bg2.gif\" width=\"35%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>用户名</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"../images/bg2.gif\" width=\"35%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>密码</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"../images/bg2.gif\" width=\"30%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>操作</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		
		for(Iterator<User> it = userList.iterator();it.hasNext();){
			User user = it.next();
			
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
			out.println("					");
			out.println("						<b>" + user.getUserid() + "</b>");
			out.println("				</td>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
			out.println("					");
			out.println("						<b>" + user.getPassword() + "</b>");
			out.println("				</td>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
			out.println("					");
			out.println("						<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='userModify.html';\" /> ");
			out.println("						<input type=\"button\" value=\"删除\" disabled=\"disabled\" />");
			out.println("				</td>				");
			//out.println("				<td>" + user.getUserid() + "</td>");
			//out.println("				<td>" + user.getPassword() + "</td>");
//			out.println("				<td>" + student.getProvince() + "</td>");
//			out.println("				<td>" + student.getGender() + "</td>");
//			out.println("				<td>" + student.getHobbies() + "</td>");
			out.println("			</tr>");
		}
//		out.println("			<tr>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>admin</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>admin</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='userModify.html';\" /> ");
//		out.println("						<input type=\"button\" value=\"删除\" disabled=\"disabled\" />");
//		out.println("				</td>				");
//		out.println("			</tr>");
//		out.println("				<tr>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>sky</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>sky</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='userModify.html';\" /> ");
//		out.println("						<input type=\"button\" value=\"删除\"  />");
//		out.println("				</td>				");
//		out.println("			</tr>");
//		out.println("				<tr>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>abc</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>abc</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='userModify.html';\" /> ");
//		out.println("						<input type=\"button\" value=\"删除\" />");
//		out.println("				</td>				");
//		out.println("			</tr>");
//		out.println("				<tr>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>tarena</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<b>tarena</b>");
//		out.println("				</td>");
//		out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" height=\"25\"  width=\"35%\">");
//		out.println("					");
//		out.println("						<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='userModify.html';\" /> ");
//		out.println("						<input type=\"button\" value=\"删除\"  />");
//		out.println("				</td>				");
//		out.println("			</tr>");
		out.println("		");
		out.println("</form>");
		out.println("<html>");
		out.println("	<body>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("		  <tr>");
		out.println("");
		out.println("		    <td height=\"17\" background=\"/ecport/images/bot_bg.gif\"></td>");
		out.println("		  </tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("		  <tr>");
		out.println("		    <td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
		out.println("			<p align=\"center\">");
		out.println("				Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\">");
		out.println("");
		out.println("				<b><font face=\"Verdana,\">Tarena</font></b>");
		out.println("				<font color=#CC0000>.com.cn</font>");
		out.println("			</a></p><br>");
		out.println("		    </td>");
		out.println("		  </tr>");
		out.println("		</table>");
		out.println("	</body>");
		out.println("</html>");
		
		out.close();
	}
@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
