package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Interaccion;

import java.util.List;

public interface IInteraccionService {
    public List<Interaccion> listar();
    public void insert(Interaccion interaccion);
    Interaccion listId(int id);
    public void delete(int id);
    public List<String[]>  ResumenInteracciones();
    public  List<String[]> TopTiposInteraccion();
}
