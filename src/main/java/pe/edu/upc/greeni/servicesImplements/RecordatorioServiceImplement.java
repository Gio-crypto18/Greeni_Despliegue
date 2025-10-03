package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Recordatorio;
import pe.edu.upc.greeni.repositories.IRecordatorioRepository;
import pe.edu.upc.greeni.servicesInterfaces.IRecordatorioService;

import java.util.List;

@Service
public class RecordatorioServiceImplement  implements IRecordatorioService {

    @Autowired
    private IRecordatorioRepository rR;

    @Override
    public List<Recordatorio> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Recordatorio recordatorio) {
        rR.save(recordatorio);
    }

    @Override
    public Recordatorio listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Recordatorio recordatorio) {
        rR.save(recordatorio);
    }

    @Override
    public List<Recordatorio> buscarService(String tipo) {
        return rR.buscarR(tipo);
    }

    @Override
    public List<String[]> quantityTipoRecordatorio() {
        return rR.quantityTipoRecordatorio();
    }

    @Override
    public List<Recordatorio> filtrarRecordatoriosPorUsuarioService(int id) {
        return rR.filtrarRecordatoriosPorUsuario(id);
    }


}
