package com.mza.Libreria.controladores;

import com.mza.Libreria.servicios.ServicePrestamo;
import com.mza.Libreria.servicios.ServiceUsuario;
import com.mza.Libreria.servicios.ServiceLibro;
import com.mza.Libreria.entidades.Usuario;
import com.mza.Libreria.entidades.Prestamo;
import com.mza.Libreria.excepciones.MiExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lautaro Pavez
 */
@Controller 
@RequestMapping("/prestamos") 
public class PrestamosController {
    
    @Autowired
    private ServicePrestamo servPrestamo; 

    @Autowired
    private ServiceUsuario servUsuario;

    @Autowired
    private ServiceLibro servLibro;

    /**
     * Controlador GET del formulario para efectuar un nuevo préstamo y
     * persistirlo en la base de datos Solo pueden acceder los Usuarios activos,
     * y solo a los libros activos y con ejemplares restantes.
     *
     * @param modelo  ModelMap
     * @param session
     * @param id
     * @return solicitud.html
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/solicitud/{id}")
    public String solicitud(ModelMap modelo, HttpSession session, @PathVariable String id){
        // Con la HttpSession obtengo el Usuario que está haciendo el préstamo
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        
        // Inyecto al modelo un Libro, un Usuario y un Préstamo 
        try {
            modelo.addAttribute("libro", servLibro.buscarPorId(id));
            modelo.addAttribute("usuario", servUsuario.buscarPorId(usuario.getId()));
        } catch (Exception e) {
            modelo.put("error", "Hubo un problema: " + e.getMessage());
        }
        return "solicitud";
    }

    /**
     * Controlador GET que recibe un solo argumentos e intenta
     * persistir un Objeto Prestamo en la Base de Datos
     *
     * @param modelo  ModelMap
     * @param session
     * @param id
     * @return solicitud.html
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/confirmacion/{id}")
    public String guardarSolicitud(ModelMap modelo, HttpSession session, @PathVariable String id) {

        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        //mediante la HttpSession obtengo el Usuario que esta haciendo el prestamo
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        
        try {
            modelo.addAttribute("libro", servLibro.buscarPorId(id));
            modelo.addAttribute("usuario", servUsuario.buscarPorId(usuario.getId()));
            //Intento persistir el nuevo Objeto Prestamo usando un método de la Clase Service
            Prestamo prestamo = servPrestamo.creaPrestamo(id, usuario.getId());
            modelo.addAttribute("prestamo", prestamo);
            modelo.addAttribute("exito", "¡Reservamos tu libro, pasa a retirarlo! con el código " + prestamo.getId());

        } catch (MiExcepcion e) {
            //Inyección del mensaje de error
            modelo.put("error", "¡Algo salió mal! " + e.getMessage());
        }
        return "prestamo";
    }

    /**
     * Controlador GET que devuelve a la vista un modelo con el listado de todos
     * los préstamos no importa el estado, solo se puede acceder si se posee el
     * ROL ADMIN
     *
     * @param modelo ModelMap
     * @return listaPrestamos.html
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/lista")
    public String listado_prestamos(ModelMap modelo) {
        //Inyección del listado con todos los Prestamos dentro del ModelMap
        try {
            List<Prestamo> prestamos = servPrestamo.listaPrestamos();
            modelo.addAttribute("prestamos", prestamos);
        } catch (MiExcepcion ex) {
            modelo.put("error", "Hubo un problema: " + ex.getMessage());
        }
        return "list-prestamo";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/misPrestamos")
    public String prestamosxUsuario(ModelMap modelo,HttpSession session,@RequestParam String id){
        
        // Recupero el usuario de la sesión
        Usuario login = (Usuario)session.getAttribute("usuariosession");
        if(login == null || !login.getId().equals(id)){ //Si login es null significa que no hay ningun usuario en la session O si no es null pero el id del usuario logueado(login.getId()) no es igual al id del usuario que quiero modificar (id que tengo como parámetro) 
            return "redirect:/inicio";                  
        }
        try {
            modelo.addAttribute("prestamos",servPrestamo.buscarPorUsuario(id));
        } catch (Exception e) {
            modelo.addAttribute("error","Hubo un problema: " + e.getMessage());
        }
        return "list-prestamoUsuario";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/baja/{id}")
    public String baja(@PathVariable String id,ModelMap modelo){
        try {
            servPrestamo.baja(id);
            return "redirect:/prestamos/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "redirect:/prestamos/lista"; 
        }
    }
      
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/alta/{id}") 
    public String alta(@PathVariable String id,ModelMap modelo){
        try {
            servPrestamo.alta(id);
            return "redirect:/prestamos/lista";  
        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage()); 
            return "redirect:/prestamos/lista"; 
        }
    }
    
}

