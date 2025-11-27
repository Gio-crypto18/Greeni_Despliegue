package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greeni.entities.GuiaFavorita;

public interface IGuiaFavoritaRepository extends JpaRepository<GuiaFavorita, Integer> {
}
