package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PriceListHandler extends SimpleTagSupport {

    private String subject="computers";

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/booksdata";
            Connection con=DriverManager.getConnection(url, "root","root");
            String sql="select * from books where subject=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,subject);
            ResultSet rs=ps.executeQuery();
            out.println("<table border=2>");
            out.println("<tr><td>Title</td><td>Price</td><td>Subject</td></tr>");
            while(rs.next()){
                String s1=rs.getString("btitle");
                String s2=rs.getString("price");
                String s3=rs.getString("subject");
                out.println("<tr>");
                out.println("<td>"+s1+"</td>");
                out.println("<td>"+s2+"</td>");
                out.println("<td>"+s3+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception ex) {

        }
    }
    
}
