package pe.edu.upc.greeni.dtos;

import java.time.LocalDate;

public class ResumenInteraccionDTO {
    private String usuario;
    private String tipoInteraccion;
    private Long totalInteracciones;
    private LocalDate primeraInteraccion;
    private LocalDate ultimaInteraccion;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getUltimaInteraccion() {
        return ultimaInteraccion;
    }

    public void setUltimaInteraccion(LocalDate ultimaInteraccion) {
        this.ultimaInteraccion = ultimaInteraccion;
    }

    public LocalDate getPrimeraInteraccion() {
        return primeraInteraccion;
    }

    public void setPrimeraInteraccion(LocalDate primeraInteraccion) {
        this.primeraInteraccion = primeraInteraccion;
    }

    public Long getTotalInteracciones() {
        return totalInteracciones;
    }

    public void setTotalInteracciones(Long totalInteracciones) {
        this.totalInteracciones = totalInteracciones;
    }

    public String getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(String tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }
}
