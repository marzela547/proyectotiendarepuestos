/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.EmpleadosModelo;
import Modelos.PuestoModelo;
import Models.Models.KitModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fgodo
 */
public class EmpleadosConexion {

      public static ArrayList<EmpleadosModelo> Listadoempleado(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<EmpleadosModelo> empleados = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From empleados "
                     + "WHERE Empestado = 'ACT' " 
                     + "ORDER BY Empcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        EmpleadosModelo empleado = new EmpleadosModelo();
                        empleado.setEmpcodigo(rss.getInt("Empcodigo"));
                        empleado.setEmpidentidad(rss.getString("Empidentidad"));
                        empleado.setEmpnombre(rss.getString("Empnombre"));;
                        empleado.setEmptelefono(rss.getString("Emptelefono"));     
                        empleado.setEmpfechanacimiento(rss.getString("Empfechanacimiento"));;
                        empleado.setEmpdireccion(rss.getString("Empdireccion"));   
                        empleado.setEmpfechaingreso(rss.getString("Empfechaingreso"));;
                        empleado.setEmpfechasalidad(rss.getString("Empfechasalida"));
                        empleado.setEmpcorreo(rss.getString("Empcorreo"));
                        empleado.setEmpestado(rss.getString("Empestado"));
                        empleados.add(empleado);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;
                
            case "Inactivos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From empleados "
                     + "WHERE Empestado = 'INA' " 
                     + "ORDER BY Empcodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        EmpleadosModelo empleado = new EmpleadosModelo();
                        empleado.setEmpcodigo(rss.getInt("Empcodigo"));
                        empleado.setEmpidentidad(rss.getString("Empidentidad"));
                        empleado.setEmpnombre(rss.getString("Empnombre"));;
                        empleado.setEmptelefono(rss.getString("Emptelefono"));     
                        empleado.setEmpfechanacimiento(rss.getString("Empfechanacimiento"));;
                        empleado.setEmpdireccion(rss.getString("Empdireccion"));   
                        empleado.setEmpfechaingreso(rss.getString("Empfechaingreso"));;
                        empleado.setEmpfechasalidad(rss.getString("Empfechasalida"));
                        empleado.setEmpcorreo(rss.getString("Empcorreo"));
                        empleado.setEmpestado(rss.getString("Empestado"));
                        empleados.add(empleado);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break; 
                
            case "Todos":
                try
                {
                    con =Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From empleados ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        EmpleadosModelo empleado = new EmpleadosModelo();
                        empleado.setEmpcodigo(rss.getInt("Empcodigo"));
                        empleado.setEmpidentidad(rss.getString("Empidentidad"));
                        empleado.setEmpnombre(rss.getString("Empnombre"));;
                        empleado.setEmptelefono(rss.getString("Emptelefono"));     
                        empleado.setEmpfechanacimiento(rss.getString("Empfechanacimiento"));;
                        empleado.setEmpdireccion(rss.getString("Empdireccion"));   
                        empleado.setEmpfechaingreso(rss.getString("Empfechaingreso"));;
                        empleado.setEmpfechasalidad(rss.getString("Empfechasalida"));
                        empleado.setEmpcorreo(rss.getString("Empcorreo"));
                        empleado.setEmpestado(rss.getString("Empestado"));
                        empleados.add(empleado);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return empleados;
    }      
    
    
    public static ArrayList<PuestoModelo> Listadopuestos() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<PuestoModelo> puestos = new ArrayList<>();

                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM puestos"
                            + " WHERE Pueestado = 'ACT'";

                     rss = stm.executeQuery(query); 

                     while(rss.next())
                     {
                        PuestoModelo puesto = new PuestoModelo();
                        puesto.setPuecodigo(rss.getInt("Puecodigo"));
                        puesto.setPuedescripcion(rss.getString("Puedescripcion"));
                        puesto.setPueestado(rss.getString("Pueestado"));
                        puestos.add(puesto);
                     }  
                        con.close();
                } 
                catch (SQLException e)
                {
                     JOptionPane.showMessageDialog(null,e);
                } 

        return puestos;
    }
    public static String Mantenimientoempleados(String accion, EmpleadosModelo EmpleadosModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoEmpleados(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            System.out.println(accion);
            cs.setInt               (2, EmpleadosModelo.getEmpcodigo()); 
            cs.setString            (3, EmpleadosModelo.getEmpidentidad());
            cs.setString            (4, EmpleadosModelo.getEmpnombre());
            cs.setString            (5, EmpleadosModelo.getEmptelefono());
            cs.setString            (6, EmpleadosModelo.getEmpfechanacimiento()); 
            cs.setString            (7, EmpleadosModelo.getEmpdireccion());
            cs.setString            (8, EmpleadosModelo.getEmpfechaingreso());
            cs.setString            (9, EmpleadosModelo.getEmpfechasalidad());
            cs.setString            (10,EmpleadosModelo.getEmpcorreo());
            cs.setString            (11, EmpleadosModelo.getEmpestado());
            cs.registerOutParameter (12, Types.VARCHAR);
            
            cs.executeUpdate();
            estado = cs.getString(12);
            System.out.println(estado);
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
        } 
        return estado;
    }
   
    
}
