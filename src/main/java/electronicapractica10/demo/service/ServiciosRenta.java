package electronicapractica10.demo.service;


import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.Renta;
import electronicapractica10.demo.repository.RepositorioRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiciosRenta {

    @Autowired
    RepositorioRenta repositorioRenta;

    @Transactional
    public Renta crearRenta(Renta renta){
        return repositorioRenta.save(renta);
    }

    public List<Renta> listaRenta(){
        return repositorioRenta.findAll();

    }

    //templates List<Renta>listaRentaOrdenado(){
     //   return repositorioRenta.rentasOrdenadas();
    //}

    public Renta getRentaById(long id ){
        return repositorioRenta.findById(id).get();
    }

    public List<Renta> historiaRenta(Cliente cliente){
        return repositorioRenta.findAllByClienteOrderByFechaInicioRenta(cliente);

    }


}
