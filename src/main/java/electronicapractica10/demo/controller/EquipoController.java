package electronicapractica10.demo.controller;


import electronicapractica10.demo.service.ServiciosCategoria;
import electronicapractica10.demo.service.ServiciosCliente;
import electronicapractica10.demo.service.ServiciosEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    private static String UPLOADED_FOLDER = "\\resources\\static\\fotos";





    @Autowired
    private ServiciosCliente serviciosCliente;

    @Autowired
    private ServiciosEquipo serviciosEquipo;
    @Autowired
    private ServiciosCategoria serviciosCategoria;



}
