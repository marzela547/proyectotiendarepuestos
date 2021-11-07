/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.PedidosModelo;
import Modelos.TempModelo;
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
public class TempConexion {
    public static ArrayList<TempModelo> Listadotemp() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<TempModelo> modelo = new ArrayList<>();
        
        
                try
                {
                    con =Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From temp";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        TempModelo temp = new TempModelo();
                        temp.setTempprodcodigo(rss.getInt("Tempprodcodigo"));
                        temp.setTempproddescripcion(rss.getString("Tempproddescripcion"));
                        temp.setTempprodprecventa(rss.getFloat("Tempprodprecventa"));;
                        temp.setTempprodcanti(rss.getInt("Tempprodcanti"));
                        modelo.add(temp);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 

        return modelo;
    }
}
