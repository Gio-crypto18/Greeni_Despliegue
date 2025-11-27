package pe.edu.upc.greeni.servicesInterfaces;
import pe.edu.upc.greeni.entities.Recordatorio;

import java.util.List;
public interface IRecordatorioService {
    public List<Recordatorio> list();
    public void insert(Recordatorio recordatorio);
    public Recordatorio listId(int id);
    public void delete(int id);
    public void update(Recordatorio recordatorio);
    public List<Recordatorio> buscarService(String tipo);
    public List<String[]> quantityTipoRecordatorio();
    public List<Recordatorio> filtrarRecordatoriosPorUsuarioService(int id);
}
