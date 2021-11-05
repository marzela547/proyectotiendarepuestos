/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Controladores.PedidosControlador;
import Modelos.CachePedidos;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author marce
 */
public class PedidosPantalla extends javax.swing.JFrame {

    /**
     * Creates new form PedidosPantalla
     */
    public PedidosPantalla() {
        initComponents();
        this.setLocationRelativeTo(null);
        CachePedidos cache = new CachePedidos();
        Date fecha = new Date();
        fecha_pedidos.setDate(fecha);
        PedidosControlador pedidocontrolador = new PedidosControlador();
        pedidocontrolador.setPlaceHolders(this.txtproveedor_pedidos, this.txtproducto_pedidos, this.txtproductodes_pedidos, this.txtprecio_pedidos);
        if(cache.isBandeProveedores()){
            PedidosControlador.agregarProveedor(txtproveedor_pedidos);
            btnbuscarproducto.setEnabled(true);
        }
        if(cache.isBandeProductos()){
            PedidosControlador.agregarProducto(txtproducto_pedidos, txtproductodes_pedidos, txtprecio_pedidos, spinnercanti_pedidos);
            PedidosControlador.Llenartablapedidostemp(tabla_pedidos);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_pedidos = new javax.swing.JTable();
        txtproveedor_pedidos = new javax.swing.JTextField();
        btnbuscarproveedor = new javax.swing.JButton();
        fecha_pedidos = new com.toedter.calendar.JDateChooser();
        btnbuscarproducto = new javax.swing.JButton();
        txtproducto_pedidos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtproductodes_pedidos = new javax.swing.JTextArea();
        spinnercanti_pedidos = new javax.swing.JSpinner();
        txtempleado_pedidos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnagregarprod_pedidos = new javax.swing.JButton();
        btnagregar_cliente3 = new javax.swing.JButton();
        btnagregar_cliente4 = new javax.swing.JButton();
        txtprecio_pedidos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 194, 185));

        tabla_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_pedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_pedidos);
        if (tabla_pedidos.getColumnModel().getColumnCount() > 0) {
            tabla_pedidos.getColumnModel().getColumn(0).setResizable(false);
            tabla_pedidos.getColumnModel().getColumn(1).setResizable(false);
            tabla_pedidos.getColumnModel().getColumn(2).setResizable(false);
            tabla_pedidos.getColumnModel().getColumn(3).setResizable(false);
        }

        txtproveedor_pedidos.setEditable(false);
        txtproveedor_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedor_pedidosActionPerformed(evt);
            }
        });

        btnbuscarproveedor.setBackground(new java.awt.Color(255, 184, 38));
        btnbuscarproveedor.setText("Buscar Proveedor");
        btnbuscarproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproveedorActionPerformed(evt);
            }
        });

        fecha_pedidos.setEnabled(false);

        btnbuscarproducto.setBackground(new java.awt.Color(255, 184, 38));
        btnbuscarproducto.setText("Buscar Producto");
        btnbuscarproducto.setEnabled(false);
        btnbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproductoActionPerformed(evt);
            }
        });

        txtproducto_pedidos.setEditable(false);
        txtproducto_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproducto_pedidosActionPerformed(evt);
            }
        });

        txtproductodes_pedidos.setEditable(false);
        txtproductodes_pedidos.setColumns(20);
        txtproductodes_pedidos.setRows(5);
        jScrollPane2.setViewportView(txtproductodes_pedidos);

        spinnercanti_pedidos.setEditor(new javax.swing.JSpinner.NumberEditor(spinnercanti_pedidos, ""));
        spinnercanti_pedidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnercanti_pedidosStateChanged(evt);
            }
        });
        spinnercanti_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinnercanti_pedidosMouseClicked(evt);
            }
        });

        txtempleado_pedidos.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Cantidad:");

        btnagregarprod_pedidos.setBackground(new java.awt.Color(255, 184, 38));
        btnagregarprod_pedidos.setText("Agregar Producto");
        btnagregarprod_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarprod_pedidosActionPerformed(evt);
            }
        });

        btnagregar_cliente3.setBackground(new java.awt.Color(255, 184, 38));
        btnagregar_cliente3.setText("Imprimir Pedido");
        btnagregar_cliente3.setActionCommand("");
        btnagregar_cliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_cliente3ActionPerformed(evt);
            }
        });

        btnagregar_cliente4.setBackground(new java.awt.Color(255, 184, 38));
        btnagregar_cliente4.setText("Regresar");
        btnagregar_cliente4.setActionCommand("");
        btnagregar_cliente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_cliente4ActionPerformed(evt);
            }
        });

        txtprecio_pedidos.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnagregar_cliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnagregar_cliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtproveedor_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtproducto_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnbuscarproveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(btnbuscarproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(179, 179, 179)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtempleado_pedidos)
                                    .addComponent(fecha_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnagregarprod_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtprecio_pedidos)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnercanti_pedidos)))))
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtproveedor_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscarproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fecha_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproducto_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtempleado_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtprecio_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnercanti_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(btnagregarprod_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar_cliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar_cliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtproveedor_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedor_pedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedor_pedidosActionPerformed

    private void btnbuscarproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproveedorActionPerformed
    ProveedoresPantalla pro = new ProveedoresPantalla();
    pro.setVisible(true);
    dispose();
    }//GEN-LAST:event_btnbuscarproveedorActionPerformed

    private void btnbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproductoActionPerformed
        ProductosPantalla pro = new ProductosPantalla();
        pro.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbuscarproductoActionPerformed

    private void txtproducto_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproducto_pedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproducto_pedidosActionPerformed

    private void btnagregarprod_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarprod_pedidosActionPerformed
       PedidosControlador.Mantenimientotemp("insertar", txtproducto_pedidos, txtproductodes_pedidos, txtprecio_pedidos, spinnercanti_pedidos);
       PedidosControlador.Llenartablapedidostemp(tabla_pedidos);
       PedidosControlador.limpiarTextos(txtproducto_pedidos, txtproductodes_pedidos, txtprecio_pedidos, spinnercanti_pedidos);
        //PedidosControlador.agregarFilaProducto(tabla_pedidos, txtproducto_pedidos, txtproductodes_pedidos, txtprecio_pedidos, spinnercanti_pedidos);
    }//GEN-LAST:event_btnagregarprod_pedidosActionPerformed

    private void btnagregar_cliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_cliente3ActionPerformed
        PedidosControlador.Mantenimientotemp("eliminar", txtproducto_pedidos, txtproductodes_pedidos, txtprecio_pedidos, spinnercanti_pedidos);
    }//GEN-LAST:event_btnagregar_cliente3ActionPerformed

    private void btnagregar_cliente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_cliente4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregar_cliente4ActionPerformed

    private void spinnercanti_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinnercanti_pedidosMouseClicked
    /*   
        }*/
        System.out.println(spinnercanti_pedidos.getValue().toString());
    }//GEN-LAST:event_spinnercanti_pedidosMouseClicked

    private void spinnercanti_pedidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnercanti_pedidosStateChanged
        PedidosControlador.cambioSpinner(spinnercanti_pedidos);
        
    }//GEN-LAST:event_spinnercanti_pedidosStateChanged

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
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidosPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar_cliente3;
    private javax.swing.JButton btnagregar_cliente4;
    private javax.swing.JButton btnagregarprod_pedidos;
    private javax.swing.JButton btnbuscarproducto;
    private javax.swing.JButton btnbuscarproveedor;
    private com.toedter.calendar.JDateChooser fecha_pedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spinnercanti_pedidos;
    private javax.swing.JTable tabla_pedidos;
    private javax.swing.JTextField txtempleado_pedidos;
    private javax.swing.JTextField txtprecio_pedidos;
    private javax.swing.JTextField txtproducto_pedidos;
    private javax.swing.JTextArea txtproductodes_pedidos;
    private javax.swing.JTextField txtproveedor_pedidos;
    // End of variables declaration//GEN-END:variables
}