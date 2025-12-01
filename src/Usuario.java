public class Usuario {
    private int id;
    private String nombre;
    private String rol;
    private int puntaje;
    private String zona;

    // Constructor
    public Usuario(int id, String nombre, String rol, int puntaje, String zona) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.puntaje = puntaje;
        this.zona = zona;
    }

    // Get y Set
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public int getPuntaje() { return puntaje; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    // toString
    @Override
    public String toString() {
        return "Usuario " +
                "Id: " + id +
                ", Nombre: " + nombre +
                ", Rol: " + rol +
                ", Puntaje: " + puntaje +
                ", Zona: " + zona;
    }
}
