package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.Guia;
import pe.edu.upc.greeni.repositories.IGuiaRepository;
import pe.edu.upc.greeni.servicesInterfaces.IGuiaService;

import java.util.List;


@Service
public class GuiaServiceImplement  implements IGuiaService {
    @Autowired
    private IGuiaRepository repositoryGuia;

    @Override
    public List<Guia> list() {
        return repositoryGuia.findAll();
    }

    @Override
    public void insert(Guia guia) {
        repositoryGuia.save(guia);
    }

    @Override
    public void update(Guia guia) {
        repositoryGuia.save(guia);
    }

    @Override
    public void delete(int id) {
        repositoryGuia.deleteById(id);
    }

    @Override
    public Guia listId(int id) {
        return repositoryGuia.findById(id).orElse(null);
    }

    @Override
    public List<Guia> buscarPorTipo(String tipo) {
        return repositoryGuia.findByTipo(tipo);
    }

    @Override
    public List<Guia> buscarPorTitulo(String titulo) {
        return repositoryGuia.findByTituloContaining(titulo);
    }




}
