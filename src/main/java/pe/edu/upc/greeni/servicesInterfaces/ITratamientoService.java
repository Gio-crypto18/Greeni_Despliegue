package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.Tratamiento;

import java.util.List;

public interface ITratamientoService {
    public List<Tratamiento> list();
    public void insert(Tratamiento tratamiento);
    public Tratamiento listId(int id);
    public void delete(int id);
    public void  update(Tratamiento tratamiento);
    public List<Tratamiento> buscarDuracionMayor(int max);
    public List<Tratamiento> buscarDuracionMenor(int min);
    public List<String[]> venceTratamiento();
}
