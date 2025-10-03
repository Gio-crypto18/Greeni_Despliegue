package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greeni.entities.Especie;

import java.util.List;


public interface IEspecieRepository  extends JpaRepository<Especie, Integer> {
    @Query(value = "SELECT s.id_especie, COUNT(s.id_especie) AS cantidad\n" +
            "FROM especie s\n" +
            "GROUP BY s.id_especie", nativeQuery = true)

    public List<String[]> quantityEspecie();


}
