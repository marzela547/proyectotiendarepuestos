package Controladores;
import Modelos.ConsultaProveedores;
import Modelos.ProveedoresModelo;
import Pantallas.FrmProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ProveeedoresControlador implements ActionListener {
    private ProveedoresModelo mod;
    private ConsultaProveedores modC;
    private FrmProveedores frm;
    
    public ProveeedoresControlador(ProveedoresModelo mod, ConsultaProveedores modC, FrmProveedores frm)
    {
        this.mod= mod;
        this.modC=modC;
        this.frm=frm;
        
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("ProveedoresModelo");
        frm.setLocationRelativeTo(null);
        frm.txtCodigo.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
     if(e.getSource()==frm.btnGuardar){
        // mod.setProcodigo(Integer.parseInt(frm.txtCodigo.getText()));
         mod.setPronombre(frm.txtNombre.getText());
         mod.setProdireccion(frm.txtDireccion.getText());
         mod.setProtelefono(frm.txtTelefono.getText());
         
         if(modC.registrar(mod)){
             JOptionPane.showMessageDialog(null, "Registro Guardado");
             limpiar();
         }else{
             JOptionPane.showMessageDialog(null,"Error al Guardar");
         }
     } 
     
     if(e.getSource()==frm.btnModificar){
         mod.setProcodigo(Integer.parseInt(frm.txtCodigo.getText()));
         mod.setPronombre(frm.txtNombre.getText());
         mod.setProdireccion(frm.txtDireccion.getText());
         mod.setProtelefono(frm.txtTelefono.getText());
         
         if(modC.modificar(mod)){
             JOptionPane.showMessageDialog(null, "Registro Modificado");
             limpiar();
         }else{
             JOptionPane.showMessageDialog(null,"Error al Modificadar");
         }
     }
     
     if(e.getSource()==frm.btnEliminar){
         mod.setProcodigo(Integer.parseInt(frm.txtCodigo.getText()));
         
         if(modC.eliminar(mod)){
             JOptionPane.showMessageDialog(null, "Registro eliminado");
             limpiar();
         }else{
             JOptionPane.showMessageDialog(null,"Error al eliminar");
         }
     }
     
     if(e.getSource()==frm.btnBuscar){
         mod.setPronombre(frm.txtNombre.getText());
         
         if(modC.buscar(mod)){
             frm.txtCodigo.setText(String.valueOf(mod.getProcodigo()));
             frm.txtNombre.setText(mod.getPronombre());
             frm.txtDireccion.setText(mod.getProdireccion());
             frm.txtTelefono.setText(mod.getProtelefono());
             
         }else{
             JOptionPane.showMessageDialog(null,"Error al buscar");
         }
     }
     
     if(e.getSource()==frm.btnLimpiar){
         limpiar();
     }
     
     
    }
    
    public void limpiar()
    {
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtDireccion.setText(null);
        frm.txtTelefono.setText(null);
    }
}
