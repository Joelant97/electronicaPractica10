package electronicapractica10.demo.controller;
import electronicapractica10.demo.service.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/inicio")
public class HomeController {

    @Autowired
    private ServiciosUsuario serviciosUsuario;

    @RequestMapping(value = "")
    public String index(Model model, Locale locale, HttpServletRequest request, Authentication authentication)
    {
        String currentUserName = "";

            currentUserName = authentication.getName();
        Collection<? extends GrantedAuthority> auths = authentication.getAuthorities();
        Set<String> roles = authentication.getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toSet());

            model.addAttribute("username", currentUserName);
            model.addAttribute("roles", roles);


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
