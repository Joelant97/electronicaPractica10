package electronicapractica10.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(Model model, Locale locale, HttpServletRequest request)
    {
        return "index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password
    ) {
        //usuarioService.autoLogin(username, password);

        return "login";
    }

/*
    @ResponseBody
    @PostMapping(value = "/graficar")
    templates List<Object[]> graficar(@RequestParam("categoria") String categoria, Model model)
    {
        Categoria categoria1 = categoriaService.findByNombreCategoria(categoria);

        model.addAttribute("categoria", categoria1);
        model.addAttribute("result", result);
        return result;

    }*/
}
