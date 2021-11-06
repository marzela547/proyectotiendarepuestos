/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.EmpleadosConexion;
import Conexiones.EmpleadosPuestosConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Modelos.CacheEmpleado;
import Modelos.EmpleadosModelo;
import Modelos.PuestoModelo;
import Especiales.Validaciones;
import Pantallas.Mantenimiento_empeadospantalla;
import static Pantallas.Mantenimiento_empeadospantalla.tabla_puesto;
import com.toedter.calendar.JDateChooser;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author fgodo
 */
public class EmpleadoControlador {
    static Integer op = 0;
 
    public static void setPlaceHolders(JTextField txtidentidad, JTextField txtnombre, JTextField txttelefono,
        JTextField txtcorreo, JTextArea txtdireccion ,JTextField txtusuario,JTextField txtcontrasena,
            JTextField txtcontrasenac)
    {
            PlaceHolder placeholderidentidad = new PlaceHolder("Ingrese la Identidad ", txtidentidad);
            PlaceHolder placeholdernombre = new PlaceHolder(" Ingrese el Nombre ", txtnombre);
            PlaceHolder placeholdertelefono = new PlaceHolder("Ingrese el Telefono  ", txttelefono);
            PlaceHolder placeholderCorreo = new PlaceHolder("Ingrese el Correo ", txtcorreo);
            PlaceHolder placeholderDireccion = new PlaceHolder("Ingrese la Dirección", txtdireccion);
            PlaceHolder placeholderUsuario = new PlaceHolder(" Ingrese el Usuario", txtusuario);
            PlaceHolder placeholderContrasena = new PlaceHolder("Ingrese la Contraseña", txtcontrasena);
            PlaceHolder placeholderContrasenac = new PlaceHolder("Confirme Contraseña", txtcontrasenac);
    }    

    
    public static Boolean Mantenimientoempelado(String accion, Integer id,
            String identidad, String nombre, String telefono , String fechanacimiento, 
            String correo,String direccion ,String fechaningreso, String fechasalida,  String estado,
            String usuario, String contrasena, String cotrasenac,JLabel erridentidad, JLabel errnombre,
            JLabel errtelefono, JLabel errfechanacimiento,   JLabel errcorreo,JLabel errdireccion, JLabel errfechaingreso,
            JLabel errfechasalida,JLabel errusuario,JLabel errcontrasena)
    { 
        
        EmpleadoControlador.Erroresnull(erridentidad,errnombre, errtelefono, errfechanacimiento, errcorreo,
                                            errdireccion,errfechaingreso,errfechasalida,errusuario,errcontrasena);
        String trimmedidentidad = identidad.trim();
        String trimmednombre = nombre.trim();
        String trimmedtelefono = telefono.trim();
        String trimmedfechanacimiento = fechanacimiento.trim();
        String trimmedcorreo = correo.trim();
        String trimmeddireccion = direccion.trim(); 
        String trimmedfechaningreso = fechaningreso.trim();
        String trimmedfechasalida = fechasalida.trim();
        String trimmedusuario = usuario.trim();
        String trimmedcontrasena = contrasena.trim();
        String trimmedcontrasenac = cotrasenac.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        Boolean dohash = false;
        validaciongeneral = EmpleadoControlador.validacionesGenerales( trimmedidentidad,trimmednombre, 
               trimmedtelefono, trimmedfechanacimiento, trimmedcorreo,trimmeddireccion, trimmedfechaningreso, 
               trimmedfechasalida,trimmedusuario,trimmedcontrasena,trimmedcontrasenac,erridentidad,errnombre,
               errtelefono,errfechanacimiento, errcorreo,errdireccion,errfechaingreso,errfechasalida, errusuario, errcontrasena);

        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                    
                    mnterror = EmpleadoControlador.Insertarempleado(trimmedidentidad, trimmednombre,
                            trimmedtelefono, trimmedfechanacimiento,trimmedcorreo,trimmeddireccion,
                            trimmedfechaningreso,trimmedfechasalida, estado,trimmedusuario,trimmedcontrasena);
                break;
                
                case "editar":   
                    mnterror = EmpleadoControlador.Modificarempleo(id,trimmedidentidad, trimmednombre,
                            trimmedtelefono, trimmedfechanacimiento,trimmedcorreo,trimmeddireccion,
                            trimmedfechaningreso,trimmedfechasalida, estado,trimmedusuario,trimmedcontrasena);             
                break;
            }
        }
        
        return !(mnterror == false && validaciongeneral == false);
    }    
    private static void Erroresnull(JLabel erridentidad, JLabel errnombre, JLabel errtelefono,
            JLabel errfechanacimiento, JLabel errcorreo, JLabel errdireccion ,JLabel errfechaingreso,
            JLabel errfechasalida,JLabel errusuario,JLabel errcontrasena )
    {
        errnombre.setText(null);
        erridentidad.setText(null);
        errtelefono.setText(null);
        errfechanacimiento.setText(null);
        errcorreo.setText(null);
        errdireccion.setText(null);
        errfechaingreso.setText(null);
        errfechasalida.setText(null);
        errusuario.setText(null);
        errcontrasena.setText(null);
    }   
    private static boolean validacionesGenerales(String trimmedidentidad,String trimmednombre,
        String trimmedtelefono, String trimmedfechanacimiento, String trimmedcorreo, String trimmeddireccion,
        String trimmedfechaningreso, String trimmedfechasalida,String trimmedusuario,String trimmedcontrasena,
        String trimmedcotrasenac,JLabel erridentidad,JLabel errnombre,JLabel errtelefono,JLabel errfechanacimiento,
        JLabel errcorreo,JLabel errdireccion,JLabel errfechaingreso,JLabel errfechasalida,JLabel errusuario,
        JLabel errcontrasena)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trimmedidentidad))
        {
           erridentidad.setText("Es un campo obligatorio");
           error = true;
        }
        if(!Validaciones.validarIdentidad(trimmedidentidad))
        {
           erridentidad.setText("Formato incorrecto [####-####-#####]");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmednombre))
        {
           errnombre.setText("El nombre es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedtelefono))
        {
           errtelefono.setText("Es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedtelefono))
        {
           errtelefono.setText("El telefono es un campo numerico");
           error = true;
        }      
         if(Validaciones.validarCampoVacio(trimmedcorreo))
        {
           errcorreo.setText("Es un campo obligatorio");
           error = true;
        }       
        if(!Validaciones.validarCorreo(trimmedcorreo))
        {
           errcorreo.setText("Formato erroneo de correo");
           error = true;
        }
        if(trimmedfechanacimiento=="")
        {
           errfechanacimiento.setText("Es un campo obligatorio");
           error = true;
        }
        
        if(trimmedfechaningreso=="")
        {
           errfechaingreso.setText("Es un campo obligatorio");
           error = true;
        }
        if(Validaciones.validarMayorEdad(trimmedfechaningreso)<18)
        {
           errfechaingreso.setText("No permitido menor Edad");
           error = true;
        }
        
        if(Validaciones.validarMayorEdad(trimmedfechanacimiento)<18)
        {
           errfechanacimiento.setText("Debe ser mayor de Edad");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmeddireccion))
        {
           errdireccion.setText("Es un campo obligatorio");
           error = true;
        }
        if(Validaciones.validarCampoVacio(trimmedusuario))
        {
           errusuario.setText("Es un campo obligatorio");
           error = true;
        }
        if(!Validaciones.validarUsuario(trimmedusuario))
        {
           errusuario.setText("Formato incorrecto");
           error = true;
        }
        if(Validaciones.validarCampoVacio(trimmedcontrasena))
        {
           errcontrasena.setText("Es un campo obligatorio");
           error = true;
        }
        if(Validaciones.validarContraseniaCoincide(trimmedcontrasena,trimmedcotrasenac))
        {
           errcontrasena.setText("No coinciden contraseñas");
           error = true;
        }
        if(Validaciones.validarTabla(Mantenimiento_empeadospantalla.tabla_puesto)==true)
        {
            JOptionPane.showMessageDialog(null,"Error la tabla puesto está vacía");
            error = true;
        } 
        return error;
    }   
    private static boolean Insertarempleado(String trimmedidentidad,String trimmednombre,String trimmedtelefono,
            String trimmedfechanacimiento, String trimmedcorreo,  String trimmeddireccion, String trimmedfechaningreso,
            String trimmedfechasalida,String estado,String trimmedusuario, String trimmedcontrasena )
    {
        boolean error = false;
        String hash = null;
        hash = EmpleadoControlador.sha256Encryption(trimmedcontrasena);
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();
        DefaultTableModel model =(DefaultTableModel) tabla_puesto.getModel();
        empleadomodelo = EmpleadoControlador.Setempleadomodelo(0, trimmedidentidad,
                trimmednombre, trimmedtelefono,trimmedfechanacimiento,trimmedcorreo,
                trimmeddireccion,trimmedfechaningreso,"0000-00-00","ACT",trimmedusuario,hash);
        String resultado = EmpleadosConexion.Mantenimientoempleados("insertar", empleadomodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                 System.out.println(EmpleadosPuestosConexion.UltimoEmpleadoId());
                CacheEmpleado.setEmpcodigo(EmpleadosPuestosConexion.UltimoEmpleadoId());
                System.out.println(CacheEmpleado.getEmpcodigo());
                if(MantenimientoPuestoEmpleados("insertar",0,CacheEmpleado.getEmpcodigo(),model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Empleado ingresado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los puestos.");
                }                
                
                                 
            break;
            
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
             case "errIdentidad":
                JOptionPane.showMessageDialog(null, "Numero de Identidad ya se encuentra registrado.");
                error = true;
            break;
            case "errTelefono":
                JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static boolean Modificarempleo(Integer id,String trimmedidentidad,String trimmednombre,String trimmedtelefono,
            String trimmedfechanacimiento, String trimmedcorreo,  String trimmeddireccion, String trimmedfechaningreso,
            String trimmedfechasalida,String estado,String trimmedusuario,String trimmedcontrasena )
    {
        boolean error = false;
        String hash = null;
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();
        DefaultTableModel model =(DefaultTableModel) tabla_puesto.getModel();
        hash = EmpleadoControlador.sha256Encryption(trimmedcontrasena);
        empleadomodelo = EmpleadoControlador.Setempleadomodelo(id, trimmedidentidad,
                trimmednombre, trimmedtelefono,trimmedfechanacimiento,trimmedcorreo,
                trimmeddireccion,trimmedfechaningreso,"0000-00-00", estado,trimmedusuario,hash);
        String resultado = EmpleadosConexion.Mantenimientoempleados("editar", empleadomodelo);    

        switch (resultado) 
        {
            case "OK": 
                System.out.println("Modifico el empleado ");
                if(MantenimientoPuestoEmpleados("editar",0,id,model ) == false)
                {
                   JOptionPane.showMessageDialog(null, "Producto modificado con éxito.");              
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error modificando los puestos.");
                }
            break;
            
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
             case "errIdentidad":
                JOptionPane.showMessageDialog(null, "Numero de Identidad ya se encuentra registrado.");
                error = true;
            break;
            case "errTelefono":
                JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }    
 
    public static boolean Eliminarempleo(Integer id)
    {
        boolean error = false;
        System.out.println("llegue");
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();
        //DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();
        //CatalogoProductoCache cache = new CatalogoProductoCache();
        //DetalleCatalogoProductosModel detalleproducto = new DetalleCatalogoProductosModel();
        empleadomodelo = EmpleadoControlador.Setempleadomodelo(id, "","", "","","","","","","","","");
        String resultado = EmpleadosConexion.Mantenimientoempleados("eliminar", empleadomodelo);    
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");    
                   error=true;
            break;
            
        }
        return error;
    }    
    public static String sha256Encryption(String data)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) 
            {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private static EmpleadosModelo Setempleadomodelo(Integer id, String trimmedidentidad,
            String trimmednombre, String trimmedtelefono, String trimmedfechanacimiento,String trimmedcorreo,
            String trimmeddireccion, String trimmedfechaningreso, String trimmedfechasalida,String estado,
            String trimmedusuario,String trimmedhash)
    {
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();      
        empleadomodelo.setEmpcodigo(id);
        empleadomodelo.setEmpidentidad(trimmedidentidad);
        empleadomodelo.setEmpnombre(trimmednombre);
        empleadomodelo.setEmptelefono(trimmedtelefono);
        empleadomodelo.setEmpfechanacimiento(trimmedfechanacimiento);
        empleadomodelo.setEmpcorreo(trimmedcorreo);
        empleadomodelo.setEmpdireccion(trimmeddireccion);
        empleadomodelo.setEmpfechaingreso(trimmedfechaningreso);
        empleadomodelo.setEmpfechasalidad(trimmedfechasalida);
        empleadomodelo.setEmpestado(estado);
        empleadomodelo.setEmpusuario(trimmedusuario);
        empleadomodelo.setEmpcontrasena(trimmedhash);
        return empleadomodelo;
    }
     private void LimpiarTodo(JTable tabla_puesto){
        DefaultTableModel model =(DefaultTableModel) tabla_puesto.getModel();
        int fila= model.getRowCount();
        for(int i = 0; i < fila; i++  )
        {       
                model.removeRow(0);  
        }
    }         
    public static void AgregarPuesto(Object[] dataRow,JTable tabla_puestos )
    {
        DefaultTableModel model =(DefaultTableModel) tabla_puestos.getModel();
        
        boolean rp= false;  
           System.out.println(model.getRowCount());
           for(int i =0 ; i<model.getRowCount();i++)
           {
                   System.out.println(model.getValueAt(i,0));
                   if(model.getValueAt(i, 0).equals(dataRow[0]) )
                   {
                       rp=true;
                   }            
           }
           
           
        
            if(rp==false)
            {
                model.addRow(dataRow);     
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Puesto ya seleccionado.");
            }         
         
    }
    public static void Quitarpuestosseleccionados( String puesto_descripcion,JTable tabla_puestos  )
    {
   
        DefaultTableModel model =(DefaultTableModel) tabla_puestos.getModel();
        for(int i = 0; i < model.getRowCount(); i++  )
        {
            if(puesto_descripcion == model.getValueAt(i, 0)){
                model.removeRow(i);
            }  
        }
    }
        public static void Llenarcmbpuestos(JComboBox CmbPuesto)
    {
        ArrayList<PuestoModelo> puestos = new ArrayList<>();
        puestos = EmpleadosConexion.Listadopuestos();
        
        for (int i = 0; i<puestos.size(); i++)
        {
            CmbPuesto.addItem(puestos.get(i).getPuedescripcion());
        }
    }
    public static void Llenartablaempleado(JTable tablaempleado, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaempleado.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<EmpleadosModelo> empleados = new ArrayList<>();
        empleados = EmpleadosConexion.Listadoempleado(accion);
        for (int i = 0; i <empleados.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    empleados.get(i).getEmpcodigo(), 
                    empleados.get(i).getEmpidentidad(),
                    empleados.get(i).getEmpusuario(),
                    empleados.get(i).getEmpnombre(),
                    empleados.get(i).getEmptelefono(), 
                    empleados.get(i).getEmpfechanacimiento(),
                    empleados.get(i).getEmpdireccion(),
                    empleados.get(i).getEmpfechaingreso(), 
                    empleados.get(i).getEmpfechasalidad(),
                    empleados.get(i).getEmpcorreo(),
                    empleados.get(i).getEmpestado()
                    
                }
            );
        } 
        FormatoTabla(tablaempleado, modelo.getColumnCount());
    }
    public static void Llenartablaempleadopuestos(JTable tablaempleado,Integer id) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaempleado.getModel(); 
        modelo.setRowCount(0);
        ArrayList<EmpleadosModelo> empleados = new ArrayList<>();
        empleados = EmpleadosPuestosConexion.ListadoPuestoEmpleados(id);
        for (int i = 0; i <empleados.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    empleados.get(i).getPuedecripcion()
                    
                }
            );
        } 
        FormatoTabla(tablaempleado, modelo.getColumnCount());
    }
    public static Integer SetdatosromCache(JTextField txtidentidad,JTextField txtnombre,JTextField txttelefono,
                JDateChooser txtnacimiento,JTextArea txtdireccion ,JDateChooser txtingreso,
                JDateChooser txtsalida, JTextField txtcorreo, JComboBox cmbestado,JTextField txtusuario)
    {
        Integer EmpId = null;
        CacheEmpleado empcache = new CacheEmpleado();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String Date;
        Date nac=null;
        Date ing=null;
        Date sal = null;
        try{
            nac = formatter.parse(empcache.getEmpleado().getEmpfechanacimiento());
            ing= formatter.parse(empcache.getEmpleado().getEmpfechaingreso());
            sal =formatter.parse(empcache.getEmpleado().getEmpfechasalidad());
        }catch(ParseException ex)
        {
            System.out.println(ex);
        }
  
        
        if(empcache.isDatosCompartidos())
        {
            EmpId = empcache.getEmpleado().getEmpcodigo();
            txtidentidad.setText(empcache.getEmpleado().getEmpidentidad());
            txtnombre.setText(empcache.getEmpleado().getEmpnombre());
            txttelefono.setText(empcache.getEmpleado().getEmptelefono());
            txtnacimiento.setDate(nac);
            txtdireccion.setText(empcache.getEmpleado().getEmpdireccion());
            txtingreso.setDate(ing);
            txtsalida.setDate(sal);
            txtcorreo.setText(empcache.getEmpleado().getEmpcorreo());
            cmbestado.setSelectedItem(empcache.getEmpleado().getEmpestado());
            txtusuario.setText(empcache.getEmpleado().getEmpusuario());
            
        }
        return EmpId;
    }    
    public void setOperacion(Integer ope)
    {
        this.op = ope;
    }
    public static Integer getOperacion()
    {
        Integer opv = op;
        return opv;
    }



    private static Boolean MantenimientoPuestoEmpleados(String accion, Integer id, 
            Integer Empcodigo, DefaultTableModel PuestoModel)
    {
  
        boolean error = false;
        EmpleadosModelo empleadoModelo = new EmpleadosModelo();        
        switch(accion)
        {
            case "insertar":
                error = false;
                for(int i=0; i<PuestoModel.getRowCount(); i++)
                {
                    empleadoModelo.setPueempcodigo(0);
                    empleadoModelo.setEmpcodigo(Empcodigo);
                    empleadoModelo.setPuecodigo(EmpleadosPuestosConexion.IdPue( String.valueOf( PuestoModel.getValueAt(i, 0))));

                    String estado = EmpleadosPuestosConexion.MantenimientoEmpleadoPuesto("insertar", empleadoModelo);       
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
            break;
                case "editar":   
                error = false;
                EmpleadosModelo empleadomodelo = new EmpleadosModelo(); 

                empleadoModelo.setPueempcodigo(0);
                empleadoModelo.setEmpcodigo(Empcodigo);
                empleadoModelo.setPuecodigo(0);

                String estado = EmpleadosPuestosConexion.MantenimientoEmpleadoPuesto("eliminar", empleadoModelo);       
                if(!estado.equals("OK"))
                {
                  error = true;
                }
                
                if(!error)
                {
                    for(int i=0; i<PuestoModel.getRowCount(); i++)
                    {
                        empleadoModelo.setPueempcodigo(0);
                        empleadoModelo.setEmpcodigo(Empcodigo);
                        empleadoModelo.setPuecodigo(EmpleadosPuestosConexion.IdPue( String.valueOf( PuestoModel.getValueAt(i, 0))));

                         String estados = EmpleadosPuestosConexion.MantenimientoEmpleadoPuesto("insertar", empleadoModelo);       
                        if(!estados.equals("OK"))
                        {
                            error = true;
                        }
                    }
                }              
            break;        

        }     
        return error;
    }      
}
