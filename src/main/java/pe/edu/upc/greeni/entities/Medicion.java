package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Medicion")

public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicion;

    @Column(name = "humedad", nullable = false)
    private Double humedad;

    @Column(name = "temperatura", nullable = false)
    private Double temperatura;

    @Column(name = "ph", nullable = false)
    private Double ph;

    @Column(name = "fecha_med",nullable = false)
    private LocalDate fecha_med;

    @ManyToOne
    @JoinColumn(name="idPlanta")
    private Planta planta;

    public Medicion() {
    }


    public Medicion(int idMedicion, Double humedad, Double temperatura, Double ph, LocalDate fecha_med, Planta planta) {
        this.idMedicion = idMedicion;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.ph = ph;
        this.fecha_med = fecha_med;
        this.planta = planta;
    }

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public LocalDate getFecha_med() {
        return fecha_med;
    }

    public void setFecha_med(LocalDate fecha_med) {
        this.fecha_med = fecha_med;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}