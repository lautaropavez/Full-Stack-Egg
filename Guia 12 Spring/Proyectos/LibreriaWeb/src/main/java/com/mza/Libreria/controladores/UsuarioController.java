package com.mza.Libreria.controladores;

import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceUsuario;
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
@RequestMapping("/usuario") 
public class UsuarioController {
    
    @Autowired
    private ServiceUsuario servUsuario;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
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
    public String modificar(ModelMap modelo,@PathVariable String id,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String mail,@RequestParam String clave,@RequestParam String clave2)throws Exception{
        try{
            servUsuario.modificar(id,nombre,apellido,mail,clave,clave2);
            modelo.put("exito","Modificación exitosa"); 
            //return lista(modelo,buscar); //nos devuelve a la página de inicio
            return "redirect:/usuario/lista";   //Profe en clase thy pone este return pero se lo devuelve vacío min 1:57  
        }catch(Exception e){
            modelo.put("error","Falto algún dato"); 
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
