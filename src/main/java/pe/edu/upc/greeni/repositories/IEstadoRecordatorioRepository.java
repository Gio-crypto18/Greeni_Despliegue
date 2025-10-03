package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greeni.entities.EstadoRecordatorio;

import java.util.List;

public interface IEstadoRecordatorioRepository extends JpaRepository<EstadoRecordatorio,Integer> {
    @Query(value = "select e.nombre as estado, count(r.id_recordatorio) as cantidad\n" +
            "from recordatorio r\n" +
            "join estado_recordatorio e on r.id_estado_recordatorio = e.id_estado_recordatorio\n" +
            "group by e.nombre;\n", nativeQuery = true)
    public List<Object[]> cantidadRecordatoriosPorEstado();
}
