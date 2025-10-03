package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greeni.entities.Recordatorio;

import java.util.List;

public interface IRecordatorioRepository extends JpaRepository<Recordatorio,Integer> {
    @Query("Select dev from Recordatorio  dev where dev.tipo like %:tipo%")
    public List<Recordatorio> buscarR(@Param("tipo")String tipo);

    @Query("select r from Recordatorio r where r.usuario.id = :idUsuario")
    public List<Recordatorio> filtrarRecordatoriosPorUsuario(@Param("idUsuario") int  idUsuario);


    @Query(value = "select tipo, count(*) as cantidad\n" +
            "from recordatorio\n" +
            "group by tipo\n" +
            "order by tipo desc;\n", nativeQuery = true)
    public List<String[]> quantityTipoRecordatorio();
}
