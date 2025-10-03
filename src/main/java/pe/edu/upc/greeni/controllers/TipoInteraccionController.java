package pe.edu.upc.greeni.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.RecordatorioDTO;
import pe.edu.upc.greeni.dtos.TipoInteraccionDTO;
import pe.edu.upc.greeni.entities.Recordatorio;
import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.servicesInterfaces.ITipoInteraccionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipointeraccion")
public class TipoInteraccionController {
    @Autowired
    private ITipoInteraccionService service;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping
    public List<TipoInteraccionDTO> listar(){
        return service.listar().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, TipoInteraccionDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PostMapping
    public void insertar(@RequestBody TipoInteraccionDTO tdto) {
        ModelMapper mapper = new ModelMapper();
        Tipo_Interaccion t = mapper.map(tdto, Tipo_Interaccion.class);
        service.insert(t);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Tipo_Interaccion tipo = service.listId(id);
        if (tipo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Tipo_Interaccion dto = m.map(tipo, Tipo_Interaccion.class);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tipo_Interaccion d = service.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar( @RequestBody TipoInteraccionDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_Interaccion dev = m.map(dto, Tipo_Interaccion.class);

        Tipo_Interaccion existente = service.listId(dev.getTipoInteraccion_Id());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getTipoInteraccion_Id());
        }

        service.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getTipoInteraccion_Id() + " modificado correctamente.");
    }
}
