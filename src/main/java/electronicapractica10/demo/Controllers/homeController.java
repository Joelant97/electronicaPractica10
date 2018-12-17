package electronicapractica10.demo.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class homeController {



    @RequestMapping(value = "/")
    public String index(Model model, Locale locale, HttpServletRequest request)
    {

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model) {

        if(usuarioService.buscarTodosUsuarios().size() == 0) {
            Set<Rol> roles = new HashSet<>();
            Rol rol = new Rol();
            rol.setNombreRol("ADMIN");
            rolService.crearRol(rol);
            Rol rol2 = new Rol();
            rol2.setNombreRol("Vendedor");
            rolService.crearRol(rol2);
            usuarioService.crearUsuario(new Usuario());
        }
        return "login";
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
