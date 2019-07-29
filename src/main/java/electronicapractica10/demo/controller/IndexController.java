package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Categoria;
import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.model.Usuario;
import electronicapractica10.demo.service.CategoriaServiceImpl;
import electronicapractica10.demo.service.ClienteEquipoServiceImpl;
import electronicapractica10.demo.service.RolServiceImpl;
import electronicapractica10.demo.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;
    @Autowired
    private CategoriaServiceImpl categoriaService;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private RolServiceImpl rolService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Locale locale, HttpServletRequest request)
    {
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        model.addAttribute("categorias",categorias);
        model.addAttribute("puerto", ""+request.getLocalPort());
//        model.addAttribute("saludo", messageSource.getMessage("saludo", null, locale));

        // model.addAttribute("derecho_autor", messageSource.getMessage("derecho_autor", null, locale));
        return "clientes.ftl";
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
            usuarioService.crearUsuario(new Usuario(1, "admin", "admin", "admin@gmail.com", rol));
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
        List<Object[]> result = clienteEquipoService.promedioAlquilerPorFamilia(categoriaService.findByNombreCategoria(categoria).getId());
        model.addAttribute("categoria", categoria1);
        model.addAttribute("result", result);
        return result;

    }
}
