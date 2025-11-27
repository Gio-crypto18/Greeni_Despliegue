package pe.edu.upc.greeni.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.GUIAFAVORITADTOC;
import pe.edu.upc.greeni.dtos.GUIAFAVORITADTOF;
import pe.edu.upc.greeni.dtos.GuiaDTO;
import pe.edu.upc.greeni.dtos.GuiaFavoritaDTO;
import pe.edu.upc.greeni.entities.Guia;
import pe.edu.upc.greeni.entities.GuiaFavorita;
import pe.edu.upc.greeni.entities.Usuario;
import pe.edu.upc.greeni.servicesInterfaces.IGuiaFavoritaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guiasfavoritas")
public class GuiaFavoritaController {
    @Autowired
    private IGuiaFavoritaService controller;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @GetMapping
    public List<GUIAFAVORITADTOF> listar() {
        return controller.list().stream().map(gf -> {
            GUIAFAVORITADTOF dto = new GUIAFAVORITADTOF();
            dto.setGuiaFavoritaId(gf.getGuiaFavoritaId());
            dto.setNombre(gf.getUsuario().getNombre());
            dto.setTitulo(gf.getGuia().getTituloGuia());
            return dto;
        }).collect(Collectors.toList());
    }


    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PostMapping
    public void insertar(@RequestBody GUIAFAVORITADTOC dto) {
        GuiaFavorita gf = new GuiaFavorita();
        gf.setUsuario(dto.getUsuario());
        gf.setGuia(dto.getGuia());
        controller.insert(gf);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        GuiaFavorita d = controller.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        controller.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuiaFavoritaDTO> listarId(@PathVariable("id") Integer id) {
        GuiaFavorita guia = controller.listId(id);
        if (guia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ModelMapper m = new ModelMapper();
        GuiaFavoritaDTO dto = m.map(guia, GuiaFavoritaDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
