package pe.edu.upc.greeni.dtos;

public class GuiaDTO {
    private int GuiaId;
    private String tituloGuia;
    private String tipoGuia;
    private String contenidoGuia;

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
