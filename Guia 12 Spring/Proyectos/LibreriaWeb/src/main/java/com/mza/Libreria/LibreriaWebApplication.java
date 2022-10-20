package com.mza.Libreria;

//import com.mza.Libreria.servicios.ServiceNotificacion;
import com.mza.Libreria.servicios.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class LibreriaWebApplication{
    
//    @Autowired
//    private ServiceNotificacion servNotif;
    
    @Autowired
    private ServiceUsuario servUsuario;

    public static void main(String[] args) {
       SpringApplication.run(LibreriaWebApplication.class, args);
    }
    
    /**
    * Acá tenemos una configuración del manejador de seguridad Spring Security al cuál le decimos cual es el servicio que debe utilizar para autentificar un usuario
    * Luego una vez que utiliza nuestro servicio para buscar un usuario en la base de datos, cual es el encoder que va a utilizar para comparar las contraseñas
    * Nosotros cuando registramos un usuario a través de nuestro servicio, la contraseña que el usuario ingreso en el registro, nosotros la encriptamos a traves 
    * de un encoder.
    * Cuando un usuario va a loguearse para ingresar a la plataforma, al llenar su usuario y su clave en texto plano, Spring Security va a tomar ese texto plano y 
    * la va a encriptar a traves del encoder que le pasamos acá, obviamente los dos encoder deben ser los mismos para que cuando se transformen las contraseñas sean
    * iguales
    * Resumido: Este método le dice a la configuración de Spring Security cuál es el servicio que vamos a utilizar para autentificar el usuario y le va a setear 
    *           un encriptador de contraseñas a ese servicio, osea que cada vez que se chequee una clave va a usarse este encriptador
    * @param auth
    * @throws java.lang.Exception
    */
    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder auth)throws Exception{
         auth
                .userDetailsService(servUsuario)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
 
    //MAIL
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(){
//        servNotif.enviarEmail("Hola Gaspar...","Mensaje para Gaspar","elceibolibreria@gmail.com");
//    } 
}
