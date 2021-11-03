/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Controladores.ClienteControlador;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marce
 */
public class Mantenimiento_clientespantalla extends javax.swing.JFrame {

    /**
     * Creates new form Mantenimiento_clientespantalla
     */
    
    static Integer IdCli=0;
    Integer mt;
    public Mantenimiento_clientespantalla() {
        initComponents();
        ClienteControlador clientecontrol = new ClienteControlador();
        mt = clientecontrol.getOperacion();
        clientecontrol.setPlaceHolders(this.txtnombre_cliente, this.txtRTN, this.txttelefono_cliente);
        if(mt == 1){ LlenarDatos(); }
    }

        private void Proceso(Integer op)
    {
        mt = op;       
    }
    
    private void LlenarDatos()
    {
        this.IdCli = ClienteControlador.SetdatosromCache(this.txtRTN,
                this.txtnombre_cliente, this.txttelefono_cliente,this.cmbestado_cliente);
                
        if(IdCli != null)
        {
            
            this.btnagregar_cliente.setEnabled(false);
            this.btnmodificar_cliente.setEnabled(true);
            this.btn_eliminar_cliente.setEnabled(true);
        }
    }    
          
    private void LimpiarInputs()
    {
        this.txtRTN.setText(null);
        this.txtnombre_cliente.setText(null);
        this.txttelefono_cliente.setText(null);      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRTN = new javax.swing.JTextField();
        txtnombre_cliente = new javax.swing.JTextField();
        txttelefono_cliente = new javax.swing.JTextField();
        errRTN = new javax.swing.JLabel();
        errnombre = new javax.swing.JLabel();
        btnagregar_cliente = new javax.swing.JButton();
        btnmodificar_cliente = new javax.swing.JButton();
        btn_eliminar_cliente = new javax.swing.JButton();
        cmbestado_cliente = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        errtelefono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txttelefono_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefono_clienteActionPerformed(evt);
            }
        });

        btnagregar_cliente.setText("Agregar");
        btnagregar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_clienteActionPerformed(evt);
            }
        });

        btnmodificar_cliente.setText("Modificar");
        btnmodificar_cliente.setEnabled(false);
        btnmodificar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificar_clienteActionPerformed(evt);
            }
        });

        btn_eliminar_cliente.setText("Eliminar");
        btn_eliminar_cliente.setEnabled(false);
        btn_eliminar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_clienteActionPerformed(evt);
            }
        });

        cmbestado_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACT", "INA" }));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnagregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnmodificar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_eliminar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRTN, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(cmbestado_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errRTN, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRTN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbestado_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errRTN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtnombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(txttelefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelefono_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefono_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefono_clienteActionPerformed

    private void btnagregar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_clienteActionPerformed
        
        if(!ClienteControlador.Mantenimientocliente("insertar", 0,
            this.txtRTN.getText(),this.txtnombre_cliente.getText(), this.txttelefono_cliente.getText(),"ACT",
            this.errRTN, this.errnombre, this.errtelefono))
    {
        this.LimpiarInputs();
        ClientesPantalla clientepantalla = new ClientesPantalla();
        clientepantalla.setVisible(true);
        dispose();
        }
    }//GEN-LAST:event_btnagregar_clienteActionPerformed

    private void btnmodificar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificar_clienteActionPerformed
        
        if(!ClienteControlador.Mantenimientocliente("editar", this.IdCli,
            this.txtRTN.getText(),this.txtnombre_cliente.getText(), this.txttelefono_cliente.getText(), cmbestado_cliente.getSelectedItem().toString(),
            this.errRTN, this.errnombre, this.errtelefono ))
    {
        this.LimpiarInputs();
        ClientesPantalla clientepantalla = new ClientesPantalla();
        clientepantalla.setVisible(true);
        dispose();

        }
    }//GEN-LAST:event_btnmodificar_clienteActionPerformed

    private void btn_eliminar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_clienteActionPerformed

        if(ClienteControlador.Eliminarcliente(this.IdCli))
        {
            this.LimpiarInputs();
            ClientesPantalla clientepantalla = new ClientesPantalla();
            clientepantalla.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_btn_eliminar_clienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_clientespantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_clientespantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_clientespantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_clientespantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_clientespantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_cliente;
    private javax.swing.JButton btnagregar_cliente;
    private javax.swing.JButton btnmodificar_cliente;
    private javax.swing.JComboBox<String> cmbestado_cliente;
    private javax.swing.JLabel errRTN;
    private javax.swing.JLabel errnombre;
    private javax.swing.JLabel errtelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtRTN;
    private javax.swing.JTextField txtnombre_cliente;
    private javax.swing.JTextField txttelefono_cliente;
    // End of variables declaration//GEN-END:variables
}