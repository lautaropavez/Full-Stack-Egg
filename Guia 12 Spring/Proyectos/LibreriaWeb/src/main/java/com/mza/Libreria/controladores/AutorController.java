package com.mza.Libreria.controladores;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceAutor;
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
@Controller
@RequestMapping("/autor") //localhost:8080/autor  //Clase 2 Mañana
public class AutorController {

    @Autowired
    private ServiceAutor servAutor;
    
    @GetMapping("/registroAutor")
    public String formulario() {
        return "nuevoAutor";
    }

    @PostMapping("/registrarAutor")
    public String crear(ModelMap modelo, @RequestParam String nombreAutor) {
        try {
            servAutor.crearAutor(nombreAutor);
            //modelo.put("exito", "¡Has creado un nuevo Autor!"); Al poner el redirect no se carga
            return "redirect:/libro/registro";
          //return "nuevoLibro";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            //Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex); //Con esto nos tira el error por consola, lo podemos sacar
            modelo.put("nombreAutor", nombreAutor);
            return "nuevoAutor";
        }
    }
}
