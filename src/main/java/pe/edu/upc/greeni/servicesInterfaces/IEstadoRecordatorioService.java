package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.EstadoRecordatorio;

import java.util.List;

public interface IEstadoRecordatorioService {
    public List<EstadoRecordatorio> listid();
    public void insert(EstadoRecordatorio estadoRecordatorio);
    public EstadoRecordatorio listId(int id);
    public void delete(int id);
    public void update(EstadoRecordatorio estadoRecordatorio);
    public List<EstadoRecordatorio> buscarServiceER(String tipoER);
    public List<Object[]> cantidadRecordatoriosPorEstado();
}
