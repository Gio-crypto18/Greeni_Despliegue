package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Diagnostico;
import pe.edu.upc.greeni.repositories.IDiagnosticoRepository;
import pe.edu.upc.greeni.servicesInterfaces.IDiagnosticoService;

import java.util.List;


@Service
public class DiagnosticoServiceImplement implements IDiagnosticoService {

    @Autowired
    private IDiagnosticoRepository diagnosticoRepository;

    @Override
    public List<Diagnostico> list() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public void insert(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public Diagnostico listId(int id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        diagnosticoRepository.deleteById(id);
    }

    @Override
    public void update(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public List<String[]> quantitySeveridadDiagnostico() {
        return diagnosticoRepository.quantitySeveridadDiagnostico();
    }


}
