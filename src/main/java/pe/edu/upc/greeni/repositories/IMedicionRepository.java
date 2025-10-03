package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greeni.entities.Medicion;

import java.util.List;

public interface IMedicionRepository extends JpaRepository<Medicion, Integer> {
        @Query("SELECT m FROM Medicion m WHERE m.Temperatura LIKE %:temp%")
        List<Medicion> buscarPorTemperatura(@Param("temp") String temp);




}


