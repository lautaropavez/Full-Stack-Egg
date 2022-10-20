package com.mza.Libreria.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mza.Libreria.entidades.Libro;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lautaropavez
 * Lo hacemos con esta lista de videos: https://www.youtube.com/watch?v=ZD3DUBeZqIk&list=PLxxZ0339925EflXGlNai0UjAQAR8To3ck&index=2
 * Min 9 video: Vemos donde están los ejemplos de OPENPDF
 */

//Acá ponemos la ruta para poder acceder a la lista de libros(lo que ponemos en el return del método lista en LibroController) 
@Component("list-libros") //Acá le estamos indicando que cuando detecte esta ruta, si luego detecta un parámetro adicional muestre la ruta correspondiente(si encuentra un parámetro adicional que cree el pdf)
public class LibrosPDF extends AbstractPdfView{

    @Override //Cuando extendemos la clase de AbstractPdfView nos pide que implementemos este método
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        List<Libro> listaLibros = (List<Libro>) model.get("libros"); //Con model.get le indicamos que obtenga el objeto llamado libros
        float[] anchos = {8f, 60f, 50f, 50f, 10f, 10f, 10f, 10f}; // A cada columna le establezco un ancho

        //creo una tabla para el titulo
        final PdfPTable tablaTitulo = new PdfPTable(1);
        //creo una Celda titulo y le doy formato
        PdfPCell titulo = new PdfPCell(new Phrase("LISTA DE LIBROS REGISTRADOS"));
        titulo.setBorder(0); //Le quitamos el borde
        titulo.setBackgroundColor(new Color(255, 74, 74 )); //Los colores se los asignamos en base al rgb que usamos en html en esta pág: https://htmlcolorcodes.com/es/
        titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
        titulo.setVerticalAlignment(Element.ALIGN_CENTER);
        titulo.setPadding(5);
        //a la tabla Titulo le agrego la Celda titulo
        tablaTitulo.addCell(titulo);
        tablaTitulo.setSpacingAfter(15);//para agregar espacio luego de esta tabla

        //Creo un objeto de PdfPTable de 8 columnas para los libros
        final PdfPTable tablaLibros = new PdfPTable(8);
        tablaLibros.setSplitLate(true);
        tablaLibros.setWidths(anchos);

        //Creo una tablaigual de 8 columnas para los nombres de cada columna
        final PdfPTable tablaNomb = new PdfPTable(8);
        tablaNomb.setWidths(anchos);
        tablaNomb.addCell(new PdfPCell(new Phrase("Nro.")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Titulo")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Autor")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Editorial")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Ej.")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Pr.")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Dis.")));
        tablaNomb.addCell(new PdfPCell(new Phrase("Est.")));

        //Dando el tamaño al Documento y poniendolo en horizontal
        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(-25, -30, 20, 10);
        //Abro el documento 
        document.open();
        
        /*
        Para rellenar la tablaLibros:
        Utilizo un for comun ya que necesito un indice para contar cuantos libros
        tiene la lista, ya que mi ID es de tipo String y no un autoincremental
        Paso todos las variables a String
         */
        for (int i = 0; i < listaLibros.size(); i++) {
            tablaLibros.addCell(String.valueOf(i + 1));//asi obtengo un contador de libros
            tablaLibros.addCell(listaLibros.get(i).getTitulo());
            tablaLibros.addCell(listaLibros.get(i).getAutor().getNombre());
            tablaLibros.addCell(listaLibros.get(i).getEditorial().getNombre());
            tablaLibros.addCell(listaLibros.get(i).getNroejemplares().toString());
            tablaLibros.addCell(listaLibros.get(i).getEjemplaresPrestados().toString());
            tablaLibros.addCell(listaLibros.get(i).getEjemplaresRestantes().toString());
            tablaLibros.addCell(listaLibros.get(i).getAlta().toString());
        }
        
        document.addTitle("LISTA DE LIBROS REGISTRADOS");
        document.add(tablaTitulo);
        document.add(tablaNomb);
        document.add(tablaLibros);
        document.close();
    }
    
}