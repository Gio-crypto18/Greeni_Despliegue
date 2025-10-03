package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.GuiaDTO;
import pe.edu.upc.greeni.dtos.GuiaDTOList;
import pe.edu.upc.greeni.dtos.TipoGuiaDTO;
import pe.edu.upc.greeni.dtos.TituloGuiaDTO;
import pe.edu.upc.greeni.entities.Guia;
import pe.edu.upc.greeni.servicesInterfaces.IGuiaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guia")
public class GuiaController {
    @Autowired
    private IGuiaService guiaService;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PostMapping
    public void insertar(@RequestBody GuiaDTO sdto)
    {
        ModelMapper m = new ModelMapper();
        Guia s=m.map(sdto,Guia.class);
        guiaService.insert(s);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping
    public List<GuiaDTOList> listar(){
        return guiaService.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, GuiaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Guia d = guiaService.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        guiaService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@RequestBody GuiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Guia guia = m.map(dto, Guia.class);

        Guia existente = guiaService.listId(guia.getGuiaId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + guia.getGuiaId());
        }
        guiaService.update(guia);
        return ResponseEntity.ok("Registro con ID " + guia.getGuiaId() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/filtro-tipo")
    public ResponseEntity<?> filtrarPorTipo(@RequestParam String tipo) {
        List<Guia> lista = guiaService.buscarPorTipo(tipo);

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron guías del tipo: " + tipo);
        }

        List<TituloGuiaDTO> listaDTO = lista.stream().map(g -> {
            ModelMapper m = new ModelMapper();
            return m.map(g, TituloGuiaDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/filtro-titulo")
    public ResponseEntity<?> filtrarPorTitulo(@RequestParam String titulo) {
        List<Guia> lista = guiaService.buscarPorTitulo(titulo);

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron guías del tipo: " + titulo);
        }

        List<TipoGuiaDTO> listaDTO = lista.stream().map(g -> {
            ModelMapper m = new ModelMapper();
            return m.map(g, TipoGuiaDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}
