/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pry_tiendarepuestos;

import Controladores.ContactoControlador;
import Modelos.ConsultaContacto;
import Modelos.ContactoModelo;
import Pantallas.FrmContacto;

/**
 *
 * @author Ryuk
 */
public class pry_tiendarepuestosContacto {
    
    public void main(String [] args){
        ContactoModelo mod= new ContactoModelo();
        ConsultaContacto modC = new ConsultaContacto();
        FrmContacto frm = new FrmContacto();
        
        ContactoControlador ctrl= new ContactoControlador(mod,modC,frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
