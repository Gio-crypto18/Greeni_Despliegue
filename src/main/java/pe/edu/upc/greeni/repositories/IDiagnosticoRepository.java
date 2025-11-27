package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greeni.entities.Diagnostico;

import java.time.LocalDate;
import java.util.List;

public interface IDiagnosticoRepository extends JpaRepository<Diagnostico,Integer> {

    @Query(value = """
SELECT severidad, COUNT(*) AS cantidad
    FROM diagnostico
    GROUP BY severidad
    ORDER BY severidad DESC
""", nativeQuery = true)
    List<String[]> quantitySeveridadByFechas(

    );
}
