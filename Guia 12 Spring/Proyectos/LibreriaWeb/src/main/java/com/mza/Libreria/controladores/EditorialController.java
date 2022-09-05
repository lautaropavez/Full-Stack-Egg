package com.mza.Libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Lautaro Pavez
 */
@Controller 
@RequestMapping("/editorial") //localhost:8080/editorial   //Clase 2 Mañana
public class EditorialController {

    @Autowired
    private ServiceEditorial servEditorial; 
    
    @GetMapping("/registroEditorial")
    public String formulario() {
        return "nuevaEditorial";
    }

    @PostMapping("/registrarEditorial") 
    public String crear(ModelMap modelo,@RequestParam String nombreEditorial){ 
        try{
            servEditorial.crearEditorial(nombreEditorial);
            //modelo.put("exito","¡Has creado una nueva Editorial!"); 
            return "redirect:/libro/registro";
        }catch(MiExcepcion ex){
            modelo.put("error", ex.getMessage());
            modelo.put("nombreEditorial",nombreEditorial);
            return "nuevaEditorial"; 
        }  
    }
    
    
}
