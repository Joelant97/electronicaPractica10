package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.model.Usuario;
import electronicapractica10.demo.service.ServiciosRol;
import electronicapractica10.demo.service.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UsuarioController {

    @Autowired
    private ServiciosUsuario serviciosUsuario;

    @Autowired
    private ServiciosRol serviciosRol;

    @GetMapping(value="/usuarios")
    public String usuarios(Model model)
    {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = serviciosUsuario.findAllUsuario();
        List<Rol> roles = serviciosRol.buscarTodosRoles();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles", roles);

        return "usuarios";
    }


    @PostMapping("/")
    public String crearUsuario(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("telefono") String telefono, @RequestParam("rol") String rol){
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setActivo(true);
        Rol r = serviciosRol.findByRole(rol);
        u.setTelefono(telefono);
        Set<Rol> roles = new HashSet<>();
        roles.add(r);
        u.setRoles(roles);
        serviciosUsuario.crearUsuario(u);
        return "redirect:/usuarios/";
    }

    @PostMapping("/modificar/")
    public String modificarUsuario(@RequestParam("username2") String username, @RequestParam("id2") String id,@RequestParam("password2") String password, @RequestParam("telefono2") String telefono, @RequestParam("rol2") String rol){
        Usuario u = serviciosUsuario.buscarById(Long.parseLong(id));
        Rol r = serviciosRol.findByRole(rol);
        Set<Rol> roles = new HashSet<>();
        roles.add(r);
        u.setRoles(roles);

        u.setUsername(username);
        u.setPassword(password);
        u.setTelefono(telefono);

        serviciosUsuario.actualizarUsuario(u);
        return "redirect:/usuarios/";
    }


    @PostMapping(value = "/eliminar/{id}")
    public String borrarRol(@PathVariable String id) {
        serviciosRol.borrarRolPorId(Long.parseLong(id));
        return "redirect:/usuarios/";
    }

}
