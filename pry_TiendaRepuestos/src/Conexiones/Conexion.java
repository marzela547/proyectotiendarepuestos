

package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "pintura123";
    private static final String url = "jdbc:mysql://localhost:3306/bdrepuestos?characterEncoding=utf8";
    private Connection con = null;
    
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
               
            }
        }
        return con;
    }
}
