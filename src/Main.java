import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int edad=0;

        boolean estudiante= true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame tu edad");
        edad = sc.nextInt();
        if(edad<0 || edad>120){
            System.out.println("Edad inválida");
            return;
        }
        System.out.println("Eres estudiante?");
        estudiante = sc.nextBoolean();
         if (edad<12) {
            System.out.println("Tarifa=50");

        } else if (edad>=12&&edad<=17) {
            if(estudiante){
                System.out.println("Tu edad es: "+edad + " y eres estudiante"+" Tarifa=60");

            }else if (!estudiante){
                System.out.println("Tu edad es:" +edad + " NO y eres estudiante"+" Tarifa=80");
            }

        } else if (edad>=18) {
            if(estudiante){
                System.out.println("Tu edad es: "+edad + " y eres estudiante"+" tarifa=90");

            }else if (!estudiante){
                System.out.println("Tu edad es: "+edad + " y NO eres estudiante"+" Tarifa=120");
            }
        }


    }
}