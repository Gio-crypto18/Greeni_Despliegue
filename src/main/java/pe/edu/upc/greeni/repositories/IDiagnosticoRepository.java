package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.greeni.entities.Diagnostico;

import java.util.List;

public interface IDiagnosticoRepository extends JpaRepository<Diagnostico,Integer> {

    @Query(value = "SELECT severidad, COUNT(*) AS cantidad\n" +
            "FROM diagnostico\n" +
            "GROUP BY severidad\n" +
            "ORDER BY severidad DESC;", nativeQuery = true)
    public List<String[]> quantitySeveridadDiagnostico();
}
