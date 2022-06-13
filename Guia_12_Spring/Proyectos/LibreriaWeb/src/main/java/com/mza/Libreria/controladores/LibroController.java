package com.mza.Libreria.controladores;

import com.mza.Libreria.servicios.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lautaro Pavez
 */
// Notas: Clase Servicio Mañana muestra CONTROLADOR DE LIBRO
@Controller 
@RequestMapping("/libro") //localhost:8080/libro        //Clase 2 Mañana
public class LibroController {

    @Autowired
    private ServiceLibro servLibro; 
    
// Clase THYMELEAF
// Este GetMapping va a renderizar esta vista(return form-perro) cuando mi URL sea la del coment de la linea de abajo, osea cuando entramos a esta URL te retorna el formulario
    @GetMapping("/registro") //localhost:8080/libro/registro
    public String formulario(){
         return "form-perro";
    }
           
    @PostMapping("/registro")
    public String crear(ModelMap modelo,@RequestParam String titulo,@RequestParam Integer anio, @RequestParam String nombreAut,@RequestParam String nombreEdit)throws Exception{ //acá van todos los atributos del metodo crear
        //chequear si poner o no acento en los strings
        try{
            servLibro.crearLibro(titulo,anio,nombreAut,nombreEdit);
            modelo.put("exito","Registro exitoso"); //en exito le podemos poner cualq cantidad de palabras pq es un String lo que le pasamos, pero siempre deben ser solo 2 parametros
            return "form-perro"; //retornamos la misma página
        }catch(Exception e){
            modelo.put("error","Falto algún dato"); 
            return "form-perro"; //retornamos la misma página
        }
    }
}
