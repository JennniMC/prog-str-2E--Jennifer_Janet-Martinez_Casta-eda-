import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int intentos = 0;
        double dato1;
        double resultado;
        int celcius= 0, farenheit = 0, km = 0, millas = 0;
        int total = 0;

        do {
            System.out.println("Elige una de las siguientes opciones");
            System.out.println(">>>>> MENÚ DE CONVERSIONES<<<<<<");
            System.out.println("1: °C a °F");
            System.out.println("2: °F a °C");
            System.out.println("3: Km a Millas");
            System.out.println("4: Millas a Km");
            System.out.println("5: Salir");

            opcion = OpcionValida(sc);

            //salir del ciclo
            if (opcion == 5) {
                System.out.println("Estas saliendo del programa :)");
                break;
            }

            System.out.print("Ingresa el valor a convertir: ");
            dato1 = ValidarNumero(sc);

            switch (opcion) {
                case 1:
                    resultado = (dato1 * 9 / 5) + 32;
                    System.out.println(dato1 + " °C = " + resultado + " °F");
                    celcius++;
                    total++;
                    break;

                case 2:
                    resultado = (dato1 - 32) * 5 / 9;
                    System.out.println(dato1 + " °F = " + resultado + " °C");
                    farenheit++;
                    total++;
                    break;

                case 3:
                    resultado = dato1 * 0.621371;
                    System.out.println(dato1 + " Km = " + resultado + " Millas");
                    km++;
                    total++;
                    break;

                case 4:
                    resultado = dato1 / 0.621371;
                    System.out.println(dato1 + " Millas = " + resultado + " Km");
                    millas++;
                    total++;
                    break;
            }

        } while (true);

        System.out.println("\n>>>>>RESULTADOS<<<<<");
        System.out.println("ELTotal de todas las conversiones: " + total);
        System.out.println("La cantidad de intendos de °C a °F fue: " + celcius);
        System.out.println("La cantidad de intentos de °F a °C fue: " + farenheit);
        System.out.println(" La cantidad de intentos de Km a Millas fue: " + km);
        System.out.println("La cantidad de intentos de Millas a Km fue: " + millas);
    }

    //  ahora devuelve double
    public static double ValidarNumero(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("No ingresaste un número, porfavor ingrasa un número valido: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    public static int OpcionValida(Scanner sc) {
        int opcion;
        while (!sc.hasNextInt()) {
            System.out.print("Los datos ingresados No son números , porfavor ngresa ingresa un número entre 1 y 5: ");
            sc.next();
        }
        opcion = sc.nextInt();

        while (opcion < 1 || opcion > 5) {
            System.out.print("Opción fuera de rango. Ingresa un número entre 1 y 5: ");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            opcion = sc.nextInt();
        }
        return opcion;
    }
}