package electronicapractica10.demo.service;


import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.model.Usuario;
import electronicapractica10.demo.repository.RolRepository;
import electronicapractica10.demo.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RolRepository repositorioRol;

    //Para Encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    /**
     * Creando el usuario por defecto y su rol.
     */


    public void crearUsuarioAdmin(){
        System.out.println("Creación del usuario y rol en la base de datos");

//        Rol rolAdmin = new Rol("ADMIN");
//        repositorioRol.save(rolAdmin);
//        Usuario admin = new Usuario();
//        admin.setUsuario("admin");
//        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
//        admin.setActivo(true);
//        admin.set(true);
//        admin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));
//        repositorioUsuario.save(admin);



        Rol rol = new Rol("ROLE_ADMIN");
        repositorioRol.save(rol);


        Usuario admin = new Usuario();
        admin.setNombre("admin");
        admin.setUsuario("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setActivo(true);
        admin.setRolSet(new HashSet<>(Arrays.asList(rol)));

        repositorioUsuario.save(admin);

    }

    /**
     * Funcion para revisar si el admin existe.
     */
//    private boolean buscarAdmin(){
//
//        Rol rol = repositorioRol.findByNombre("ROLE_ADMIN");
//        if (rol == null){
//
//            return false;
//        }
//
//        return true;
//    }




}
