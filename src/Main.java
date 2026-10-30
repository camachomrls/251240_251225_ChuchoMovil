import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaVeterinario sistema = new SistemaVeterinario();
        int opcion;

        System.out.println("REGISTRO DE ATENCION VETERINARIA GRATUITA");
        System.out.println("Chucho Movil - Proyecto escolar");
        System.out.println("Registro para esterilizacion gratuita de perros y gatos.");
        System.out.println("La vacunacion antirrabica no requiere este registro.");
        System.out.println("Los datos se conservan mientras el programa este abierto.");

        do {
            System.out.println("\nMenu");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Ver turnos en espera");
            System.out.println("3. Atender siguiente mascota");
            System.out.println("4. Ver mascotas atendidas");
            System.out.println("5. Buscar registro por folio");
            System.out.println("6. Salir");
            opcion = leerEntero("Selecciona una opcion: ", 1, 6);

            switch (opcion) {
                case 1:
                    registrarMascota(sistema);
                    break;
                case 2:
                    sistema.mostrarPendientes();
                    break;
                case 3:
                    sistema.atenderSiguiente();
                    break;
                case 4:
                    sistema.mostrarAtendidos();
                    break;
                case 5:
                    int folio = leerEntero("Folio: ", 1, Integer.MAX_VALUE);
                    Registro registro = sistema.buscarPorFolio(folio);
                    if (registro == null) {
                        System.out.println("No existe un registro con ese folio.");
                    } else {
                        System.out.println(registro);
                    }
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
            }
        } while (opcion != 6);

        entrada.close();
    }

    private static void registrarMascota(SistemaVeterinario sistema) {
        System.out.println("\n--- NUEVO REGISTRO ---");
        String nombrePropietario = leerTexto("Nombre del propietario: ");
        String telefono = leerTexto("Telefono: ");
        String colonia = leerTexto("Colonia: ");
        String codigoPostal = leerTexto("Codigo postal: ");
        System.out.print("Email (opcional, Enter para omitir): ");
        String email = entrada.nextLine().trim();
        if (email.isEmpty()) {
            email = "No proporcionado";
        }
        String nombreMascota = leerTexto("Nombre de la mascota: ");
        int tipo = leerEntero("Tipo de mascota (1. Perro / 2. Gato): ", 1, 2);
        String especie = "Perro";
        if (tipo == 2) {
            especie = "Gato";
        }
        int edad = leerEntero("Edad en meses: ", 0, Integer.MAX_VALUE);
        int opcionSexo = leerEntero("Sexo (1. Hembra / 2. Macho): ", 1, 2);
        String sexo = "Hembra";
        if (opcionSexo == 2) {
            sexo = "Macho";
        }
        String raza = leerTexto("Raza (o mestizo): ");
        String talla = "Pequeno (0-10 kg)";
        if (tipo == 1) {
            int opcionTalla = leerEntero("Talla (1. Pequeno / 2. Mediano / 3. Grande): ", 1, 3);
            if (opcionTalla == 2) {
                talla = "Mediano (11-20 kg)";
            } else if (opcionTalla == 3) {
                talla = "Grande (mayor de 20 kg)";
            }
        }
        String motivo = "Esterilizacion";
        String unidadMovil = leerTexto("Nombre o numero de la unidad movil: ");

        Propietario propietario = new Propietario(nombrePropietario, telefono, colonia, codigoPostal, email);
        Mascota mascota = new Mascota(nombreMascota, especie, edad, sexo, raza, talla, propietario);
        int folio = sistema.registrar(mascota, motivo, unidadMovil);

        System.out.println("Registro exitoso. Folio: " + folio);
        System.out.println("La mascota fue agregada a la cola de atencion gratuita.");
    }

    private static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = entrada.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Este dato no puede quedar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static int leerEntero(String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.print(mensaje);
            try {
                int numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
                System.out.println("Ingresa un numero entre " + minimo + " y " + maximo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero entero valido.");
            }
        }
    }
}
