public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private String sexo;
    private String raza;
    private String talla;
    private Propietario propietario;

    public Mascota(String nombre, String especie, int edad, String sexo, String raza,
                   String talla, Propietario propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.sexo = sexo;
        this.raza = raza;
        this.talla = talla;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public String toString() {
        return "Mascota: " + nombre + " | Especie: " + especie
                + " | Edad: " + edad + " meses"
                + "\nSexo: " + sexo + " | Raza: " + raza + " | Talla: " + talla
                + "\nPropietario: " + propietario;
    }
}
