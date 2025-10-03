package pe.edu.upc.greeni.dtos;

public class GuiaFavoritaDTO {
    private int  GuiaFavoritaId;
    private int GuiaId;
    private int id;

    public int getGuiaId() {
        return GuiaId;
    }

    public void setGuiaId(int guiaId) {
        GuiaId = guiaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuiaFavoritaId() {
        return GuiaFavoritaId;
    }

    public void setGuiaFavoritaId(int guiaFavoritaId) {
        GuiaFavoritaId = guiaFavoritaId;
    }
}
