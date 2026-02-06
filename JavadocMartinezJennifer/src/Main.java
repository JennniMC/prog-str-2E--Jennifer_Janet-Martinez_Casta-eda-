import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(">>>>Menú de Opciones <<<<<");
            System.out.println("OPCION 1. Calcular IMC");
            System.out.println("OPCION 2. Calcular área de un rectángulo");
            System.out.println("OPCION 3. Convertir °C a °F");
            System.out.println("OPCION 4. Calcular área de un círculo");
            System.out.println("OPCION 5. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dame peso en kg: ");
                    double peso = sc.nextDouble();
                    System.out.print("Dame tu estatura en m : ");
                    double estatura = sc.nextDouble();
                    double iMC = obtenerIMC(peso, estatura);
                    System.out.println("Tu IMC es: " + iMC);
                    break;

                case 2:
                    System.out.print("Dame el ancho del rectángulo: ");
                    double ancho = sc.nextDouble();
                    System.out.print("Dame el largo del rectángulo: ");
                    double largo = sc.nextDouble();
                    System.out.println("Área del rectángulo: " + calcularAreaDeRectangulo(ancho, largo));
                    break;

                case 3:
                    System.out.print("Dame la temperatura en °Celsius : ");
                    double tempCelcius = sc.nextDouble();
                    System.out.println("Temperatura en °Fahrenheit es : " + convertirFahrenheit(tempCelcius)+" Grados");
                    break;

                case 4:
                    System.out.print("Dame el radio del círculo: ");
                    double radio = sc.nextDouble();
                    System.out.println("El área del círculo es : " + calcularAreaDeCirculo(radio));
                    break;

                case 5:
                    System.out.println(" El programa ya termino ahora vas a salir :).");
                    break;

                default:
                    System.out.println("Elige una opció valida.");
            }

            System.out.println();

        } while (opcion != 5);

        sc.close();
    }

    /**
     * Indica el IMC con los datos  del peso y la estatura.
     *
     * @param peso Peso en kilogramos
     * @param estatura Altura de la persona en m
     * @return retorna el valor obtenido del IMC
     */
    public static double obtenerIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    /**
     * Calcula el área de un rectángulo con  la formula ancho * largo.
     *
     * @param ancho  ancho del rectángulo
     * @param largo  largo del rectángulo
     * @return retorna el área total del rectángulo
     */
    public static double calcularAreaDeRectangulo(double ancho, double largo) {
        return ancho * largo;
    }

    /**
     * Convierte  grados Celsius a Fahrenheit usando la formula F=(C * 1.8)+32.
     *
     * @param celsius grados Celsius
     * @return equivalente de grados celcius  en grados Fahrenheit
     */
    public static double convertirFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área del circulo con  formula A = πr²
     *
     * @param radio Radio del círculo
     * @return Área calculada del círculo
     */
    public static double calcularAreaDeCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}