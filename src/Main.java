import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService grade = new GradeService();
        Validator validator = new Validator();

        String name = validator.leerTextoNoVacio(
                sc, "Dame el nombre del alumno:");

        System.out.println("Nombre ingresado: " + name);
        double a=validator.leerDoubleEnRango(
                sc, "Dame la calificación del 1 parcial: ", 0, 100);
        double b = validator.leerDoubleEnRango(
                sc, "Dame la calificación del 2 parcial: ", 0, 100);
        double c =validator.leerDoubleEnRango(
                sc, "Dame la calificación del 3 parcial: ", 0, 100);
        int asistencia = validator.leerIntEnRango(
                sc, "Dame el % de la aistencia total ", 0, 100);

        boolean entregoProyecto = validator.leerBoolean(
                "¿El alumno entrego el proyecto?: true-false: ", sc);
        double promedio = grade.calcularPromedio(a, b, c);
        double caliFinal = grade.calcularFinal(promedio, asistencia);
        String estado = grade.determinarEstado(caliFinal, asistencia, entregoProyecto);

        imprimirReporte(name, a, b, c, promedio, asistencia, entregoProyecto, caliFinal, estado);

        sc.close();

    }
    public static void imprimirReporte(String nombre,
                                       double a, double b, double c,
                                       double promedio,
                                       int asistencia,
                                       boolean entregoProyecto,
                                       double caliFinal,
                                       String estado) {

        System.out.println("****** Datos del Alumno ****");
        System.out.println("Nombre del alumno: " + nombre);
        System.out.println("Calificación por parcial: " + a + ", " + b + ", " + c);
        System.out.println("Promedio: " + promedio);
        System.out.println("Total de Asistencias: " + asistencia + "%");
        System.out.println("¿El alumno entregó proyecto?: " + entregoProyecto);
        System.out.println("Calificación Final: " + caliFinal);
        System.out.println("Estado(Aprovado/Reprobado): " + estado);
    }
}
