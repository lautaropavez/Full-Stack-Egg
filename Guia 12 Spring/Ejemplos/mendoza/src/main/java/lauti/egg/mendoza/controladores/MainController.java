
package lauti.egg.mendoza.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lautaro Pavez
 */

@Controller
@RequestMapping("/persona")
public class MainController {

    @GetMapping("/inicio")
    public String index(){
        
        return "index.html";
    }
}
