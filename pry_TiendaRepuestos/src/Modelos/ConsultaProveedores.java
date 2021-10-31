package Modelos;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaProveedores extends Conexion {

    //registrar
    public boolean registrar(ProveedoresModelo prov) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO proveedores (Pronombre,Prodireccion,Protelefono) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, prov.getPronombre());
            ps.setString(2, prov.getProdireccion());
            ps.setString(3, prov.getProtelefono());
            ps.execute();
            return true;

        } catch (SQLException e) {
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
    
    //Modificar
    public boolean modificar(ProveedoresModelo prov) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE proveedores SET Pronombre=?, Prodireccion=?,Protelefono=? WHERE Procodigo=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, prov.getPronombre());
            ps.setString(2, prov.getProdireccion());
            ps.setString(3, prov.getProtelefono());
            ps.setInt(4, prov.getProcodigo());
            ps.execute();
            return true;

        } catch (SQLException e) {
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
    
    //Eliminar
    public boolean eliminar(ProveedoresModelo prov) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM proveedores WHERE Procodigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getProcodigo());
            ps.execute();
            return true;

        } catch (SQLException e) {
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
    //Buscar
    public boolean buscar(ProveedoresModelo prov) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();

        String sql = "SELECT * FROM proveedores WHERE Pronombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getPronombre());
            rs=ps.executeQuery();
            
            if(rs.next()){
                prov.setProcodigo(Integer.parseInt(rs.getString("Procodigo")));
                prov.setPronombre(rs.getString("Pronombre"));
                prov.setProdireccion(rs.getString("Prodireccion"));
                prov.setProtelefono(rs.getString("Protelefono"));
                return true;
            }
            return false;

        } catch (SQLException e) {
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
