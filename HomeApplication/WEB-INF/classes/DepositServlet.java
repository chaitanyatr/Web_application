import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class DepositServlet extends GenericServlet{
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
long account=Long.parseLong(request.getParameter("account"));
int amount=Integer.parseInt(request.getParameter("amount"));
try{
ps=con.prepareStatement("update bofa set amount=amount+? where account=?");
ps.setInt(1,amount);
ps.setLong(2,account);
int rs=ps.executeUpdate();
if(rs!=0)
request.getRequestDispatcher("/home.html").forward(request,response);
}
catch(Exception e){
e.printStackTrace();
}
}
}