package pe.edu.upc.greeni.dtos;

import pe.edu.upc.greeni.entities.Guia;
import pe.edu.upc.greeni.entities.Usuario;

public class GUIAFAVORITADTOC {
    private int  GuiaFavoritaId;
    private Usuario usuario;
    private Guia guia;

    public int getGuiaFavoritaId() {
        return GuiaFavoritaId;
    }

    public void setGuiaFavoritaId(int guiaFavoritaId) {
        GuiaFavoritaId = guiaFavoritaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }
}
