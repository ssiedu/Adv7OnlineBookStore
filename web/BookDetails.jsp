<%@page isELIgnored="true" errorPage="myerrorpage.jsp" session="true" isThreadSafe="true"  contentType="text/html" language="java" import="java.sql.*" %>


<%@include file="info.jsp" %>
<%!
    int highDis=20;
    int lowDis=10;
int getDiscount(int pr){
        int dis=0;
        if(pr>=1000){
            dis=pr*lowDis/100;
        }else{
            dis=pr*highDis/100;
        }
        return dis;
    }
%>
<%
    int code=Integer.parseInt(request.getParameter("code"));
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
    String sql="select * from books where bcode=?";
    PreparedStatement ps=con.prepareStatement(sql);
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
        <h3>Welcome <%=session.getAttribute("user")%></h3>
        <h3>Book-Details</h3>
        <hr>
        <table border="2" width="2" cellspacing="2" cellpadding="2">
            <tbody>
                <tr>
                    <td>BCode</td>
                    <td><%=bcode%></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><%=title%></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><%=author%></td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td><%=subject%></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><%=price%></td>
                </tr>
                <tr>
                    <td>Disc</td>
                    <td><%=getDiscount(Integer.parseInt(price))%></td>
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