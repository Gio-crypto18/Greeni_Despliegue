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

    @OneToMany(mappedBy = "tipoInteraccion")
    private List<Interaccion> interacciones;

    public Tipo_Interaccion() {
    }

    public Tipo_Interaccion(int tipoInteraccion_Id, String nombre, List<Interaccion> interacciones) {
        TipoInteraccion_Id = tipoInteraccion_Id;
        Nombre = nombre;
        this.interacciones = interacciones;
    }

    public int getTipoInteraccion_Id() {
        return TipoInteraccion_Id;
    }

    public void setTipoInteraccion_Id(int tipoInteraccion_Id) {
        TipoInteraccion_Id = tipoInteraccion_Id;
    }

    public List<Interaccion> getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(List<Interaccion> interacciones) {
        this.interacciones = interacciones;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}

