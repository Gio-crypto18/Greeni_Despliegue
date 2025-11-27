package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Tipo_Interaccion;
import pe.edu.upc.greeni.entities.Tratamiento;

import java.util.List;

public interface ITipoInteraccionService {
    public List<Tipo_Interaccion> listar();
    public void insert(Tipo_Interaccion tipoInteraccion);
    public void update(Tipo_Interaccion tipoInteraccion);
    public void delete(int id);
    public Tipo_Interaccion listId(int id);
}
