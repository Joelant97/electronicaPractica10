package electronicapractica10.demo.service;

import java.util.List;

import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClienteServices
 */
@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public void crearCliente(Cliente cliente) {

        clienteRepository.save(cliente);
        
    }

    @Transactional
    public void eliminarCliente(Cliente cliente){

        cliente.setActivo(false);
        clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(long id){

        return clienteRepository.findById(id);
    }

    public List<Cliente> listaClientes() {
        
        return clienteRepository.findAllByActivo(true);
    }

    
}