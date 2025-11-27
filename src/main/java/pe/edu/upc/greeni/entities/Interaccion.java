package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Interaccion")
public class Interaccion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Interaccion_id;

    @Column(name="descripcion",length = 100 , nullable = false)
    private String descripcion;

    @Column(name="fecha_pub", nullable = false )
    private LocalDate fecha_pub;

    @ManyToOne
    @JoinColumn(name="id",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="tipo_interaccion_id",nullable = false)
    private Tipo_Interaccion tipoInteraccion;


    public Interaccion(int interaccion_id, String descripcion, LocalDate fecha_pub, Usuario usuario, Tipo_Interaccion tipoInteraccion) {
        Interaccion_id = interaccion_id;
        this.descripcion = descripcion;
        this.fecha_pub = fecha_pub;
        this.usuario = usuario;
        this.tipoInteraccion = tipoInteraccion;
    }

    public Interaccion() {
    }

    public int getInteraccion_id() {
        return Interaccion_id;
    }

    public void setInteraccion_id(int interaccion_id) {
        Interaccion_id = interaccion_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_pub() {
        return fecha_pub;
    }

    public void setFecha_pub(LocalDate fecha_pub) {
        this.fecha_pub = fecha_pub;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo_Interaccion getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(Tipo_Interaccion tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }
}
