package electronicapractica10.demo.controller;

import electronicapractica10.demo.model.Categoria;
import electronicapractica10.demo.service.ServiciosCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    /*@Autowired
    private ServiciosCategoria categoriaService;

    @RequestMapping(value = "/")
    templates String categorias(Model model)
    {
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList = categoriaService. ();
        model.addAttribute("categorias",categoriaList);
        return "categoria";
    }

    @PostMapping(value = "/")
    templates String crearCategoria(@RequestParam("nombre") String nombre,
                                 RedirectAttributes redirectAttributes) {

        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombre);
        categoriaService.crearCategoria(categoria);

        return "redirect:/categorias/";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    templates String borrarCategoria(@PathVariable String id) {
        Categoria categoria = categoriaService.buscarPorId(Long.parseLong(id));
        categoriaService.;
        return "redirect:/categorias/";

    }*/

}