import java.util.Scanner;
public class ActividadSwitchCalculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        double a=0;
        double b=0;
        System.out.println(">>>>>>>CALCULADORA<<<<<<<<");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("opción: ");
        opcion=sc.nextInt();
        // Pedir valores
        if (opcion< 1 || opcion >4) {
            System.out.println("Opción inválida");
        } else {

            double resultados;
            // opcion operación
            switch (opcion) {
                case 1:
                    System.out.println("Opción 1 : Suma");
                    System.out.print("Dame el valor de a: ");
                     a = sc.nextDouble();
                    System.out.print("Dame el valor de b: ");
                     b = sc.nextDouble();
                    resultados = a + b;
                    System.out.println(" Valor a = " + a + ", Valor b = " + b);
                    System.out.println("Resultado: " + resultados);
                    break;

                case 2:
                    System.out.println("Opción 2: Resta");
                    System.out.print("Dame el valor de a: ");
                     a = sc.nextDouble();
                    System.out.print("Dame el valor de b: ");
                     b = sc.nextDouble();
                    resultados = a - b;

                    System.out.println(" a = " + a + ", b = " + b);
                    System.out.println("Resultado: " + resultados);
                    break;

                case 3:
                    System.out.println("Opción 3: Multiplicación");
                    System.out.print("Dame el valor de a: ");
                    a = sc.nextDouble();
                    System.out.print("Dame el valor de b: ");
                    b = sc.nextDouble();
                    resultados = a * b;
                    System.out.println(" Valor a = " + a + ", Valor  b = " + b);
                    System.out.println("Resultado: " + resultados);
                    break;

                case 4:
                    System.out.println("Opción 4 : División");
                    System.out.print("Dame el valor de a: ");
                    a = sc.nextDouble();
                    System.out.print("Dame el valor de b: ");
                    b = sc.nextDouble();
                    System.out.println(" Valor a = " + a + ", valor b = " + b);
                    if (b == 0) {
                        System.out.println("No se puede dividir entre cero (n/0) ");
                    } else {
                        resultados = a / b;
                        System.out.println("Resultado : " + resultados);
                    }
                    break;


            }
        }

        sc.close();
    }
}
