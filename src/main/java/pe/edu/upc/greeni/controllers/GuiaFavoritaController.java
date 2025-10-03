package pe.edu.upc.greeni.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
    public List<GuiaFavoritaDTO> listar() {
        return controller.list().stream().map(gf -> {
            GuiaFavoritaDTO dto = new GuiaFavoritaDTO();
            dto.setGuiaFavoritaId(gf.getGuiaFavoritaId());
            dto.setGuiaId(gf.getGuia().getGuiaId());
            dto.setId(gf.getUsuario().getId());
            return dto;
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER')")
    @PostMapping
    public void insertar(@RequestBody GuiaFavoritaDTO sdto) {
        GuiaFavorita gf = new GuiaFavorita();
        Usuario u = new Usuario();
        u.setId(sdto.getId());
        gf.setUsuario(u);
        Guia g = new Guia();
        g.setGuiaId(sdto.getGuiaId());
        gf.setGuia(g);
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

}
