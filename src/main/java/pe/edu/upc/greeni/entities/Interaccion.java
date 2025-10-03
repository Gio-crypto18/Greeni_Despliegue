package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Interacción")
public class Interaccion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Interaccion_id;

    @Column(name="Descripcion",length = 100 , nullable = false)
    private String Descripcion;

    @Column(name="Fecha_pub", nullable = false )
    private LocalDate Fecha_pub;

    @ManyToOne
    @JoinColumn(name="id",nullable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name="tipo_interaccion_id",nullable = false)
    private Tipo_Interaccion tipoInteraccion;


    public Interaccion(int interaccion_id, Tipo_Interaccion tipoInteraccion, Usuario usuario, LocalDate fecha_pub, String descripcion) {
        Interaccion_id = interaccion_id;
        this.tipoInteraccion = tipoInteraccion;
        this.usuario = usuario;
        Fecha_pub = fecha_pub;
        Descripcion = descripcion;
    }

    public Interaccion() {
    }

    public int getInteraccion_id() {
        return Interaccion_id;
    }

    public void setInteraccion_id(int interaccion_id) {
        Interaccion_id = interaccion_id;
    }

    public Tipo_Interaccion getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(Tipo_Interaccion tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDate getFecha_pub() {
        return Fecha_pub;
    }

    public void setFecha_pub(LocalDate fecha_pub) {
        Fecha_pub = fecha_pub;
    }
}
