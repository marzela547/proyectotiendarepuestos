/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Controladores.ContactoContralador;

/**
 *
 * @author fgodo
 */
public class Mantenimiento_Contacto extends javax.swing.JFrame {

    /**
     * Creates new form Mantenimiento_Contacto
     */
    static Integer IdCon=0;
    Integer mt;      
    public Mantenimiento_Contacto() {
        initComponents();
        this.setLocationRelativeTo(null);
        ContactoContralador.Llenarcmbproveedor(this.cmbproveedor_contacto);
        ContactoContralador.setPlaceHolders(this.txtnombre_contacto, this.txttelefono_contacto, this.txtcorreo_contacto);
        mt = ContactoContralador.getOperacion();
        if(mt == 1){ LlenarDatos(); }
    }            
    private void LlenarDatos()
    {
        this.IdCon = ContactoContralador.SetdatosromCache(this.txtnombre_contacto,
                this.txttelefono_contacto, this.txtcorreo_contacto, this.cmbproveedor_contacto,
                this.cmbestado_contacto);
                
        if(IdCon != null)
        {
            this.btnagregar_contacto.setEnabled(false);
            this.btnmodificar_contacto.setEnabled(true);
            this.btn_eliminar_contacto.setEnabled(true);
            
        }
    }  
    private void LimpiarInputs()
    {
        this.txtcorreo_contacto.setText(null);
        this.txttelefono_contacto.setText(null);
        this.txtnombre_contacto.setText(null); 
    }       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        btnagregar_contacto = new javax.swing.JButton();
        btnmodificar_contacto = new javax.swing.JButton();
        btn_eliminar_contacto = new javax.swing.JButton();
        errnombre = new javax.swing.JLabel();
        errtelefono = new javax.swing.JLabel();
        txtnombre_contacto = new javax.swing.JTextField();
        txttelefono_contacto = new javax.swing.JTextField();
        cmbestado_contacto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbproveedor_contacto = new javax.swing.JComboBox<>();
        txtcorreo_contacto = new javax.swing.JTextField();
        errcorreo = new javax.swing.JLabel();
        btnregresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(43, 47, 61));

        btnagregar_contacto.setBackground(new java.awt.Color(70, 104, 116));
        btnagregar_contacto.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar_contacto.setText("Agregar");
        btnagregar_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_contactoActionPerformed(evt);
            }
        });

        btnmodificar_contacto.setBackground(new java.awt.Color(70, 104, 116));
        btnmodificar_contacto.setForeground(new java.awt.Color(255, 255, 255));
        btnmodificar_contacto.setText("Modificar");
        btnmodificar_contacto.setEnabled(false);
        btnmodificar_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificar_contactoActionPerformed(evt);
            }
        });

        btn_eliminar_contacto.setBackground(new java.awt.Color(70, 104, 116));
        btn_eliminar_contacto.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_contacto.setText("Eliminar");
        btn_eliminar_contacto.setEnabled(false);
        btn_eliminar_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_contactoActionPerformed(evt);
            }
        });

        errnombre.setForeground(new java.awt.Color(255, 51, 51));

        errtelefono.setForeground(new java.awt.Color(255, 51, 51));

        txtnombre_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombre_contactoActionPerformed(evt);
            }
        });

        txttelefono_contacto.setToolTipText("");
        txttelefono_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefono_contactoActionPerformed(evt);
            }
        });

        cmbestado_contacto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACT", "INA" }));
        cmbestado_contacto.setEnabled(false);
        cmbestado_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbestado_contactoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(230, 230, 230));
        jLabel5.setText("Mantenimiento de Contacto");

        cmbproveedor_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbproveedor_contactoActionPerformed(evt);
            }
        });

        txtcorreo_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreo_contactoActionPerformed(evt);
            }
        });

        errcorreo.setForeground(new java.awt.Color(255, 51, 51));

        btnregresar.setBackground(new java.awt.Color(70, 104, 116));
        btnregresar.setForeground(new java.awt.Color(255, 255, 255));
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logomantenimiento.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(errnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcorreo_contacto)
                                    .addComponent(errcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttelefono_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnagregar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbestado_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbproveedor_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnmodificar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btn_eliminar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(75, 75, 75))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(txtnombre_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbestado_contacto)
                    .addComponent(txtcorreo_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(errcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbproveedor_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttelefono_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(errtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodificar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregar_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_contactoActionPerformed
        if(!ContactoContralador.Mantenimientocontacto("insertar", 0,
                this.txtnombre_contacto.getText(), this.txttelefono_contacto.getText(), this.txtcorreo_contacto.getText(),
                cmbproveedor_contacto.getSelectedItem().toString(),cmbestado_contacto.getSelectedItem().toString(), 
                this.errnombre, this.errtelefono,this.errcorreo))
        {
            this.LimpiarInputs();
            ContactoPantalla pantalla = new ContactoPantalla();
            pantalla.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnagregar_contactoActionPerformed

    private void btnmodificar_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificar_contactoActionPerformed
        if(!ContactoContralador.Mantenimientocontacto("editar", this.IdCon,
                this.txtnombre_contacto.getText(), this.txttelefono_contacto.getText(), this.txtcorreo_contacto.getText(),
                cmbproveedor_contacto.getSelectedItem().toString(),cmbestado_contacto.getSelectedItem().toString(), 
                this.errnombre, this.errtelefono,this.errcorreo))
        {
            this.LimpiarInputs();
            ContactoPantalla pantalla = new ContactoPantalla();
            pantalla.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnmodificar_contactoActionPerformed

    private void btn_eliminar_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_contactoActionPerformed

        if(ContactoContralador.Eliminarcontacto(this.IdCon))
        {
            this.LimpiarInputs();
            ContactoPantalla pantalla = new ContactoPantalla();
            pantalla.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_btn_eliminar_contactoActionPerformed

    private void txtnombre_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombre_contactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre_contactoActionPerformed

    private void txttelefono_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefono_contactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefono_contactoActionPerformed

    private void cmbestado_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbestado_contactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbestado_contactoActionPerformed

    private void cmbproveedor_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbproveedor_contactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbproveedor_contactoActionPerformed

    private void txtcorreo_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreo_contactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreo_contactoActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        ContactoPantalla pantalla = new ContactoPantalla();
        pantalla.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

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
            java.util.logging.Logger.getLogger(Mantenimiento_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mantenimiento_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_Contacto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_contacto;
    private javax.swing.JButton btnagregar_contacto;
    private javax.swing.JButton btnmodificar_contacto;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> cmbestado_contacto;
    private javax.swing.JComboBox<String> cmbproveedor_contacto;
    private javax.swing.JLabel errcorreo;
    private javax.swing.JLabel errnombre;
    private javax.swing.JLabel errtelefono;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField txtcorreo_contacto;
    private javax.swing.JTextField txtnombre_contacto;
    private javax.swing.JTextField txttelefono_contacto;
    // End of variables declaration//GEN-END:variables
}
