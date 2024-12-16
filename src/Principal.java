import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final Scanner TCL = new Scanner(System.in);
    private static final ArrayList<Profesional> PROFESIONALES = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("SOFTWARE DE GESTION DE LOS ALL BLACKS");
        int eleccion = 0;


        do {
            System.out.println("-------------------------------------");
            System.out.print("1-Introducir datos de un profesional \n" +
                    "2-Consulta con filtro \n" +
                    "3-Listado de nombres \n" +
                    "4-Salir \n" +
                    "Opcion: ");
            while (true) {
                try {
                    eleccion = TCL.nextInt();
                    TCL.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Por favor, introduzca un número válido." + e.getMessage());
                    TCL.nextLine();
                }
            }


            switch (eleccion) {
                case 1:
                    crearProfesional();
                    break;
                case 2:
                    consultarConFiltro();
                    break;
                case 3:

                    System.out.println(PROFESIONALES.stream()
                            .map(Profesional::getNombre)
                            .collect(Collectors.joining(",", "", ".")));
                    break;
                case 4:
                    System.out.println("Gracias por utilizar este software ¡Haka!");
                    break;
                default:
                    System.out.println("No es una opcion correcta.");
            }
        } while (eleccion != 4);
        TCL.close();
    }

    private static void crearProfesional() {
        System.out.print("Introduzca nombre: ");
        String nombre = TCL.next();
        TCL.nextLine();

        System.out.print("Introduzca edad: ");
        int edad = TCL.nextInt();
        TCL.nextLine();

        System.out.print("Introduzca genero (f/m): ");
        String generoIn = TCL.next().toLowerCase();
        char genero = generoIn.charAt(0);
        TCL.nextLine();

        System.out.print("Introduzca tipo de profesional: (1-Jugador, 2-Directivo, 3-Fisio) ");
        int tipo = TCL.nextInt();
        TCL.nextLine();

        Profesional profesional = new Profesional(nombre, edad, genero, tipo);

        PROFESIONALES.add(profesional);
    }

    private static void consultarConFiltro() {
        int eleccion = 0;
        do {
            System.out.println("Submenu de consultas");
            System.out.println("-------------------------------------");
            System.out.print("1-Profesionales por genero \n" +
                    "2-Profesionales por tipo \n" +
                    "3-Profesionales por edad \n" +
                    "4-Volver al menu principal \n" +
                    "Opcion: ");
            while (true) {
                try {
                    eleccion = TCL.nextInt();
                    TCL.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Por favor, introduzca un número válido." + e.getMessage());
                    TCL.nextLine();
                }
            }
            switch (eleccion) {
                case 1:
                    filtrarGenero();
                    break;
                case 2:
                    filtrarTipo();
                    break;
                case 3:
                    filtrarEdad();
                    break;
                case 4:
                    System.out.println("Volviendo al programa principal...");
                    break;
                default:
                    System.out.println("Introduzca una eleccion valida.");
            }
        } while (eleccion != 4);
    }

    private static void filtrarGenero() {
        System.out.println("Profesionales por genero...");
        System.out.println("Listado de profesionales del genero masculino: ");

        PROFESIONALES.stream()
                .filter(profesional -> profesional.getGenero() == 'm')
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Listado de profesionales del genero femenino: ");

        PROFESIONALES.stream()
                .filter(profesional -> profesional.getGenero() == 'f')
                .forEach(System.out::println);
    }

    private static void filtrarTipo() {
        System.out.println("Profesionales por tipo...");

        System.out.println("Listado de profesionales del tipo Jugador: ");
        PROFESIONALES.stream()
                .filter(profesional -> profesional.getTipo() == 1)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Listado de profesionales del tipo Directivo: ");
        PROFESIONALES.stream()
                .filter(profesional -> profesional.getTipo() == 2)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Listado de profesionales del tipo Fisio: ");
        PROFESIONALES.stream()
                .filter(profesional -> profesional.getTipo() == 3)
                .forEach(System.out::println);
    }

    private static void filtrarEdad() {
        int edadMinima = 0;
        int edadMaxima = 0;
        System.out.println("Profesionales por edad...");

        System.out.println("Introduzca edad minima y maxima para la consulta:");
        while (true) {
            try {
                edadMinima = TCL.nextInt();
                TCL.nextLine();
                edadMaxima = TCL.nextInt();
                TCL.nextLine();
                if (edadMinima > edadMaxima) {
                    System.out.println("La edad mínima no puede ser mayor que la edad máxima. Inténtelo de nuevo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un número válido." + e.getMessage());
                TCL.nextLine();
            }
        }


        System.out.println("Imprimiendo profesionales entre " + edadMinima + " y " + edadMaxima + " años:");
        int finalEdadMinima = edadMinima;
        int finalEdadMaxima = edadMaxima;
        PROFESIONALES.stream()
                .filter(profesional -> profesional.getEdad() >= finalEdadMinima && profesional.getEdad() <= finalEdadMaxima)
                .forEach(System.out::println);
    }
}