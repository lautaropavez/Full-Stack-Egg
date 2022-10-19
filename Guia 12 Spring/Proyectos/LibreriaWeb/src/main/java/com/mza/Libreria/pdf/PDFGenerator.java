//package com.mza.Libreria.pdf;
//
//import com.lowagie.text.Document;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import com.mza.Libreria.entidades.Libro;
//import java.awt.Color;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Toshiba
// */
//
//@Service
//public class PDFGenerator {
//    
//    public void export(HttpServletResponse response,Map<String, Object> model) throws IOException{
//        // Vamos a adjuntar un documento a la respuesta y vamos a devolverle la respuesta al usuario
//        Document document = new Document(PageSize.A4.rotate()); // Creamos un documento nuevo y podemos especificar el tamaño del documento con un ENUM
//        PdfWriter.getInstance(document,response.getOutputStream()); // Esto va a obtener 2 parámetros: 1° Documento que queremos asignar, 2° Donde queremos escribir el pdf. Entonces acá le decimos que le daremos este documento y nos gustaria que lo escriba en este OutputStream(Flujo de salida)
//        
//        List<Libro> listaLibros = (List<Libro>) model.get("libros");
//        float[] anchos = {8f, 60f, 50f, 50f, 10f, 10f, 10f, 10f};
//        
//        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD); //Elejimos la fuente para el titulo
//        fontTitle.setSize(18); //Tamaño de fuente
//        Paragraph paragraph = new Paragraph("This is a title.",fontTitle); //Creamos un Párrafo que tiene 2 parámetros: 1° Texto que queremos que se muestre 2° Toma estilo de fuente que definimos antes
//        paragraph.setAlignment(Paragraph.ALIGN_CENTER); //Alineación
//        
//        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA); //Creamos otra fuente para nuestro parrafo
//        fontTitle.setSize(18); //Tamaño de fuente
//        Paragraph paragraph2 = new Paragraph("This is a paragraph.",fontParagraph);
//        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
//        
//        //Creo una tabla para el titulo
//        final PdfPTable tablaTitulo = new PdfPTable(1); 
//        //creo una Celda titulo y le doy formato
//        PdfPCell titulo = new PdfPCell(new Phrase("LISTA DE LIBROS REGISTRADOS"));
//        titulo.setBorder(0);
//        titulo.setBackgroundColor(new Color(100, 161, 157));
//        titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
//        titulo.setVerticalAlignment(Element.ALIGN_CENTER);
//        titulo.setPadding(5);
//        //a la tabla Titulo le agrego la Celda titulo
//        tablaTitulo.addCell(titulo);
//        tablaTitulo.setSpacingAfter(15);//para agregar espacio luego de esta tabla
//        //Creo un objeto de PdfPTable de 8 columnas para los libros
//        final PdfPTable tablaLibros = new PdfPTable(8);
//        tablaLibros.setSplitLate(true);
//        tablaLibros.setWidths(anchos);
//        
//        //Creo una tablaigual de 8 columnas para los nombres de cada columna
//        final PdfPTable tablaNomb = new PdfPTable(8);
//        tablaNomb.setWidths(anchos);
//        tablaNomb.addCell(new PdfPCell(new Phrase("Nro.")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Titulo")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Autor")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Editorial")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Ej.")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Pr.")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Dis.")));
//        tablaNomb.addCell(new PdfPCell(new Phrase("Est.")));
//        
//        //Dando el tamaño al Documento y poniendolo en horizontal(Lo puse cuando cree el documento)
//        //document.setPageSize(PageSize.A4.rotate());
//        document.setMargins(-25, -30, 20, 10);
//        document.open(); //Para comenzar a trabajar con el documento debo abrirlo primero
//        
//        /**
//           Para rellenar la tablaLibros:
//           Utilizo un for comun ya que necesito un indice para contar cuantos libros
//           tiene la lista, ya que mi ID es de tipo String y no un autoincremental
//           Paso todos las variables a String
//        */
//        for (int i = 0; i < listaLibros.size(); i++) {
//            tablaLibros.addCell(String.valueOf(i + 1));//asi obtengo un contador de libros
//            tablaLibros.addCell(listaLibros.get(i).getTitulo());
//            tablaLibros.addCell(listaLibros.get(i).getAutor().getNombre());
//            tablaLibros.addCell(listaLibros.get(i).getEditorial().getNombre());
//            tablaLibros.addCell(listaLibros.get(i).getNroejemplares().toString());
//            tablaLibros.addCell(listaLibros.get(i).getEjemplaresPrestados().toString());
//            tablaLibros.addCell(listaLibros.get(i).getEjemplaresRestantes().toString());
//            tablaLibros.addCell(listaLibros.get(i).getAlta().toString());
//        }
//
//        document.addTitle("LISTA DE LIBROS REGISTRADOS");
//        document.add(tablaTitulo);
//        document.add(tablaNomb);
//        document.add(tablaLibros);
//
//        // Ya que hemos creado 2 párrafos, tenemos que agregarlos al documento real
//        document.add(paragraph);
//        document.add(paragraph2);
//        document.close();
//    }     
//}
