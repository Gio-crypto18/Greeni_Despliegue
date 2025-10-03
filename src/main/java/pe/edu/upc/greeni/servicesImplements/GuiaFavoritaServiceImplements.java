package pe.edu.upc.greeni.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greeni.entities.GuiaFavorita;
import pe.edu.upc.greeni.repositories.IGuiaFavoritaRepository;
import pe.edu.upc.greeni.repositories.IGuiaRepository;
import pe.edu.upc.greeni.repositories.IUsuarioRepository;
import pe.edu.upc.greeni.servicesInterfaces.IGuiaFavoritaService;

import java.util.List;

@Service
public class GuiaFavoritaServiceImplements implements IGuiaFavoritaService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IGuiaRepository guiaRepository;

    @Autowired
    private IGuiaFavoritaRepository guiaFavoritaRepository;

    @Override
    public List<GuiaFavorita> list() {
        return guiaFavoritaRepository.findAll();
    }
    @Override
    public void delete(int GuiaFavoritaId) {
        guiaFavoritaRepository.deleteById(GuiaFavoritaId);
    }

    @Override
    public GuiaFavorita listId(int id) {
        return guiaFavoritaRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(GuiaFavorita gf) {
        gf.setUsuario(usuarioRepository.findById(gf.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        gf.setGuia(guiaRepository.findById(gf.getGuia().getGuiaId())
                .orElseThrow(() -> new RuntimeException("Guía no encontrada")));

        guiaFavoritaRepository.save(gf);
    }



}


