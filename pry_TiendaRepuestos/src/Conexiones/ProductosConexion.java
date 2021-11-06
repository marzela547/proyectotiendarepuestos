/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.ProductosModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class ProductosConexion {
     public static ArrayList<ProductosModelo> Listadoproducto(String accion, int cod) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
       // cod = 2;
        ArrayList<ProductosModelo> productos = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From productos"
                     + "WHERE Prodestado = 'ACT' " 
                     + "ORDER BY Prodcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProdcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));
                        producto.setProdestado(rss.getString("Prodestado"));;
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
                    String query = "SELECT * From productos "
                     + "WHERE Prodestado = 'INA' " 
                     + "ORDER BY Prodcodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProdcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));
                        producto.setProdestado(rss.getString("Prodestado"));;
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
                    String query = "SELECT pp.Prodcodigo, Proddescripcion, Prodprecventa, Prodestado FROM productos p JOIN `productos-proveedores` pp "
                            + "ON p.Prodcodigo = pp.Prodcodigo JOIN proveedores pv "
                            + "ON pv.Procodigo = pp.Procodigo "
                            + "WHERE pp.Procodigo = "+cod 
                            + " ORDER BY pp.Prodcodigo ASC";
                    
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ProductosModelo producto = new ProductosModelo();
                        producto.setProdcodigo(rss.getInt("Prodcodigo"));
                        producto.setProddescripcion(rss.getString("Proddescripcion"));
                        producto.setProdprecventa(rss.getFloat("Prodprecventa"));
                        producto.setProdestado(rss.getString("Prodestado"));;
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
