
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaContacto {
    String con = null;
    
    //registrar
    public boolean registrar(ContactoModelo contac){
        PreparedStatement ps= null;
        Connection con= null;
        con=Conexiones.Conexion.getConexion(con);
        
        String sql="INSERT INTO contactos(Connombre,Contelefono,Concorreo,Procodigo) VALUE(?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, contac.getConnombre());
            ps.setString(2, contac.getContelefono());
            ps.setString(3, contac.getConcorreo());
            ps.setInt(4, contac.getProcodigo1());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    //modificar
    public boolean modificar(ContactoModelo contac) {
        PreparedStatement ps= null;
        Connection con= null;
        con=Conexiones.Conexion.getConexion(con);
        
        String sql="UPDATE contactos SET Connombre=?,Contelefono=?,Concorreo=?,Procodigo=? WHERE Concodigo=?";
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, contac.getConnombre());
            ps.setString(2, contac.getContelefono());
            ps.setString(3, contac.getConcorreo());
            ps.setInt(4, contac.getProcodigo1());
            ps.setInt(5, contac.getConcodigo());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    //eliminar
    public boolean eliminar(ContactoModelo contac) {
        PreparedStatement ps= null;
        Connection con= null;
        con=Conexiones.Conexion.getConexion(con);
        
        String sql="DELETE FROM contactos WHERE Concodigo=?";
        try{
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, contac.getConcodigo());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    //buscar
    public boolean buscar(ContactoModelo contac) {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con= null;
        con=Conexiones.Conexion.getConexion(con);
        
        String sql="SELECT * FROM contactos WHERE Connombre=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, contac.getConnombre());
            rs=ps.executeQuery();
            if(rs.next()){
                contac.setConcodigo(Integer.parseInt(rs.getString("Concodigo")));
                contac.setConnombre(rs.getString("Connombre"));
                contac.setContelefono(rs.getString("Contelefono"));
                contac.setConcorreo(rs.getString("Concorreo"));
                contac.setProcodigo1(Integer.parseInt(rs.getString("Procodigo1")));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
