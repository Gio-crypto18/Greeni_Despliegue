package pe.edu.upc.greeni.entities;

import jakarta.persistence.*;

@Entity

@Table(name="Especie")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecie;

    @Column(name = "NombreC", length = 25, nullable = false)
    private String NombreC;

    public Especie() {
    }

    public Especie(int idEspecie, String nombreC) {
        this.idEspecie = idEspecie;
        NombreC = nombreC;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String nombreC) {
        NombreC = nombreC;
    }
}