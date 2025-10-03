package pe.edu.upc.greeni.dtos;

public class RecordatorioFiltroDTO {
    private int idRecordatorio;
    private String nombre;
    private String tipo;
    private String fechaRe;
    private String usuarioNombre;
    private String estadoNombre;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaRe() {
        return fechaRe;
    }

    public void setFechaRe(String fechaRe) {
        this.fechaRe = fechaRe;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }
}
