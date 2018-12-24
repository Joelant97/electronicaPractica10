package electronicapractica10.demo.service;


import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ServiciosCliente  {



    @Autowired
    private RepositorioCliente repositorioCliente;

    @Transactional
    public Cliente crearClient(Cliente cliente){
        repositorioCliente.save(cliente);

        return cliente;
    }

    @Transactional
    public Cliente updateClient(Cliente cliente){
        repositorioCliente.save(cliente);

        return cliente;
    }

    public void eliminarCliente(long id){
        repositorioCliente.deleteById(id);
    }

    public List<Cliente> getListaClientes(){
        return repositorioCliente.findAll();
    }

    public  Cliente getClienteByID(long id){
        return repositorioCliente.findById(id).get();
    }


}

