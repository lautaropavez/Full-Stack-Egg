package com.mza.Libreria.controladores;

import com.mza.Libreria.entidades.Editorial;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceEditorial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
     
    @GetMapping("/lista")
    public String lista(ModelMap modelo){
        List<Editorial> editorialesLista = servEditorial.buscaTodas();
        modelo.addAttribute("editoriales",editorialesLista); //Utilizo una llave("libros") y lo que viaja como valor es la lista librosLista
         return "list-editorial"; // 
    }
    
    //CREAR TRY AND CATCH
    //Clase THYMELEAF min 01:02:00
    @GetMapping("/modificar/{id}") 
    public String modificar(@PathVariable String id,ModelMap modelo){
        modelo.put("editorial",servEditorial.buscarporId(id));
        return "modif-Editorial"; 
    }
    
//    @PostMapping("/modificar/{id}")
//    public String modificar(ModelMap modelo,@PathVariable String id, @RequestParam String nombre)throws Exception{
//        try{
////            servEditorial.modificarEditorial(id,nombre);
//            //modelo.put("exito","Modificación exitosa"); 
//            //return "list-editorial"; Profe en clase thy pone este return pero se lo devuelve vacío min 1:57
//            return "list-editorial";
//        }catch(MiExcepcion ex){
//            modelo.put("error",ex.getMessage());
//            modelo.put("id",id);
//            modelo.put("nombre",nombre);
//            //return "redirect:/libro/lista"; 
//            return "modif-Editorial";
//            //return "redirect:/editorial/modificar/{id}";  
//        }
//    }
    
    //Alta y Baja Clase THYMELEAF Tarde min 01:28:00
//    @GetMapping("/baja/{id}")
//    public String baja(@PathVariable String id,ModelMap modelo){
//        try {
//            servAutor.baja(id);
//            return "redirect:/libro/lista";  
//        } catch (Exception ex) {
//            modelo.put("error", ex.getMessage());
//            return "redirect:/libro/lista"; 
//        }
//    }
//    
//    @GetMapping("/alta/{id}") 
//    public String alta(@PathVariable String id,ModelMap modelo){
//        try {
//            servAutor.alta(id);
//            return "redirect:/libro/lista";  
//        } catch (Exception ex) {
//            modelo.put("error", ex.getMessage()); 
//            return "redirect:/libro/lista"; 
//        }
//    }
//    
//    @GetMapping("/eliminar/{id}") //PATHVARIABLE
//    public String eliminar(@PathVariable String id,ModelMap modelo) throws Exception{
//        try {
//            servAutor.eliminarLibro(id);
//            return "redirect:/libro/lista";  
//        }catch(MiExcepcion ex) {
//            modelo.put("error", ex.getMessage()); //La profe no lo puso pero fijarme si anda
//            return "redirect:/libro/lista"; 
//        }
//    }   
    
}
