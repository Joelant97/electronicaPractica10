package electronicapractica10.demo.service;

import electronicapractica10.demo.model.Equipo;
import electronicapractica10.demo.model.EquipoRenta;
import electronicapractica10.demo.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EquipoServices {

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    EquipoRentaServices equipoRentaServices;

    @Transactional
    public void crearEquipo(Equipo equipo) {

        equipoRepository.save(equipo);

    }

    @Transactional
    public void eliminarEquipo(Equipo equipo) {

        equipo.setActivo(false);
        equipoRepository.save(equipo);

    }

    public Equipo buscarEquipo(long id) {

        return equipoRepository.findById(id);
    }

    public List<Equipo> buscarEquipos() {

        return equipoRepository.findAll();
    }

    public List<Equipo> buscarEquiposDisponibles() {

        return equipoRepository.findAllByActivoAndCantidadGreaterThan(true, 0);
    }

    public Set<EquipoRenta> buscarEquiposAlquiler(List<String> equipos) {


        Set<EquipoRenta> equipoRentaSet = new HashSet<>();
        for (String s : equipos) {

            EquipoRenta equipoRenta = new EquipoRenta();
            String[] parte = s.split(":");

            Equipo equipo = buscarEquipo(Integer.parseInt(parte[0]));
            equipo.setCantidad(equipo.getCantidad() - Integer.parseInt(parte[1]));
            crearEquipo(equipo);

            equipoRenta.setEquipo(equipo);
            equipoRenta.setCantidad(Integer.parseInt(parte[1]));
            equipoRenta.setDevuelto(false);

            equipoRentaSet.add(equipoRenta);

            equipoRentaServices.crearEquipoAlquiler(equipoRenta);

        }



        return equipoRentaSet;
    }

}
