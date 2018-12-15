package electronicapractica10.demo.service;


import electronicapractica10.demo.model.Equipo;
import electronicapractica10.demo.repository.RepositorioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiciosEquipo {

    @Autowired
    RepositorioEquipo repositorioEquipo;

    @Transactional
    public Equipo crearEquipo(Equipo equipo){
        return repositorioEquipo.save(equipo);

    }

    public List<Equipo> listaEquipos(){
        return repositorioEquipo.findAll();
    }

    public Equipo getEquipoById(long id){
        return repositorioEquipo.findById(id).get();

    }

    public void eliminarEquipo(long id){
        repositorioEquipo.deleteById(id);
    }


}
