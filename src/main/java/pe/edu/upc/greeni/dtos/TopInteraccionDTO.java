package pe.edu.upc.greeni.dtos;

public class TopInteraccionDTO {
    private String tipoInteraccion;
    private int totalInteracciones;
    private Double porcentajeTotal;

    public String getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(String tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }

    public Double getPorcentajeTotal() {
        return porcentajeTotal;
    }

    public void setPorcentajeTotal(Double porcentajeTotal) {
        this.porcentajeTotal = porcentajeTotal;
    }

    public int getTotalInteracciones() {
        return totalInteracciones;
    }

    public void setTotalInteracciones(int totalInteracciones) {
        this.totalInteracciones = totalInteracciones;
    }
}
