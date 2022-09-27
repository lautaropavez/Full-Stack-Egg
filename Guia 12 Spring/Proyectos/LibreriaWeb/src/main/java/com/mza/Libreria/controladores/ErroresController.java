package com.mza.Libreria.controladores;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.http.HttpStatus;
//import java.util.Enumeration;
//import java.util.Map;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lautaro Pavez
 */
@Controller
public class ErroresController implements ErrorController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ErroresController.class);
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST}) //@RequestMapping("/error")
    public String handleError(HttpServletRequest request,Model modelo){
        String errorPage = "error";
        String pageTitle = "error";
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMsg = "";  
        
        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());

            switch(statusCode){
                case 400: {
                    errorPage = "error/400";
                    LOGGER.error("Error 400"); 
                    errorMsg = "El recurso solicitado no existe.";
                    break;
                }
                case 401: {
                    errorPage = "error/401";
                    LOGGER.error("Error 401");
                    errorMsg = "No se encuentra autorizado.";
                    break;
                }
                case 403: {
                    errorPage = "error/403";
                    LOGGER.error("Error 403");
                    errorMsg = "No tiene permisos para acceder al recurso.";
                    break;                
                }
                case 404: {
                    errorPage = "error/404";
                    LOGGER.error("Error 404");
                    errorMsg = "Lo sentimos, el recurso solicitado no fue encontrado.";
                    break;                
                }
                  case 408: {
                    errorPage = "error/408";
                    LOGGER.error("Error 408");
                    errorMsg = "Lo sentimos, su solicitud ha excedido el tiempo máximo permitido.";
                    break;                
                }
                case 500: {
                    errorPage = "error/500";
                    LOGGER.error("Error 500");
                    errorMsg = "Ocurrió un error interno.";
                    break;                
                }
            }    
        }
        
        modelo.addAttribute("errorMsg",errorMsg);
        modelo.addAttribute("pageTitle",pageTitle); //NO lo voy a utilizar
        return errorPage;
    }
   
//LOGGER:
//Spring boot logging is defined as a framework that enables developers to trace out errors that might occur in the running of the application.
//Spring Boot uses Commons Logging for all internal logging but leaves the underlying log implementation open. Default configurations are provided for Java Util Logging, Log4J2, and Logback. In each case, loggers are pre-configured to use console output with optional file output also available.;
                    
// FORMA VIDEO YOUTUBE(CLASE SPRING ESTÁ)
//    if(status != null){
//            Integer statusCode = Integer.valueOf(status.toString());
//            Escribir esto: statusCode == HttpStatus.NOT_FOUND.value()
//            Es lo mismo qu escribir: statusCode == 404 (por ejemplo, puede ser otro valor)
            
//            if(statusCode == HttpStatus.NOT_FOUND.value()){
////                pageTitle = "Page Not Found"; // Le puedo mandar el title desde acá
//                System.out.println(statusCode);
//                errorPage = "error/404";
//                LOGGER.error("Error 404");
//            }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
//                System.out.println(statusCode);
//                pageTitle = "Internal Server Error";
//                errorPage = "error/500";
//                LOGGER.error("Error 500");
//            }else if(statusCode == HttpStatus.FORBIDDEN.value()){
//                System.out.println(statusCode);
//                pageTitle = "Forbidden Error";
//                errorPage = "error/403";
//                LOGGER.error("Error 403");
//            }else if(statusCode == HttpStatus.UNAUTHORIZED.value()){
//                System.out.println(statusCode);
//                pageTitle = "Unauthorized Error";
//                errorPage = "error/401";
//                LOGGER.error("Error 401");
//            }else if(statusCode == HttpStatus.BAD_REQUEST.value()){
//                System.out.println(statusCode);
//                pageTitle = "Bad Request Error";
//                errorPage = "error/400";
//                LOGGER.error("Error 400");
//            }else if(statusCode == HttpStatus.REQUEST_TIMEOUT.value()){
//                System.out.println(statusCode);
//                pageTitle = "Request Timeout Error";
//                errorPage = "error/408";
//                LOGGER.error("Error 408");
//            }
    
    
// FORMA VIDEO 8 MVC (INCOMPLETO)
//     Acá le decimos que el recurso /error (todo lo que sea /error) va a entrar en este método y este método lo que hace es recuperar el código de error en el servidor,
//     establecer un mensaje particular para ese código de error y redireccionar o abrir una vista, en este caso "error" en linea 22
//    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST}) 
//    public ModelAndView renderErrorPage(HttpServletRequest httpRequest){
//        
//        ModelAndView errorPage = new ModelAndView("error");
//        String errorMsg = "";
//        int httpErrorCode = getErrorCode(httpRequest);
//        
//        switch(httpErrorCode){
//            case 400: {
//                errorMsg = "El recurso solicitado no existe.";
//                break;
//            }
//            case 401: {
//                errorMsg = "No se encuentra autorizado.";
//                break;
//            }
//            case 403: {
//                errorMsg = "No tiene permisos para acceder al recurso.";
//                break;                
//            }
//            case 404: {
//                errorMsg = "El recurso solicitado no fue encontrado.";
//                break;                
//            }
//            case 500: {
//                errorMsg = "Ocurrió un error interno.";
//                break;                
//            }
//        }
//        
//        errorPage.addObject("codigo",httpErrorCode);
//        errorPage.addObject("mensaje",errorMsg);
//        return errorPage;
//    }
//    
//    public int getErrorCode(HttpServletRequest httpRequest){
//        
//        Map mapa = httpRequest.getParameterMap();
//        for(Object key : mapa.keySet()){
//            String[] valores = (String[]) mapa.get(key);
//            for(String valor : valores){
//                System.out.println(key.toString() + ": " + valor);
//            }
//        }
//        
//        Enumeration<String> atributos = httpRequest.getAttributeNames();
//        while(atributos.hasMoreElements()){
//            String key = atributos.nextElement();
//            System.out.println(key + ":" + httpRequest.getAttribute(key));
//        }
//        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
//    }   
}