package pe.edu.upc.greeni.dtos;

public class TipoInteraccionDTO {

    private int TipoInteraccion_Id;
    private String Nombre;

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
