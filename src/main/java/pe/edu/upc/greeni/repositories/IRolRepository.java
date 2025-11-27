package pe.edu.upc.greeni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greeni.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol,Integer> {
}
