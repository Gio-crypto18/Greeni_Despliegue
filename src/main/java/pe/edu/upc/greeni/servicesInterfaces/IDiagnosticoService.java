package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Diagnostico;
import pe.edu.upc.greeni.entities.Usuario;

import java.util.List;

public interface IDiagnosticoService {
    public List<Diagnostico> list();
    public void insert(Diagnostico diagnostico);
    public Diagnostico listId(int id);
    public void delete(int id);
    public void update(Diagnostico diagnostico);
    public List<String[]> quantitySeveridadDiagnostico();
}
