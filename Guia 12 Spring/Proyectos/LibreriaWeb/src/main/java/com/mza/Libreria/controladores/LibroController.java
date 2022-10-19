package com.mza.Libreria.controladores;

import com.mza.Libreria.entidades.Autor;
import com.mza.Libreria.entidades.Editorial;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceAutor;
import com.mza.Libreria.servicios.ServiceEditorial;
import com.mza.Libreria.servicios.ServiceLibro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import com.mza.Libreria.pdf.LibrosPDF;
//import com.mza.Libreria.pdf.PDFGenerator;
//import java.util.Map;

/**
 *
 * @author Lautaro Pavez
 */

// Notas: Clase Servicio Mañana muestra CONTROLADOR DE LIBRO y en (Clase 2 Mañana)
@Controller 
@RequestMapping("/libro")
public class LibroController {

//    @Autowired
//    private LibrosPDF librosPDF;
//    
//    @Autowired
//    private PDFGenerator PDFGenerator;
    
    @Autowired
    private ServiceLibro servLibro; 
    
    @Autowired
    private ServiceAutor servAutor; 
    
    @Autowired
    private ServiceEditorial servEditorial; 
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/registro") 
    public String formulario(ModelMap modelo){
        
        List<Autor> autores = servAutor.buscaActivosxOrdenAlf();
        modelo.addAttribute("autores", autores);
        
        List<Editorial> editoriales = servEditorial.buscaActivasxOrdenAlf();
        modelo.addAttribute("editoriales", editoriales);
        
        return "nuevoLibro";
    }	
      
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registrar") 
    public String crear(ModelMap modelo,@RequestParam MultipartFile archivo,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares, @RequestParam String idAutor,@RequestParam String idEditorial,@RequestParam(required = false) String descripcion){ 
        try{
           servLibro.crearLibro(archivo,titulo,anio,ejemplares,idAutor,idEditorial,descripcion);
           modelo.put("exito","¡Registro exitoso!");    
           //return "redirect:/libro/lista";
           List<Autor> autores = servAutor.buscaActivosxOrdenAlf();
           modelo.addAttribute("autores", autores);
        
           List<Editorial> editoriales = servEditorial.buscaActivasxOrdenAlf();
           modelo.addAttribute("editoriales", editoriales);
           return "nuevoLibro"; 
          //Forma profe Videos MVC 2
          //modelo.put("titulo","¡¡Bienvenido a Libreria El Ceibo!!");
          //modelo.put("descripcion","Tu usuario fue registrado de manera satisfactoria");
          //return "exito.html"; //Si esta todo ok retorna la pag principal, en vez de el registro de nuevo
        }catch(MiExcepcion ex){
            modelo.put("error", ex.getMessage());
            //Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex); //Con esto nos tira el error por consola, lo podemos sacar
            modelo.put("titulo",titulo);
            modelo.put("anio",anio);
            modelo.put("ejemplares",ejemplares);
            modelo.put("descripcion",descripcion);
            List<Autor> autores = servAutor.buscaActivosxOrdenAlf();
            modelo.addAttribute("autores", autores);
            List<Editorial> editoriales = servEditorial.buscaActivasxOrdenAlf();
            modelo.addAttribute("editoriales", editoriales);
            
            return "nuevoLibro"; 
        }  
    }

    //Clase THYMELEAF min 01:03:00
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/lista")
    public String lista(ModelMap modelo,@RequestParam(required = false) String buscar){
        
        modelo.addAttribute("libros",servLibro.listaBuscada(buscar)); //Utilizo una llave("libros") y lo que viaja como valor es la lista librosLista
         
        return "list-libros"; 
    }
//    
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
//    @GetMapping("/pdf/generate")
//    public void generatePDF(HttpServletResponse response,Map<String, Object> model) throws IOException{
//        response.setContentType("application/pdf");
//        
//        //Debemos settear el header a response
//        String headerKey = "Content-Disposition"; //Este header le dice al browser que tipo de archivo devolvemos
//        String headerValue = "attachment; filename=pdf_" + "Lista de libros"+ ".pdf"; //nombre del archivo
//        response.setHeader(headerKey, headerValue);
//        
//        PDFGenerator.export(response,model);
//    } 
//    
//    
    /**
     * Get para mostrar mas información sobre un libro o solicitar un préstamos
     * como aquí los libros son accesible a los usuarios trae solo los libros activos y que posean ejemplares restantes
     * @param id
     * @param modelo ModelMap
     * @return libro.html
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/libro/{id}") 
    public String libro(@PathVariable String id,ModelMap modelo){
       
        modelo.put("libro",servLibro.buscarPorId(id));
       
        return "libro"; 
    }
    
    //CREAR TRY AND CATCH
    //Clase THYMELEAF min 01:02:00
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id,ModelMap modelo){
        List<Autor> autores = servAutor.buscaActivosxOrdenAlf();
        modelo.addAttribute("autores", autores);
      
        List<Editorial> editoriales = servEditorial.buscaActivasxOrdenAlf();
        modelo.addAttribute("editoriales", editoriales);
        
        modelo.put("libro",servLibro.buscarPorId(id));
        return "modif-Libro"; // ya esta creado el form en el archivo form-perro.html (de la clase)
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/modificar/{id}")
    public String modificar(ModelMap modelo,@RequestParam MultipartFile archivo,@PathVariable String id, @RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares, @RequestParam String idAutor,@RequestParam String idEditorial, @RequestParam(required = false) String descripcion)throws Exception{
        try{
            servLibro.modificarLibro(archivo,id,titulo,anio,ejemplares,idAutor,idEditorial,descripcion);
            //modelo.put("exito","Modificación exitosa");
            //return "modif-Libro";
            //return "list-libros"; Profe en clase thy pone este return pero se lo devuelve vacío min 1:57
            return "redirect:/libro/lista"; 
        }catch(MiExcepcion ex){
            modelo.put("error",ex.getMessage());
            modelo.put("id",id);
           // modelo.put("archivo",archivo);
            modelo.put("titulo",titulo);
            modelo.put("anio",anio);
            modelo.put("ejemplares",ejemplares);
            modelo.put("descripcion",descripcion);
            List<Autor> autores = servAutor.buscaActivosxOrdenAlf();
            modelo.addAttribute("autores", autores);
            List<Editorial> editoriales = servEditorial.buscaActivasxOrdenAlf();
            modelo.addAttribute("editoriales", editoriales);
            modelo.put("autor",idAutor);
            modelo.put("editorial",idEditorial);
            //return "redirect:/libro/lista"; 
//            return "libro/modificar/{id}";
            return "redirect:/libro/modificar/{id}";  
        }
    }
    
    //Alta y Baja Clase THYMELEAF Tarde min 01:28:00
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/baja/{id}")
    public String baja(@PathVariable String id,ModelMap modelo){
        try {
            servLibro.baja(id);
            return "redirect:/libro/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "redirect:/libro/lista"; 
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/alta/{id}") 
    public String alta(@PathVariable String id,ModelMap modelo){
        try {
            servLibro.alta(id);
            return "redirect:/libro/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); 
            return "redirect:/libro/lista"; 
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}") //PATHVARIABLE
    public String eliminar(@PathVariable String id,ModelMap modelo) throws Exception{
        try {
            servLibro.eliminarLibro(id);
            return "redirect:/libro/lista";  
        }catch(MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); //La profe no lo puso pero fijarme si anda
            return "redirect:/libro/lista"; 
        }
    }   

}
