<%
    int code=Integer.parseInt(request.getParameter("code"));
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
    String sql="select * from books where bcode=?";
    java.sql.PreparedStatement ps=con.prepareStatement(sql);
    ps.setInt(1, code);
    java.sql.ResultSet rs=ps.executeQuery();
    rs.next();
    String bcode=rs.getString(1);
    String title=rs.getString(2);
    String author=rs.getString(3);
    String subject=rs.getString(4);
    String price=rs.getString(5);
%>
<html>
    <body>
        <h3>Book-Details</h3>
        <hr>
        <table border="2" width="2" cellspacing="2" cellpadding="2">
            <tbody>
                <tr>
                    <td>BCode</td>
                    <td><% out.print(bcode); %></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><% out.println(title);%></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><% out.println(author);%></td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td><% out.println(subject);%></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><% out.println(price);%></td>
                </tr>
            </tbody>
        </table>
        <hr>
        <a href="buyerpage.jsp">Buyer-Page</a>
    </body>
</html>
<%
    con.close();
%>