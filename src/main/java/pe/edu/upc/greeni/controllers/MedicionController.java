package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.MedicionDTOInsert;
import pe.edu.upc.greeni.dtos.MedicionDTOList;
import pe.edu.upc.greeni.dtos.MedicionReporteListDTO;
import pe.edu.upc.greeni.entities.Medicion;
import pe.edu.upc.greeni.servicesInterfaces.IMedicionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicion")
public class MedicionController {
    @Autowired
    private IMedicionService service;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PostMapping
    public void insertar(@RequestBody MedicionDTOInsert sdto)
    {
        ModelMapper m = new ModelMapper();
        Medicion s = m.map(sdto, Medicion.class);
        service.insert(s);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')or hasAuthority('PLANTLOVER') ")
    @GetMapping
    public List<MedicionDTOList> listar(){
        return service.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, MedicionDTOList.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Medicion d = service.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@RequestBody MedicionDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Medicion dev = m.map(dto, Medicion.class);

        Medicion existente =  service.listId(dev.getIdMedicion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getIdMedicion());
        }
        service.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getIdMedicion() + " modificado correctamente.");
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorTemperatura(@RequestParam String temp) {
        List<Medicion> lista = service.buscarPorTemperatura(temp);

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron mediciones con temperatura: " + temp);
        }

        List<MedicionReporteListDTO> listaDTO = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MedicionReporteListDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }



}
