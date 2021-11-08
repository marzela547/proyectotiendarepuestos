/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;


import Modelos.ContactoModelo;
import Modelos.ProveedorModelo;
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
public class ContactoConexion {
    
    public static ArrayList<ContactoModelo> Listadocontacto(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ContactoModelo> contactos = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT Concodigo,Connombre,Contelefono,Concorreo,a.Procodigo,Pronombre,Conestado FROM contactos as a " 
                     + "INNER JOIN proveedores b on a.Procodigo=b.Procodigo "
                     + "WHERE Conestado = 'ACT' " 
                     + "ORDER BY Concodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ContactoModelo contacto = new ContactoModelo();
                        contacto.setConcodigo(rss.getInt("Concodigo"));
                        contacto.setConnombre(rss.getString("Connombre"));
                        contacto.setContelefono(rss.getString("Contelefono"));
                        contacto.setConcorreo(rss.getString("Concorreo"));
                        contacto.setProcodigo(rss.getInt("a.Procodigo"));
                        contacto.setPronombre(rss.getString("Pronombre"));
                        contacto.setConestado(rss.getString("Conestado"));
                        contactos.add(contacto);
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
                    String query = "SELECT Concodigo,Connombre,Contelefono,Concorreo,a.Procodigo,Pronombre,Conestado FROM contactos as a " 
                     + "INNER JOIN proveedores b on a.Procodigo=b.Procodigo "
                     + "WHERE Conestado = 'INA'" 
                     + "ORDER BY Concodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ContactoModelo contacto = new ContactoModelo();
                        contacto.setConcodigo(rss.getInt("Concodigo"));
                        contacto.setConnombre(rss.getString("Connombre"));
                        contacto.setContelefono(rss.getString("Contelefono"));
                        contacto.setConcorreo(rss.getString("Concorreo"));
                        contacto.setProcodigo(rss.getInt("a.Procodigo"));
                        contacto.setPronombre(rss.getString("Pronombre"));
                        contacto.setConestado(rss.getString("Conestado"));
                        contactos.add(contacto);;
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
                    String query = "SELECT Concodigo,Connombre,Contelefono,Concorreo,a.Procodigo,Pronombre,Conestado FROM contactos as a " 
                     + "INNER JOIN proveedores b on a.Procodigo=b.Procodigo";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ContactoModelo contacto = new ContactoModelo();
                        contacto.setConcodigo(rss.getInt("Concodigo"));
                        contacto.setConnombre(rss.getString("Connombre"));
                        contacto.setContelefono(rss.getString("Contelefono"));
                        contacto.setConcorreo(rss.getString("Concorreo"));
                        contacto.setProcodigo(rss.getInt("a.Procodigo"));
                        contacto.setPronombre(rss.getString("Pronombre"));
                        contacto.setConestado(rss.getString("Conestado"));
                        contactos.add(contacto);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return contactos;
    }      
    public static ArrayList<ProveedorModelo> Listadoproveedores() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProveedorModelo> proveedores = new ArrayList<>();

                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM proveedores"
                            + " WHERE Proestado = 'ACT'";

                     rss = stm.executeQuery(query); 

                     while(rss.next())
                     {
                        ProveedorModelo proveedor = new ProveedorModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("ProNombre"));
                        proveedores.add(proveedor);
                     }  
                        con.close();
                } 
                catch (SQLException e)
                {
                     JOptionPane.showMessageDialog(null,e);
                } 

        return proveedores;
    }    
    
    public static Integer IdPro (String proveedor)
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT Procodigo FROM proveedores "
                    + "WHERE Pronombre= '"+proveedor+"'";
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("Procodigo");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }
        
    
    
    
    
    public static String Mantenimientocontacto(String accion, ContactoModelo ContactoModelo)
    { 
        String estado = "";
        Connection con = null;     
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoContacto(?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            cs.setInt               (2, ContactoModelo.getConcodigo()); 
            cs.setString            (3, ContactoModelo.getConnombre());
            cs.setString            (4, ContactoModelo.getContelefono());
            cs.setString            (5, ContactoModelo.getConcorreo());
            cs.setInt               (6, ContactoModelo.getProcodigo());
            cs.setString            (7, ContactoModelo.getConestado()); 
            cs.registerOutParameter (8, Types.VARCHAR);           
            cs.executeUpdate();
            estado = cs.getString(8);
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
            System.out.println(estado);
        } 
        return estado;
    }
}    
 