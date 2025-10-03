package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.QuantityRecordatorioDTO;
import pe.edu.upc.greeni.dtos.RecordatorioDTO;
import pe.edu.upc.greeni.dtos.RecordatorioFiltroDTO;
import pe.edu.upc.greeni.entities.Recordatorio;
import pe.edu.upc.greeni.servicesInterfaces.IRecordatorioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recordatorio")
public class RecordatorioController {
    @Autowired
    private IRecordatorioService rR;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping
    public List<RecordatorioDTO> listar() {
        return rR.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RecordatorioDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PostMapping
    public void insertar(@RequestBody RecordatorioDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Recordatorio d = m.map(dto, Recordatorio.class);
        rR.insert(d);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Recordatorio dev = rR.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecordatorioDTO dto = m.map(dev, RecordatorioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recordatorio d = rR.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rR.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar( @RequestBody RecordatorioDTO dto) {
        ModelMapper m = new ModelMapper();
        Recordatorio dev = m.map(dto, Recordatorio.class);

        Recordatorio existente = rR.listId(dev.getIdRecordatorio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getIdRecordatorio());
        }

        rR.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getIdRecordatorio() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestParam String filtro) {
        List<Recordatorio> devices = rR.buscarService(filtro);

        if (devices.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros del tipo: " + filtro);
        }

        List<RecordatorioDTO> listaDTO = devices.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecordatorioDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/cantidadtipo")
    public ResponseEntity<?> cantidadTipoRecordatorio() {
        List<QuantityRecordatorioDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = rR.quantityTipoRecordatorio();

        if (fila == null || fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron diagnósticos");
        }
        for (String[] s : fila) {
            QuantityRecordatorioDTO dto = new QuantityRecordatorioDTO();
            dto.setTipo(s[0]);
            dto.setQuantity(Integer.parseInt(s[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/filtropor-usuario")
    public ResponseEntity<?> filtrarRecordatoriosPorUsuario(@RequestParam int idUsuario) {
        List<Recordatorio> recordatorios = rR.filtrarRecordatoriosPorUsuarioService(idUsuario);

        if (recordatorios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron recordatorios para el usuario con ID: " + idUsuario);
        }

        List<RecordatorioFiltroDTO> listaDTO = recordatorios.stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RecordatorioFiltroDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

}