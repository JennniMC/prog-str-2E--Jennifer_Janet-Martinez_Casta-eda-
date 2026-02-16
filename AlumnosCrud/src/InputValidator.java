import java.util.Scanner;
public class InputValidator {
    public int getValidInt(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.println(msg);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("El valor no es numerico");
                sc.next();
            }
        }
    }

    public static boolean idExiste(Alumno[] alumnos, int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

}
