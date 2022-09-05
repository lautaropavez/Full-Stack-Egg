package com.mza.Libreria.controladores;
import com.mza.Libreria.entidades.Autor;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceAutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/lista")
    public String lista(ModelMap modelo){
        List<Autor> autoresLista = servAutor.buscaTodos();
        modelo.addAttribute("autores",autoresLista); //Utilizo una llave("libros") y lo que viaja como valor es la lista librosLista
         return "list-autor"; // 
    }
    
    //CREAR TRY AND CATCH
    //Clase THYMELEAF min 01:02:00
    @GetMapping("/modificar/{id}") 
    public String modificar(@PathVariable String id,ModelMap modelo){
        modelo.put("autor",servAutor.buscarporId(id));
        return "modif-Autor"; 
    }
    
//    @PostMapping("/modificar/{id}") 
//    public String modificar(ModelMap modelo,@PathVariable String id, @RequestParam String nombre)throws Exception{
//        try{
//            
////            servAutor.modificarAutor(id,nombre);
//            //modelo.put("exito","Modificación exitosa"); 
//            return "list-libro"; Profe en clase thy pone este return pero se lo devuelve vacío min 1:57
//        }catch(MiExcepcion ex){
//            modelo.put("error",ex.getMessage());
//            modelo.put("id",id);
//            modelo.put("nombre",nombre);
//            //return "redirect:/autor/lista"; 
//            return "modif-Autor";
//            //return "redirect:/autor/modificar/{id}";  
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
