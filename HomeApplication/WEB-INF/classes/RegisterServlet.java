import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class RegisterServlet extends GenericServlet{
Connection con=null;
PreparedStatement ps=null;
public void init(ServletConfig config){
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
}catch(Exception e){
e.printStackTrace();
}
}
public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException{
String username=request.getParameter("username");
String password=request.getParameter("password");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
int mobile=Integer.parseInt(phone);
long account=Long.parseLong(request.getParameter("account"));
int amount=Integer.parseInt(request.getParameter("amount"));
int x=0;
try{
ps=con.prepareStatement("insert into bofa values(?,?,?,?,?,?)");
ps.setString(1,username);
ps.setString(2,password);
ps.setString(3,email);
ps.setInt(4,mobile);
ps.setLong(5,account);
ps.setInt(6,amount);
x=ps.executeUpdate();
}catch(Exception e){
e.printStackTrace();
}
PrintWriter pw=response.getWriter();
pw.println("<html><body bgcolor='wheat'><center>");
if(x!=0){
pw.println(username+" Registered successfully now login");
request.getRequestDispatcher("/login.html").include(request,response);
}
else{
pw.println(username+" not registered");
request.getRequestDispatcher("/login.html").include(request,response);
}
pw.println("</center></body></html>");
}
}