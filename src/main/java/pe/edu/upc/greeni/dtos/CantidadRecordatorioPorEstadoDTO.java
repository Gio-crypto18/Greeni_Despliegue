package pe.edu.upc.greeni.dtos;

public class CantidadRecordatorioPorEstadoDTO {
    private String estado;
    private Long cantidad;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
