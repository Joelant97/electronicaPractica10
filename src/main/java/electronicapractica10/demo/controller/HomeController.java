package electronicapractica10.demo.controller;
import electronicapractica10.demo.service.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller("/inicio")
public class HomeController {

    @Autowired
    private ServiciosUsuario serviciosUsuario;

    @RequestMapping(value = "")
    public String index(Model model, Locale locale, HttpServletRequest request)
    {
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password
    ) {
        serviciosUsuario.autoLogin(username, password);

        return "redirect:/";
    }



}
