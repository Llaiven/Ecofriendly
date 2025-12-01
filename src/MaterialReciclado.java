public class MaterialReciclado {

    private String tipo;
    private int cantidad;
    private String fecha;
    private int idUsuario;

    public MaterialReciclado(String tipo, int cantidad, String fecha, int idUsuario) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public String getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
    public String getFecha() { return fecha; }
    public int getIdUsuario() { return idUsuario; }

    @Override
    public String toString() {
        return "Material: " + tipo +
                ", Cantidad: " + cantidad +
                ", Fecha: " + fecha +
                ", Usuario ID: " + idUsuario;
    }
}

