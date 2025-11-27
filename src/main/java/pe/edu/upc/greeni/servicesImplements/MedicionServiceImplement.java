package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Medicion;
import pe.edu.upc.greeni.repositories.IMedicionRepository;
import pe.edu.upc.greeni.servicesInterfaces.IMedicionService;

import java.util.List;

@Service
public class MedicionServiceImplement implements IMedicionService {
    @Autowired
    private IMedicionRepository medicionRepository;

    @Override
    public List<Medicion> list() {
        return medicionRepository.findAll();
    }

    @Override
    public Medicion listId(int id) {
        return medicionRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(Medicion medicion) {
        medicionRepository.save(medicion);
    }

    @Override
    public void delete(int id) {
        medicionRepository.deleteById(id);
    }

    @Override
    public void update(Medicion medicion) {
        medicionRepository.save(medicion);
    }

    @Override
    public List<Medicion> buscarPorTemperatura(String temp) {
        return medicionRepository.buscarPorTemperatura(temp);
    }




}
