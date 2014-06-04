/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP LAPTOP
 */
public class confac {
    
public static Connection getConnection()
{
Connection con=null;
try{
Class.forName("com.mysql.jdbc.Driver");
      con= DriverManager.getConnection("jdbc:mysql://localhost:3306/chronydata","root","cisco");
    
}
catch(Exception e)
{}
    return con;
        
        



}
    
    
    
}
