package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Rol;
import pe.edu.upc.greeni.repositories.IRolRepository;
import pe.edu.upc.greeni.servicesInterfaces.IRolService;

import java.util.List;
@Service
public class RolServiceImplements  implements IRolService {
    @Autowired
    private IRolRepository repository ;

    @Override
    public List<Rol> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Rol rol) {
    repository.save(rol);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Rol rol) {
        repository.save(rol);
    }

    @Override
    public Rol listId(int id) {
        return repository.findById(id).orElse(null);
    }
}
