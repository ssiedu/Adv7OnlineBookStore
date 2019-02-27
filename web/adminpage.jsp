<%
    session.setMaxInactiveInterval(1200);
    int n=session.getMaxInactiveInterval();
%>
<html>
    <body>
        <h3>Welcome Admin</h3>
          <h3>If you remain idle for <%=n%> seconds, your session will expire</h3>
        <hr>
        <pre>
        <a href="bookentry.jsp">Add-New-Book</a>
        <a href="">Update-Books</a>
        <a href="">Remove-Books</a>
        <a href="">View-Orders</a>
        <a href="">Logout</a>
        </pre>
        <hr>
    </body>
</html>
