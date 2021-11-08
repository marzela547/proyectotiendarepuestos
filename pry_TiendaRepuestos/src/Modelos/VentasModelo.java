
package Modelos;

import Controladores.VentaControlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VentasModelo {
    
    public ArrayList<VentaControlador> getTipoPago()
    {
        Connection con = null;
        con = Conexiones.Conexion.getConexion(con);
        Statement stmt;
        ResultSet rs;
        
        ArrayList<VentaControlador> listaTipoPago = new ArrayList<>();
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tiposdepagos;");
            
            while(rs.next())
            {
                VentaControlador Venta = new VentaControlador();
                Venta.setTippacodigo(rs.getInt("Tippacodigo"));
                Venta.setTippsDesc(rs.getString("TippaDesc"));
                listaTipoPago.add(Venta);
            }
          
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        return listaTipoPago;
    }
}
 