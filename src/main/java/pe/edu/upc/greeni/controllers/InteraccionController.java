package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.*;
import pe.edu.upc.greeni.entities.Interaccion;
import pe.edu.upc.greeni.entities.Planta;
import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.entities.Usuario;
import pe.edu.upc.greeni.servicesInterfaces.IInteraccionService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/interaccion")
public class InteraccionController {
    @Autowired
    private IInteraccionService service;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping
    public List<InteraccionDTOFULL> listar(){
        return service.listar().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, InteraccionDTOFULL.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PostMapping
    public void insertar(@RequestBody InteraccionDTOFULL idto) {
        ModelMapper m = new ModelMapper();
        Interaccion co = m.map(idto, Interaccion.class);
        service.insert(co);
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Interaccion inte = service.listId(id);
        if (inte == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        InteraccionDTOList dto = m.map(inte, InteraccionDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarInteraccion(@PathVariable("id") Integer id) {
        Interaccion i = service.listId(id);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/resumen")
    public ResponseEntity<?> resumenInteraccion() {
        List<ResumenInteraccionDTO> listaDTO = new ArrayList<>();
        List<String[]> filas = service.ResumenInteracciones();

        for (String[] s : filas) {
            ResumenInteraccionDTO dto = new ResumenInteraccionDTO();
            dto.setUsuario(s[0]);
            dto.setTipoInteraccion(s[1]);
            dto.setTotalInteracciones(Long.parseLong(s[2]));
            dto.setPrimeraInteraccion(LocalDate.parse(s[3]));
            dto.setUltimaInteraccion(LocalDate.parse(s[4]));
            listaDTO.add(dto);
        }
        if (listaDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/top")
    public ResponseEntity<?> topInteraccion() {
        List<String[]> filas = service.TopTiposInteraccion();
        List<TopInteraccionDTO> listaDTO = new ArrayList<>();

        for (String[] s : filas) {
            TopInteraccionDTO dto = new TopInteraccionDTO();
            dto.setTipoInteraccion(s[0]);
            dto.setTotalInteracciones(Integer.parseInt(s[1]));
            dto.setPorcentajeTotal(Double.parseDouble(s[2]));

            listaDTO.add(dto);
        }

        if (listaDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        return ResponseEntity.ok(listaDTO);
    }



}
