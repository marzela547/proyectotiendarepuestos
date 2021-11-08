/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especiales;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author fgodo
 */
public class Validaciones {
    public static Boolean validarCampoVacio(String campo)
    {
        return campo.matches("^\\s*$");
    }
    
    public static Boolean validarIdentidad(String identidad)
    {
        return identidad.matches("\\d{4}-?\\d{4}-?\\d{5}$");
    }
    public static Boolean validarRTN(String identidad)
    {
        return identidad.matches("\\d{4}-?\\d{4}-?\\d{6}$");
    }
    public static Boolean validarUsuario(String usuario)
    {
        return usuario.matches("^[a-zA-Z0-9ÁÉÍÓÚÜÑáéíóúüñ]*$");
    }
    
    public static Boolean validarNumeros(String num) 
    {
        return num.matches("[0-9]+");
    }
    public static Boolean validarNumerosDouble(String num) 
    {
        return num.matches("([0-9]+[.]?|[0-9]*[.][0-9]{0,2})");
    }
    public static Boolean validarLetras(String letras) 
    {
        return letras.matches("[a-zA-ZÁÉÍÓÚÜÑáéíóúüñ ]+");
    }
    
    public static Boolean ValidarNumerosyLetras(String campo)
    {
       return campo.matches("^[A-Za-z0-9ÁÉÍÓÚÜÑáéíóúüñ _]*[A-Za-z0-9ÁÉÍÓÚÜÑáéíóúüñ][A-Za-z0-9ÁÉÍÓÚÜÑáéíóúüñ _]*$"); 
    }

    public static Boolean validarCorreo(String correo) 
    {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return correo.matches(regex);
    }
    
    public static Boolean validarContrasenia(String contrasenia) 
    {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return contrasenia.matches(regex);
    }   
    
    public static boolean validarContraseniaCoincide(String contrasenia, String confirmcontrasenia)
    {
        if(contrasenia.equals(confirmcontrasenia))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static Boolean validarStocks(String n1 , String n2)
    {
        Integer N1,N2;
        N1= Integer.parseInt(n1);
        N2= Integer.parseInt(n2);
        if(N1>=N2){return  true;}else{return  false;}
    }

    public static Boolean validarmayor0(String n1)
    {
        Integer N1;
        N1= Integer.parseInt(n1);
        if(N1>0){return  true;}else{return  false;}
    }
    
    public static boolean validarTabla(JTable tabla)
    {
        if(0<tabla.getRowCount())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static String Fechavacia(Date fecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String Date ="";
        if (fecha != null)
        {
            Date=formatter.format(fecha);
        }
        return Date; 
    }
    
    public static boolean validarTamanosNom(String nom){
        if(nom.length()<3){
            return false;
        }
        
        return true;
    }
    public static boolean validarTamanosNum( String num){
        if(num.length() <7){
            return false;
        }
        
        return true;
    }
   
    /**
    * 
    * @param fecha String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false.
    * @return Boolean
    */
     public static Boolean ValidarFormatoFecha(String fecha)
    {
        String regex= "^\\d{4}([\\/])(0?[1-9]|1[0-2])\\1(3[01]|[12][0-9]|0?[1-9])$";
        return fecha.matches(regex);
    }
    
    /**
    * 
    * @param fecha String
    * Si la fecha de Caducidad es mayor a la fecha actual retorna true,
    * de lo contrario retorna false.
    * @return Boolean
    */
    public static Boolean ValidarFecha(String fecha)
    {        
        Date ahora = new Date();
        SimpleDateFormat convertidor = new SimpleDateFormat("yyyy/MM/dd");
        String actual = convertidor.format(ahora);
        
            try 
            {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                formatoFecha.setLenient(false);
                formatoFecha.parse(fecha);

                if(fecha.compareTo(actual)<0)
                {
                    return true;
                }

                } 
            catch (Exception e) 
            {
                return false;
            }
        
        return false;
    }
    
    public static Boolean validarNomenclatura(String letras) 
    {
        return letras.matches("[a-zA-Z]{3}");
    }   
    
    public static Integer validarMayorEdad(String facimiento)
    {
        String hoy= String.valueOf(LocalDate.now());
        Date Datehoy = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Integer anio =0;
        JDateChooser today = new JDateChooser();
        JDateChooser nacimiento = new JDateChooser();
        try
        {
            Datehoy = formatter.parse(hoy);  
            today.setDate(Datehoy);  
            Datehoy = formatter.parse(facimiento);
            nacimiento.setDate(Datehoy);
              anio = today.getCalendar().get(Calendar.YEAR)-nacimiento.getCalendar().get(Calendar.YEAR);
              Integer mes = today.getCalendar().get(Calendar.MONTH)-nacimiento.getCalendar().get(Calendar.MONTH);
              Integer dia = today.getCalendar().get(Calendar.DATE)-nacimiento.getCalendar().get(Calendar.DATE);
              if(mes<0 ||(mes==0 && dia<0)){
                anio =anio-1;
                } 
             return anio; 
        }catch(Exception e)
        {
            System.out.println("error");
        
        }
        
        return 0;
    }
    public static boolean validarlimitemined(String fingreso)
    {
        String hoy= String.valueOf(LocalDate.now());
        Date Datehoy = null;
        boolean limi=false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Integer anio =0;
        JDateChooser today = new JDateChooser();
        JDateChooser nacimiento = new JDateChooser();
        try
        {
            Datehoy = formatter.parse(hoy);  
            today.setDate(Datehoy);  
            Datehoy = formatter.parse(fingreso);
            nacimiento.setDate(Datehoy);
            anio = today.getCalendar().get(Calendar.YEAR)-nacimiento.getCalendar().get(Calendar.YEAR);

            if(anio < 70)
            {
                limi= false;
            }else
            {
                limi=  true;
            }
            
        }catch(Exception e)
        {
            System.out.println("error");
        
        }
        return limi;
       
    }    
    public static boolean validarlimitemaxingreso(String fecha)
    {

        String hoy= String.valueOf(LocalDate.now());
        Date Datehoy = null;
        boolean limi=false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Integer anio =0;
        JDateChooser today = new JDateChooser();
        JDateChooser ingreso = new JDateChooser();
        try
        {
            Datehoy = formatter.parse(hoy);  
            today.setDate(Datehoy);  
            Datehoy = formatter.parse(fecha);
            ingreso.setDate(Datehoy);
            anio = today.getCalendar().get(Calendar.YEAR)-ingreso.getCalendar().get(Calendar.YEAR);
            Integer mes = today.getCalendar().get(Calendar.MONTH)-ingreso.getCalendar().get(Calendar.MONTH);
            Integer dia = today.getCalendar().get(Calendar.DATE)-ingreso.getCalendar().get(Calendar.DATE);         
            

            if(today.getCalendar().get(Calendar.DATE)>=ingreso.getCalendar().get(Calendar.DATE))
            {
                if(today.getCalendar().get(Calendar.MONTH)>=ingreso.getCalendar().get(Calendar.MONTH))
                {
                    if(today.getCalendar().get(Calendar.YEAR)>=ingreso.getCalendar().get(Calendar.YEAR))
                    {
                        limi= false;

                    }else{
                        limi= true;
                    }   
                    
                }else{
                    limi= true;
                }                
            }else{
                limi= true;
            }     
        }catch(Exception e)
        {
            System.out.println("error");
        
        }
        return limi;
       
    }
    public static boolean validarfechaingresosalida(String fechai,String fechas)
    {
        String hoy= String.valueOf(LocalDate.now());
        Date Datehoy = null;
        boolean limi=false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Integer anio =0;
        JDateChooser ingreso = new JDateChooser();
        JDateChooser salida = new JDateChooser();
        try
        {
            Datehoy = formatter.parse(fechas);  
            salida.setDate(Datehoy);  
            Datehoy = formatter.parse(fechai);
            ingreso.setDate(Datehoy);
            anio = salida.getCalendar().get(Calendar.YEAR)-ingreso.getCalendar().get(Calendar.YEAR);
            Integer mes = salida.getCalendar().get(Calendar.MONTH)-ingreso.getCalendar().get(Calendar.MONTH);
            Integer dia = salida.getCalendar().get(Calendar.DATE)-ingreso.getCalendar().get(Calendar.DATE);            
            
              if(mes<0 ||(mes==0 && dia<0)){
                anio =anio-1;
                }
            
            
            if(anio>0)
            {
                limi= false;
            }else
            {
                limi=  true;
            }
            
        }catch(Exception e)
        {
            System.out.println("error");
        
        }
        return limi;
       
    }      
    
    
    }
    
    public static Boolean validarSelecciones(JTextField proveedor, JComboBox cmbtipo, JTable tabla){
        if(proveedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor");
            return false;
        }else
            if( cmbtipo.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un tipo de pago");
                return false;
            }else
                if(tabla.getRowCount() <1){
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto a ordenar");
                    return false;
                }
        return true;
    }
}
