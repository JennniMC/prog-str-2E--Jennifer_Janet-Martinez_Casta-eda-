import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Alumno[] alumnos = new Alumno[25];
        Scanner sc = new Scanner(System.in);
        AlumosService service = new AlumosService();
        InputValidator input = new InputValidator();

        int opcion;
        do {
            System.out.println("======Menú====");
            System.out.println(" 1) Alta alumno");
            System.out.println(" 2) Buscar por ID (solo activos)");
            System.out.println(" 3) Actualizar promedio por ID (solo activos)");
            System.out.println(" 4) Baja lógica por ID");
            System.out.println(" 5) Listar activos");
            System.out.println(" 6) Reportes");
            System.out.println(" 0) Salir");
            opcion = input.getValidInt(sc, "Elige una opción:");
            switch (opcion) {
                case 1:
                    service.alta(alumnos, sc);

                    break;

                case 2:
                    service.buscar(alumnos, sc);
                    break;
                case 3:
                    service.actualizarPromedio(alumnos, sc);
                    break;
                case 4:
                    service.baja(alumnos, sc);
                    break;
                case 5:
                    service.listarActivos(alumnos);
                    break;
                case 6:
                    service.reportes(alumnos);
                    break;
                case 0:
                    break;
                default:

                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);

    }
}
