/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author fgodo
 */
public class ControladorGeneral {
    protected static void FormatoTabla(JTable tabla, Integer columnas)  
    {
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);  

        for (int i = 0; i<columnas; i++)
        {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        
        final TableColumnModel columnModel = tabla.getColumnModel(); 
        for (int columna = 0; columna < tabla.getColumnCount(); columna++) 
        { 
            int ancho = 100;
            
            for (int fila = 0; fila < tabla.getRowCount(); fila++) 
            { 
                TableCellRenderer renderer = tabla.getCellRenderer(fila, columna); 
                Component comp = tabla.prepareRenderer(renderer, fila, columna); 
                ancho = Math.max(comp.getPreferredSize().width+1 , ancho);              
            }
            
            if(ancho > 300)
            {
                ancho=300; 
            }
            
            columnModel.getColumn(columna).setPreferredWidth(ancho); 
        }
    } 
    public static void Filtrotabla(JTable tabla, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(rowSorter);
        fieldBusqueda.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                String text = fieldBusqueda.getText();

                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                } 
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = fieldBusqueda.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }
        );  
    }       
}
