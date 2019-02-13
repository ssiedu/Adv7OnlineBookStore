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

public class VerifyUser extends HttpServlet {
    
   Connection con; PreparedStatement ps;

    @Override
    public void init(){
        String sql="select uname from users where userid=? and password=?";
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
        ps=con.prepareStatement(sql);            
            
        }catch(Exception e){}
        
    }
    
    @Override
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){}
                
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //VerifyUser?userid=aaa&password=bbb&utype=Admin
        String uid=request.getParameter("userid");
        String pw=request.getParameter("password");
        String utype=request.getParameter("utype");
        
        if(utype.equals("Admin")){
            //admin-check
            if(uid.equals("admin") && pw.equals("indore")){
              response.sendRedirect("adminpage.jsp");
            }else{
                out.println("Invalid Admin Account");
            }
            
        }else{
            //buyer-check (users)
            try{
                ps.setString(1, uid);
                ps.setString(2, pw);
                ResultSet rs=ps.executeQuery();
                boolean found=rs.next();
                if(found){
                    response.sendRedirect("buyerpage.jsp");
                }else{
                    out.println("Invalid Buyer Account");
                }
                
            }catch(Exception e){
                out.println(e);
            }
            
            
            
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
