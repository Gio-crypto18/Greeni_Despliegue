package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Planta;
import pe.edu.upc.greeni.repositories.IPlantaRepository;
import pe.edu.upc.greeni.servicesInterfaces.IPlantaService;
import java.util.List;

@Service
public class PlantaServiceImplement  implements IPlantaService {

    @Autowired
    private IPlantaRepository pr;

    @Override
    public List<Planta> list() {
        return pr.findAll();
    }

    @Override
    public void insert(Planta planta) {
        pr.save(planta);
    }

    @Override
    public Planta listId(int id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void update(Planta planta) {
        pr.save(planta);
    }

    @Override
    public List<String[]> quantitynombrePlanta() {
        return pr.quantitynombrePlanta();
    }

    @Override
    public List<String[]> getPlantasMax() {
        return  pr.getPlantasMax();
    }


    @Override
    public void delete(int id) {
        pr.deleteById(id);
    }

}
