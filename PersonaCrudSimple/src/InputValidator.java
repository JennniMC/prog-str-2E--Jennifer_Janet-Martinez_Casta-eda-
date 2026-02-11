import java.util.Scanner;

public class InputValidator {

    public int getValidInt(Scanner sc, String msg){
        while(true){
            try {
                System.out.println(msg);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("El valor no es numerico");
                sc.next();
            }
        }
    }
}