package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Guia")
public class Guia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GuiaId;

    @Column(name="Titulo",length = 20,nullable = false)
    private String tituloGuia;

    @Column(name = "Tipo",length = 10,nullable = false)
    private String tipoGuia;

    @Column(name = "Contenido",length = 200,nullable = false)
    private String contenidoGuia;

    public Guia() {
    }

    public int getGuiaId() {
        return GuiaId;
    }

    public void setGuiaId(int guiaId) {
        GuiaId = guiaId;
    }

    public String getTituloGuia() {
        return tituloGuia;
    }

    public void setTituloGuia(String tituloGuia) {
        this.tituloGuia = tituloGuia;
    }

    public String getTipoGuia() {
        return tipoGuia;
    }

    public void setTipoGuia(String tipoGuia) {
        this.tipoGuia = tipoGuia;
    }

    public String getContenidoGuia() {
        return contenidoGuia;
    }

    public void setContenidoGuia(String contenidoGuia) {
        this.contenidoGuia = contenidoGuia;
    }
}
