/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fgodo
 */
public class Conexion {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "pintura123";
    private static final String url = "jdbc:mysql://localhost:3306/bdrepuestos?characterEncoding=utf8";

    public static Connection getConexion(Connection con)
    {
        if (con == null)
        {
            try 
            {
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
