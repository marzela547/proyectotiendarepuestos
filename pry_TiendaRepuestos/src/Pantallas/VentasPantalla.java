
package Pantallas;

import Controladores.VentaControlador;
import Especiales.TextPrompt;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfTable;
import java.awt.Desktop;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Kevin Espinal
 */
public class VentasPantalla extends javax.swing.JFrame {
 
        DefaultTableModel m = new DefaultTableModel();
        Connection con = null;
        int cliente=0;
        String fechaNow;
        
        
       
      
    public VentasPantalla(){
        initComponents();
        
        TextPrompt nombreCliente = new TextPrompt("Nombre del cliente",txtNombreCliente);
        TextPrompt rtn = new TextPrompt("RTN",txtRTN);
        TextPrompt nombreVendedor = new TextPrompt("Nombre del Vendedor",txtNomVendedor);
        Calendar fecha = new GregorianCalendar();
        String anio = Integer.toString(fecha.get(Calendar.YEAR));
        String mes = Integer.toString(fecha.get(Calendar.MONTH));
        String dia = Integer.toString(fecha.get(Calendar.DATE));
        int mesInt = Integer.parseInt(mes)+1;
        fechaNow = anio + "/" + mesInt  + "/" + dia ;
        txtFechaActual.setText(fechaNow);
        LimpiarFactura();
        

    }
    
 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        VentanaProductos = new javax.swing.JDialog();
        container = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lupa = new javax.swing.JLabel();
        buscar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        lupa1 = new javax.swing.JLabel();
        buscar1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Clientes = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lupa2 = new javax.swing.JLabel();
        buscar2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNfactura = new javax.swing.JLabel();
        btn_SeleccinarProducto = new javax.swing.JButton();
        btn_SeleccionarCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomVendedor = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        cmbTipoPago = new javax.swing.JComboBox<>();
        txtNombreCliente = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRTN = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        VentanaProductos.setBackground(new java.awt.Color(87, 74, 74));
        VentanaProductos.setUndecorated(true);
        VentanaProductos.setResizable(false);
        VentanaProductos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                VentanaProductosComponentShown(evt);
            }
        });

        container.setBackground(new java.awt.Color(204, 212, 204));
        container.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Productos"));

        jPanel4.setBackground(new java.awt.Color(204, 212, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

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
                        .addGap(0, 26, Short.MAX_VALUE)))
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
                .addGap(0, 28, Short.MAX_VALUE))
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
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaProductos);

        jPanel5.setBackground(new java.awt.Color(204, 212, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel7.setText("Producto");

        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });

        buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscar1MouseClicked(evt);
            }
        });

        jLabel8.setText("Precio");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel9.setText("Cantidad");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lupa1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buscar1))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lupa1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 88, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout VentanaProductosLayout = new javax.swing.GroupLayout(VentanaProductos.getContentPane());
        VentanaProductos.getContentPane().setLayout(VentanaProductosLayout);
        VentanaProductosLayout.setHorizontalGroup(
            VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProductosLayout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        VentanaProductosLayout.setVerticalGroup(
            VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        Clientes.setUndecorated(true);
        Clientes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ClientesComponentShown(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(204, 212, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Clientes"));

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaClientes);

        jPanel16.setBackground(new java.awt.Color(204, 212, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel12.setText("Buscar");

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

        buscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lupa2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar2)
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
                            .addComponent(jLabel12)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buscar2))
                .addGap(22, 22, 22)
                .addComponent(lupa2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientesLayout = new javax.swing.GroupLayout(Clientes.getContentPane());
        Clientes.getContentPane().setLayout(ClientesLayout);
        ClientesLayout.setHorizontalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesLayout.createSequentialGroup()
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        ClientesLayout.setVerticalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Factuta Nº");

        txtNfactura.setText("xxxxxxxxxx");

        btn_SeleccinarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_SeleccinarProducto.setText("Seleccionar producto");
        btn_SeleccinarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeleccinarProductoActionPerformed(evt);
            }
        });

        btn_SeleccionarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_SeleccionarCliente.setText("Seleccionar cliente");
        btn_SeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeleccionarClienteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 184, 38));
        jPanel1.setPreferredSize(new java.awt.Dimension(163, 55));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        txtImpuesto.setEditable(false);
        txtImpuesto.setText("0.00");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Tipo de pago", "Débito", "Crédito" }));

        txtNombreCliente.setEditable(false);

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "productos", "Precio", "Unidades", "Sub total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDetalleMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaDetalle);

        jLabel4.setText("ISV");

        jLabel5.setText("Sub total");

        jLabel11.setText("Total");

        txtRTN.setEditable(false);

        txtSubtotal.setEditable(false);
        txtSubtotal.setText("0.00");
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(btnConectar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreCliente)
                                    .addComponent(txtRTN))
                                .addGap(18, 18, 18)
                                .addComponent(btn_SeleccionarCliente)))
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_SeleccinarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addGap(294, 294, 294)
                        .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNfactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_SeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_SeleccinarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnConectar)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
            int opcion = cmbTipoPago.getSelectedIndex();
              con = Conexiones.Conexion.getConexion(con);
            if(TablaDetalle.getRowCount()!=0){
                if(cliente!=0){
                        
                  if (opcion != 0)
                    {
                        insertVtn(txtFechaActual.getText(),1,cliente,cmbTipoPago.getSelectedItem().toString(),0,1,1);
                         for(int i = 0; i<TablaDetalle.getRowCount();i++){
                         int idPro = Integer.parseInt(TablaDetalle.getValueAt(i, 0).toString());
                         int cant = Integer.parseInt(TablaDetalle.getValueAt(i, 0).toString());
                         int idVenta = getMaxidVenta();
                         insertDtsVtn(cant, idVenta  ,idPro);
                         }
                         
                        try{
                       
                        JOptionPane.showMessageDialog(null, "Factura registrada con exito");
                        pdf();
                        try {
                            File path = new File ("src/pdf/factura"+getMaxidVenta()+".pdf");
                            Desktop.getDesktop().open(path);
                       }catch (IOException ex) {
                            ex.printStackTrace();
                       }
                      
                        LimpiarFactura();
                      
                        }catch(Exception e){
                            
                        }
                        
                    }  
                   else
                    {
                         JOptionPane.showMessageDialog(null, "Seleccione un tipo de pago");
                    }
            
                 }else{
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
                }
                 
            }else{
                  JOptionPane.showMessageDialog(null, "Debe de agregar un producto a la factura.");
            }
            
        
    }//GEN-LAST:event_btnConectarActionPerformed

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
        int codigo=-1,existencia;
        boolean existe;
        String producto,precio, cantidad;
        try{
        
            float subtotal;

            if(fila == -1){
                JOptionPane.showMessageDialog(this,"Debe Seleccionar un Producto","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            
            
            else{

                m = (DefaultTableModel) TablaProductos.getModel();
                codigo = Integer.parseInt(TablaProductos.getValueAt(fila, 0).toString());
                producto = TablaProductos.getValueAt(fila, 1).toString();
                precio = TablaProductos.getValueAt(fila, 2).toString();
                cantidad = txtCantidad.getText();
                subtotal = Float.parseFloat(precio)*Float.parseFloat(cantidad);
                existencia = stockProducto(codigo);
                if( existencia < Integer.parseInt(txtCantidad.getText()))
               {
                    JOptionPane.showMessageDialog(this,"No hay sufuciente unidades en existencia. \n Solo hay "+ existencia,"Advertencia",JOptionPane.WARNING_MESSAGE);
               }else if(txtCantidad.getText().equals("")){
                  JOptionPane.showMessageDialog(this,"Debe de llenar el campo de cantidad","Advertencia",JOptionPane.WARNING_MESSAGE);
               }else if(txtCantidad.getText().equals("0")){
                    JOptionPane.showMessageDialog(this,"Debe de ser una cantidad mayor a 0","Advertencia",JOptionPane.WARNING_MESSAGE);
               }
                else
                {
                     
                     m = (DefaultTableModel) TablaDetalle.getModel();
                     existe = ExisteEnTabla(TablaDetalle,String.valueOf(Integer.parseInt(TablaProductos.getValueAt(fila, 0).toString())),0);
                     if(!existe){
                           String filaElemento[] = {String.valueOf(codigo),producto,precio,cantidad, String.valueOf(subtotal)};
                           m.addRow(filaElemento);
                     }
                     else
                     {
                         for(int i = 0; i<TablaDetalle.getRowCount();i++){
                             if(TablaDetalle.getValueAt(i, 0).equals(String.valueOf(Integer.parseInt(TablaProductos.getValueAt(fila, 0).toString())))){
                            
                                 TablaDetalle.setValueAt(Integer.parseInt(TablaDetalle.getValueAt(TablaDetalle.convertRowIndexToModel(i), 3).toString())+ Integer.parseInt(txtCantidad.getText()),TablaDetalle.convertRowIndexToModel(i),3);
                                 TablaDetalle.setValueAt(Float.parseFloat(TablaDetalle.getValueAt(TablaDetalle.convertRowIndexToModel(i), 3).toString())* Float.parseFloat(precio),TablaDetalle.convertRowIndexToModel(i),4);
 
                             }
                     }
                           
                  
                     
                }
                   
                     
                     
                     RestarStockProducto(codigo, Integer.parseInt(txtCantidad.getText()));
                     VentanaProductos.dispose();
                     txtCodigo.setText("");
                     txtProducto.setText("");
                     txtPrecio.setText("");
                     txtCantidad.setText("");
                }
                     
             
             
               
              
             
            }
          
          
        }catch(Exception e){
        }

        txtSubtotal.setText(String.valueOf(SumSubtotal()));
        txtImpuesto.setText(String.valueOf(Float.parseFloat(txtSubtotal.getText())*0.15));
        txtTotal.setText(String.valueOf(Float.parseFloat(txtSubtotal.getText())+Float.parseFloat(txtImpuesto.getText())));
        System.out.println();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void VentanaProductosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_VentanaProductosComponentShown
        cargarProducto();
    }//GEN-LAST:event_VentanaProductosComponentShown

    private void TablaDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDetalleMouseClicked

    }//GEN-LAST:event_TablaDetalleMouseClicked

    private void btn_SeleccinarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeleccinarProductoActionPerformed
        VentanaProductos.setSize(850,500);
        VentanaProductos.setLocationRelativeTo(this);
        VentanaProductos.setVisible(true);
    }//GEN-LAST:event_btn_SeleccinarProductoActionPerformed

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoKeyPressed

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoKeyTyped

    private void buscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar1MouseClicked

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void TablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMouseClicked
        int fila = TablaProductos.getSelectedRow();
     
                txtProducto.setText( TablaProductos.getValueAt(fila, 1).toString());
                txtPrecio.setText(TablaProductos.getValueAt(fila, 2).toString());
                
    }//GEN-LAST:event_TablaProductosMouseClicked

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked

    }//GEN-LAST:event_TablaClientesMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if(txtBuscar.getText().isEmpty())
        {
            cargarClientes();
        }
        else{
            filtroClientes();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int seleccion = TablaClientes.getSelectedRow();
        try{

            if(seleccion == -1){
                JOptionPane.showMessageDialog(this,"Debe Seleccionar un Cliente","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else{
                DefaultTableModel p = (DefaultTableModel)TablaClientes.getModel();
                cliente = Integer.parseInt(String.valueOf(p.getValueAt(TablaClientes.getSelectedRow(),0)));
                String Nombre = String.valueOf(p.getValueAt(TablaClientes.getSelectedRow(),1));
                String RTN = String.valueOf(p.getValueAt(TablaClientes.getSelectedRow(),2));
                txtNombreCliente.setText(Nombre);
                txtRTN.setText(RTN);
                Clientes.dispose();
                txtBuscar.setText("");
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ClientesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ClientesComponentShown
        cargarClientes();
    }//GEN-LAST:event_ClientesComponentShown

    private void btn_SeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeleccionarClienteActionPerformed
        Clientes.setSize(850,500);
        Clientes.setLocationRelativeTo(this);
        Clientes.setVisible(true);
    }//GEN-LAST:event_btn_SeleccionarClienteActionPerformed

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasPantalla().setVisible(true);
            }
        });
    }
    
    
    
    
    //*****************************************************************************************
    //*************************FUNCIONES****************************************************//
     public void cargarProducto(){
            try{
            DefaultTableModel Producto = new DefaultTableModel();
            TablaProductos.setModel(Producto);
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = Conexiones.Conexion.getConexion(con);
           
            
            String sql= "SELECT  Prodcodigo,Proddescripcion,Prodprecventa,Proexistencia FROM productos";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Producto.addColumn("Codigo");
            Producto.addColumn("Producto"); 
            Producto.addColumn("Precio");
            Producto.addColumn("Existencia");
 
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
     
      public void filtroProducto(){
       try{
            DefaultTableModel Pr= new DefaultTableModel();
            TablaProductos.setModel(Pr);
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = Conexiones.Conexion.getConexion(con);
            
            String sql= "SELECT Prodcodigo,Proddescripcion,Prodprecventa,Proexistencia FROM productos WHERE Prodcodigo LIKE '%"+txtCodigo.getText()+"%' or Proddescripcion LIKE '%"+txtCodigo.getText()+"%'";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Pr.addColumn("Codigo");
            Pr.addColumn("Productos"); 
            Pr.addColumn("Precio");
            Pr.addColumn("Existencia");
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
      
            public void cargarClientes(){
            try{
            DefaultTableModel Cliente = new DefaultTableModel();    
            TablaClientes.setModel(Cliente);
            PreparedStatement ps = null;
            ResultSet rs = null;
             con = Conexiones.Conexion.getConexion(con);
            
            String sql= "call bdrepuestos.getAllClientes();";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Cliente.addColumn("Codigo");
            Cliente.addColumn("Nombre");
            Cliente.addColumn("RTN");
 
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]=rs.getObject(i+1);
                }
                Cliente.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
}
      
      
      public float SumSubtotal(){
          float subtotal=0;
         
          for (int i =0;i<TablaDetalle.getRowCount();i++){
              subtotal=subtotal + Float.parseFloat(TablaDetalle.getValueAt(i,4).toString());
          }
          return subtotal;
      }

      
     
      public void filtroClientes()
      {
       try{
            DefaultTableModel Pr= new DefaultTableModel();
            TablaProductos.setModel(Pr);
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = Conexiones.Conexion.getConexion(con);
            
            String sql= "SELECT * FROM Clientes WHERE RTN LIKE '%"+txtBuscar.getText()+"%' or Clinombre LIKE '%"+txtBuscar.getText()+"%'";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            Pr.addColumn("RTN");
            Pr.addColumn("Nombre Cliente"); 
           
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
      public int stockProducto(int ProdCodigo){
             int stock =0 ;
            try{
               
               PreparedStatement ps = null;
               ResultSet rs = null;
               con = Conexiones.Conexion.getConexion(con);

              // String sql= "call bdrepuestos.getStockProductos(?);";
              String sql= "call bdrepuestos.getStockProductos('"+ProdCodigo+"');";
               ps= con.prepareStatement(sql);
               rs=ps.executeQuery();



               if(rs.next())
               {
                 stock = Integer.parseInt(rs.getString(1));
               }

           }catch(SQLException ex){
               System.err.println(ex.toString());
           }

         return stock;
          
      }
         
      public void RestarStockProducto(int ProdCodigo, int cantidad){
              con = Conexiones.Conexion.getConexion(con);
              try
              {
                  String query = "call bdrepuestos.upt_stockProdRes(?, ?);";
                  PreparedStatement preparedStmt = con.prepareStatement(query);
                  preparedStmt.setInt   (1, ProdCodigo);
                  preparedStmt.setInt   (2, cantidad);
                  preparedStmt.executeUpdate();
              }
              catch(Exception e)
              {
                  System.err.println(e.getMessage());
              }
         }
         
      public boolean ExisteEnTabla(JTable tabla, String dto, int col){
          boolean Existe = false;
          for(int i = 0; i<tabla.getRowCount();i++){
              if(TablaDetalle.getValueAt(i, col).equals(dto)){
                  Existe = true;
              }
              
          }
          return Existe;
      }
      
      public void insertVtn(String Venfecha, int Empcodigo,int Clicodigo,String Tippacodigo,float Vendescuento, int Estcodigo ,int id_sar){
          con = Conexiones.Conexion.getConexion(con);
              try
              {
                  String query = "call bdrepuestos.insert_vts(?,?,?,?,?,?,?);";
                  PreparedStatement preparedStmt = con.prepareStatement(query);
                  preparedStmt.setString   (1, Venfecha);
                  preparedStmt.setInt   (2, Empcodigo);
                  preparedStmt.setInt   (3, Clicodigo);
                  preparedStmt.setString   (4, Tippacodigo);
                  preparedStmt.setFloat   (5, Vendescuento);
                  preparedStmt.setInt   (6, Estcodigo);
                  preparedStmt.setInt   (7, id_sar);
                  preparedStmt.executeUpdate();
              }
              catch(Exception e)
              {
                  System.err.println(e.getMessage());
              }
      }
    
      
      public void insertDtsVtn(int Detvencantidad , int Ventcodigo , int  Prodcodigo){
             con = Conexiones.Conexion.getConexion(con);
              try
              {
                  String query = "call bdrepuestos.insert_DtlVts(?, ?, ?);";
                  PreparedStatement preparedStmt = con.prepareStatement(query);
                  preparedStmt.setInt   (1, Detvencantidad);
                  preparedStmt.setInt   (2, Ventcodigo);
                  preparedStmt.setInt   (3, Prodcodigo);
                
                  preparedStmt.executeUpdate();
              }
              catch(Exception e)
              {
                  System.err.println(e.getMessage());
              }
      }
      
      public int getMaxidVenta(){
               int id=0;
            try{
               
               PreparedStatement ps = null;
               ResultSet rs = null;
               con = Conexiones.Conexion.getConexion(con);

              // String sql= "call bdrepuestos.getStockProductos(?);";
              String sql= "call bdrepuestos.getMaxIdVentas();";
               ps= con.prepareStatement(sql);
               rs=ps.executeQuery();
               if(rs.next())
               {
                 id = Integer.parseInt(rs.getString(1));
               }

           }catch(SQLException ex){
               System.err.println(ex.toString());
           }
         return id;
          
      }
      public void LimpiarFactura(){
            DefaultTableModel dtm = (DefaultTableModel) TablaDetalle.getModel();
            dtm.setRowCount(0); 
            cliente = 0;
            txtNombreCliente.setText("");
            txtRTN.setText("");
            txtSubtotal.setText("0.00");
            txtImpuesto.setText("0.00");
            txtTotal.setText("0.00");
            txtNfactura.setText(String.valueOf(getMaxidVenta() + 1));
                        
      }
     private void pdf(){
         try{
             FileOutputStream archivo;
             File file = new File("src/pdf/factura"+getMaxidVenta()+".pdf");
             archivo = new FileOutputStream(file);
             Document doc = new Document();
             PdfWriter.getInstance(doc, archivo);
             doc.open();
             
             Image img = Image.getInstance("src/img/logoMotoRepuestos.jpeg");
             
             Paragraph fecha = new Paragraph();
             Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
             fecha.add(Chunk.NEWLINE);
             Date date = new Date();
             fecha.add("Factura: "+getMaxidVenta()+"\n"+"Fecha: " + fechaNow);//new SimpleDateFormat("dd-mm-yyy").format(date)+"\n\n");
             PdfPTable Encabezado = new PdfPTable(4);
             Encabezado.setWidthPercentage(100);
             Encabezado.getDefaultCell().setBorder(0);
             float [] ColumnaEncabezado = new float[]{20f,30f,70f,40f};
             Encabezado.setWidths(ColumnaEncabezado);
             Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
             
             Encabezado.addCell(img);
             String NomEmpresa = "MOTo-CAr";
             
             String tel = "94946591";
             String dir = "--------------------";
          
             
             Encabezado.addCell("");
             Encabezado.addCell(NomEmpresa+"\nTel: "+tel+"\nDireccion: "+dir);
             Encabezado.addCell(fecha);
             doc.add(Encabezado);
             
             /***************************************************/
               PdfPTable cli = new PdfPTable(2);
               cli.setWidthPercentage(100);
               cli.getDefaultCell().setBorder(0);
               float[] columnaCli = new float[]{20f,50f};
               cli.setWidths(columnaCli);
               cli.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell cl1 = new PdfPCell(new Phrase("RNT"));
               PdfPCell cl2 = new PdfPCell(new Phrase("Nombre Cliente"));
               
               cl1.setBorder(0);
               cl2.setBorder(0);
               cli.addCell(cl1);
               cli.addCell(cl2);
               cli.addCell(txtRTN.getText());
               cli.addCell(txtNombreCliente.getText()+ "\n\n\n\n");
               doc.add(cli);
               
               /*****************PRODUCTO**********/
                  PdfPTable tablaProducto = new PdfPTable(4);
               tablaProducto.setWidthPercentage(100);
               tablaProducto.getDefaultCell().setBorder(0);
               float[] columnaProducto = new float[]{20f,50f,30f,40f};
               tablaProducto.setWidths(columnaProducto);
               tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell prdcol1 = new PdfPCell(new Phrase("Descripcion",negrita));
               PdfPCell prdcol2 = new PdfPCell(new Phrase("Precio U",negrita));
               PdfPCell prdcol3 = new PdfPCell(new Phrase("Cantidad",negrita));
               PdfPCell prdcol4 = new PdfPCell(new Phrase("Sub total",negrita));
               prdcol1.setBorder(0);
               prdcol2.setBorder(0);
               prdcol3.setBorder(0);
               prdcol4.setBorder(0);
               prdcol1.setBackgroundColor(BaseColor.DARK_GRAY);
               prdcol2.setBackgroundColor(BaseColor.DARK_GRAY);
               prdcol3.setBackgroundColor(BaseColor.DARK_GRAY);
               prdcol4.setBackgroundColor(BaseColor.DARK_GRAY);
               
               tablaProducto.addCell(prdcol1);
               tablaProducto.addCell(prdcol2);
               tablaProducto.addCell(prdcol3);
               tablaProducto.addCell(prdcol4);
               
               for(int i=0; i< TablaDetalle.getRowCount(); i++){
                   String producto = TablaDetalle.getValueAt(i, 1).toString();
                   String precio = TablaDetalle.getValueAt(i, 2).toString();
                   String cantidad = TablaDetalle.getValueAt(i, 3).toString();
                   String Subtotal = TablaDetalle.getValueAt(i, 4).toString();
                   tablaProducto.addCell(producto);
                   tablaProducto.addCell(precio);
                   tablaProducto.addCell(cantidad);
                   tablaProducto.addCell(Subtotal);
               }
               
               doc.add(tablaProducto);
             
               Paragraph totales = new Paragraph();
               totales.add(Chunk.NEWLINE);
               totales.add("\n\n\nSub total: L. " + txtSubtotal.getText());
               totales.add("\nImpuesto: L. " + txtImpuesto.getText());
               totales.add("\nTotal a pagar: L. " + txtTotal.getText());
               totales.setAlignment(Element.ALIGN_RIGHT);
               doc.add(totales);
             
             doc.close();
         }catch(Exception e){
             System.out.println(e);
             
         }
     }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Clientes;
    private javax.swing.JTable TablaClientes;
    public javax.swing.JTable TablaDetalle;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JDialog VentanaProductos;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btn_SeleccinarProducto;
    private javax.swing.JButton btn_SeleccionarCliente;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel buscar1;
    private javax.swing.JLabel buscar2;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JPanel container;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lupa;
    private javax.swing.JLabel lupa1;
    private javax.swing.JLabel lupa2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtFechaActual;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JLabel txtNfactura;
    private javax.swing.JTextField txtNomVendedor;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtRTN;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
