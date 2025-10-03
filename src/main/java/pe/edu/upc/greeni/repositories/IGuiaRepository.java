package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greeni.entities.Guia;

import java.util.List;

public interface IGuiaRepository extends JpaRepository<Guia, Integer> {
    @Query("SELECT g FROM Guia g WHERE g.tipoGuia = :tipo")
    List<Guia> findByTipo(@Param("tipo") String tipo);

    @Query("SELECT g FROM Guia g WHERE g.tituloGuia LIKE %:titulo%")
    List<Guia> findByTituloContaining(@Param("titulo") String titulo);
}

