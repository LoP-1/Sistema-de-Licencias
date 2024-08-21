/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;

/**
 *
 * @author Miguel_Castillo
 */
public class pdf {
    public void ReportePDF(Paragraph texto, String nombre) {       
        Document document = new Document();

        try {

            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream(nombre + ".pdf"));


            document.open();
            

            PdfContentByte cb = writer.getDirectContent();

            //Titulo
            Font fontTitulo = new Font(Font.HELVETICA, 24, Font.BOLD, Color.BLACK);
            Paragraph titulo = new Paragraph("Reporte de Licencias", fontTitulo);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(titulo);
            

            //Agrega el texto

            document.add(texto);
            
            

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            // step 5: we close the document
            if (document != null) {
                document.close();
            }
        }

        JOptionPane.showMessageDialog(null, 
                "Se creó el archivo " + nombre + " en la carpeta del proyecto");
    }
}
