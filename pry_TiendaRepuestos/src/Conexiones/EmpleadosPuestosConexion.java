package Conexiones;




import Modelos.EmpleadosModelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fgodo
 */
public class EmpleadosPuestosConexion {

      public static ArrayList<EmpleadosModelo> ListadoPuestoEmpleados(Integer Empcodigo) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<EmpleadosModelo> empleados = new ArrayList<>();

        try
        {
            con =Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "Select Pueempcodigo,Empcodigo,Puedescripcion  FROM `puesto-empleado` a INNER JOIN puestos b on a.Puecodigo=b.Puecodigo WHERE Empcodigo="+Empcodigo+";";
            rss = stm.executeQuery(query);
            while (rss.next()) 
            {
                EmpleadosModelo empleado = new EmpleadosModelo();
                empleado.setPueempcodigo(rss.getInt("Pueempcodigo"));
                empleado.setPuedecripcion(rss.getString("Puedescripcion"));
                empleados.add(empleado);
            }
              con.close();
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 


        return empleados;
    }      
    
        
    
    public static Integer  isGerente(Integer id) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        Integer valor = 0; 
        String pu="Gerente";
         try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "Select count(Pueempcodigo) as contador FROM `puesto-empleado`"
                    + "WHERE Empcodigo="+id+" AND Puecodigo=1";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                valor=rss.getInt("contador");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return valor;           
    }    
    
    public static Integer UltimoEmpleadoId ()
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            System.out.println("llego 1");
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT Empcodigo FROM empleados "
                    + "ORDER BY Empcodigo DESC LIMIT 1;";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("Empcodigo");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }     
    public static Integer IdPue (String Puesto )
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT Puecodigo FROM puestos "
                    + "WHERE Puedescripcion= '"+Puesto+"'";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("Puecodigo");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }
    
    public static String MantenimientoEmpleadoPuesto(String accion, EmpleadosModelo EmpleadosModelo)
    {
        String estado = "";
        Connection con = null;
        try
        {
            
            String query;
            con = Conexion.getConexion(con);
            query = "{CALL MantenimientoEmpleadoPuesto(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            System.out.println(accion);
            cs.setInt               (2, EmpleadosModelo.getPueempcodigo());
            System.out.println( EmpleadosModelo.getPueempcodigo());
            cs.setInt               (3, EmpleadosModelo.getEmpcodigo());
            System.out.println( EmpleadosModelo.getEmpcodigo());
            cs.setInt               (4, EmpleadosModelo.getPuecodigo());
            System.out.println( EmpleadosModelo.getPuecodigo());
            cs.registerOutParameter (5, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(5);
            System.out.println(estado);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }    
}
