/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.PedidosModelo;
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
public class PedidosConexion {
     public static ArrayList<PedidosModelo> Listadopedido(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<PedidosModelo> pedidos = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From pedidos "
                     + "WHERE Pedestado = 'ACT' " 
                     + "ORDER BY Pedcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        PedidosModelo pedido = new PedidosModelo();
                        pedido.setProcodigo(rss.getInt("Procodigo"));
                        pedido.setPedfecha(rss.getString("Pedfecha"));
                        pedido.setEmpcodigo(rss.getInt("Empcodigo"));;
                        pedido.setPedestado(rss.getString("Pedestado"));
                        pedidos.add(pedido);
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
                    String query = "SELECT * From pedidos "
                     + "WHERE Pedestado = 'INA' " 
                     + "ORDER BY Pedcodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        PedidosModelo pedido = new PedidosModelo();
                        pedido.setProcodigo(rss.getInt("Procodigo"));
                        pedido.setPedfecha(rss.getString("Pedfecha"));
                        pedido.setEmpcodigo(rss.getInt("Empcodigo"));;
                        pedido.setPedestado(rss.getString("Pedestado"));
                        pedidos.add(pedido);
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
                    String query = "SELECT * From pedidos";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        PedidosModelo pedido = new PedidosModelo();
                        pedido.setProcodigo(rss.getInt("Procodigo"));
                        pedido.setPedfecha(rss.getString("Pedfecha"));
                        pedido.setEmpcodigo(rss.getInt("Empcodigo"));;
                        pedido.setPedestado(rss.getString("Pedestado"));
                        pedidos.add(pedido);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return pedidos;
    }
      public static String Mantenimientopedidos(String accion, PedidosModelo PedidosModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoPedidos(?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
           System.out.println(accion);
            cs.setInt               (2, PedidosModelo.getPedcodigo()); 
            System.out.println(PedidosModelo.getPedcodigo()+"<------------");
            cs.setInt               (3, PedidosModelo.getProcodigo());
            System.out.println(PedidosModelo.getProcodigo()+"<------------");
            cs.setString            (4, PedidosModelo.getPedfecha()); 
            System.out.println(PedidosModelo.getPedfecha()+"<------------");
            cs.setInt               (5, PedidosModelo.getEmpcodigo());
            System.out.println(PedidosModelo.getEmpcodigo()+"<------------");
            cs.setString               (6, PedidosModelo.getPedestado());
            System.out.println(PedidosModelo.getPedestado()+"<------------");
            cs.setInt               (7, PedidosModelo.getDetpedcant()); 
            cs.registerOutParameter (8, Types.VARCHAR);
            
            cs.executeUpdate();
            estado = cs.getString(8);
            System.out.println(estado);
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
        } 
        return estado;
    }
      public static ArrayList<PedidosModelo> Listadotemp() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<PedidosModelo> pedidos = new ArrayList<>();
        
        
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From temp "
                     + "ORDER BY Tempcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        PedidosModelo pedido = new PedidosModelo();
                        pedido.setProdcodigo(rss.getInt("Tempprodcodigo"));
                        pedido.setProddescripcion(rss.getString("Tempproddescripcion"));
                        pedido.setDetpedprodprecio(rss.getFloat("Tempprodprecventa"));;
                        pedido.setDetpedcant(rss.getInt("Tempprodcanti"));
                        pedidos.add(pedido);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            

        return pedidos;
    }
      public static String Mantenimientotemp(String accion, PedidosModelo PedidosModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
            System.out.println("abskiidi");
            query = "{CALL MantenimientoTemp(?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            System.out.println(accion);
            cs.setInt               (2, PedidosModelo.getProdcodigo());
            cs.setString            (3, PedidosModelo.getProddescripcion());
            cs.setFloat             (4, PedidosModelo.getDetpedprodprecio());
            cs.setInt               (5, PedidosModelo.getDetpedcant());
            cs.registerOutParameter (6, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(6);

            System.out.println(estado);
            //System.out.println("PASO AQUI");
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
            System.out.println("ERRRRROOOOOR");
        } 
        return estado;
    }
}
