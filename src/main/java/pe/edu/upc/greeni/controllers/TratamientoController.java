package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.TratamientoDTO;
import pe.edu.upc.greeni.dtos.VencimientoDTO;
import pe.edu.upc.greeni.entities.Tratamiento;
import pe.edu.upc.greeni.servicesInterfaces.ITratamientoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tratamiento")
public class TratamientoController {
    @Autowired
    private ITratamientoService ta;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO') or hasAuthority('PLANTLOVER') ")
    @GetMapping
    public List<TratamientoDTO> listar(){
        return ta.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PostMapping
    public void insertar(@RequestBody TratamientoDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Tratamiento t=m.map(dto,Tratamiento.class);
        ta.insert(t);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @GetMapping({"/{id}"})
    public ResponseEntity<?> listar(@PathVariable("id") Integer id) {
        Tratamiento tra = this.ta.listId(id);
        if (tra == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        } else {
            ModelMapper m = new ModelMapper();
            Tratamiento ta = (Tratamiento) m.map(tra, Tratamiento.class);
            return ResponseEntity.ok(ta);
        }
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tratamiento trat = this.ta.listId(id);
        if (trat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        } else {
            this.ta.delete(id);
            return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
        }
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PutMapping //({"/{id}"})
    public ResponseEntity<String> modificar(@RequestBody TratamientoDTO dto) {
        ModelMapper m = new ModelMapper();
        Tratamiento tra = m.map(dto, Tratamiento.class);

        Tratamiento existente = ta.listId(tra.getIdTratamiento());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tra.getIdTratamiento());
        }
        ta.update(tra);
        return ResponseEntity.ok("Registro con ID " + tra.getIdTratamiento() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscarmax")
    public ResponseEntity<?> buscarDuracionMayor(@RequestParam int max) {
            List<Tratamiento> lista = ta.buscarDuracionMayor(max);

            if (lista.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron tratamientos con duración mayor a " + max);
            }

            List<TratamientoDTO> listaDTO = lista.stream().map(x -> {
                ModelMapper m = new ModelMapper();
                return m.map(x, TratamientoDTO.class);
            }).collect(Collectors.toList());

            return ResponseEntity.ok(listaDTO);
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @GetMapping("/buscarmin")
        public ResponseEntity<?> buscarDuracionMenor(@RequestParam int min) {
            List<Tratamiento> lista = ta.buscarDuracionMenor(min);

            if (lista.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron tratamientos con duración menor a " + min);
            }

            List<TratamientoDTO> listaDTO = lista.stream().map(x -> {
                ModelMapper m = new ModelMapper();
                return m.map(x, TratamientoDTO.class);
            }).collect(Collectors.toList());

            return ResponseEntity.ok(listaDTO);
        }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/vencitrata")
    public ResponseEntity<?> vencimientotrata() {
        List<String[]> fila = ta.venceTratamiento();

        if (fila == null || fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron vencimientos en los próximos 30 días");
        }

        List<VencimientoDTO> listaDTO = new ArrayList<>(fila.size());
        for (String[] s : fila) {
            VencimientoDTO dto = new VencimientoDTO();
            dto.setId_tratamiento(Integer.parseInt(s[0]));
            dto.setNombre(s[1]);
            dto.setFechafin(java.time.LocalDate.parse(s[2]));
            dto.setDias(Integer.parseInt(s[3]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }
    }



