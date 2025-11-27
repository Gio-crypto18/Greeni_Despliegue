package pe.edu.upc.greeni.dtos;

public class QuantityEspecieDTO {
    private String NombreC;
    private int quantityEspecie;

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String nombreC) {
        NombreC = nombreC;
    }

    public int getQuantityEspecie() {
        return quantityEspecie;
    }

    public void setQuantityEspecie(int quantityEspecie) {
        this.quantityEspecie = quantityEspecie;
    }
}
