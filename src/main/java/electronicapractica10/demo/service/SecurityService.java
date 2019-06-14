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
