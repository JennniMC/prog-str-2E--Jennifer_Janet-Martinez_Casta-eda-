import java.util.Scanner;
public class AlumosService {
    public void alta(Alumno[] alumnos, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Dame el ID: ");
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID invalido");
            return;
        }

        if (InputValidator.idExiste(alumnos, id)) {
            System.out.println("El ID esta  repetido");
            return;
        }


        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.equals("")) {
            System.out.println("Nombre vacio");
            return;
        }

        System.out.print("Dame el Promedio del alumno: ");
        double promedio = sc.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio fuera de rango");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio, true);
                System.out.println("Alumno agregado correctamente");
                break;
            }
        }
    }

    public void buscar(Alumno[] alumnos, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Introduce el ID del alumno: ");
        sc.nextLine();

        for (Alumno i : alumnos) {
            if (i != null && i.getId() == id && i.isActivo()) {
                System.out.println("ID del alumno: " + i.getId());
                System.out.println("Nombre del alumno: " + i.getNombre());
                System.out.println("Promedio: " + i.promedio);
                return;
            }
        }

        System.out.println("Alumno no encontrado o inactivo");
    }

    public void actualizarPromedio(Alumno[] alumnos, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Dame el ID del aulmno a actualizar: ");
        sc.nextLine();
        for (Alumno i : alumnos) {
            if (i != null && i.getId() == id && i.isActivo()) {
                System.out.print("Nuevo promedio: ");
                double nuevo = sc.nextDouble();
                sc.nextLine();

                if (nuevo >= 0 && nuevo <= 10) {
                    i.promedio = nuevo;
                    System.out.println("Promedio actualizado");
                } else {
                    System.out.println("Promedio inválido");
                }
                return;
            }
        }

        System.out.println("Alumno no encontrado");
    }

    public void baja(Alumno[] alumnos, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Dame el ID del alumno para la baja: ");
        sc.nextLine();
        for (Alumno i : alumnos) {
            if (i != null && i.getId() == id && i.isActivo()) {
                i.setActivo(false);
                System.out.println("Alumno dado de baja");
                return;
            }
        }

        System.out.println("Alumno no encontrado");
    }


    public void listarActivos(Alumno[] alumnos) {
        for (Alumno i : alumnos) {
            if (i != null && i.isActivo()) {
                System.out.println(i.getId() + " - " + i.getNombre() + " - " + i.promedio);
            }
        }
    }


    public void reportes(Alumno[] alumnos) {
        double suma = 0;
        int contador = 0;
        Alumno promedioMayor = null;
        Alumno promedioMenor = null;
        int promedioMayor8 = 0;

        for (Alumno i : alumnos) {
            if (i != null && i.isActivo()) {
                suma += i.promedio;
                contador++;

                if (promedioMayor == null || i.promedio > promedioMayor.promedio) promedioMayor = i;
                if (promedioMenor == null || i.promedio < promedioMenor.promedio) promedioMenor = i;
                if (i.promedio >= 8.0) promedioMayor8++;
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        System.out.println("Promedio general de todos los alumnos: " + (suma / contador));
        System.out.println("Promedio Mayor: " + promedioMayor.getId() + " " + promedioMayor.getNombre() + " " + promedioMayor.promedio);
        System.out.println("Promedio Menor: " + promedioMenor.getId() + " " + promedioMenor.getNombre() + " " + promedioMenor.promedio);
        System.out.println("Alumnos con promedio mayor o igual a 8: " + promedioMayor8);

    }
}