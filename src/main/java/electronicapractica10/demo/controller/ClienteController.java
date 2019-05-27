package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.Renta;
import electronicapractica10.demo.service.ServiciosCliente;
import electronicapractica10.demo.service.ServiciosRenta;
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

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private static String UPLOADED_FOLDER = "/images";
    @Autowired
    private ServiciosCliente clienteService;
    @Autowired
    private ServiciosRenta rentaService;

    /**
     * Lista todos los clientes
     * @param model
     * @return template clientes
     */
    @RequestMapping(value = "/")
    public String clientes(Model model)
    {
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.getListaClientes();
        model.addAttribute("clientes", clientes);
        return "clientesview";
    }

    @GetMapping(value = "/detail/{id}/")
    public String detalleCliente(@PathVariable @NotNull String id) {
        Cliente cliente = clienteService.getClienteByID(Long.parseLong(id));
        return "clientes";

    }


    @GetMapping(value = "/historial/{id}")
    public String historialCliente(Model model, @PathVariable String id)
    {
        Cliente cliente = clienteService.getClienteByID(Long.parseLong(id));
        if (cliente != null){
            List<Renta> historial = rentaService.historiaRentaCliente(Long.parseLong(id));
            model.addAttribute("cliente", cliente);
            model.addAttribute("historial", historial);
        }

        return "historial";
    }


    @PostMapping(value = "/add/")
    public String crearCliente(@RequestParam("nombre") String nombre,
                               @RequestParam("cedula") String cedula,
                               @RequestParam("telefono") String telefono,
                               @RequestParam("correo") String email,
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

        Cliente cliente = new Cliente(nombre, cedula, fotoBytes, email, telefono);
        clienteService.crearClient(cliente);
        System.out.println(cliente.toString());

        return "redirect:/clientes/";
    }


    @PutMapping("/edit/{id}")
    public String modificarCliente(@PathVariable String id,
                                   @RequestParam("nombre") String nombre,
                                   @RequestParam("cedula") String cedula,
                                   @RequestParam("telefono") String telefono,
                                   @RequestParam("correo") String email,
                                   @RequestParam("foto") MultipartFile foto,
                                   RedirectAttributes redirectAttributes)
    {

        Cliente cliente = clienteService.getClienteByID(Long.parseLong(id));
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setCorreo(email);
        cliente.setTelefono(telefono);

        try {

            byte[] bytes = foto.getBytes();
            cliente.setFoto(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully modified '" + foto.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        clienteService.updateClient(cliente);
        return "redirect:/clientes/";
    }

    @GetMapping(value = "/delete/{id}")
    public String borrarCliente(@PathVariable String id) {
        Cliente cliente = clienteService.getClienteByID(Long.parseLong(id));
        clienteService.eliminarCliente(Long.parseLong(id));
        return "redirect:/clientes/";

    }

}
