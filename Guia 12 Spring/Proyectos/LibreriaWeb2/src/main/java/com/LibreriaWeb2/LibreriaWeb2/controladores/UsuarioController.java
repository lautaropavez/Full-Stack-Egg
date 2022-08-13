package com.LibreriaWeb2.LibreriaWeb2.controladores;

import com.LibreriaWeb2.LibreriaWeb2.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Lautaro Pavez
 */

@Controller 
@RequestMapping("/usuario") 
public class UsuarioController {
    
    @Autowired
    private ServiceUsuario servUsuario;
}
