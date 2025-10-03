package pe.edu.upc.greeni.servicesInterfaces;

import pe.edu.upc.greeni.entities.GuiaFavorita;

import java.util.List;

public interface IGuiaFavoritaService {
    public List<GuiaFavorita> list();
    public void insert(GuiaFavorita guiaFavorita);
    public void delete(int GuiaFavoritaId);
    public GuiaFavorita listId(int id);
}
