package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greeni.entities.Planta;

import java.util.List;

public interface IPlantaRepository extends JpaRepository<Planta, Integer> {


    @Query(value = "select s.nombre_planta, count(s.nombre_planta) AS cantidad\n" +
            "from planta s\n" +
            "group by s.nombre_planta", nativeQuery = true)
    public List<String[]> quantitynombrePlanta();

    @Query(value = "SELECT s.nombre_planta, MAX(s.fecha_reg) AS fecha_registro\n" +
            "FROM planta s\n" +
            "GROUP BY s.nombre_planta;", nativeQuery = true)
    public List<String[]> getPlantasMax();

}
