<%
  String id=(String)session.getAttribute("user");
%>
<html>
    <body>
        <h3>Welcome <%=id%></h3>
        <hr>
        <pre>
        <a href="SubjectServlet">View-Books</a>
        <a href="">Search-By-Title</a>
        <a href="">Search-By-Author</a>
        <a href="">View-Cart</a>
        <a href="">Logout</a>
        </pre>
        <hr>
    </body>
</html>
