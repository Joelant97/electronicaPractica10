package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Renta;
import electronicapractica10.demo.model.Equipo;
import electronicapractica10.demo.model.EquipoRenta;
import electronicapractica10.demo.model.Factura;
import electronicapractica10.demo.service.RentaServices;
import electronicapractica10.demo.service.EquipoServices;
import electronicapractica10.demo.service.FacturaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class FacturaController {

    @Autowired
    FacturaServices facturaServices;

    @Autowired
    RentaServices rentaServices;

    @Autowired
    EquipoServices equipoServices;

    @RequestMapping("/index/facturas")
    public String index(Model model) {
        model.addAttribute("titulo", "Facturas");
        return "facturas";
    }

    @ResponseBody
    @RequestMapping(value = "/facturas", produces = {"application/json"})
    public List<Factura> facturas() {
        return facturaServices.listaFacturas();
    }

    @RequestMapping(value = "/factura/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> crearFactura(@RequestBody String facturaAlquiler) {

        String[] parte = facturaAlquiler.split(":");

        Renta renta = rentaServices.buscarAlquiler(Integer.parseInt(parte[0]));
        renta.setPendiente(false);

        for (EquipoRenta equipoRenta : renta.getEquipoRenta()) {

            Equipo equipo = equipoRenta.getEquipo();
            equipo.setCantidad(equipo.getCantidad() + renta.getCantidadEquipos());
            equipoServices.crearEquipo(equipo);
        }
        rentaServices.crearAlquiler(renta);

        Factura factura = new Factura();
        factura.setRenta(renta);
        factura.setFecha(Date.valueOf(LocalDate.now()));
        factura.setTotal(Integer.parseInt(parte[1]));

        facturaServices.crearFactura(factura);


        return new ResponseEntity<>(facturaAlquiler, HttpStatus.OK);

    }


}
