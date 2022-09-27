package com.mza.Libreria.configuraciones;

import com.mza.Libreria.servicios.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
    
    // Acá tenemos una instancia del servicio de Usuario, que vamos a utilizar para buscar en la BBDD algún usuario por nombre de usuario
    @Autowired
    public ServiceUsuario servUsuario;

    /**
    * Método para Configurar la Seguridad Web, en donde indico las rutas y los
    * parametros principales
    * @param http HttpSecurity
    * @throws Exception
    */   
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/css/*", "/js/*", "/img/*", "/**") //Acá le digo que los recursos que estén dentro de estas carpetas, pueda acceder cualquier usuario sin estar logueado o necesidad de algún permiso
            .permitAll() 
            .and()
            .formLogin()
            .loginPage("/login") // En que URL está mi formulario de login
            .loginProcessingUrl("/logincheck") //Como voy a llamar el proceso cuando tenga éxito. Acá va cuál va a ser la URL que va a utilizar Spring Security, esta URL es la que hay que usar en el formulario login de la pagina login.html
            .usernameParameter("username") // Como viajan los datos del logueo (usamos username pero podemos usar cualquiera)
            .passwordParameter("password")// Como viajan los datos del logueo (usamos password pero podemos usar cualquiera)
            .defaultSuccessUrl("/inicio") // A que URL viaja si el usuario se autentico con éxito
            .permitAll()
            .and().logout() // Aca configuro la salida
            .logoutUrl("/logout") // Cuando el usuario ingrese a "/logout", Spring security deberia desloguear al usuario del sistema
            .logoutSuccessUrl("/login?logout") // A que URL nos va a dirigir. Profe en clase Spring sec turno tarde pone: .logoutSuccessUrl("/login?logout")
            .permitAll()
            .and().csrf().disable();
    } 
}