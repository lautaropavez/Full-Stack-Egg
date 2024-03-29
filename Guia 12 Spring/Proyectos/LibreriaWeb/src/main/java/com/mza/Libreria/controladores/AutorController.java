package com.mza.Libreria.controladores;

import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceAutor;
import com.mza.Libreria.servicios.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private ServiceLibro servLibro;
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/registroAutor")
    public String formulario() {
        return "nuevoAutor";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registrarAutor")
    public String crear(ModelMap modelo, @RequestParam String nombreAutor) {
        try {
            servAutor.crearAutor(nombreAutor);
            modelo.put("exito", "¡Has creado un nuevo Autor!"); //Al poner el redirect no se carga
            //return "redirect:/libro/registro";
            return "nuevoAutor";
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            //Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex); //Con esto nos tira el error por consola, lo podemos sacar
            modelo.put("nombreAutor", nombreAutor);
            return "nuevoAutor";
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/lista")
    public String lista(ModelMap modelo,@RequestParam(required = false) String buscar){
        
        modelo.addAttribute("autores",servAutor.listaBuscada(buscar)); 
         
        return "list-autor";  
    }
     
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/alta/{id}") 
    public String alta(@PathVariable String id,ModelMap modelo){
        try {
            servLibro.altaxAutor(id);
            return "redirect:/autor/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); 
            return "redirect:/autor/lista"; 
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/baja/{id}")
    public String baja(@PathVariable String id,ModelMap modelo){
        try {
            servLibro.bajaxAutor(id);
            return "redirect:/autor/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "redirect:/autor/lista"; 
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}") //PATHVARIABLE
    public String eliminar(@PathVariable String id,ModelMap modelo) throws Exception{
        try {
            servLibro.eliminarAutor(id);
            return "redirect:/autor/lista";  
        }catch(MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); //La profe no lo puso pero fijarme si anda
            return "redirect:/autor/lista"; 
        }
    }   
    
}
