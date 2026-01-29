import java.util.Scanner;
//Autor: Jennifer Janet Martinez Castañeda 2E
public class Main {

    public static void main(String[] args) {
        int numero = pedirEntero();
        int resultado = sumarHastaN(numero);
        System.out.println("La suma es: " + resultado);
    }

    public static int pedirEntero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un número sin decimales(entero): ");
        int numero = sc.nextInt();
        sc.close();
        return numero;
    }

    public static int sumarHastaN(int numero) {
        int sumar = 0;

        for (int i = 1; i <= numero; i++) {
            sumar += i;
        }

        return sumar;
    }
}

