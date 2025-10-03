package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.EspecieDTO;
import pe.edu.upc.greeni.dtos.QuantityEspecieDTO;
import pe.edu.upc.greeni.entities.Especie;
import pe.edu.upc.greeni.servicesInterfaces.IEspecieService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especies")
public class EspecieController {
    @Autowired
    private IEspecieService es;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLANTLOVER') or hasAuthority('CIENTIFICO')")
    @GetMapping
    public List<EspecieDTO> listar(){
        return es.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,EspecieDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PostMapping
    public void insertar(@RequestBody EspecieDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Especie r =m.map(dto, Especie.class);
        es.insert(r);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Especie dev = es.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EspecieDTO dto = m.map(dev, EspecieDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEspecie(@PathVariable("id") Integer id) {
        Especie d = es.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        es.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificarEspecie(@RequestBody EspecieDTO dto) {
        ModelMapper m = new ModelMapper();
        Especie dev = m.map(dto, Especie.class);

        Especie existente = es.listId(dev.getIdEspecie());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getIdEspecie());
        }
        es.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getIdEspecie() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CIENTIFICO')")
    @GetMapping("/cantidadespecie")
    public ResponseEntity<?> ObtenerCantidad() {

        List<QuantityEspecieDTO> listaDTO=new ArrayList<>();
        List<String[]> fila =es.quantityEspecie();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros: ");
        }
        for (String[] s: fila)
        {
            QuantityEspecieDTO dto=new QuantityEspecieDTO();
            dto.setIdEspecie(Integer.parseInt(s[0]));
            dto.setQuantityEspecie(Integer.parseInt(s[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }
}
