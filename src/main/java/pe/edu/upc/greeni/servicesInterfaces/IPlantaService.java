package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Planta;
import pe.edu.upc.greeni.entities.Usuario;

import java.util.List;



public interface IPlantaService {
    List<Planta> list();
    void insert(Planta planta);
    Planta listId(int id);
    void delete(int id);
    void update(Planta planta);
    public List<String[]>quantitynombrePlanta();
    public List<String[]> getPlantasMax();

}

