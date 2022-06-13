
package com.mza.Libreria.servicios;

import com.mza.Libreria.entidades.Usuario;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.repositorios.UsuarioRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lautaro Pavez
 */
@Service
public class ServiceUsuario {
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    public void registrar(String nombre,String apellido,String mail,String clave) throws MiExcepcion{
   
        validacion(nombre,apellido,mail,clave);
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setClave(clave);//Por el momento la clave la vamos a setear de esta manera, no la vamos a encriptar ni nada, mas adelante le vamos a poner más seguridad 
        usuario.setAlta(new Date());
        
        usuarioRepo.save(usuario);
    }
    
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
}
