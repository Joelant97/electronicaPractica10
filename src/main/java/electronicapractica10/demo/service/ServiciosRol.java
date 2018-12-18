package electronicapractica10.demo.service;


import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.repository.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiciosRol {

    @Autowired
    private RepositorioRol repositorioRol;

    public void crearRol(Rol rol){
        repositorioRol.save(rol);
    }
    public void actualizarRol(Rol rol){
        crearRol(rol);
    }
    public void borrarRolPorId(long id){
        repositorioRol.deleteById(id);
    }
    public void borrarTodosLosRoles(){
        repositorioRol.deleteAll();
    }




    public List<Rol> buscarTodosRoles(){
        return repositorioRol.findAll();
    }


    public Rol findByNombreRol(String rol){
        return repositorioRol.findByNombreRol(rol);
    }


    public Rol buscarPorId(long id){
        return repositorioRol.findById(id).get();
    }

    public boolean rolExiste(Rol rol){
        return findByNombreRol(rol.getRole()) != null;
    }



}



