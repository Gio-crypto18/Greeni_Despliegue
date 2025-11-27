package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greeni.entities.Interaccion;

import java.util.List;

public interface IInteraccionRepository extends JpaRepository<Interaccion,Integer> {
    @Query(value = "select u.nombre as usuario,\n" +
            "       t.nombre as tipo_interaccion,\n" +
            "       count(i.interaccion_id) as total_interacciones,\n" +
            "       min(i.fecha_pub) as primera_interaccion,\n" +
            "       max(i.fecha_pub) as ultima_interaccion from interaccion i\n" +
            "       join usuario u on i.id = u.id\n" +
            "       join tipo_interacción t on i.tipo_interaccion_id = t.tipo_interaccion_id\n" +
            "       group by u.nombre, t.nombre\n" +
            "       order by total_interacciones desc", nativeQuery = true)
    public List<String[]> ResumenInteracciones();


    @Query(
            value = "SELECT t.nombre AS tipo_interaccion,\n" +
                    "       COUNT(i.interaccion_id) AS total_interacciones,\n" +
                    "       ROUND(\n" +
                    "           100.0 * COUNT(i.interaccion_id) / SUM(COUNT(i.interaccion_id)) OVER (), \n" +
                    "           2\n" +
                    "       ) AS porcentaje_total\n" +
                    "FROM interaccion i\n" +
                    "JOIN tipo_interacción t ON i.tipo_interaccion_id = t.tipo_interaccion_id\n" +
                    "GROUP BY t.nombre\n" +
                    "ORDER BY total_interacciones DESC\n",
            nativeQuery = true
    )
    public  List<String[]> TopTiposInteraccion();


}