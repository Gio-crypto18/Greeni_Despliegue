package pe.edu.upc.greeni.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greeni.dtos.*;
import pe.edu.upc.greeni.entities.Recordatorio;
import pe.edu.upc.greeni.entities.Usuario;
import pe.edu.upc.greeni.servicesInterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")//noombre en español
public class UsuarioController {
    @Autowired
    private IUsuarioService us;
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('PLANTLOVER')or hasAuthority('CIENTIFICO') ")
    @GetMapping("/info")
    public List<UsuarioDTOList> listar(){
        return us.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTOList.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('PLANTLOVER')or hasAuthority('CIENTIFICO') ")
    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        us.insert(u);
    }

    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('PLANTLOVER')or hasAuthority('CIENTIFICO') ")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario usu = us.listId(id);
        if (usu == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(usu, UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('PLANTLOVER')or hasAuthority('CIENTIFICO') ")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario u = us.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        us.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('PLANTLOVER')or hasAuthority('CIENTIFICO') ")
    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usu = m.map(dto, Usuario.class);

        Usuario existente = us.listId(usu.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + usu.getId());
        }

        us.update(usu);
        return ResponseEntity.ok("Registro con ID " + usu.getId() + " modificado correctamente.");
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestParam String filtro) {
        List<Usuario> usuarios = us.buscarPorNombreService(filtro);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con el nombre: " + filtro);
        }

        List<UsuarioDTO> listaDTO = usuarios.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reporte-rol")
    public ResponseEntity<?> obtenerCantidadUsuariosPorRol() {
        List<UsuariosCantidadUsuariosDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = us.CantidadUsuariosPorRol();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros de usuarios por rol");
        }

        for (String[] s : fila) {
            UsuariosCantidadUsuariosDTO dto = new UsuariosCantidadUsuariosDTO();
            dto.setRol(s[0]);
            dto.setCantidadUsuarios(Integer.parseInt(s[1]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reporte-activo")
    public ResponseEntity<?> obtenerUsuariosActivosPorMes() {
        List<UsuariosActivosMesDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = us.UsuariosActivoporMes();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros de usuarios activos por mes");
        }

        for (String[] s : fila) {
            UsuariosActivosMesDTO dto = new UsuariosActivosMesDTO();
            dto.setMes(Integer.parseInt(s[0]));
            dto.setCantidadUsuarios(Integer.parseInt(s[1]));
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }



}
