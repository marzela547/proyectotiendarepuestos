
package Controladores;

import Modelos.ConsultaContacto;
import Modelos.ContactoModelo;
import Pantallas.FrmContacto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ContactoControlador implements ActionListener{
    private ContactoModelo mod;
    private ConsultaContacto modC;
    private FrmContacto frm;
    
    public ContactoControlador (ContactoModelo mod, ConsultaContacto modC, FrmContacto frm)
    {
        this.mod=mod;
        this.modC=modC;
        this.frm=frm;
        
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("ContactoModelo");
        frm.setLocationRelativeTo(null);
        frm.txtIdContacto.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        //GUARDAR
        if(e.getSource()==frm.btnGuardar){
            mod.setConnombre(frm.txtNombre.getText());
            mod.setContelefono(frm.txtTelefono.getText());
            mod.setConcorreo(frm.txtCorreo.getText());
            mod.setProcodigo1(Integer.parseInt(frm.txtProveedor.getText()));
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
        }
        
        //MODIFICAR
        if(e.getSource()==frm.btnModificar){
            mod.setConcodigo(Integer.parseInt(frm.txtIdContacto.getText()));
            mod.setConnombre(frm.txtNombre.getText());
            mod.setContelefono(frm.txtTelefono.getText());
            mod.setConcorreo(frm.txtCorreo.getText());
            mod.setProcodigo1(Integer.parseInt(frm.txtProveedor.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
        }
        
        //ELIMINAR
        if(e.getSource()==frm.btnEliminar){
            mod.setConcodigo(Integer.parseInt(frm.txtIdContacto.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
        }
        
        //BUSCAR
        if(e.getSource()==frm.btnBuscar){
            mod.setConnombre(frm.txtNombre.getText());
            
            if(modC.registrar(mod)){
                frm.txtIdContacto.setText(String.valueOf(mod.getConcodigo()));
                frm.txtNombre.setText(mod.getConnombre());
                frm.txtTelefono.setText(mod.getContelefono());
                frm.txtCorreo.setText(mod.getConcorreo());
                frm.txtProveedor.setText(String.valueOf(mod.getProcodigo1()));
            }else{
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
        }
        
        //LIMPIAR
        if(e.getSource()==frm.btnLimpiar){
            limpiar();
        } 
    }
    public void limpiar()
    {
       frm.txtIdContacto.setText(null); 
       frm.txtNombre.setText(null); 
       frm.txtTelefono.setText(null); 
       frm.txtCorreo.setText(null); 
       frm.txtProveedor.setText(null); 
    }
    
    
}
