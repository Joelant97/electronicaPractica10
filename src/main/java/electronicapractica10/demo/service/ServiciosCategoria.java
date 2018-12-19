package electronicapractica10.demo.service;

import electronicapractica10.demo.model.Categoria;
import electronicapractica10.demo.repository.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiciosCategoria {

    @Autowired
    RepositorioCategoria repositorioCategoria;

    @Transactional
    public Categoria crearCategoria(Categoria categoria){
        return repositorioCategoria.save(categoria);

    }

    @Transactional
    public List<Categoria> findAllSubFamilias(){
        return repositorioCategoria.findAll();
    }

    public List<Categoria> listaCategoria(){
        return repositorioCategoria.findAll();
    }

    public Categoria buscarById(long id){
        return repositorioCategoria.findById(id).get();
    }

    public Categoria buscarByNombre(String nombre){
        return repositorioCategoria.findByNombre(nombre);
    }

    public void eliminarCategoria(long id){
        repositorioCategoria.deleteById(id);
    }



    public Categoria buscarByNombreSubFamilia(String nombre){
        return repositorioCategoria.findByNombre(nombre);
    }
    public boolean subFamiliaExiste(Categoria subFamilia){
        return buscarByNombreSubFamilia(subFamilia.getNombre()) != null;
    }


}