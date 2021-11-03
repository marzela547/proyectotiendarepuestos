/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Controladores.ClienteControlador;
import Controladores.ControladorGeneral;
import Modelos.CacheCliente;
import Modelos.ClientesModelo;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.UIManager;

/**
 *
 * @author marce
 */
public class ClientesPantalla extends javax.swing.JFrame {

    /**
     * Creates new form ClientesPantalla
     */
    public ClientesPantalla() {
        initComponents();
        ClienteControlador.Llenartablacliente(tabla_clientes, "Todos"); 
        ControladorGeneral.Filtrotabla(tabla_clientes, txtbuscar_cliente);
        
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
        txtbuscar_cliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        btnagregar_cliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 65, 173));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(201, 194, 185));

        txtbuscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_clienteActionPerformed(evt);
            }
        });

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "RTN", "Nombre", "Telefono", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_clientes.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        tabla_clientes.setGridColor(new java.awt.Color(204, 204, 204));
        tabla_clientes.getTableHeader().setReorderingAllowed(false);
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_clientes);
        if (tabla_clientes.getColumnModel().getColumnCount() > 0) {
            tabla_clientes.getColumnModel().getColumn(0).setResizable(false);
            tabla_clientes.getColumnModel().getColumn(1).setResizable(false);
            tabla_clientes.getColumnModel().getColumn(2).setResizable(false);
            tabla_clientes.getColumnModel().getColumn(3).setResizable(false);
            tabla_clientes.getColumnModel().getColumn(4).setResizable(false);
        }

        btnagregar_cliente.setBackground(new java.awt.Color(255, 184, 38));
        btnagregar_cliente.setText("Agregar");
        btnagregar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtbuscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnagregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_clienteActionPerformed
        ClienteControlador clico = new ClienteControlador();
        clico.setOperacion(0);
        Mantenimiento_clientespantalla mantenimientocliente = new Mantenimiento_clientespantalla();
        mantenimientocliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnagregar_clienteActionPerformed

    private void txtbuscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_clienteActionPerformed

    private void tabla_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMouseClicked
        int seleccion = this.tabla_clientes.rowAtPoint(evt.getPoint());
        ClientesModelo clientemodelo = new ClientesModelo();
        ClienteControlador clico = new ClienteControlador();
        clientemodelo.setClicodigo(Integer.parseInt(String.valueOf(this.tabla_clientes.getModel().getValueAt(seleccion, 0))));
        clientemodelo.setRTN(String.valueOf(this.tabla_clientes.getModel().getValueAt(seleccion, 1)));
        clientemodelo.setClinombre(String.valueOf(this.tabla_clientes.getModel().getValueAt(seleccion, 2)));
        clientemodelo.setClitelefono(String.valueOf(this.tabla_clientes.getModel().getValueAt(seleccion, 3)));
        clientemodelo.setCliestado(String.valueOf(this.tabla_clientes.getModel().getValueAt(seleccion,4)));
        CacheCliente clientecache = new CacheCliente();
        clientecache.Setdatoscompartidos(true);
        clientecache.setCliente(clientemodelo);
        clico.setOperacion(1);
        dispose();
        Mantenimiento_clientespantalla mantenimientocliente = new Mantenimiento_clientespantalla();

        mantenimientocliente.setVisible(true);
    }//GEN-LAST:event_tabla_clientesMouseClicked

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
           // UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
           UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar_cliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField txtbuscar_cliente;
    // End of variables declaration//GEN-END:variables
}
