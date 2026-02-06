import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pesoKg;
        int distanciaKm;
        int tipoServicio;
        boolean zonaRemota;
        double subtotal;
        double iva;
        double total;

       pesoKg = leerDoubleEnRango(sc,
                "Dame el peso(kg) en un rago de  1 a 50: ", 0.1, 50.0);

       distanciaKm = leerIntEnRango(sc,
                "Dame la distancia en un rango de 1 a 2000 km: ", 1, 2000);

         tipoServicio = leerIntEnRango(sc,
                "Escoja un Tipo de servicio 1._Estándar, 2._Express: ", 1, 2);

        zonaRemota = leerBoolean(sc,
                "Esta es zona remota?, escriba-> (true/false): ");


        ShippingCalculator tikect1 = new ShippingCalculator();
        subtotal = tikect1.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
        iva = tikect1.calcularIVA(subtotal);
       total = tikect1.calcularTotal(subtotal, iva);


       ticketImpreso(pesoKg, distanciaKm, tipoServicio, zonaRemota, subtotal, iva, total);

        sc.close();
    }



    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double dato = 0;
        boolean valido;

        do {
            valido = true;
            System.out.print(msg);

            if (sc.hasNextDouble()) {
                dato = sc.nextDouble();

                if (dato < min || dato > max) {
                    System.out.println("Número fuera del rango permitido.");
                    valido = false;
                }

            } else {
                System.out.println("El dato ingresado No es númerico, solo se permiten números.");
                sc.next(); // descarta la cadena
                valido = false;
            }

        } while (!valido);

        return dato;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int dato = 0;
        boolean valido;

        do {
            valido = true;
            System.out.print(msg);

            if (sc.hasNextInt()) {
                dato = sc.nextInt();

                if (dato < min || dato > max) {
                    System.out.println("Número fuera del rango permitido.");
                    valido = false;
                }

            } else {
                System.out.println("El dato ingresado No es númerico, solo se permiten números.");
                sc.next();
                valido = false;
            }

        } while (!valido);

        return dato;


}

    public static boolean leerBoolean(Scanner sc, String msg) {
        boolean dato;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                dato = sc.nextBoolean();
                break;
            } else {
                sc.next(); // descarta entrada inválida
            }
        }
        return dato;
    }



    public static void ticketImpreso(double pesoKg, int distanciaKm, int tipoServicio,
                                      boolean zonaRemota, double subtotal, double iva, double total) {

        String servicio;

        if (tipoServicio == 1) {
            servicio = "Estándar";
        } else {
            servicio = "Express";
        }

        System.out.println("**********TICKET**********");
        System.out.println("Tipo de servicio: " + servicio);
        System.out.println("Peso(kg): " + pesoKg);
        System.out.println("Distancia(km): " + distanciaKm);
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("********Cuenta**********");
        System.out.println("Su subtotal: "+ subtotal);
        System.out.println("IVA:"+ iva);
        System.out.println("TOTAL a pagar:" + total);
        System.out.println("***********************++*");
    }
}
