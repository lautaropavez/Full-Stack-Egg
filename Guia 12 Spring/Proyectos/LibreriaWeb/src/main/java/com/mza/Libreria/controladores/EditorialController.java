package com.mza.Libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceEditorial;
import com.mza.Libreria.servicios.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private ServiceLibro servLibro; 
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/registroEditorial")
    public String formulario() {
        return "nuevaEditorial";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registrarEditorial") 
    public String crear(ModelMap modelo,@RequestParam String nombre){ 
        try{
            servEditorial.crearEditorial(nombre);
            modelo.put("exito","¡Has creado una nueva Editorial!"); 
            //return "redirect:/libro/registro";
            return "nuevaEditorial";
        }catch(MiExcepcion ex){
            modelo.put("error", ex.getMessage());
            modelo.put("nombre",nombre);
            return "nuevaEditorial"; 
        }  
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/lista")
    public String lista(ModelMap modelo,@RequestParam(required = false) String buscar){
        
        modelo.addAttribute("editoriales",servEditorial.listaBuscada(buscar));
         
        return "list-editorial";  
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/alta/{id}") 
    public String alta(@PathVariable String id,ModelMap modelo){
        try {
            servLibro.altaxEditorial(id);
            return "redirect:/editorial/lista";  
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage()); 
            return "redirect:/editorial/lista"; 
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/baja/{id}")
    public String baja(@PathVariable String id,ModelMap modelo){
        try {
            servLibro.bajaxEditorial(id);
            return "redirect:/editorial/lista";  
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "redirect:/editorial/lista"; 
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}") //PATHVARIABLE
    public String eliminar(@PathVariable String id,ModelMap modelo) throws Exception{
        try {
            servLibro.eliminarEditorial(id);
            return "redirect:/editorial/lista";  
        }catch(MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); 
            return "redirect:/editorial/lista"; 
        }
    }   
   
}
