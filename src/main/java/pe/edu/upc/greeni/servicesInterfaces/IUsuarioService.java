package pe.edu.upc.greeni.servicesInterfaces;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Usuario;

import java.util.List;


public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public Usuario listId(int id);
    public void delete(int id);
    public void update(Usuario usuario);
    public List<Usuario> buscarPorNombreService(String nombre);
    public List<String[]> CantidadUsuariosPorRol();
    public List<String[]> UsuariosActivoporMes( );
}
