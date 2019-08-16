package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.*;
import electronicapractica10.demo.service.ClienteEquipoServiceImpl;
import electronicapractica10.demo.service.ClienteServiceImpl;
import electronicapractica10.demo.service.EquipoServiceImpl;
import electronicapractica10.demo.service.FacturaServiceImpl;
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
    @Autowired
    private FacturaServiceImpl facturaService;

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
        model.addAttribute("alquileres", alquileres);
        return "alquileresview";
    }

    @PostMapping(value = "/despachar/")
    public String despacho(@RequestParam("client") String idcliente,
                           @RequestParam("cant[]") List<String> cantidades,
                           @RequestParam("ids[]") String ids,
                           @RequestParam("fechaentrega") String fechapromesa){

        Cliente c = clienteService.buscarPorId(Long.parseLong(idcliente));
        String [] equipos_ids =  ids.split(",");
        float precioTotal = 0;
        Factura factura = new Factura();
        factura.setFechaFacturacion(LocalDate.now());
        factura.setCliente(c);

       for(int i=0; i <equipos_ids.length; i++) {
            ClienteEquipo a = new ClienteEquipo();
            Equipo e = equipoService.buscarPorId(Long.parseLong(equipos_ids[i]));
            LocalDate date = LocalDate.now();
            LocalDate date2 = LocalDate.parse(fechapromesa);
            long numdays = ChronoUnit.DAYS.between(date, date2);

            a.setEstado("Pendiente");
            a.setFechaInicioAlquiler(date);
            a.setFechaFinAlquiler(date2);
            a.setEquipo(e);
            a.setCliente(c);
            a.setCosto(1*e.getPrecio()*numdays);
            clienteEquipoService.crearClienteEquipo(a);

            factura.getAlquileres().add(a);
            precioTotal += a.getCosto();
        }
        factura.setMontoTotal(precioTotal);

        Factura nuevafactura = facturaService.crearFactura(factura);
        return String.format("redirect:/alquileres/factura/%d", nuevafactura.getId());
    }

    @GetMapping(value = "/entrega/{id}")
    public String entrega(@PathVariable("id") String id){

        ClienteEquipo a = clienteEquipoService.buscarPorId(Long.parseLong(id));
        a.setEstado("Entregado");
        clienteEquipoService.actualizarClienteEquipo(a);
        return "redirect:/alquileres/";
    }

    @GetMapping(value = "/factura/{id}")
    public String entregado(Model model, @PathVariable("id") String id){
        Factura factura = facturaService.buscarPorId(Long.parseLong(id));
        model.addAttribute("factura", factura);
        return "invoice";
    }

}
