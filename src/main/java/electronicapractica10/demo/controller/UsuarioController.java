package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private RolServiceImpl rolService;

    @GetMapping(value="/")
    public String usuarios(Model model)
    {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioService.buscarTodosUsuarios();
        List<Rol> roles = rolService.buscarTodosRoles();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles", roles);

        return "usuarios";
    }


    @PostMapping("/")
    public String crearUsuario(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("rol") String rol){
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setActive(1);
        Rol r = new Rol();
        r = rolService.findByNombreRol(rol);
        u.setRol(r);
        usuarioService.crearUsuario(u);
        return "redirect:/usuarios/";
    }

    @PostMapping("/modificar/")
    public String modificarUsuario(@RequestParam("username2") String username, @RequestParam("id2") String id,@RequestParam("password2") String password, @RequestParam("email2") String email, @RequestParam("rol2") String rol){
        Usuario u = usuarioService.buscarPorId(Long.parseLong(id));
        Rol r = rolService.findByNombreRol(rol);
        u.setRol(r);
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);

        usuarioService.actualizarUsuario(u);
        return "redirect:/usuarios/";
    }


    @PostMapping(value = "/eliminar/{id}")
    public String borrarRol(@PathVariable String id) {
        rolService.borrarRolPorId(Long.parseLong(id));
        return "redirect:/usuarios/";
    }

}
