package pe.edu.upc.greeni.dtos;

import java.time.LocalDate;

public class PlantaMaxDTO {
    private String nombrePlanta;
    private LocalDate fecha_reg;

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public LocalDate getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(LocalDate fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
}
