package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.Equipo;
import electronicapractica10.demo.model.Renta;
import electronicapractica10.demo.service.ServiciosCliente;
import electronicapractica10.demo.service.ServiciosEquipo;
import electronicapractica10.demo.service.ServiciosRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class RentaController {
    @Autowired
    private ServiciosRenta serviciosRenta;
    @Autowired
    private ServiciosCliente serviciosCliente;
    @Autowired
    private ServiciosEquipo serviciosEquipo;

    @GetMapping(value = "/")
    public String rentas(Model model)
    {
        List<Equipo> equipos = new ArrayList<>();

        List<Renta> rentas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        equipos = serviciosEquipo.listaEquipos();
        rentas = serviciosRenta.listaRenta();
        clientes = serviciosCliente.getListaClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("equipos", equipos);
        model.addAttribute("rentas",rentas);
        return "rentas";

    }

    @PostMapping(value = "/despacho/")
    public String despacho(@RequestParam("client") String idcliente, @RequestParam("cant[]") List<String> cantidades, @RequestParam("ids[]") List<String> ids, @RequestParam("fechaInicioRenta") String fecha, @RequestParam("fechaFinRenta") String fechapromesa){


        return "redirect:/rentas/";

    }


    @PostMapping(value = "/entrega/{id}")
    public String entrega(@PathVariable("id") String id){

        Renta a = serviciosRenta.getRentaById(Long.parseLong(id));
        a.setEstado("Completado");
        serviciosRenta.actualizarRenta(a);
        return "redirect:/rentas/";
    }



    @GetMapping(value = "/rentado/{id}")
    public String entregado(Model model, @PathVariable("id") String id){
        Renta renta = serviciosRenta.getRentaById(Long.parseLong(id));
        model.addAttribute("renta", renta);
        return "renta";

    }



}
