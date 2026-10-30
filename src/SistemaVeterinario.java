import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SistemaVeterinario {
    private Queue<Registro> pendientes;
    private ArrayList<Registro> atendidos;
    private int siguienteFolio;

    public SistemaVeterinario() {
        pendientes = new LinkedList<>();
        atendidos = new ArrayList<>();
        siguienteFolio = 1;
    }

    public int registrar(Mascota mascota, String motivo, String unidadMovil) {
        Registro registro = new Registro(siguienteFolio, mascota, motivo, unidadMovil);
        pendientes.offer(registro);
        siguienteFolio++;
        return registro.getFolio();
    }

    public void atenderSiguiente() {
        if (pendientes.isEmpty()) {
            System.out.println("No hay mascotas en espera.");
            return;
        }

        Registro registro = pendientes.poll();
        registro.marcarAtendido();
        atendidos.add(registro);
        System.out.println("Atencion registrada correctamente:");
        System.out.println(registro);
    }

    public void mostrarPendientes() {
        if (pendientes.isEmpty()) {
            System.out.println("No hay mascotas en espera.");
            return;
        }

        System.out.println("--- TURNOS EN ORDEN DE LLEGADA ---");
        for (Registro registro : pendientes) {
            System.out.println(registro);
            System.out.println("--------------------------------");
        }
        System.out.println("Total en espera: " + pendientes.size());
    }

    public void mostrarAtendidos() {
        if (atendidos.isEmpty()) {
            System.out.println("Todavia no se ha atendido ninguna mascota.");
            return;
        }

        System.out.println("--- MASCOTAS ATENDIDAS ---");
        for (Registro registro : atendidos) {
            System.out.println(registro);
            System.out.println("--------------------------------");
        }
        System.out.println("Total atendidas: " + atendidos.size());
    }

    public Registro buscarPorFolio(int folio) {
        for (Registro registro : pendientes) {
            if (registro.getFolio() == folio) {
                return registro;
            }
        }
        for (Registro registro : atendidos) {
            if (registro.getFolio() == folio) {
                return registro;
            }
        }
        return null;
    }
}
