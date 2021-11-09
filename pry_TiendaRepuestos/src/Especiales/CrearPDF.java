/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especiales;

import Conexiones.PedidosConexion;
import Conexiones.TempConexion;
import Modelos.CacheLogin;
import Modelos.CachePedidos;
import Modelos.PedidosModelo;
import Modelos.TempModelo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class CrearPDF {
    
    String fechas;
    List <String> proveedores;
    List <String> empresadatos;
    
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;
    
    public CrearPDF(String fecha){
      this.fechas = fecha;
      
      documento = new Document();
      
    }
    
    public void crearPDF(){
        try{
            PedidosConexion.llamarUltimo();
            BaseColor myColor = WebColors.getRGBColor("#7da6b5");
            archivo = new FileOutputStream("src/pdf/ordencompra"+CachePedidos.getPedcodigo()+".pdf");
            File path = new File("src/pdf/ordencompra"+CachePedidos.getPedcodigo()+".pdf");
            Desktop.getDesktop().open(path);
            PdfWriter writer= PdfWriter.getInstance(documento, archivo);
            Font fuente = new Font();
            fuente.setSize(28);
            fuente.setColor(myColor);
            fuente.setStyle(Font.BOLD);
            documento.open();
            titulo = new Paragraph("Orden de Compra", fuente);
            titulo.setAlignment(2);
            Image ima = null;
            try{
                ima = Image.getInstance("src/Imagenes/Logoproto.png");
                ima.scaleAbsolute(100, 100);
                ima.setAbsolutePosition(35, 705);
            }catch(Exception ex){
                System.out.println("Error: "+ex);
            }
            documento.add(ima);
            documento.add(titulo);
            Paragraph fech = new Paragraph("Fecha: "+fechas);
            fech.setAlignment(2);
            //fech.setFont(TIMES_ROMAN);
            documento.add(fech);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Moto-Car Repuestos \n"
            +"P. Sherman Calle Wallaby 42 \n"
            +"Sydney \n"
            +"11101 \n"
            +"+504 9782-9173 \n\n"));
            PdfPTable titulos = new PdfPTable(2);
            titulos.setWidthPercentage(100);
            PdfPCell vendedor = new PdfPCell(new Phrase("Vendedor"));
            vendedor.setBackgroundColor(myColor);
            vendedor.setRowspan(2);
            PdfPCell comprador = new PdfPCell(new Phrase("Comprador"));
            comprador.setBackgroundColor(myColor);
            comprador.setRowspan(2);
            titulos.addCell(vendedor);
            titulos.addCell(comprador);
            documento.add(titulos);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            CachePedidos cache = new CachePedidos();
            String datos = cache.getPronombre() +" \nDepto. Ventas \n"+cache.getProdireccion()+" \n+504 "+cache.getProtelefono();
            String datosTitu = "Vendedor";
            Rectangle rect = new Rectangle(35, 10, 160, 603);
            addColumn(writer, rect, false, datos,0);
            datos = "Moto-Car Repuestos \nDepto. Compras \nBarrio El Centro \n+504 2256-0000";
            datosTitu = "Comprador";
            rect = new Rectangle(300, 10, 510, 595);
            addColumn(writer, rect, true, datos, 2);
            documento.add(Chunk.NEWLINE);
            PdfPTable datosEx = new PdfPTable(3);
            datosEx.setWidthPercentage(100);
            PdfPCell delivery = new PdfPCell(new Phrase("Delivery"));
            delivery.setBackgroundColor(myColor);
            PdfPCell pago = new PdfPCell(new Phrase("Términos de pago"));
            pago.setBackgroundColor(myColor);
            PdfPCell empleado = new PdfPCell(new Phrase("Solicitado por"));
            empleado.setBackgroundColor(myColor);
            
            datosEx.addCell(delivery);
            datosEx.addCell(pago);
            datosEx.addCell(empleado);
            datosEx.addCell("Si");
            datosEx.addCell(cache.getTippago());
            datosEx.addCell(CacheLogin.getEmpnombre());
            documento.add(datosEx);
            
            documento.add(Chunk.NEWLINE);
            
            PdfPTable productos = new PdfPTable(5);
            productos.setWidthPercentage(100);
            PdfPCell codigo = new PdfPCell(new Phrase("Código"));
            codigo.setBackgroundColor(myColor);
            PdfPCell descrip = new PdfPCell(new Phrase("Descripción"));
            descrip.setBackgroundColor(myColor);
            PdfPCell precio = new PdfPCell(new Phrase("Precio"));
            precio.setBackgroundColor(myColor);
            PdfPCell canti = new PdfPCell(new Phrase("Cantidad"));
            canti.setBackgroundColor(myColor);
            PdfPCell totales = new PdfPCell(new Phrase("Totales"));
            totales.setBackgroundColor(myColor);
            productos.addCell(codigo);
            productos.addCell(descrip);
            productos.addCell(precio);
            productos.addCell(canti);
            productos.addCell(totales);
            //System.out.println("ENTRA");
            float subtot =0;
            List <TempModelo> producto = TempConexion.Listadotemp();
            //System.out.println("FUERA DEL FOR");
            for(int i=0; i<producto.size(); i++){
                //System.out.println("DENTRO DEL FOR");
                productos.addCell(String.valueOf(producto.get(i).getTempprodcodigo()));
                //producto.get(i).getTempprodcanti();
                //System.out.println(producto.get(i).getTempprodcodigo()+"<---------");
                productos.addCell(producto.get(i).getTempproddescripcion());
               // System.out.println(producto.get(i).getTempproddescripcion()+"<---------");
                productos.addCell(String.valueOf(producto.get(i).getTempprodprecventa()));
                //System.out.println(producto.get(i).getTempprodprecventa()+"<---------");
                productos.addCell(String.valueOf(producto.get(i).getTempprodcanti()));
                float total = producto.get(i).getTempprodprecventa() * producto.get(i).getTempprodcanti();
               // System.out.println(producto.get(i).getTempprodcanti()+"<---------");
                subtot+=total;
                productos.addCell(String.valueOf(total));
            }
            documento.add(productos);
            PdfPTable calculos = new PdfPTable(2);
            calculos.setWidthPercentage(30);
            PdfPCell subto = new PdfPCell(new Phrase("Subtotal"));
            subto.setBackgroundColor(myColor);
            PdfPCell valorsub = new PdfPCell(new Phrase(String.valueOf(subtot)));
            //codigo.setBackgroundColor(myColor);
            PdfPCell isv = new PdfPCell(new Phrase("ISV 15%"));
            isv.setBackgroundColor(myColor);
            PdfPCell totalf = new PdfPCell(new Phrase("Total"));
            totalf.setBackgroundColor(myColor);
            
            calculos.addCell(subto);
            calculos.addCell(valorsub);
            calculos.addCell(isv);
            double isvval = subtot*0.15;
            double tot = subtot+isvval;
            calculos.addCell(String.valueOf(isvval));
            calculos.addCell(totalf);
            calculos.addCell(String.valueOf(tot));
            calculos.setHorizontalAlignment(2);
            documento.add(Chunk.NEWLINE);
            documento.add(calculos);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Autorizado por: John Doe"));
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Orden de compra realizada");
        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }
    }
    public void addColumn(PdfWriter writer, Rectangle rect, boolean useAscender, String texto, Integer num){
        try{
           /* rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(0.5f);
            rect.setBorderColor(BaseColor.RED);*/
            
            PdfContentByte cb = writer.getDirectContent();
            cb.rectangle(rect);
            Phrase p = new Phrase(texto);
            ColumnText ct = new ColumnText(cb);
            ct.setSimpleColumn(rect);
            ct.setUseAscender(useAscender);
            ct.addText(Chunk.NEWLINE);
            ct.addText(p);
            
            ct.go();
            ct.setAlignment(num);
        }catch(Exception ex){
            
        }
    }
    
    
}
