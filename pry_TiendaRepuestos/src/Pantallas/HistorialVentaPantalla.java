
package Pantallas;

import static Pantallas.VentasPantalla.txtNombreCliente;
import static Pantallas.VentasPantalla.txtRTN;
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
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class HistorialVentaPantalla extends javax.swing.JFrame {
Connection con = null;
int codigoventa;
 String fechaNow;
  
    public HistorialVentaPantalla() {
        initComponents();
         cargarVentasHistorial();
         Calendar fecha = new GregorianCalendar();
        String anio = Integer.toString(fecha.get(Calendar.YEAR));
        String mes = Integer.toString(fecha.get(Calendar.MONTH));
        String dia = Integer.toString(fecha.get(Calendar.DATE));
        int mesInt = Integer.parseInt(mes)+1;
        fechaNow = dia + "/" + mesInt  + "/" + anio ;
         
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DetalleVenta = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaVentasDetalleHistoral = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lupa2 = new javax.swing.JLabel();
        buscar2 = new javax.swing.JLabel();
        lbNfactura = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnGenerarReporte = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaVentasHistorial = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();

        DetalleVenta.setUndecorated(true);
        DetalleVenta.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                DetalleVentaComponentShown(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(201, 194, 185));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datalle de venta"));

        TablaVentasDetalleHistoral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaVentasDetalleHistoral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVentasDetalleHistoralMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaVentasDetalleHistoral);

        jPanel16.setBackground(new java.awt.Color(201, 194, 185));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel12.setText("Factura n°");

        buscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbNfactura.setText("xxxxxx");

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
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(buscar2))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNfactura)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(lbNfactura)))
                    .addComponent(buscar2))
                .addGap(25, 25, 25)
                .addComponent(lupa2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnOK.setBackground(new java.awt.Color(255, 184, 38));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnOK)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DetalleVentaLayout = new javax.swing.GroupLayout(DetalleVenta.getContentPane());
        DetalleVenta.getContentPane().setLayout(DetalleVentaLayout);
        DetalleVentaLayout.setHorizontalGroup(
            DetalleVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DetalleVentaLayout.setVerticalGroup(
            DetalleVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.getAccessibleContext().setAccessibleName("DetalleVenta");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 194, 185));

        btnGenerarReporte.setBackground(new java.awt.Color(255, 184, 38));
        btnGenerarReporte.setText("Generar reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        TablaVentasHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaVentasHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVentasHistorialMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaVentasHistorial);

        btnRegresar.setBackground(new java.awt.Color(255, 184, 38));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 184, 38));
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cmbEstado.setBackground(new java.awt.Color(255, 184, 38));
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado de la venta", "Activo", "Inactivo" }));
        cmbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbEstadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(299, 299, 299)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(647, 647, 647)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaVentasHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVentasHistorialMouseClicked
       int fila = TablaVentasHistorial.getSelectedRow();
       
       if(TablaVentasHistorial.getValueAt(fila, 2).toString().equals("Activo")){
           cmbEstado.setSelectedIndex(1);
       }else{
            cmbEstado.setSelectedIndex(2);
       }
       int column = TablaVentasHistorial.getColumnModel().getColumnIndexAtX(evt.getX());
       int row = evt.getY()/TablaVentasHistorial.getRowHeight();
       
       if(row < TablaVentasHistorial.getRowCount() && row>= 0&& column < TablaVentasHistorial.getColumnCount() && column >=0){
           Object value = TablaVentasHistorial.getValueAt(row, column);
           if(value instanceof JButton){
               
               ((JButton)value).doClick();
               JButton boton = (JButton) value;
                   DetalleVenta.setSize(850,350);
                   DetalleVenta.setLocationRelativeTo(this);
                   DetalleVenta.setVisible(true);
                   codigoventa =Integer.parseInt(TablaVentasHistorial.getValueAt(fila, 0).toString());
         }
       }
       
       
    }//GEN-LAST:event_TablaVentasHistorialMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
       pdf();
        try {
               File path = new File ("src/pdf/Reporte.pdf");
               Desktop.getDesktop().open(path);
            }catch (IOException ex) {
               ex.printStackTrace();
            }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          for(int i = 0; i<TablaVentasHistorial.getRowCount();i++){  
              if(TablaVentasHistorial.getValueAt(i, 2).toString().equals("Activo")){
                    updEstVenta(Integer.parseInt(TablaVentasHistorial.getValueAt(i, 0).toString()),1);                   
              }else{
                   updEstVenta(Integer.parseInt(TablaVentasHistorial.getValueAt(i, 0).toString()),2);            
              }
          }
          
          cargarVentasHistorial();
             
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbEstadoMouseClicked
        int fila = TablaVentasHistorial.getSelectedRow();       
           TablaVentasHistorial.setValueAt(cmbEstado.getSelectedItem().toString(),TablaVentasHistorial.convertRowIndexToModel(fila),2);        
    }//GEN-LAST:event_cmbEstadoMouseClicked

    private void TablaVentasDetalleHistoralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVentasDetalleHistoralMouseClicked

    }//GEN-LAST:event_TablaVentasDetalleHistoralMouseClicked

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
    DetalleVenta.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void DetalleVentaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DetalleVentaComponentShown
        lbNfactura.setText(String.valueOf(codigoventa));
        cargarVentasDetalleHistorial(codigoventa);
    }//GEN-LAST:event_DetalleVentaComponentShown

    
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialVentaPantalla().setVisible(true);
            }
        });
    }
    
@SuppressWarnings("empty-statement")
         public void cargarVentasHistorial(){
            try{
             TablaVentasHistorial.setDefaultRenderer(Object.class, new render());
             JButton btn1 = new JButton("Detalle");
            DefaultTableModel VentasHistorial = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
            };
            TablaVentasHistorial.setModel(VentasHistorial);
            TablaVentasHistorial.setRowHeight(30);
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = Conexiones.Conexion.getConexion(con);
           
            
            String sql= "call bdrepuestos.get_ventasHistorial();";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            VentasHistorial.addColumn("Numero de Factura");
            VentasHistorial.addColumn("Fecha Venta"); 
            VentasHistorial.addColumn("Estado");
            VentasHistorial.addColumn("Detalle");
            
 
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas+1];
                
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]  = rs .getObject(i+1);
                    filas[3] = btn1;
                }
                
                VentasHistorial.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
}  
         
         public void updEstVenta(int codigo, int est){
              con = Conexiones.Conexion.getConexion(con);
              try
              {
                  String query = "call bdrepuestos.UPD_EstVenta(?, ?);";
                  PreparedStatement preparedStmt = con.prepareStatement(query);
                  preparedStmt.setInt   (1, codigo);
                  preparedStmt.setInt   (2, est);
                  preparedStmt.executeUpdate();
              }
              catch(Exception e)
              {
                  System.err.println(e.getMessage());
              }
         }
         
         
       public void cargarVentasDetalleHistorial(int codigo){
            try{
            DefaultTableModel detalle = new DefaultTableModel();    
            TablaVentasDetalleHistoral.setModel(detalle);
            PreparedStatement ps = null;
            ResultSet rs = null;
             con = Conexiones.Conexion.getConexion(con);
            
            String sql= "call bdrepuestos.get_ventasDetallesHistorial(?);";
             ps= con.prepareStatement(sql);
            ps.setInt   (1, codigo);
           
            rs=ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            detalle.addColumn("Codigo Producto");
            detalle.addColumn("Producto");
            detalle.addColumn("Precio Producto");
            detalle.addColumn("Cantidad");
 
            while(rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i]=rs.getObject(i+1);
                }
                detalle.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
}
       private void pdf(){
         try{
             FileOutputStream archivo;
             File file = new File("src/pdf/Reporte.pdf");
             archivo = new FileOutputStream(file);
             Document doc = new Document();
             PdfWriter.getInstance(doc, archivo);
             doc.open();
             
             Image img = Image.getInstance("src/img/logoMotoRepuestos.jpeg");
             
             Paragraph fecha = new Paragraph();
             Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
             fecha.add(Chunk.NEWLINE);
             Date date = new Date();
             fecha.add("Factura: "+"Fecha: " + fechaNow);
             PdfPTable Encabezado = new PdfPTable(3);
             Encabezado.setWidthPercentage(100);
             Encabezado.getDefaultCell().setBorder(0);
             float [] ColumnaEncabezado = new float[]{20f,30f,70f};
             Encabezado.setWidths(ColumnaEncabezado);
             Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
             
             Encabezado.addCell(img);
             String NomEmpresa = "MOTo-CAr"; 
             String tema = "Reporte";
            
          
             
             Encabezado.addCell("");
             Encabezado.addCell(NomEmpresa+"\n"+tema);
             Encabezado.addCell(fecha);
             doc.add(Encabezado);
      
               /*****************PRODUCTO**********/
               PdfPTable tablaVentaDetalle = new PdfPTable(3);
               tablaVentaDetalle.setWidthPercentage(100);
               tablaVentaDetalle.getDefaultCell().setBorder(0);
               float[] columnaVentaDetalle = new float[]{20f,50f,30f};
               tablaVentaDetalle.setWidths(columnaVentaDetalle);
               tablaVentaDetalle.setHorizontalAlignment(Element.ALIGN_LEFT);
               PdfPCell col1 = new PdfPCell(new Phrase("Numero de Factura",negrita));
               PdfPCell col2 = new PdfPCell(new Phrase("Fecha Venta",negrita));
               PdfPCell col3 = new PdfPCell(new Phrase("Estado",negrita));
               col1.setBorder(0);
               col2.setBorder(0);
               col3.setBorder(0);
               col1.setBackgroundColor(BaseColor.DARK_GRAY);
               col2.setBackgroundColor(BaseColor.DARK_GRAY);
               col3.setBackgroundColor(BaseColor.DARK_GRAY);
                            
               tablaVentaDetalle.addCell(col1);
               tablaVentaDetalle.addCell(col2);
               tablaVentaDetalle.addCell(col3);
             
               
               for(int i=0; i< TablaVentasHistorial.getRowCount(); i++){
                   String num = TablaVentasHistorial.getValueAt(i, 0).toString();
                   String fech = TablaVentasHistorial.getValueAt(i, 1).toString();
                   String Estado = TablaVentasHistorial.getValueAt(i, 2).toString();
                   tablaVentaDetalle.addCell(num);
                   tablaVentaDetalle.addCell(fech);
                   tablaVentaDetalle.addCell(Estado);
                   
               }
               
               doc.add(tablaVentaDetalle);
             
            
             
             doc.close();
         }catch(Exception e){
             System.out.println(e);
             
         }
     }
         
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DetalleVenta;
    private javax.swing.JTable TablaVentasDetalleHistoral;
    public javax.swing.JTable TablaVentasHistorial;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel buscar2;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbNfactura;
    private javax.swing.JLabel lupa2;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
