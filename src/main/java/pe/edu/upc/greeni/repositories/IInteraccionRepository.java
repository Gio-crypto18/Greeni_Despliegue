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
            "       max(i.fecha_pub) as ultima_interaccion\n" +
            "from interacción i\n" +
            "join usuario u on i.id = u.id\n" +
            "join tipo_interacción t on i.tipo_interaccion_id = t.tipo_interaccion_id\n" +
            "group by u.nombre, t.nombre\n" +
            "order by total_interacciones desc;\n", nativeQuery = true)
    public List<String[]> ResumenInteracciones();

    @Query(value = "select t.nombre as tipo_interaccion,\n" +
            "    count(i.interaccion_id) as total_interacciones,\n" +
            "    round(100.0 * count(i.interaccion_id) / sum(count(i.interaccion_id)) over (), 2) as porcentaje_total\n" +
            "from interacción i\n" +
            "join tipo_interacción t on i.tipo_interaccion_id = t.tipo_interaccion_id\n" +
            "group by t.nombre\n" +
            "order by total_interacciones desc\n" +
            "limit 4;\n", nativeQuery = true)
    public  List<String[]> TopTiposInteraccion();


}
