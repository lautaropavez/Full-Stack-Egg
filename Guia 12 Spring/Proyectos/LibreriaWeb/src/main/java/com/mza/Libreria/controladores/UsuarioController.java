package com.mza.Libreria.controladores;

import com.mza.Libreria.entidades.Usuario;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceUsuario;
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
@RequestMapping("/usuario") 
public class UsuarioController {
    
    @Autowired
    private ServiceUsuario servUsuario;
    
    //IMPORTANTE: En videos(MVC Youtube y Clase THYMELEAF) estos métodos los han hecho en el Main el registro de usuarios
    
//    //Método de prueba
//    @GetMapping("/registro")//localhost:8080/usuario/registro
//    public String registro(){
//        return "registro.html";
//    }
//     
//    //Método de prueba
//    @PostMapping("/registrar")
//    public String registrar(ModelMap modelo,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String mail,@RequestParam String clave1,@RequestParam String clave2){
//        try {
//            servUsuario.registrar(nombre, apellido, mail, clave1);
//            
//        } catch (MiExcepcion ex) {
//            modelo.put("error", ex.getMessage()); // Este modelo lo vamos a utilizar para enviar en este caso el mensaje de error en la pantalla.
//            
//            modelo.put("nombre",nombre);
//            modelo.put("apellido",apellido);
//            modelo.put("mail",mail);
//            modelo.put("clave1",clave1);
//            modelo.put("clave2",clave2);
//            //Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex); //Con esto nos tira el error por consola, lo podemos sacar
//            return "registro.html"; //Si ocurre un error retorna el registro 
//            
//        }
//        //Forma profe Clase Thymeleaft 
//        modelo.put("exito","¡¡Registro exitoso!!");
//        return "registro.html"; //Si está todo ok retorna el registro y ya pusimos un div con los mensajes de exito cuando ingrese un usuario
//        //Forma profe Videos MVC 2
//        //modelo.put("titulo","¡¡Bienvenido a Libreria El Ceibo!!");
//        //modelo.put("descripcion","Tu usuario fue registrado de manera satisfactoria");
//        //return "exito.html"; //Si esta todo ok retorna la pag principal, en vez de el registro de nuevo
//        //Forma Lauti hacerlo con una popup
//    }
    
        //Clase THYMELEAF min 01:03:00
    @GetMapping("/lista") //localhost:8080/usuario/lista
    public String lista(ModelMap modelo){
        List<Usuario> usuariosLista = servUsuario.listarTodos();
        modelo.addAttribute("usuarios",usuariosLista); //Utilizo una llave("usuarios") y lo que viaja como valor es la lista usuariosLista
        return "list-usuario";  
    }
    
    //Clase THYMELEAF min 01:27:00 (html sin hacer)
    @GetMapping("/modificar/{id}") //PATHVARIABLE
    public String modificar(@PathVariable String id,ModelMap modelo){ //Acá recibo un id que viene por URL --> /modificar/${id} y ese id es el que uso para buscar el usuario y mostrarlo, lo enviamos tambien por url 
        modelo.put("usuario",servUsuario.buscarPorId(id));
        return "form-usuario-modif"; // ya esta creado el form en el archivo form-perro.html (de la clase)
    }
    
    @PostMapping("/modificar/{id}") 
    public String modificar(ModelMap modelo,@PathVariable String id,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String mail,@RequestParam String clave)throws Exception{
        try{
            servUsuario.modificar(id, nombre, apellido, mail, clave);
            modelo.put("exito","Modificación exitosa"); 
            return lista(modelo); //nos devuelve a la página de inicio
            //return "list-usuario"; Profe en clase thy pone este return pero se lo devuelve vacío min 1:57
            
        }catch(Exception e){
            modelo.put("error","Falto algún dato"); 
            return "form-usuario-modif"; 
        }
    }
    
//    //Clase THYMELEAF min 01:27:00 (html sin hacer)
//    @GetMapping("/baja/{id}") //PATHVARIABLE
//    public String baja(@PathVariable String id,ModelMap modelo){ //Acá recibo un id que viene por URL --> /modificar/${id} y ese id es el que uso para buscar el usuario y mostrarlo, lo enviamos tambien por url 
//        modelo.put("usuario",servUsuario.buscarPorId(id));
//        return "form-usuario-modif"; // ya esta creado el form en el archivo form-perro.html (de la clase)
//    }
//    
//    //Clase THYMELEAF min 01:27:00 (html sin hacer)
//    @GetMapping("/alta/{id}") //PATHVARIABLE
//    public String alta(@PathVariable String id,ModelMap modelo){ //Acá recibo un id que viene por URL --> /modificar/${id} y ese id es el que uso para buscar el usuario y mostrarlo, lo enviamos tambien por url 
//        modelo.put("usuario",servUsuario.buscarPorId(id));
//        return "form-usuario-modif"; // ya esta creado el form en el archivo form-perro.html (de la clase)
//    }
    
}
