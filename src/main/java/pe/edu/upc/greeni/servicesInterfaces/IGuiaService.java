package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Guia;
import pe.edu.upc.greeni.entities.Usuario;

import java.util.List;

public interface IGuiaService {
    public List<Guia> list();
    public void insert(Guia guia);
    public void update(Guia guia);
    public void delete(int id);
    public Guia listId(int id);
    public List<Guia> buscarPorTipo(String tipo);
    public List<Guia> buscarPorTitulo(String titulo);
}
