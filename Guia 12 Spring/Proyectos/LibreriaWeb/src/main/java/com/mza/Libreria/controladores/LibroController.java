package com.mza.Libreria.controladores;

import com.mza.Libreria.entidades.Libro;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceLibro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Lautaro Pavez
 */

// Notas: Clase Servicio Mañana muestra CONTROLADOR DE LIBRO
@Controller 
@RequestMapping("/libro") //localhost:8080/libro (Clase 2 Mañana)
public class LibroController {

    @Autowired
    private ServiceLibro servLibro; 
    
    @GetMapping("/registro") //localhost:8080/libro/registro
    public String formulario(){
         return "form-libro"; // ya esta creado el form en el archivo form-perro.html
    }
      
    //Hacer que envia el mensaje de las validaciones de los servicios con e.getMessage
    @PostMapping("/registrar") //El post mapping trae la info
    public String crear(ModelMap modelo,@RequestParam MultipartFile archivo, @RequestParam String titulo,@RequestParam Integer anio, @RequestParam String nombreAut,@RequestParam String nombreEdit){ //acá van todos los atributos del metodo crear
        try{
            servLibro.crearLibro(archivo,titulo,anio,nombreAut,nombreEdit);
            modelo.put("exito","Registro exitoso"); //en exito le podemos poner cualq cantidad de palabras pq es un String lo que le pasamos, pero siempre deben ser solo 2 parametros
            return "form-libro"; //retornamos la misma página
          //Forma profe Clase Thymeleaft 
//        modelo.put("exito","¡¡Registro exitoso!!");
//        return "registro.html"; //Si está todo ok retorna el registro y ya pusimos un div con los mensajes de exito cuando ingrese un usuario
//        //Forma profe Videos MVC 2
//        //modelo.put("titulo","¡¡Bienvenido a Libreria El Ceibo!!");
//        //modelo.put("descripcion","Tu usuario fue registrado de manera satisfactoria");
//        //return "exito.html"; //Si esta todo ok retorna la pag principal, en vez de el registro de nuevo
//        //Forma Lauti hacerlo con una popup
        }catch(MiExcepcion ex){
            modelo.put("error", ex.getMessage());// Este modelo lo vamos a utilizar para enviar en este caso el mensaje de error en la pantalla.
            //Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex); //Con esto nos tira el error por consola, lo podemos sacar

//            A modificar por los atributos de libro en vez usuario  
//            modelo.put("nombre",nombre);
//            modelo.put("apellido",apellido);
//            modelo.put("mail",mail);
//            modelo.put("clave1",clave1);
//            modelo.put("clave2",clave2);
            return "form-libro"; //Si ocurre un error retornamos la misma página
        }
        
        
    }
   
//    public String registrar(ModelMap modelo,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String mail,@RequestParam String clave1,@RequestParam String clave2){ 
//    }
    
    
    
    
    
        //Clase THYMELEAF min 01:03:00
    @GetMapping("/lista") //localhost:8080/libro/lista
    public String lista(ModelMap modelo){
        List<Libro> librosLista = servLibro.listarTodos();
        modelo.addAttribute("libros",librosLista); //Utilizo una llave("libros") y lo que viaja como valor es la lista librosLista
         return "list-libro"; // 
    }
    
    //CREAR TRY AND CATCH
    //Clase THYMELEAF min 01:02:00
    @GetMapping("/modificar/{id}") //localhost:8080/libro/modificar
    public String modificar(@PathVariable String id,ModelMap modelo){
        modelo.put("libro",servLibro.buscarPorId(id));
        return "form-libro-modificar"; // ya esta creado el form en el archivo form-perro.html (de la clase)
    }
    
    @PostMapping("/modificar/{id}") 
    public String modificar(ModelMap modelo,@PathVariable String id,@RequestParam MultipartFile archivo, @RequestParam String titulo,@RequestParam Integer anio, @RequestParam String nombreAut,@RequestParam String nombreEdit)throws Exception{
        try{
            servLibro.modificarLibro(archivo,id,titulo,anio,nombreAut,nombreEdit);
            //modelo.put("exito","Modificación exitosa"); 
            //return "list-libro"; Profe en clase thy pone este return pero se lo devuelve vacío min 1:57
            return "/";
        }catch(Exception e){
            modelo.put("error","Falto algún dato"); 
            return "form-libro-modif"; 
        }
    }
    
}
