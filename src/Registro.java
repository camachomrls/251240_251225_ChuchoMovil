public class Registro {
    private int folio;
    private Mascota mascota;
    private String motivo;
    private String unidadMovil;
    private boolean atendido;

    public Registro(int folio, Mascota mascota, String motivo, String unidadMovil) {
        this.folio = folio;
        this.mascota = mascota;
        this.motivo = motivo;
        this.unidadMovil = unidadMovil;
        this.atendido = false;
    }

    public int getFolio() {
        return folio;
    }

    public void marcarAtendido() {
        atendido = true;
    }

    public String toString() {
        String estado;
        if (atendido) {
            estado = "Atendido";
        } else {
            estado = "En espera";
        }
        return "Folio: " + folio + "\n" + mascota
                + "\nMotivo: " + motivo + "\nUnidad movil: " + unidadMovil
                + "\nCosto: Gratuito\nEstado: " + estado;
    }
}
