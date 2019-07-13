package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.Renta;
import electronicapractica10.demo.service.ClienteServices;
import electronicapractica10.demo.service.RentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ClienteController {

    private static String UPLOADED_FOLDER = "/images";

    @Autowired
    private ClienteServices clienteServices;

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/clientes")
    public String clientes(Model model, Locale locale) {
    // List all clients
        List<Cliente> clientes = clienteServices.listaClientes();
        model.addAttribute("clientes", clientes);

        return "clientesview";
    }

    @PostMapping(value = "/clientes/add/")
    public String crearCliente(@RequestParam("nombre") String nombre,
                               @RequestParam("cedula") String cedula,
                               @RequestParam("telefono") String telefono,
                               @RequestParam("email") String email,
                               @RequestParam("foto") MultipartFile foto,
                               RedirectAttributes redirectAttributes) {

        byte[] fotoBytes = new byte[0];
        try {
            fotoBytes = foto.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, fotoBytes);

            redirectAttributes.addFlashAttribute("message",
                    foto.getOriginalFilename() + "cargada exitosamente");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Cliente cliente = new Cliente(nombre, cedula, telefono, email, fotoBytes, true);
        clienteServices.crearCliente(cliente);
        System.out.println(cliente.toString());

        return "redirect:/clientes/";
    }

}