package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Especie;
import pe.edu.upc.greeni.repositories.IEspecieRepository;
import pe.edu.upc.greeni.servicesInterfaces.IEspecieService;


import java.util.List;


@Service
public class EspecieServiceImplement implements IEspecieService {
    @Autowired
    private IEspecieRepository especieRepository;

    @Override
    public List<Especie> list() {
        return especieRepository.findAll();
    }

    @Override
    public void insert(Especie especie) {
        especieRepository.save(especie);
    }

    @Override
    public Especie listId(int id) {
        return especieRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        especieRepository.deleteById(id);
    }

    @Override
    public void update(Especie especie) {
        especieRepository.save(especie);
    }

    @Override
    public List<String[]> quantityEspecie() {
        return especieRepository.quantityEspecie();
    }
}
