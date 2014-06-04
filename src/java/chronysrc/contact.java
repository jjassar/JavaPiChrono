package chronysrc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author HP LAPTOP
 */
public class contact extends HttpServlet {

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
            
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String website=request.getParameter("website");
            String message=request.getParameter("message");
          final  String emailid="maansarb751@gmail.com";
          final  String password="7696388826";
Properties prop=new Properties();
prop.put("mail.smtp.auth","true");
prop.put("mail.smtp.starttls.enable", "true");
prop.put("mail.smtp.host","smtp.gmail.com");
prop.put("mail.smtp.port","587");
		
Session s=Session.getInstance(prop,
		new Authenticator() {
protected  PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(emailid, password);
	}
	}
 );
		
	Message m=new MimeMessage(s);	
m.setFrom(new InternetAddress(email));
m.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailid));
m.setSubject("Contact mail");
		m.setText("Dear Admin,"+"\n"+
        "Someone want to connect with you"+"\n"+ "Details are : "+"\n"+
        "Name : "+name+"\n"+
        "emailid : "+email+"\n"+
        "website : "+website+"\n"+
        "mesaage : "+message+"\n");
		Transport.send(m);
out.println("<script type='text/javascript'> alert('Mail sent')   </script>");
		response.sendRedirect("contact.html");
	}
	catch(Exception e)
	{
	out.println(e);
		
	}
	
    

            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contact at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");


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
