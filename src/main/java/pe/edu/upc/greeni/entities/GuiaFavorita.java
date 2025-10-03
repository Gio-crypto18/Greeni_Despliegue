package pe.edu.upc.greeni.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "GuiaFavorita")
public class GuiaFavorita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GuiaFavoritaId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "guia_id", nullable = false)
    private Guia guia;

    public GuiaFavorita() {
    }

    public GuiaFavorita(int guiaFavoritaId, Usuario usuario, Guia guia) {
        GuiaFavoritaId = guiaFavoritaId;
        this.usuario = usuario;
        this.guia = guia;
    }

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
