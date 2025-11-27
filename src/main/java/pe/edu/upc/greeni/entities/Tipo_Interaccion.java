package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tipo_interacción")
public class Tipo_Interaccion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int TipoInteraccion_Id;

    @Column(name="Nombre", length=100, nullable = false)
    private String Nombre;

    public Tipo_Interaccion() {
    }

    public Tipo_Interaccion(int tipoInteraccion_Id, String nombre) {
        TipoInteraccion_Id = tipoInteraccion_Id;
        Nombre = nombre;
    }

    public int getTipoInteraccion_Id() {
        return TipoInteraccion_Id;
    }

    public void setTipoInteraccion_Id(int tipoInteraccion_Id) {
        TipoInteraccion_Id = tipoInteraccion_Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}

