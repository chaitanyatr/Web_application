<!DOCTYPE HTML>
<html>

<head>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
   <link rel="shortcut icon" type="image/x-icon" href="images/brainstorming_alternative.png"/>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  <script>
      function validation(){
          if(document.name.token.value==0){
              alert('Enter your token');
              document.name.token.focus();
              return false;
          }
      }
  </script>
  
  <style>
      form,h1{
          position: relative;
          left: 350px;
          
      }
      
    #id{
        width: 200px;
        height: 25px;
        background-color: #D5D5D5;
    }
    #but{
        width: 60px;
        height: 25px;
    }
</style>
</head>
<body>
  <div id="main">
    
    <div id="site_content">
<header>
      <div id="logo">
        <div id="logo_text">
        
          <pre>
          <h1 ><a href="index.html" >Hdfc Bank</a></h1>
          <h2 style="font-size: 22px">Transfer Amount Anywhere</h2></pre>
        </div>
      </div>
      <nav>
        <ul class="sf-menu" id="nav">
          <li ><a href="deposit.html">Deposit</a></li>
          <li><a href="withdrawl.jsp">WithDrawl</a></li>
          <li><a href="balance.jsp">Balance Enquiry</a></li>
	  <li><a href="profile.jsp">Profile</a></li>
        
          <li><a href="#"><img width="40" height="40" src="images/user.png" alt="photo_two" /></a>
            <ul>
                <li><a href="index.html">Logout</a></li>
<!--                <li><a href="register.html">Register</a></li>-->
             
            </ul>
          </li>
         
        </ul>
      </nav>
    </header>

      <div id="content">
         
<%@page import="java.sql.*" %>

<%
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
ps=con.prepareStatement("select * from bofa");
rs=ps.executeQuery();
%>


	<table border="2">
	<tr><td>Username </td><td>Email</td><td>Phone </td><td>Account</td></tr>
	<%
	while(rs.next()){
	%>
	<tr><td><%=rs.getString(1)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td></tr>

		<%
	}
	
	%>
	</table>
       
      </div>
    </div>
    <footer>
      <p>Copyright &copy; 2014. All Rights Reserved.</p>
    </footer>
  </div>
  <p>&nbsp;</p>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
  <script type="text/javascript" src="js/image_fade.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>
</body>
</html>

