
package com.LibreriaWeb2.LibreriaWeb2.service;

import com.LibreriaWeb2.LibreriaWeb2.entidades.Usuario;
import com.LibreriaWeb2.LibreriaWeb2.enumeradores.Rol;
import com.LibreriaWeb2.LibreriaWeb2.excepciones.MiExcepcion;
import com.LibreriaWeb2.LibreriaWeb2.repositorios.UsuarioRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Lautaro Pavez
 */
@Service
public class ServiceUsuario{
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private ServiceNotificacion sNotific;
    
    @Transactional
    public void registrar(String nombre,String apellido,String mail,String clave) throws MiExcepcion{
   
        validacion(nombre,apellido,mail,clave);
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setRol(Rol.USUARIO);
        usuario.setClave(clave);
        
        usuario.setAlta(new Date());
        usuario.setBaja(null);
        
        usuarioRepo.save(usuario);
        
        sNotific.enviarEmail("Bienvenidos a Biblioteca Virtual", "Libreria Web", usuario.getMail());
    }
    
    @Transactional
    public void modificar(String id,String nombre,String apellido,String mail,String clave) throws MiExcepcion{
        
        validacion(nombre,apellido,mail,clave);
        
        Optional<Usuario> respuesta = usuarioRepo.findById(id); //Este método nos devuelve una clase Optional como respuesta 
        if(respuesta.isPresent()){ //Y nos dice si el resultado está presente, osea si encontró un resultado con este id
            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setMail(mail);
            usuario.setClave(clave);

            
            usuarioRepo.save(usuario);
        }else{
         throw new MiExcepcion("No se encontró el usuario ingresado");   
        }  
    }
    
    @Transactional
    public void deshabilitar(String id)throws MiExcepcion{
        
        Optional<Usuario> respuesta = usuarioRepo.findById(id);
        if(respuesta.isPresent()){ 
            Usuario usuario = respuesta.get();
            usuario.setBaja(new Date());
            usuarioRepo.save(usuario);
        }else{
         throw new MiExcepcion("No se encontró el usuario ingresado");   
        }  
    }
    
    @Transactional
    public void habilitar(String id)throws MiExcepcion{
        
        Optional<Usuario> respuesta = usuarioRepo.findById(id);
        if(respuesta.isPresent()){ 
            Usuario usuario = respuesta.get();
            usuario.setBaja(null);          
            usuarioRepo.save(usuario);
        }else{
         throw new MiExcepcion("No se encontró el usuario ingresado");   
        }  
    }
    
    @Transactional
    public void cambiarRol(String id)throws MiExcepcion{
        Optional<Usuario> respuesta = usuarioRepo.findById(id);

        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            if (usuario.getRol().equals(Rol.USUARIO)) {
                usuario.setRol(Rol.ADMIN);
            } else if (usuario.getRol().equals(Rol.ADMIN)) {
                usuario.setRol(Rol.USUARIO);
            }
        }
    }
    
    @Transactional
    public void eliminar(String id){
        
    }
    
    public void validacion(String nombre,String apellido,String mail,String clave) throws MiExcepcion {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiExcepcion("Debe indicar el nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new MiExcepcion("Debe indicar el apellido");
        }
        if (mail == null || mail.isEmpty()) {
            throw new MiExcepcion("Debe indicar el correo electrónico");
        }
        if (mail.contains("@") == false) {
                throw new MiExcepcion("El correo electrónico es incorrecto");
        }
        if (clave == null || clave.trim().isEmpty()) {
            throw new MiExcepcion("Debe indicar la clave");
        }
        if (clave.length() < 8) {
            throw new MiExcepcion("La clave no puede tener menos de 6 caracteres");
        }
    }

    // El método loadUserByUsernamees llamado cuando el usuario quiera autentificarse en la plataforma. Cuando un usuario tiene el formulario para autentificarse(formulario login), 
    // lo que hace Spring Security es llamar a este método de este servicio. El método busca el usuario por el mail y si existe es crearle estos tres permisos y va a pasarle 
    // a Spring security los datos del usuario, la clave y los permisos a los que tiene acceso ese usuario. 
    // Si nosotros trabajamos con más de un rol, por ejemplo un administrador que pudiese crear personas, en ese caso deberiamos a través de algún atributo de usuario, 
    // determinar que tipo de usuario es y dependiendo de eso, que permiso le asignamos. Por el momento lo dejamos así
    // El método recibe un nombre de usuario y lo transforma en un usuario de Spring Security
//    @Override
//    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepo.buscarPorMail(mail); 
//        if (usuario != null){ //si existe(si es distinto de null) lo que vamos a hacer es convertirlo en un usuario del dominio spring
//            List<GrantedAuthority> permisos = new ArrayList<>(); //Creo una lista de permisos
//            
//            //Creo una lista de permisos! 
//            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());//Creamos permisos para un usuario común
//            permisos.add(p1);
//            
//            GrantedAuthority p2 = new SimpleGrantedAuthority("MODULO PORTADAS"); //CHEQUEAR SI DEJAR O NO
//            permisos.add(p2); //Incluimos en la lista de permisos las variables que acabamos de crear
//
//            //Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
//            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//            HttpSession session = attr.getRequest().getSession(true);
//
//            session.setAttribute("usuariosession", usuario); // llave + valor
//           
//            User user = new User(usuario.getMail(),usuario.getClave(), permisos); //El constructor de usuarios de Spring security nos pide: nombre de usario, clave, listado de permisos
//           
//            return user;
//        }else{
//            return null;
//        } 
//    }
}
