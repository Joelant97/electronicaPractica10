package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.ClienteEquipo;
import electronicapractica10.demo.model.Equipo;
import electronicapractica10.demo.service.ClienteEquipoServiceImpl;
import electronicapractica10.demo.service.ClienteServiceImpl;
import electronicapractica10.demo.service.EquipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/alquileres")
public class AlquilerController {

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;
    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private EquipoServiceImpl equipoService;

    @GetMapping(value = "/")
    public String alquileres(Model model)
    {
        List<Equipo> equipos = new ArrayList<>();
        List<ClienteEquipo> alquileres = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        equipos = equipoService.buscarTodosEquipos();
        alquileres = clienteEquipoService.buscarTodosClientesEquipos();
        clientes = clienteService.buscarTodosClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("equipos", equipos);
        model.addAttribute("alquileres",alquileres);
        return "alquileresview";
    }

    @PostMapping(value = "/despachar/")
    public String despacho(@RequestParam("client") String idcliente,
                           @RequestParam("cant[]") List<String> cantidades,
                           @RequestParam("equipos") List<String> ids,
                           @RequestParam("fechaentrega") String fechapromesa){

        Cliente c = clienteService.buscarPorId(Long.parseLong(idcliente));
        for(int i=0; i< ids.size(); i++) {
            System.out.println(ids.get(i));
            ClienteEquipo a = new ClienteEquipo();
            Equipo e = equipoService.buscarPorId(Long.parseLong(ids.get(i)));
            a.setEstado("Pendiente");
            LocalDate date = LocalDate.now();
            LocalDate date2 = LocalDate.parse(fechapromesa);
            a.setFechaInicioAlquiler(date);
            a.setFechaFinAlquiler(date2);
            a.setEquipo(e);
            a.setCliente(c);
            long numdays = ChronoUnit.DAYS.between(date, date2);
            a.setCosto(1*e.getPrecio()*numdays);
            clienteEquipoService.crearClienteEquipo(a);
        }
        return "redirect:/alquileres/";
    }

    @PostMapping(value = "/entrega/{id}")
    public String entrega(@PathVariable("id") String id){

        ClienteEquipo a = clienteEquipoService.buscarPorId(Long.parseLong(id));
        a.setEstado("Entregado");
        clienteEquipoService.actualizarClienteEquipo(a);
        return "redirect:/alquileres/";
    }

    @GetMapping(value = "/entregado/{id}")
    public String entregado(Model model, @PathVariable("id") String id){
        ClienteEquipo alquiler = clienteEquipoService.buscarPorId(Long.parseLong(id));
        model.addAttribute("alquiler",alquiler);
        return "alquiler";
    }

}
