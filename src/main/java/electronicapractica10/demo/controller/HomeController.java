package electronicapractica10.demo.controller;
import electronicapractica10.demo.model.Rol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Controller
public class HomeController {



    @RequestMapping(value = "/")
    public String index(Model model, Locale locale, HttpServletRequest request)
    {

    }

    


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password
    ) {
        usuarioService.autoLogin(username, password);

        return "redirect:/";
    }


    @ResponseBody
    @PostMapping(value = "/graficar")
    public List<Object[]> graficar(@RequestParam("categoria") String categoria, Model model)
    {
        Categoria categoria1 = categoriaService.findByNombreCategoria(categoria);

        model.addAttribute("categoria", categoria1);
        model.addAttribute("result", result);
        return result;

    }
}
