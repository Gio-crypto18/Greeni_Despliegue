package pe.edu.upc.greeni.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.PlantaDTO;
import pe.edu.upc.greeni.dtos.PlantaMaxDTO;
import pe.edu.upc.greeni.dtos.QuantityPlantaDTO;
import pe.edu.upc.greeni.entities.Planta;
import pe.edu.upc.greeni.servicesInterfaces.IPlantaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantas")

public class PlantaController {
    @Autowired
    private IPlantaService ps;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')or hasAuthority('PLANTLOVER') ")
    @GetMapping
    public List<PlantaDTO> listar(){
        return ps.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PlantaDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PostMapping
    public void insertar(@RequestBody PlantaDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Planta d=m.map(dto,Planta.class);
        ps.insert(d);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Planta dev = ps.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PlantaDTO dto = m.map(dev, PlantaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Planta d = ps.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        ps.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@RequestBody PlantaDTO dto) {
        ModelMapper m = new ModelMapper();
        Planta dev = m.map(dto, Planta.class);

        Planta existente = ps.listId(dev.getIdPlanta());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getIdPlanta());
        }
        ps.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getIdPlanta() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("plantareporte")
    public ResponseEntity<?> ObtenerCantidad() {

        List<QuantityPlantaDTO> listaDTO=new ArrayList<>();
        List<String[]> fila =ps.quantitynombrePlanta();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros: ");
        }
        for (String[] s: fila)
        {
            QuantityPlantaDTO dto=new QuantityPlantaDTO();
            dto.setNombrePlanta(s[0]);
            dto.setQuantityPlanta(Integer.parseInt(s[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/max")
    public ResponseEntity<?> ObtenerMax() {

        List<PlantaMaxDTO> listaDTO =new ArrayList<>();
        List<String[]> fila =ps.getPlantasMax();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros: ");
        }
        for (String[] s: fila)
        {
            PlantaMaxDTO dto=new PlantaMaxDTO();
            dto.setNombrePlanta(s[0]);
            dto.setFecha_reg(LocalDate.parse(s[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }

}
