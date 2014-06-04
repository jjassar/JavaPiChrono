package chronysrc;











/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author jagdeepsingh
 */
public class RegNewChrony extends HttpServlet {
    
    
     String u,p;
    
    String s2="";
    
    boolean valid=false;

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
        
    
        
        
        
        
    BufferedReader reader = request.getReader();
    StringBuilder sb = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
        //sb.append(line + "\n");
        sb.append(line);
        line = reader.readLine();
    }
    reader.close();
    String data = sb.toString();
    
       System.out.println(data);
       
       String[] arr = data.split(",");
       
    
   /*
    JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(data);
            
            JSONObject jsonObject = (JSONObject) obj;
            
             u = (String) jsonObject.get("user");
             p = (String) jsonObject.get("pass");
        
            
             
             
            System.out.println(u);
            
            System.out.println(p);
            
           
           
            
             } catch (ParseException ex) {
            System.out.println(ex);
                 
                 
            Logger.getLogger(Jsonrece.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        */
        
       boolean prev_reg = checkReg(arr[1]);
       System.out.println(String.valueOf(prev_reg));
       
       
       
        if(!(prev_reg))
        {
           try {
            
            
          Connection con=   factory.confac.getConnection();
          String q="insert into reg(chmac,chserial) values(?,?)";
          PreparedStatement ps= con.prepareStatement(q);
          ps.setString(1,arr[0]);
          ps.setString(2,arr[1]);
      
          
          ps.executeUpdate();
       
         
          
        } catch (SQLException ex) {
         ex.printStackTrace();
            
            Logger.getLogger(RegNewChrony.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.print(String.valueOf(prev_reg));
            // TODO output your page here. You may use following sample code. 
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Jsonrece</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Jsonrece at " + request.getContextPath() + "</h1>");
            
             out.println(s2);
             
             
            out.println("</body>");
            out.println("</html>");*/
            
        } finally {            
            out.close();
        }
        
        
        
    }

    
  private boolean checkReg(String chserial)
  {
      boolean exists = false;
         try {
             Connection con= factory.confac.getConnection();
             Statement stmt= con.createStatement();
             ResultSet rs= stmt.executeQuery("select * from reg");
             
             while(rs.next())
             {
                 
                 
                 if(rs.getString(11).equalsIgnoreCase(chserial))
                 {
                     
                     
                     exists=true;
                    
                 }
                 
                 
                
             }      } catch (SQLException ex) {
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

