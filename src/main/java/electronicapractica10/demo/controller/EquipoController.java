package electronicapractica10.demo.controller;


import electronicapractica10.demo.model.Categoria;
import electronicapractica10.demo.model.Equipo;
import electronicapractica10.demo.service.ServiciosCategoria;
import electronicapractica10.demo.service.ServiciosCliente;
import electronicapractica10.demo.service.ServiciosEquipo;
import electronicapractica10.demo.service.ServiciosRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    private static String UPLOADED_FOLDER = "/images";


    @Autowired
    private ServiciosRenta serviciosRenta;

    @Autowired
    private ServiciosEquipo serviciosEquipo;
    @Autowired
    private ServiciosCategoria serviciosCategoria;


    @GetMapping("/")
    public String equipos(Model model)
    {
        List<Equipo> equipos = new ArrayList<>();
        equipos = serviciosEquipo.listaEquipos();
        List<Categoria> categories = serviciosCategoria.listaCategoria();
        //subFamilias:
        List<Categoria> subCategorias = serviciosCategoria.findAllSubFamilias();
        model.addAttribute("subfamilias", subCategorias);

        model.addAttribute("categorias", categories);
        model.addAttribute("equipos", equipos);
        return "equiposView";
    }

    @PostMapping("/add/")
    public String crearEquipo(@RequestParam("foto") MultipartFile foto, @RequestParam("nombre") String nombre, @RequestParam("precio") String precio, @RequestParam("existencia") String existencia,
                              @RequestParam("categoria") String categoria, @RequestParam("subfamilia") String subfamilia,
                              RedirectAttributes redirectAttributes) {

        Equipo equipo = new Equipo();
        try {

            byte[] bytes = foto.getBytes();
            equipo.setFoto(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + foto.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        equipo.setNombre(nombre);
        equipo.setCostoPorDia(Long.parseLong(precio));
        equipo.setExistencia(Integer.parseInt(existencia));
        Categoria Categoria = serviciosCategoria.buscarByNombre(categoria);
        System.out.println(Categoria.getNombre());
        equipo.setCategoria(Categoria);
        equipo.setSubCategoria(serviciosCategoria.buscarByNombreSubFamilia(subfamilia));
        serviciosEquipo.crearEquipo(equipo);
        return "redirect:/equipos/";

    }

    @RequestMapping(value = "/detail/{id}/", method = RequestMethod.GET)
    public String ver(Model model, @PathVariable String id)
    {
        Equipo equipo = serviciosEquipo.getEquipoById(Long.parseLong(id));

        model.addAttribute("equipo", equipo);
        return "verequipo";

    }

    @PostMapping("/edit/{id}")
    public String modificarEquipo(@RequestParam("nombre2") String nombre, @RequestParam("id2") String id,@RequestParam("precio2") String precio,
                                  @RequestParam("existencia2") String existencia, @RequestParam("categoria2") String categoria,
                                  @RequestParam("foto2") MultipartFile foto,  RedirectAttributes redirectAttributes){

        Equipo equipo = serviciosEquipo.getEquipoById(Long.parseLong(id));
        equipo.setNombre(nombre);
        equipo.setCostoPorDia(Long.parseLong(precio));
        equipo.setExistencia(Integer.parseInt(existencia));
        equipo.setCategoria(serviciosCategoria.buscarByNombre(categoria));
        try {

            byte[] bytes = foto.getBytes();
            equipo.setFoto(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Su carga fue Satisfactoria'" + foto.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        serviciosEquipo.actualizarEquipo(equipo);
        return "redirect:/equipos/";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String borrarEquipo(@PathVariable String id) {
        Equipo equipo = serviciosEquipo.getEquipoById(Long.parseLong(id));
        serviciosEquipo.eliminarEquipo(equipo.getId());
        return "redirect:/equipos/";

    }


    @RequestMapping(value = "/delivered/", method = RequestMethod.GET)
    public String listadonodevueltos(Model model) {

        List<Object[]> nodevueltos = serviciosRenta.equiposRentaNoDevueltos();
        model.addAttribute("objetos",nodevueltos);
        return "nodevueltos";

    }


}
