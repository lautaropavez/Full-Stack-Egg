package com.mza.Libreria.controladores;

import com.mza.Libreria.entidades.Usuario;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceUsuario;
import javax.servlet.http.HttpSession;
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
/**
 *
 * @author Lautaro Pavez
 */

//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")  //Si no voy a poner acá el método de que el usuario se modifique su propio perfil, puedo poner el preauthorize solo para el admin en todo este controller
@Controller 
@RequestMapping("/usuario") 
public class UsuarioController {
    
    @Autowired
    private ServiceUsuario servUsuario;
  
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/editar-perfil") // /editar-perfil/{id}
    public String editarPerfil(ModelMap modelo,HttpSession session,@RequestParam String id){
        
        // Yo acá recupero el usuario de la sesión, ya que cuando el usuario se loguea, en loadByUsername en service usuario, busca el usuario en la BBDD y lo guarda en la sesión con el nombre "usuariosession"
        // Le digo al controlador que el método va a usar la sesión cuando le pongo el Httpsession como parámetro. A la session le pido el atributo "usuariosession" lo casteo y lo guardo en una variable que se llama login
        Usuario login = (Usuario)session.getAttribute("usuariosession");
        if(login == null || !login.getId().equals(id)){ //Si login es null significa que no hay ningun usuario en la session O si no es null pero el id del usuario logueado(login.getId()) no es igual al id del usuario que quiero modificar (id que tengo como parámetro) 
            return "redirect:/inicio";                  // Los redirecciono al inicio
        }
        try {
            modelo.addAttribute("perfil",servUsuario.buscarPorId(id));
        } catch (Exception e) {
            modelo.addAttribute("error",e.getMessage());
        }
        
        return "perfil.html";  
    }
    
    //Ver si ponerlo en el main para poner en el 
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @PostMapping("/actualizar-perfil") //
    public String registrar(ModelMap modelo,HttpSession session, @RequestParam MultipartFile archivo,@RequestParam String id,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String mail,@RequestParam String clave1,@RequestParam String clave2){
        Usuario usuario = null;
        try{
            Usuario login = (Usuario)session.getAttribute("usuariosession");
            if(login == null || !login.getId().equals(id)){ //Si login es null significa que no hay ningun usuario en la session O si no es null pero el id del usuario logueado(login.getId()) no es igual al id del usuario que quiero modificar (id que tengo como parámetro) 
                return "redirect:/inicio";                  // Los redirecciono al inicio
            }
            usuario = servUsuario.buscarPorId(id);
            servUsuario.modificar(archivo,id,nombre,apellido,mail,clave1,clave2);
            modelo.put("exito","Modificación exitosa"); 
            session.setAttribute("usuariosession",usuario); 
            return "redirect:/inicio";    
        }catch(MiExcepcion ex){
            modelo.put("error",ex.getMessage()); 
            modelo.put("perfil",usuario); 
            return "perfil.html"; 
        }
    }
    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/lista") //Clase THYMELEAF min 01:03:00
    public String lista(ModelMap modelo,@RequestParam(required = false) String buscar){
        
        modelo.addAttribute("usuarios",servUsuario.listaBuscada(buscar));
        
        return "list-usuario";  
    } 
    
    //Clase THYMELEAF min 01:27:00 
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/modificar/{id}") //PATHVARIABLE
    public String modificar(@PathVariable String id,ModelMap modelo){ //Acá recibo un id que viene por URL --> /modificar/${id} y ese id es el que uso para buscar el usuario y mostrarlo, lo enviamos tambien por url 
        modelo.put("usuario",servUsuario.buscarPorId(id));
        return "modif-Usuario"; 
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/modificar/{id}") 
    public String modificar(ModelMap modelo, @RequestParam MultipartFile archivo,@PathVariable String id,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String mail,@RequestParam String clave,@RequestParam String clave2)throws Exception{
        try{
            servUsuario.modificar(archivo,id,nombre,apellido,mail,clave,clave2);
            modelo.put("exito","Modificación exitosa"); 
            //return lista(modelo,buscar); //nos devuelve a la página de inicio
            return "redirect:/usuario/lista";   //Profe en clase thy pone este return pero se lo devuelve vacío min 1:57  
        }catch(MiExcepcion ex){
            modelo.put("error",ex.getMessage()); 
            return "modif-Usuario"; 
        }
    }
    
    //Clase THYMELEAF Tarde min 01:28:00
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/baja/{id}") //PATHVARIABLE
    public String baja(@PathVariable String id,ModelMap modelo){
        try {
            servUsuario.deshabilitar(id);
            return "redirect:/usuario/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); //La profe no lo puso pero fijarme si anda
            return "redirect:/usuario/lista"; 
        //  return "redirect:/"; Profe pone este return 
        }
    }
    
    //Clase THYMELEAF Tarde min 01:28:00
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/alta/{id}") //PATHVARIABLE
    public String alta(@PathVariable String id,ModelMap modelo){ //Acá recibo un id que viene por URL --> /modificar/${id} y ese id es el que uso para buscar el usuario y mostrarlo, lo enviamos tambien por url 
        try {
            servUsuario.habilitar(id);
            return "redirect:/usuario/lista";  
        } catch (MiExcepcion ex) {
        //    modelo.put("error", ex.getMessage()); Ver como hacer para que lo muestre si sucede algún error porque salta directamente a la otra página.La profe no lo puso pero fijarme si anda
            return "redirect:/usuario/lista"; 
        //  return "redirect:/"; Profe pone este return 
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}") //PATHVARIABLE
    public String eliminar(@PathVariable String id,ModelMap modelo) throws Exception{
        try {
            servUsuario.eliminar(id);
            return "redirect:/usuario/lista";  
        }catch(MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); //La profe no lo puso pero fijarme si anda
            return "redirect:/usuario/lista"; 
        }
    }   
}
