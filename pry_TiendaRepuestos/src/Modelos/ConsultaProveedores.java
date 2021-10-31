package Modelos;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaProveedores extends Conexion{
    
    //registrar
    public boolean registrar(ProveedoresModelo prov){
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql ="INSERT INTO proveedores (Pronombre,Prodireccion,Protelefono) VALUES(?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            
            ps.setString(1,prov.getPronombre());
            ps.setString(2,prov.getProdireccion());
            ps.setString(3,prov.getProtelefono());
            
        }catch(SQLException e){
            
        }
        
    }
    
}
