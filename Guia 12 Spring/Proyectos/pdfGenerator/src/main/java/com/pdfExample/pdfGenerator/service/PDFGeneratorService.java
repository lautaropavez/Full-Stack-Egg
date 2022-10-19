package com.pdfExample.pdfGenerator.service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author lautaropavez
 * Hecho con este video: https://www.youtube.com/watch?v=S7udzd3xjGQ
 */

@Service
public class PDFGeneratorService {
    
    /**
    * La idea es tener sólo un método que genere el pdf
    * @param response: respuesta Http que queremos enviarle al usuario
    * @throws java.io.IOException
    */
    public void export(HttpServletResponse response) throws IOException{
        // Vamos a adjuntar un documento a la respuesta y vamos a devolverle la respuesta al usuario
        Document document = new Document(PageSize.A4); // Creamos un documento nuevo y podemos especificar el tamaño del documento con un ENUM
        PdfWriter.getInstance(document,response.getOutputStream()); // Esto va a obtener 2 parámetros: 1° Documento que queremos asignar, 2° Donde queremos escribir el pdf. Entonces acá le decimos que le daremos este documento y nos gustaria que lo escriba en este OutputStream(Flujo de salida)
        
        document.open(); //Para comenzar a trabajar con el documento debo abrirlo primero
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD); //Elejimos la fuente para el titulo
        fontTitle.setSize(18); //Tamaño de fuente
        Paragraph paragraph = new Paragraph("This is a title.",fontTitle); //Creamos un Párrafo que tiene 2 parámetros: 1° Texto que queremos que se muestre 2° Toma estilo de fuente que definimos antes
        paragraph.setAlignment(Paragraph.ALIGN_CENTER); //Alineación
        
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA); //Creamos otra fuente para nuestro parrafo
        fontTitle.setSize(18); //Tamaño de fuente
        Paragraph paragraph2 = new Paragraph("This is a paragraph.",fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        
        // Ya que hemos creado 2 párrafos, tenemos que agregarlos al documento real
        document.add(paragraph);
        document.add(paragraph2);
        document.close();
    }
}
