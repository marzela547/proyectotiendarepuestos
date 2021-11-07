/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Especiales;

import Conexiones.TempConexion;
import Modelos.CachePedidos;
import Modelos.PedidosModelo;
import Modelos.TempModelo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
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
    
    public CrearPDF(String proveedorName, String proveedorAdd ,String fecha){
      this.fechas = fecha;
      //this.proveedores.add(proveedorName);
      //this.proveedores.add(proveedorAdd);
      //this.empresadatos.add("Moto-Car Repuestos");
      //this.empresadatos.add("P. Sherman Calle Wallaby 42");
      
      documento = new Document();
      titulo = new Paragraph("Orden de Compra");
    }
    
    public void crearPDF(){
        try{
            BaseColor myColor = WebColors.getRGBColor("#7da6b5");
            archivo = new FileOutputStream("D:\\Documentos\\pruebapedidos.pdf");
            PdfWriter writer= PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(2);
            Image ima = null;
            try{
                ima = Image.getInstance("C:\\Users\\marce\\Documents\\NetBeansProjects\\ProyectoRepuestos\\pry_TiendaRepuestos\\src\\Imagenes\\Logoproto.png");
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
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("\nMoto-Car Repuestos \n"
            +"P. Sherman Calle Wallaby 42 \n"
            +"Sydney \n"
            +"11101 \n"
            +"+504 9782-9173 \n\n"));
            PdfPTable titulos = new PdfPTable(2);
            titulos.setWidthPercentage(100);
            PdfPCell vendedor = new PdfPCell(new Phrase("Vendedor"));
            vendedor.setBackgroundColor(myColor);
            vendedor.setBorderColor(BaseColor.WHITE);
            vendedor.setRowspan(2);
            PdfPCell comprador = new PdfPCell(new Phrase("Comprador"));
            comprador.setBackgroundColor(myColor);
            comprador.setBorderColor(BaseColor.WHITE);
            comprador.setRowspan(2);
            titulos.addCell(vendedor);
            titulos.addCell(comprador);
            documento.add(titulos);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            CachePedidos cache = new CachePedidos();
            String datos = cache.getPronombre() +" \nDepto. Ventas \n"+cache.getProdireccion()+" \n+504 2256-5789";
            String datosTitu = "Vendedor";
            Rectangle rect = new Rectangle(35, 10, 160, 593);
            addColumn(writer, rect, false, datos,0);
            datos = "Moto-Car Repuestos \nDepto. Compras \nBarrio El Centro \n+504 2256-0000";
            datosTitu = "Comprador";
            rect = new Rectangle(300, 10, 510, 585);
            addColumn(writer, rect, true, datos, 2);
            
            PdfPTable productos = new PdfPTable(4);
            productos.setWidthPercentage(100);
            PdfPCell codigo = new PdfPCell(new Phrase("Código"));
            codigo.setBackgroundColor(myColor);
            codigo.setBorderColor(BaseColor.WHITE);
            PdfPCell descrip = new PdfPCell(new Phrase("Descripción"));
            descrip.setBackgroundColor(myColor);
            descrip.setBorderColor(BaseColor.WHITE);
            PdfPCell precio = new PdfPCell(new Phrase("Precio"));
            precio.setBackgroundColor(myColor);
            precio.setBorderColor(BaseColor.WHITE);
            PdfPCell canti = new PdfPCell(new Phrase("Cantidad"));
            canti.setBackgroundColor(myColor);
            canti.setBorderColor(BaseColor.WHITE);
            productos.addCell(codigo);
            productos.addCell(descrip);
            productos.addCell(precio);
            productos.addCell(canti);
            //System.out.println("ENTRA");
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
               // System.out.println(producto.get(i).getTempprodcanti()+"<---------");
                
            }
            documento.add(productos);
            
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
