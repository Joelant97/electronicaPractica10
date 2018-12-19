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

    public List<Categoria> listaCategoria(){
        return repositorioCategoria.findAll();
    }

    public Categoria buscarById(long id){
        return repositorioCategoria.findById(id).get();
    }

    public void eliminarCategoria(long id){
        repositorioCategoria.deleteById(id);
    }


}