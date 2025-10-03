package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolId;

    @Column(name ="tipo",length = 10,nullable = false)
    private String tipo;

    public Rol() {
    }

    public int getRolId() {
        return rolId;
    }

    public Rol(int rolId, String tipo) {
        this.rolId = rolId;
        this.tipo = tipo;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
