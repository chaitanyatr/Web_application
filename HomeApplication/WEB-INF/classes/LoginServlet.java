import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;  
public class LoginServlet extends GenericServlet{
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
public void init(ServletConfig config){
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
}catch(Exception e){
e.printStackTrace();
}
}

public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
String username=request.getParameter("username");
String password=request.getParameter("password");
try{
ps=con.prepareStatement("select * from bofa where username=? and password=?");
ps.setString(1,username);
ps.setString(2,password);
rs=ps.executeQuery();
PrintWriter pw=response.getWriter();
pw.println("<html><body bgcolor='wheat'><center><h2>");
if(rs.next()){
//pw.println("Logged in successfully");
RequestDispatcher rd=request.getRequestDispatcher("/home.html");
rd.forward(request,response);
//request.getRequestDispatcher("/home.html").forward(request,response);
}
else{
pw.println("Failed to login");
request.getRequestDispatcher("/login.html").include(request,response);
}
}
catch(Exception e){
e.printStackTrace();
}
}
}