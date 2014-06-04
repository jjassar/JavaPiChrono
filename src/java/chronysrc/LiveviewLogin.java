package chronysrc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class LiveviewLogin extends HttpServlet {

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
        try {
         //   List l=new LinkedList();
            
            String id=request.getParameter("email");
            String pass=request.getParameter("pass");
            
             Connection con= factory.confac.getConnection();
               Statement stmt= con.createStatement();
               ResultSet rs= stmt.executeQuery("select * from reg");
               String cname=null;
            String uname=null;
            boolean valid =false;
            while(rs.next())
            {
            if(rs.getString(4).equalsIgnoreCase(id) && rs.getString(8).equals(pass))
            {
            valid=true;
            
            uname=rs.getString(2)+" "+rs.getString(3);
            cname=rs.getString(11);
            }
              
            }
            if(valid==true)
            {
                HttpSession session=request.getSession();
                session.setAttribute("username", uname);
                session.setAttribute("cname", cname);
                request.setAttribute("chn", cname);
            RequestDispatcher rd=request.getRequestDispatcher("LiveDisplay.jsp");
            rd.forward(request, response);
            }
            
           else
             {
              request.setAttribute("error", "Invalid User Or Password !");
                 RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
                 rd.forward(request, response);
             }
            
             
            
        } catch (IOException e) {
            out.println(e);
        } catch (SQLException e) {            
            out.println(e);
       } catch (ServletException e) {
           out.println(e);
       } finally {            
            out.close();
        }
    }

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
