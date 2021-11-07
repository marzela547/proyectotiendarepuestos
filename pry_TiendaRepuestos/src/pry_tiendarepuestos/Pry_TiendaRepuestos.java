/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pry_tiendarepuestos;

import Controladores.ProveeedoresControlador;
import Modelos.ConsultaProveedores;
import Modelos.ProveedoresModelo;
import Pantallas.FrmProveedores;

/**
 *
 * @author Kevin Espinal
 */
public class Pry_TiendaRepuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProveedoresModelo mod= new ProveedoresModelo();
        ConsultaProveedores modC=new ConsultaProveedores();
        FrmProveedores frm=new FrmProveedores();
        
        ProveeedoresControlador ctrl =new ProveeedoresControlador(mod,modC,frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
