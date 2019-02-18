import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //will show the details of the book
        //whose title is clicked by user
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int code=Integer.parseInt(request.getParameter("code"));
        String sql="select * from books where bcode=?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, code);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String bcode=rs.getString(1);
            String title=rs.getString(2);
            String author=rs.getString(3);
            String subject=rs.getString(4);
            String price=rs.getString(5);
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Book Details</h3>");
            out.println("<hr>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<td>Code</td>");
            out.println("<td>"+code+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Title</td>");
            out.println("<td>"+title+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Author</td>");
            out.println("<td>"+author+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Subject</td>");
            out.println("<td>"+subject+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Price</td>");
            out.println("<td>"+price+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=CartManager?code="+code+">Add-To-Cart</a><br>");
            out.println("<a href=SubjectServlet>SubjectPage</a><br>");
            out.println("<a href=buyerpage.jsp>BuyerPage</a>");
            out.println("</body>");
            out.println("</html>");
            con.close();
        }catch(Exception e){
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
