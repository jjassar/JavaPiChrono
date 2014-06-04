/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chronysrc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jagdeep
 */
public class RecvRecords extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         BufferedReader reader = request.getReader();
        
        StringBuilder sb = new StringBuilder();
        
        String line = reader.readLine();
        
        while(line != null)
        {
            sb.append(line);
            line = reader.readLine();
        }
        
        
        String data = sb.toString();
        
        
        System.out.println(data);
        
        String dat = data.substring(0, data.length()-1);
        
        String[] records = data.split("!");
        
        for(int i = 0; i < records.length; i++)
        {
            System.out.println(i);
            String[] rows = records[i].split(",");
            System.out.println(rows[0]);
            System.out.println(rows[1]);
            System.out.println(rows[2]);
        Timestamp ts = Timestamp.valueOf(rows[2]);
        java.sql.Time ti = new java.sql.Time(ts.getTime());
        java.sql.Date da = new java.sql.Date(ts.getTime());
            System.out.println(ti.toString());
            System.out.println(da.toString());
            
            addRecord(rows[0], rows[1], ti, da);
            
            
        }
        

        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          
            out.println("Online");
            
            
        } finally {
            out.close();
        }
    }

    
    private void addRecord(String ser, String vel, Time t, Date d)
    {
             
        
        
        
         try {
            
          
            Connection con= factory.confac.getConnection();
           String q="insert into velrecords(chserial,velocity,ftime,fdate) values(?,?,?,?)";
           
                 
          PreparedStatement ps= con.prepareStatement(q);
          ps.setString(1, ser);
          ps.setString(2,vel);
          ps.setTime(3, t);
          ps.setDate(4,d);
          
          
      //    ps.setString(3,t);

          
          ps.executeUpdate();
          ps.close();
      
         // response.sendRedirect("regsucess.jsp");
          
             }
        catch(SQLException e)
        {
        e.printStackTrace();
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

