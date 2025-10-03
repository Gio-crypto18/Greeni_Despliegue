package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Usuario;
import pe.edu.upc.greeni.repositories.IUsuarioRepository;
import pe.edu.upc.greeni.servicesInterfaces.IUsuarioService;

import java.util.List;
@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository us;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> list() {
        return us.findAll();
    }

    @Override
    public void insert(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        us.save(u);
    }

    @Override
    public Usuario listId(int id) {
        return us.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        us.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        us.save(usuario);
    }

    @Override
    public List<Usuario> buscarPorNombreService(String nombre) {
        return us.buscarPorNombreService(nombre);
    }

    @Override
    public List<String[]> CantidadUsuariosPorRol() {
        return  us.cantidadUsuariosPorRol();
    }

    @Override
    public List<String[]> UsuariosActivoporMes() {
        return us.usuariosActivosPorMes();
    }


}
