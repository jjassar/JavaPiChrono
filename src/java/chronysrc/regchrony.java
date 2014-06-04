package chronysrc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP LAPTOP
 */
public class regchrony extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
            String fname=request.getParameter("fname");
            String lname=request.getParameter("lname");
            String email=request.getParameter("email");
            String dop=request.getParameter("pod");
            String cname=request.getParameter("cname");
            String cno=request.getParameter("phone");
            String pass=request.getParameter("pass");
            String chserial=request.getParameter("chserial");
            String chtype=request.getParameter("chtype");
            
            
           
            
       if(checkReg(chserial))
       {
           
            System.out.println(chserial);
         try {
            
          
            Connection con= factory.confac.getConnection();
         // String q="update reg(fname,lname,email,dop,contact,password,chtype) values(?,?,?,?,?,?,?) "
         //         + "where chserial=" + chserial ;
           
           String q="UPDATE reg SET fname = ? , lname = ? , email = ? , dop = ? , contact = ? , password = ? , "
                   + "chtype = ? WHERE chserial = ? ";
                  
          PreparedStatement ps= con.prepareStatement(q);
          ps.setString(1,fname);
          ps.setString(2,lname);
          ps.setString(3,email);
          ps.setString(4,dop);
          ps.setString(5,cno);
          ps.setString(6,pass);
          ps.setString(7,chtype);
          
          ps.setString(8,chserial);
          
          /*
          ps.setString(2,lname);
          ps.setString(3,email);
          ps.setString(4,dop);
          ps.setString(5,cno);
          ps.setString(6,pass);
          ps.setString(7,chtype);
          */
          
          ps.executeUpdate();
          ps.close();
      
         // response.sendRedirect("regsucess.jsp");
          
             }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
     
         HttpSession session=request.getSession();
                session.setAttribute("name", email);
                session.setAttribute("chser", chserial);
           RequestDispatcher rd=request.getRequestDispatcher("regsucess.jsp");
            rd.forward(request, response);
          
        }
       else
       {
           
             request.setAttribute("error", "No new Chrony found in database.... !");
          RequestDispatcher rd=request.getRequestDispatcher("RegisterChrony.jsp");
            rd.forward(request, response); 
       }
    }

    
    private boolean checkReg(String chserial)
  {
      boolean exists = false;
         try {
             Connection con= factory.confac.getConnection();
             Statement stmt= con.createStatement();
             ResultSet rs= stmt.executeQuery("select * from reg where fname is null");
             
             while(rs.next())
             {
                 
                 
                 if(rs.getString(11).equalsIgnoreCase(chserial))
                 {
                     
                     
                     
                     exists=true;
                    
                 }
                 
                 
                
             }      
         
             con.close();
         } 
         catch (SQLException ex) {
             Logger.getLogger(RegNewChrony.class.getName()).log(Level.SEVERE, null, ex);
         }
         
          return exists;
  }
    
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
