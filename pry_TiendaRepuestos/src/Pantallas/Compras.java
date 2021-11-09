/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;


import Conexiones.Conexion;
import Especiales.TextPrompt;
import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marlo
 */
public class Compras extends javax.swing.JFrame {

    DefaultTableModel m = new DefaultTableModel();
    DefaultTableModel Proveedor = new DefaultTableModel();
    DefaultTableModel Detalle = new DefaultTableModel();
    double Sub=0,ISV=0,Total=0;
    public Compras() {
        initComponents();
        TextPrompt prueba = new TextPrompt("Nombre Proveedor",txtProveedor);
        TextPrompt prueba2 = new TextPrompt("Nombre o codigo",txtBuscar);
        TextPrompt prueba3 = new TextPrompt("Producto o codigo",txtCodigo);
         setLocationRelativeTo(null);
        jTextField1.setVisible(false);
         JTextFieldDateEditor editor = (JTextFieldDateEditor) this.CalendarEntrega.getDateEditor();
         JTextFieldDateEditor editor1 = (JTextFieldDateEditor) this.CalendarPedido.getDateEditor();
        editor.setEditable(false);
        editor1.setEditable(false);
     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VentanaProductos = new javax.swing.JDialog();
        container = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lupa = new javax.swing.JLabel();
        buscar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        Proveedores = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaProveedor = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lupa1 = new javax.swing.JLabel();
        buscar1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        Cantidad = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        CalendarPedido = new com.toedter.calendar.JDateChooser();
        CalendarEntrega = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtISV = new javax.swing.JTextField();
        txtSub = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        txtQuitar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        VentanaProductos.setBackground(new java.awt.Color(87, 74, 74));
        VentanaProductos.setUndecorated(true);
        VentanaProductos.setResizable(false);
        VentanaProductos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                VentanaProductosComponentShown(evt);
            }
        });

        container.setBackground(new java.awt.Color(43, 47, 61));
        container.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Productos"));

        jPanel4.setBackground(new java.awt.Color(70, 104, 116));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Codigo");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lupa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(buscar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buscar))
                .addGap(22, 22, 22)
                .addComponent(lupa)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaProductos.setOpaque(false);
        jScrollPane2.setViewportView(TablaProductos);

        jButton3.setBackground(new java.awt.Color(70, 104, 116));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout VentanaProductosLayout = new javax.swing.GroupLayout(VentanaProductos.getContentPane());
        VentanaProductos.getContentPane().setLayout(VentanaProductosLayout);
        VentanaProductosLayout.setHorizontalGroup(
            VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        VentanaProductosLayout.setVerticalGroup(
            VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProductosLayout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Proveedores.setUndecorated(true);
        Proveedores.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ProveedoresComponentShown(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(43, 47, 61));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Proveedores"));

        TablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProveedorMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaProveedor);

        jPanel16.setBackground(new java.awt.Color(204, 212, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        jPanel16.setForeground(new java.awt.Color(70, 104, 116));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lupa1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar1)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buscar1))
                .addGap(22, 22, 22)
                .addComponent(lupa1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton4.setBackground(new java.awt.Color(70, 104, 116));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout ProveedoresLayout = new javax.swing.GroupLayout(Proveedores.getContentPane());
        Proveedores.getContentPane().setLayout(ProveedoresLayout);
        ProveedoresLayout.setHorizontalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ProveedoresLayout.setVerticalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(43, 47, 61));

        jTextField1.setText("jTextField1");

        Cantidad.setModel(new javax.swing.SpinnerNumberModel(5, 5, null, 1));
        Cantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CantidadStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad ");

        txtProveedor.setToolTipText("Nombre del Proveedor");
        txtProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProveedorActionPerformed(evt);
            }
        });

        cmbTipoPago.setBackground(new java.awt.Color(70, 104, 135));
        cmbTipoPago.setForeground(new java.awt.Color(255, 255, 255));
        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito" }));
        cmbTipoPago.setToolTipText("Tipo de Pago");

        jButton1.setBackground(new java.awt.Color(70, 104, 135));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Seleccionar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CalendarPedido.setBackground(new java.awt.Color(255, 255, 255));
        CalendarPedido.setForeground(new java.awt.Color(255, 255, 255));
        CalendarPedido.setDateFormatString("yyyy-MMM-dd");

        CalendarEntrega.setBackground(new java.awt.Color(255, 255, 255));
        CalendarEntrega.setDateFormatString("yyyy-MMM-dd");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha de Pedido");

        jButton2.setBackground(new java.awt.Color(70, 104, 135));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar Proveedor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de entrega");

        jButton5.setBackground(new java.awt.Color(70, 104, 135));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Agregar");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtISV.setEditable(false);
        txtISV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtISV.setText("0.00");
        txtISV.setToolTipText("");
        txtISV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISVActionPerformed(evt);
            }
        });

        txtSub.setEditable(false);
        txtSub.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSub.setText("0.00");
        txtSub.setToolTipText("");
        txtSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0.00");
        txtTotal.setToolTipText("");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Subtotal");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ISV 15%");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total");

        btnGuardar.setBackground(new java.awt.Color(70, 104, 135));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(70, 104, 135));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        TablaDetalle = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int cells){
                return false;
            }
        };
        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "producto", "Precio", "Unidad. Pedida", "Unidad. Recibida", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDetalle.getTableHeader().setReorderingAllowed(false);
        TablaDetalle.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TablaDetalleComponentAdded(evt);
            }
        });
        TablaDetalle.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaDetalleAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDetalleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablaDetalleMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDetalle);
        if (TablaDetalle.getColumnModel().getColumnCount() > 0) {
            TablaDetalle.getColumnModel().getColumn(0).setResizable(false);
            TablaDetalle.getColumnModel().getColumn(1).setResizable(false);
            TablaDetalle.getColumnModel().getColumn(2).setResizable(false);
            TablaDetalle.getColumnModel().getColumn(3).setResizable(false);
            TablaDetalle.getColumnModel().getColumn(4).setResizable(false);
            TablaDetalle.getColumnModel().getColumn(5).setResizable(false);
        }

        txtQuitar.setBackground(new java.awt.Color(70, 104, 135));
        txtQuitar.setForeground(new java.awt.Color(255, 255, 255));
        txtQuitar.setText("Quitar");
        txtQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuitarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nueva Compra");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logomantenimiento.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(500, 500, 500)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSub, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtISV, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(521, 521, 521)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtProveedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(212, 212, 212)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cantidad))
                                    .addComponent(CalendarEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CalendarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalendarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalendarEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(txtProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /******************************************************************/
           public void cargarProducto(){
            try{
            DefaultTableModel Producto = new DefaultTableModel();
            TablaProductos.setModel(Producto);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion(con);
            
            String sql= "SELECT * FROM productos";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Producto.addColumn("Codigo");
            Producto.addColumn("Producto"); 
            Producto.addColumn("Precio");
 
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]=rs.getObject(i+1);
                }
                Producto.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
}  
   /******************************************************************/
           public void cargarProveedor(){
            try{
            DefaultTableModel Proveedor = new DefaultTableModel();    
            TablaProveedor.setModel(Proveedor);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion(con);
            
            
            String sql= "SELECT * FROM proveedores ";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Proveedor.addColumn("Codigo");
            Proveedor.addColumn("Nombre"); 
 
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]=rs.getObject(i+1);
                }
                Proveedor.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
}
   /******************************************************************/
           public void filtroProducto(){
       try{
            DefaultTableModel Pr= new DefaultTableModel();
            TablaProductos.setModel(Pr);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion(con);
            
            
            String sql= "SELECT * FROM productos WHERE Prodcodigo LIKE '%"+txtCodigo.getText()+"%' or Proddescripcion LIKE '%"+txtCodigo.getText()+"%'";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Pr.addColumn("Codigo");
            Pr.addColumn("Producto"); 
            Pr.addColumn("Precio");
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]=rs.getObject(i+1);
                }
                Pr.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }

}
 /******************************************************************/
           public void filtroProveedor(){
       try{
            DefaultTableModel p= new DefaultTableModel();
            TablaProveedor.setModel(p);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion(con);
            
            
            String sql= "SELECT * FROM proveedores WHERE Procodigo LIKE '%"+txtBuscar.getText()+"%' or Pronombre LIKE '%"+txtBuscar.getText()+"%'";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
                p.addColumn("Codigo");
                p.addColumn("Nombre"); 
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]=rs.getObject(i+1);
                }
                p.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }

}
 /******************************************************************/
           public void Compras(){
           Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion(con);
            
          
                       try
                        {
                          String query = "call Compras(?, ?, ?, ?);";
                          PreparedStatement preparedStmt = con.prepareStatement(query);
                          preparedStmt.setString(1, jTextField1.getText());
                          int año = CalendarPedido.getCalendar().get(Calendar.YEAR);
                          int mes = CalendarPedido.getCalendar().get(Calendar.MONTH);
                          int dia = CalendarPedido.getCalendar().get(Calendar.DAY_OF_MONTH);
                          int año1 = CalendarEntrega.getCalendar().get(Calendar.YEAR);
                          int mes1 = CalendarEntrega.getCalendar().get(Calendar.MONTH);
                          int dia1 = CalendarEntrega.getCalendar().get(Calendar.DAY_OF_MONTH);
                          String Fecha = año + "-" + mes + "-" + dia;
                          String Fecha1 = año1 + "-" + mes1 + "-" + dia1;
                          preparedStmt.setString(2, Fecha);
                          preparedStmt.setString(3, Fecha1);
                          preparedStmt.setString(4, cmbTipoPago.getSelectedItem().toString());
    
                          preparedStmt.executeUpdate();
                          JOptionPane.showMessageDialog(this,"Datos agregados con exito");
                        }
                            catch(Exception e)
                            {
                                System.err.println(e.getMessage());
                                
                            }          
}
/******************************************************************/
           public void DetalleC(){
            
           Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion(con);
            
           
           if(TablaDetalle.getRowCount()>0){  
               for(int i=0; i<TablaDetalle.getRowCount(); i++){
                        try
                           {
                           String query = "call DetalleCompra(?, ?, ?);";
                           PreparedStatement preparedStmt = con.prepareStatement(query);
                           preparedStmt.setString(1, TablaDetalle.getValueAt(i, 0).toString()); //Codigo
                           preparedStmt.setString(2, TablaDetalle.getValueAt(i, 4).toString()); //Recibida
                           preparedStmt.setString(3, TablaDetalle.getValueAt(i, 2).toString()); //Precio

                           preparedStmt.executeUpdate();
                           }
                           catch(Exception e)
                           {
                                 System.err.println(e.getMessage());
                                 JOptionPane.showMessageDialog(this,"Error al ingresar datos"+e);
                           }
               }
            }else{
               
            } 
}
/******************************************************************/
           public boolean ValoresDuplicado(){
               int prod = TablaProductos.getSelectedRow();
               for(int i=0; i<TablaDetalle.getRowCount(); i++){
                   if(TablaDetalle.getValueAt(i,1).equals(TablaProductos.getValueAt(prod, 1))){
                       return true;
                   }
               }
               return false;
           }
    private void txtProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveedorActionPerformed

    private void txtISVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISVActionPerformed

    private void txtSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed
 
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     int fila = TablaDetalle.getSelectedRow();
     int fila2 = TablaDetalle.getRowCount();
     
     if(txtProveedor.getText().isEmpty() || CalendarPedido.getDate()== null || CalendarEntrega.getDate()== null)   
     {
     
     }else{
            Compras();
            DetalleC();
            
            Sub=0;ISV=0;Total=0;
            txtProveedor.setText(null);
            jTextField1.setText(null);
            CalendarPedido.setDate(null);
            CalendarEntrega.setDate(null);
            txtSub.setText("0.00");
            txtISV.setText("0.00");
            txtTotal.setText("0.00");
            Cantidad.setValue(5);
            for(int i= fila2-1; i>=0; i--){
                Detalle.removeRow(i);
            }
     }  
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            int fila2 = TablaDetalle.getRowCount();
            int resp;
            
             resp = JOptionPane.showConfirmDialog(this,"¿Esta seguro de cancelar la compra?","Cancelar",JOptionPane.YES_NO_OPTION);
              if(resp == JOptionPane.YES_OPTION){
            txtProveedor.setText(null);
            jTextField1.setText(null);
            CalendarPedido.setDate(null);
            CalendarEntrega.setDate(null);
            Sub=0;ISV=0;Total=0;
            txtSub.setText("0.00");
            txtISV.setText("0.00");
            txtTotal.setText("0.00");
            Cantidad.setValue(5);
            for(int i= fila2-1; i>=0; i--){
                Detalle.removeRow(i);
            }
           }else
              {
              }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
     Detalle = (DefaultTableModel) TablaDetalle.getModel();
    }//GEN-LAST:event_formComponentShown

    private void TablaDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetalleMouseClicked
      
    }//GEN-LAST:event_TablaDetalleMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Proveedores.setSize(820,335);
        Proveedores.setLocationRelativeTo(this);
        Proveedores.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaProductos.setSize(850,400);
        VentanaProductos.setLocationRelativeTo(this);
        VentanaProductos.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
      if(txtCodigo.getText().isEmpty())
      {
       cargarProducto();   
      }
      else{
        filtroProducto();
      }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked

    }//GEN-LAST:event_buscarMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = TablaProductos.getSelectedRow();
        
        try{
            String codigo,producto,precio; 
            
            
            if(fila == -1){
                JOptionPane.showMessageDialog(this,"Debe Seleccionar un Producto","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else if(ValoresDuplicado()==true){ 
                JOptionPane.showMessageDialog(this,"El producto seleccionado ya esta en la tabla");
            }else{
                 m = (DefaultTableModel) TablaProductos.getModel();
                codigo = TablaProductos.getValueAt(fila, 0).toString();
                producto = TablaProductos.getValueAt(fila, 1).toString();
                precio = TablaProductos.getValueAt(fila, 2).toString();
        
                //Pasando los datos a la otra tabla
                 m = (DefaultTableModel) TablaDetalle.getModel();
                String filaElemento[] = {codigo,producto,precio};
                m.addRow(filaElemento);
                VentanaProductos.dispose();
                txtCodigo.setText("");
            }
        }catch(Exception e){           
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void VentanaProductosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_VentanaProductosComponentShown
        cargarProducto();
    }//GEN-LAST:event_VentanaProductosComponentShown

    private void TablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProveedorMouseClicked

    }//GEN-LAST:event_TablaProveedorMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
      if(txtBuscar.getText().isEmpty())
        {
        cargarProveedor();   
        }
        else{
            filtroProveedor();
            }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int seleccion = TablaProveedor.getSelectedRow();
        try{

            if(seleccion == -1){
                JOptionPane.showMessageDialog(this,"Debe Seleccionar un Proveedor","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else{
            DefaultTableModel p = (DefaultTableModel)TablaProveedor.getModel();
            String Codigo = String.valueOf(p.getValueAt(TablaProveedor.getSelectedRow(),0)); 
            String Nombre = String.valueOf(p.getValueAt(TablaProveedor.getSelectedRow(),1));       
            jTextField1.setText(Codigo);
            txtProveedor.setText(Nombre);
            Proveedores.dispose();
            txtBuscar.setText("");
            }
        }catch(Exception e){           
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ProveedoresComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ProveedoresComponentShown
        cargarProveedor();
    }//GEN-LAST:event_ProveedoresComponentShown

    private void TablaDetalleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetalleMouseEntered

    }//GEN-LAST:event_TablaDetalleMouseEntered

    private void TablaDetalleComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TablaDetalleComponentAdded
        
    }//GEN-LAST:event_TablaDetalleComponentAdded

    private void TablaDetalleAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaDetalleAncestorAdded

    }//GEN-LAST:event_TablaDetalleAncestorAdded

    private void TablaDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetalleMousePressed
          
    }//GEN-LAST:event_TablaDetalleMousePressed

    private void txtQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuitarActionPerformed
         int fila = TablaDetalle.getSelectedRow();
         
         int resp; int fil;
         
        try{
            if(fila == -1){
                JOptionPane.showMessageDialog(this,"Debe Seleccionar un Producto a eliminar","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else{
              resp = JOptionPane.showConfirmDialog(this,"¿Esta seguro de eliminar este Producto?","Eliminar",JOptionPane.YES_NO_OPTION);
              if(resp == JOptionPane.YES_OPTION){
                String cantidad = TablaDetalle.getValueAt(fila, 4).toString();
                String precio = TablaDetalle.getValueAt(fila, 2).toString();
                Sub -= (Double.parseDouble(precio) * Integer.parseInt(cantidad));
                ISV = Sub*0.15;
                Total = Sub+ISV;
                txtSub.setText(String.valueOf(Sub));
                txtISV.setText(String.valueOf(ISV));
                txtTotal.setText(String.valueOf(Total));
                
                m =(DefaultTableModel)TablaDetalle.getModel();
                m.removeRow(fila);
                
              }
            }
        }catch(Exception e){           
        }
    }//GEN-LAST:event_txtQuitarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int seleccion = TablaDetalle.getSelectedRow();
        Sub=0;
        
     try{   
        if(seleccion == -1){
                JOptionPane.showMessageDialog(this,"Debe Seleccionar un Producto","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else{
                Detalle.setValueAt(Cantidad.getValue(),seleccion , 4);
                String precio = TablaDetalle.getValueAt(seleccion, 2).toString();
                String cantidad = TablaDetalle.getValueAt(seleccion, 4).toString();
                Detalle.setValueAt(Double.parseDouble(precio) * (Double.parseDouble(cantidad)), seleccion , 5);
        }
        int cont = TablaDetalle.getRowCount();
            for(int i=0; i<cont; i++){
                Sub+= Double.parseDouble(TablaDetalle.getValueAt(i, 5).toString());
                txtSub.setText(String.valueOf(Sub));
            }
                ISV = Sub*0.15;
                Total = Sub+ISV;
                txtISV.setText(String.valueOf(ISV));
                txtTotal.setText(String.valueOf(Total));
     }catch(Exception e)
     {
     }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void CantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CantidadStateChanged
 
    }//GEN-LAST:event_CantidadStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
           // UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
           UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (ClassNotFoundException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(ClientesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CalendarEntrega;
    private com.toedter.calendar.JDateChooser CalendarPedido;
    private javax.swing.JSpinner Cantidad;
    private javax.swing.JDialog Proveedores;
    public javax.swing.JTable TablaDetalle;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTable TablaProveedor;
    private javax.swing.JDialog VentanaProductos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel buscar1;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JPanel container;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lupa;
    private javax.swing.JLabel lupa1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtISV;
    public static javax.swing.JTextField txtProveedor;
    private javax.swing.JButton txtQuitar;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    void TablaDetalle(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
