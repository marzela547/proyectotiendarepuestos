/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicionales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class Conection {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "daniel100";
    private static final String url = "jdbc:mysql://localhost:3306/bdrepuestos?characterEncoding=utf8";
    
    //**********
    // Metodos públicos
    //*********
    
    /**
    * 
    * @param con Connection
    * Método que se encarga de establecer la conexion con MySQL
    * @return Connection
    */
    public static Connection getConexion(Connection con)
    {
        if (con == null)
        {
            try 
            {
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.120/inventariohospital","root","daniel100"  );
		con = DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "SQLException: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "SQLState: " + ex.getSQLState());
                JOptionPane.showMessageDialog(null, "VendorError: " + ex.getErrorCode());
            }
        }
        return con;
    }
}
