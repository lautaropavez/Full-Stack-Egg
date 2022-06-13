
package com.ejemploMendoza.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Lautaro Pavez
 */
@Controller
public class PortalControlador {
    
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
}
