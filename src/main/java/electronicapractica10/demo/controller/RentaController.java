package electronicapractica10.demo.controller;

public class RentaController {
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
        return "alquileres";

    }

    @PostMapping(value = "/despacho/")
    public String despacho(@RequestParam("client") String idcliente, @RequestParam("cant[]") List<String> cantidades, @RequestParam("ids[]") List<String> ids, @RequestParam("fecha") String fecha, @RequestParam("fechaentrega") String fechapromesa){

        }



        return "redirect:/alquileres/";
    }


    @PostMapping(value = "/entrega/{id}")
    public String entrega(@PathVariable("id") String id){

        ClienteEquipo a = clienteEquipoService.buscarPorId(Long.parseLong(id));
        a.setEstado("Completado");
        clienteEquipoService.actualizarClienteEquipo(a);
        return "redirect:/alquileres/";
    }

    @GetMapping(value = "/rentado/{id}")
    public String entregado(Model model, @PathVariable("id") String id){

    }
}
