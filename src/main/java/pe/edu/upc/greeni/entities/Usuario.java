package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="Nombre",length = 100,nullable = false)
    private String nombre;

    @Column(name ="email",length = 100,nullable = false)
    private String email;

    @Column(name ="password",length = 200,nullable = false)
    private String password;

    @Column(name ="activo",nullable = false)
    private boolean activo;

    @Column(name ="FechaIni",nullable = false)
    private LocalDate fechaIni;

    @Column(name ="Biografia",nullable = false)
    private String biografia;

    @Column(name ="notificaciones",nullable = false)
    private boolean notificaciones;

    @ManyToOne
    @JoinColumn(name="rolId")
    private Rol rol;

    public Usuario(){}

    public Usuario(int id, String nombre, String email, String password, boolean activo, LocalDate fechaIni, String biografia, boolean notificaciones) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.activo = activo;
        this.fechaIni = fechaIni;
        this.biografia = biografia;
        this.notificaciones = notificaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


}
