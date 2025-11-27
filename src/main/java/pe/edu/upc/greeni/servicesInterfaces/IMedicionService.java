package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Medicion;
import pe.edu.upc.greeni.entities.Tratamiento;

import java.util.List;

public interface IMedicionService {
    public List<Medicion> list();
    public Medicion listId(int id);
    public void insert(Medicion medicion);
    public void delete(int id);
    public void  update(Medicion medicion);
    public List<Medicion> buscarPorTemperatura(String temp);

}
