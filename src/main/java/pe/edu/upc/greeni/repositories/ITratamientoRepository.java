package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greeni.entities.Tratamiento;

import java.util.List;

public interface ITratamientoRepository extends JpaRepository<Tratamiento,Integer> {
        List<Tratamiento> findByDuracionGreaterThan(int duracion);
        List<Tratamiento> findByDuracionLessThan(int duracion);
    @Query(value = "select id_tratamiento, nombre, fechafin,\n" +
            "       (fechafin - current_date) as dias_restantes\n" +
            "from tratamiento\n" +
            "where fechafin between current_date and (current_date + INTERVAL '7 days')\n" +
            "ORDER BY fechafin;", nativeQuery = true)
    public List<String[]> venceTratamiento();
    }



