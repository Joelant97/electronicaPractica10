package electronicapractica10.demo.service;


import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.model.Usuario;
import electronicapractica10.demo.repository.RepositorioRol;
import electronicapractica10.demo.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ServiciosUsuario {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioRol repositorioRol;




    @Transactional
    public List<Usuario> findAllUsuario(){

        return repositorioUsuario.findAll();
    }

    @Transactional
    public Usuario buscarById(Long id){
        return repositorioUsuario.findById(id).get();
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));

        //usuario.setRoles(new HashSet<>(repositorioRol.findAll()));

        repositorioUsuario.save(usuario);
        return usuario;
    }

    //Metodo Actualiza el Usuario:
    @Transactional
    public void actualizarUsuario(Usuario usuario){
        crearUsuario(usuario);
    }


    @Autowired
    private UserDetailsService userDetailsService;

    @Transactional
    public Usuario buscarPorNombre(String username) {
        return repositorioUsuario.findByUsername(username);
    }


    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            System.out.println("--> El Login funciona para el usuario: " + username);
        }
    }

    public long getIDCount() {

        return repositorioUsuario.count() + 1;

    }


    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Usuario user = repositorioUsuario.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Rol role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }


}



