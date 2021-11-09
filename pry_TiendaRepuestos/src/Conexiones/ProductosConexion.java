/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.ProductosModelo;
import Modelos.ProveedoresModelo;
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
 * @author marce
 */
public class ProductosConexion {
     public static ArrayList<ProductosModelo> ListadoProducto(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProductosModelo> productos = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT Prodcodigo,Proddescripcion,Prodprecventa,c.Tipdescripcion,b.Mardescripcion,Proexistencia,Prodcantidadminima,Prodestado FROM productos a " 
                     + "INNER JOIN marcas b on a.Marcodigo=b.Marcodigo " 
                     + "INNER JOIN tipoproducto c on c.Tipcodigo=a.Tipcodigo "
                     + "WHERE Prodestado = 'ACT' " 
                     + "ORDER BY Prodcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));;
                        producto.setTipdescripcion(rss.getString("c.Tipdescripcion"));
                        producto.setMardescripcion(rss.getString("b.Mardescripcion"));
                        producto.setProexistencia(rss.getInt("Proexistencia"));
                        producto.setProdcantidadminima(rss.getInt("Prodcantidadminima"));
                        producto.setEstado(rss.getString("Prodestado"));
                        productos.add(producto);
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
                    String query = "SELECT Prodcodigo,Proddescripcion,Prodprecventa,c.Tipdescripcion,b.Mardescripcion,Proexistencia,Prodcantidadminima,Prodestado FROM productos a " 
                     + "INNER JOIN marcas b on a.Marcodigo=b.Marcodigo " 
                     + "INNER JOIN tipoproducto c on c.Tipcodigo=a.Tipcodigo "
                     + "WHERE Prodestado = 'INA' " 
                     + "ORDER BY Prodcodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));;
                        producto.setTipdescripcion(rss.getString("c.Tipdescripcion"));
                        producto.setMardescripcion(rss.getString("b.Mardescripcion"));
                        producto.setProexistencia(rss.getInt("Proexistencia"));
                        producto.setProdcantidadminima(rss.getInt("Prodcantidadminima"));
                        producto.setEstado(rss.getString("Prodestado"));
                        productos.add(producto);
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
                    String query = "SELECT Prodcodigo,Proddescripcion,Prodprecventa,c.Tipdescripcion,b.Mardescripcion,Proexistencia,Prodcantidadminima,Prodestado FROM productos a " 
                     + "INNER JOIN marcas b on a.Marcodigo=b.Marcodigo " 
                     + "INNER JOIN tipoproducto c on c.Tipcodigo=a.Tipcodigo ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));;
                        producto.setTipdescripcion(rss.getString("c.Tipdescripcion"));
                        producto.setMardescripcion(rss.getString("b.Mardescripcion"));
                        producto.setProexistencia(rss.getInt("Proexistencia"));
                        producto.setProdcantidadminima(rss.getInt("Prodcantidadminima"));
                        producto.setEstado(rss.getString("Prodestado"));
                        productos.add(producto);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return productos;
    }
     
    public static ArrayList<ProductosModelo> Listadomarcas() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProductosModelo> marcas = new ArrayList<>();

                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM marcas"
                            + " WHERE Marestado = 'ACT'";

                     rss = stm.executeQuery(query); 

                     while(rss.next())
                     {
                        ProductosModelo marca = new ProductosModelo();
                        marca.setMarcodigo(rss.getInt("Marcodigo"));
                        marca.setMardescripcion(rss.getString("Mardescripcion"));
                        marcas.add(marca);
                     }  
                        con.close();
                } 
                catch (SQLException e)
                {
                     JOptionPane.showMessageDialog(null,e);
                } 

        return marcas;
    }   
    public static ArrayList<ProductosModelo> Listadotipos() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProductosModelo> tipos = new ArrayList<>();

                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM tipoproducto"
                            + " WHERE Tipestado = 'ACT'";

                     rss = stm.executeQuery(query); 

                     while(rss.next())
                     {
                        ProductosModelo tipo = new ProductosModelo();
                        tipo.setTipcodigo(rss.getInt("Tipcodigo"));
                        tipo.setTipdescripcion(rss.getString("Tipdescripcion"));
                        tipos.add(tipo);
                     }  
                        con.close();
                } 
                catch (SQLException e)
                {
                     JOptionPane.showMessageDialog(null,e);
                } 

        return tipos;
    }   
    
    public static Integer IdMarca (String marca)
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT Marcodigo FROM marcas "
                    + "WHERE Mardescripcion= '"+marca+"'";
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("Marcodigo");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }

    public static Integer IdTipo (String tipo)
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT Tipcodigo FROM tipoproducto "
                    + "WHERE Tipdescripcion= '"+tipo+"'";
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("Tipcodigo");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }    


     

     public static String MantenimientProductos(String accion, ProductosModelo ProductosModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoProductos(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);   
            cs.setInt               (2, ProductosModelo.getProcodigo()); 
           
            cs.setString            (3,  ProductosModelo.getProddescripcion());
            cs.setFloat             (4,  ProductosModelo.getProdprecventa());
            cs.setInt               (5,  ProductosModelo.getTipcodigo());
            cs.setInt               (6,  ProductosModelo.getMarcodigo());
            cs.setInt               (7,  ProductosModelo.getProexistencia()); 
            cs.setInt               (8,  ProductosModelo.getProdcantidadminima());
            cs.setString            (9,  ProductosModelo.getEstado());
            cs.registerOutParameter (10, Types.VARCHAR);           
            cs.executeUpdate();
            estado = cs.getString(10);
            System.out.println(estado);
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
        } 
        return estado;
    }
     public static ArrayList<ProductosModelo> Listadoproducto(String accion, int cod) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
       // cod = 2;
        ArrayList<ProductosModelo> productos = new ArrayList<>();
        
        switch(accion)
        {
                
            case "detalle":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT dp.Prodcodigo, Proddescripcion, Detpedcant, Detpedprodprecio FROM detallepedido dp JOIN productos p  "
                            + "ON dp.Prodcodigo = p.Prodcodigo "
                            + "WHERE Pedcodigo = "+cod 
                            + " ORDER BY dp.Prodcodigo ASC";
                    
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setDetpedcant(rss.getInt("Detpedcant"));
                        producto.setProdprecventa(rss.getFloat("Detpedprodprecio"));
                        
                        productos.add(producto);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break; 
                
            case "proveedor":
                try
                {
                    con =Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT pp.Prodcodigo, Proddescripcion, Prodprecventa, Prodestado FROM productos p JOIN `productos-proveedores` pp "
                            + "ON p.Prodcodigo = pp.Prodcodigo JOIN proveedores pv "
                            + "ON pv.Procodigo = pp.Procodigo "
                            + "WHERE pp.Procodigo = "+cod 
                            + " ORDER BY pp.Prodcodigo ASC";
                    
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));
                        producto.setEstado(rss.getString("Prodestado"));;
                        productos.add(producto);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return productos;
    }
}
