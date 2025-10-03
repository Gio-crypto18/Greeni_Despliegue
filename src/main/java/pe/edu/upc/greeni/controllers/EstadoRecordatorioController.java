package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.CantidadRecordatorioPorEstadoDTO;
import pe.edu.upc.greeni.dtos.EstadoRecordatorioDTOInsert;
import pe.edu.upc.greeni.dtos.EstadoRecordatorioDTOList;
import pe.edu.upc.greeni.entities.EstadoRecordatorio;
import pe.edu.upc.greeni.servicesInterfaces.IEstadoRecordatorioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estado_recordatorio")
public class EstadoRecordatorioController {
    @Autowired
    private IEstadoRecordatorioService estadoRecordatorioService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PostMapping
    public void insertar(@RequestBody EstadoRecordatorioDTOInsert sdto) {
        ModelMapper m = new ModelMapper();
        EstadoRecordatorio s = m.map(sdto, EstadoRecordatorio.class);
        estadoRecordatorioService.insert(s);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping
    public List<EstadoRecordatorioDTOList> listar() {
        return estadoRecordatorioService.listid().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, EstadoRecordatorioDTOList.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        EstadoRecordatorio dev = estadoRecordatorioService.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EstadoRecordatorioDTOList dto = m.map(dev, EstadoRecordatorioDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        EstadoRecordatorio d = estadoRecordatorioService.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        estadoRecordatorioService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@RequestBody EstadoRecordatorioDTOList dto) {
        ModelMapper m = new ModelMapper();
        EstadoRecordatorio dev = m.map(dto, EstadoRecordatorio.class);

        EstadoRecordatorio existente = estadoRecordatorioService.listId(dev.getIdEstadoRecordatorio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getIdEstadoRecordatorio());
        }
        estadoRecordatorioService.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getIdEstadoRecordatorio() + " modificado correctamente.");
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam String t) {
        List<EstadoRecordatorio> devices = estadoRecordatorioService.buscarServiceER(t);

        if (devices.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron dispositivos del tipo: " + t);
        }

        List<EstadoRecordatorioDTOList> listaDTO = devices.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EstadoRecordatorioDTOList.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping("/cantidadporestado")
    public ResponseEntity<?> cantidadporestado() {
        List<Object[]> fila = estadoRecordatorioService.cantidadRecordatoriosPorEstado();

        if (fila == null || fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron vencimientos en los próximos 7 días");
        }

        List<CantidadRecordatorioPorEstadoDTO> listaDTO = new ArrayList<>(fila.size());
        for (Object[] s : fila) {
            CantidadRecordatorioPorEstadoDTO dto = new CantidadRecordatorioPorEstadoDTO();
            dto.setEstado((String) s[0]); // primera columna: nombre del estado
            dto.setCantidad(((Number) s[1]).longValue()); // segunda columna: cantidad
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }
}
