package com.mza.Libreria.controladores;

import com.mza.Libreria.entidades.Libro;
import com.mza.Libreria.entidades.Usuario;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.servicios.ServiceLibro;
import com.mza.Libreria.servicios.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lautaro Pavez
 */

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
@Controller
@RequestMapping("/imagen")
public class ImagenController {

    @Autowired
    private ServiceLibro servLibro;
    
    @Autowired
    private ServiceUsuario servUsuario;

//  (1° Forma que aprendimos, solo cambian las 2 lineas que comentamos)
//   @GetMapping("/libro")
//   public ResponseEntity<byte[]> portadaLibro(@RequestParam String id) throws MiExcepcion{ 
//  (2° Forma que aprendimos) Para pasarle el id por la URL con PathVariable
    @GetMapping("/libro/{id}")
    public ResponseEntity<byte[]> portadaLibro(@PathVariable String id) throws MiExcepcion {
        try {
            Libro libro = servLibro.findbyId(id);
            if (libro.getPortada() == null) {
                throw new MiExcepcion("El libro no tiene foto de portada");  
            }
            byte[] portada = libro.getPortada().getContenido(); // Accedemos al contenido que es un arreglo de bytes, que es el que tenemos que hacer que descargue el navegador con una URL pq las fotos en HTML se consumen con una URL

            HttpHeaders headers = new HttpHeaders(); //Las cabeceras le vana  decir al navegador que yo estoy devolviendo una imagen
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(portada, headers, HttpStatus.OK); // El response entity puede recibir tres parámetros: 1° contenido, 2° cabecera 3° estado en el que se determina ese proceso, osea con que código vamos a devolver el pedido(HTTP STATUS 200,500,400,etc.)
        } catch (MiExcepcion e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> portadaUsuario(@PathVariable String id) throws MiExcepcion {
        try {
            Usuario usuario = servUsuario.buscarPorId(id);
            if (usuario.getImagen()== null) {
                throw new MiExcepcion("El usuario no tiene foto de perfil");  
            }
            byte[] imagen = usuario.getImagen().getContenido(); // Accedemos al contenido que es un arreglo de bytes, que es el que tenemos que hacer que descargue el navegador con una URL pq las fotos en HTML se consumen con una URL

            HttpHeaders headers = new HttpHeaders(); //Las cabeceras le van a decir al navegador que yo estoy devolviendo una imagen
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imagen, headers, HttpStatus.OK); // El response entity puede recibir tres parámetros: 1° contenido, 2° cabecera 3° estado en el que se determina ese proceso, osea con que código vamos a devolver el pedido(HTTP STATUS 200,500,400,etc.)
        } catch (MiExcepcion e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
