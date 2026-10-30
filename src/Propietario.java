public class Propietario {
    private String nombre;
    private String telefono;
    private String colonia;
    private String codigoPostal;
    private String email;

    public Propietario(String nombre, String telefono, String colonia, String codigoPostal, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String toString() {
        return nombre + " | Telefono: " + telefono
                + "\nColonia: " + colonia + " | Codigo postal: " + codigoPostal
                + "\nEmail: " + email;
    }
}
