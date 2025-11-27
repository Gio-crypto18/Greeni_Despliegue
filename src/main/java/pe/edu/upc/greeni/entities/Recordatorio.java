package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Recordatorio")
public class Recordatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecordatorio;

    @Column(name="Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name="Fecha_re", nullable = false)
    private LocalDate fechaRe;

    @Column(name="Tipo", length = 10, nullable = false)
    private String tipo;

    //Relación con Usuario (FK)
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;

    //Relación con Estado Recordatorio (FK)
    @ManyToOne
    @JoinColumn(name="id_estado_recordatorio", nullable = false)
    private EstadoRecordatorio estado;

    public Recordatorio() {
    }
    public Recordatorio(int idRecordatorio, String nombre, LocalDate fechaRe, String tipo,  Usuario usuario, EstadoRecordatorio estado) {
        this.idRecordatorio = idRecordatorio;
        this.nombre = nombre;
        this.fechaRe = fechaRe;
        this.tipo = tipo;
        this.usuario = usuario;
        this.estado = estado;
    }
    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaRe() {
        return fechaRe;
    }

    public void setFechaRe(LocalDate fechaRe) {
        this.fechaRe = fechaRe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoRecordatorio getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecordatorio estado) {
        this.estado = estado;
    }
}
