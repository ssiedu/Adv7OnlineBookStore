<%
  long val=session.getCreationTime();
  java.util.Date dt=new java.util.Date(val);
  session.setMaxInactiveInterval(1800);
  int n=session.getMaxInactiveInterval();
  String id=(String)session.getAttribute("user");
  if(id==null){
      response.sendRedirect("index.jsp");
  }
%>
<html>
    <body>
        <h3>Welcome <%=id%></h3>
        <%--        
        <h3>You are with us since : <%=dt%></h3>
        <h3>If you remain idle for <%=n%> seconds, your session will expire</h3>
        --%>
        <hr>
        <pre>
        <a href="SubjectServlet">View-Books</a>
        <a href="searchbyid.jsp">Search-Book-By-Id</a>
        <a href="">Search-By-Title</a>
        <a href="">Search-By-Author</a>
        <a href="DisplayCart">View-Cart</a>
        <a href="KillSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>
