package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Especie;

import java.util.List;

public interface IEspecieService {
    public List<Especie> list();
    public void insert(Especie especie);
    public Especie listId(int id);
    public void delete(int id);
    public void update(Especie especie);
    public List<String[]> quantityEspecie();

}
