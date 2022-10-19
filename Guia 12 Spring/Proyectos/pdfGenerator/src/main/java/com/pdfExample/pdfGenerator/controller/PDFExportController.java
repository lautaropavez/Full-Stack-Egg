package com.pdfExample.pdfGenerator.controller;

import com.pdfExample.pdfGenerator.service.PDFGeneratorService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lautaropavez
 * Hecho con este video: https://www.youtube.com/watch?v=S7udzd3xjGQ
 */

@Controller
public class PDFExportController {
    
    @Autowired
    PDFGeneratorService pdfGeneratorService;
    
//    /**
//    * Con esto hemos logrado la inyección de dependencia, por lo que cuando la aplicación corra, Spring escaneará la anotación del servicio y dirá: Necesito hacer un bean fuera de esta clase,
//    * Va a hacer un bean y el bean sólo será un objeto fuera de esta clase, luego el objeto lo vamos a inyectar en el constructor basado en la inyección aquí
//     * @param response
//    * @param pdfGeneratorService
//    */
//    public PDFExportController(PDFGeneratorService pdfGeneratorService){
//        this.pdfGeneratorService = pdfGeneratorService;
//    }
    
    
//    Esto va a configurar el encabezado de disposición del contenido, a la respuesta, para que el navegador sepa lo que se devuelve
    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException{
        response.setContentType("application/pdf");
        //Lo más común a la hora de generar archivos PDF es tener algún tipo de Hora y Fecha en el nombre 
        DateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yy:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        
        //Debemos settear el header a response
        String headerKey = "Content-Disposition"; //Este header le dice al browser que tipo de archivo devolvemos
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf"; //nombre del archivo
        response.setHeader(headerKey, headerValue);
        
        pdfGeneratorService.export(response);
    }

    
    
    
    
}
