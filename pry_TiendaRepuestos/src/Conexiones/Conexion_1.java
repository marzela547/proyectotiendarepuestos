/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author marlo
 */
public class Conexion_1 {
 
    private final String base="bdrespuestos";
    private final String user="root";
    private final String password="Paolamejia15";
    private final String url="jdbc:mysql://localhost:3306/" + base;
    private Connection  con =null;
    
    
    
    public   Connection getConenection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(this.url,this.user,this.password);
        }catch(SQLException e)
        {
           // System.err.println(e);
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            return con;
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

