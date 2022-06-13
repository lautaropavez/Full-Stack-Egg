package com.mza.Libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Lautaro Pavez
 */
@Controller
@RequestMapping("/") //localhost:8080/
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }
}
