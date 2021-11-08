/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Controladores.ContactoContralador;
import Controladores.ControladorGeneral;
import Modelos.CacheContacto;
import Modelos.ContactoModelo;

/**
 *
 * @author fgodo
 */
public class ContactoPantalla extends javax.swing.JFrame {

    /**
     * Creates new form ContactoPantalla
     */
    public ContactoPantalla() {
        initComponents();
        ContactoContralador.Llenartablacontacto(tabla_contacto, "Activos");   
        ControladorGeneral.Filtrotabla(tabla_contacto, txtbuscar_contacto);    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtbuscar_contacto = new javax.swing.JTextField();
        btnagregar_contacto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_contacto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 47, 61));
        jPanel1.setForeground(new java.awt.Color(43, 47, 61));

        txtbuscar_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_contactoActionPerformed(evt);
            }
        });

        btnagregar_contacto.setBackground(new java.awt.Color(70, 104, 116));
        btnagregar_contacto.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar_contacto.setText("Agregar");
        btnagregar_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_contactoActionPerformed(evt);
            }
        });

        tabla_contacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Telefono", "Correo", "Proveedor", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_contacto.setGridColor(new java.awt.Color(102, 102, 102));
        tabla_contacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_contactoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_contacto);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\fgodo\\OneDrive\\Documentos\\GitHub\\proyectotiendarepuestos\\pry_TiendaRepuestos\\src\\Imagenes\\LogoPantallamd.PNG")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Tabla Contactos");

        jButton1.setBackground(new java.awt.Color(70, 104, 116));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtbuscar_contacto)
                                .addGap(18, 18, 18)
                                .addComponent(btnagregar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar_contacto)
                    .addComponent(txtbuscar_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscar_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_contactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_contactoActionPerformed

    private void btnagregar_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_contactoActionPerformed
        ContactoContralador conco = new ContactoContralador();
        conco.setOperacion(0);
        Mantenimiento_Contacto mantenimiento = new Mantenimiento_Contacto();
        mantenimiento.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnagregar_contactoActionPerformed

    private void tabla_contactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_contactoMouseClicked
        int seleccion = this.tabla_contacto.rowAtPoint(evt.getPoint());
        ContactoModelo conmodelo = new ContactoModelo();
        ContactoContralador conco = new ContactoContralador();
        conco.setOperacion(1);      
        conmodelo.setConcodigo(Integer.parseInt(String.valueOf(this.tabla_contacto.getModel().getValueAt(seleccion, 0))));
        conmodelo.setConnombre(String.valueOf(this.tabla_contacto.getModel().getValueAt(seleccion, 1)));
        conmodelo.setContelefono(String.valueOf(this.tabla_contacto.getModel().getValueAt(seleccion, 2)));
        conmodelo.setConcorreo(String.valueOf(this.tabla_contacto.getModel().getValueAt(seleccion, 3)));
        conmodelo.setPronombre(String.valueOf(this.tabla_contacto.getModel().getValueAt(seleccion,4)));
        conmodelo.setConestado(String.valueOf(this.tabla_contacto.getModel().getValueAt(seleccion,5)));       
        CacheContacto contactocache = new CacheContacto();
        contactocache.setDatosCompartidos(true);
        contactocache.setContacto(conmodelo);
        dispose();
        Mantenimiento_Contacto mantenimiento = new Mantenimiento_Contacto();
        mantenimiento.setVisible(true);
    }//GEN-LAST:event_tabla_contactoMouseClicked

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
            java.util.logging.Logger.getLogger(ContactoPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactoPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactoPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactoPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactoPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar_contacto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_contacto;
    private javax.swing.JTextField txtbuscar_contacto;
    // End of variables declaration//GEN-END:variables
}