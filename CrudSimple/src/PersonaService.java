import java.util.Scanner;

public class PersonaService {

    public void alta(Persona[] personas, Scanner sc){

        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del nuevo usuario");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");

            return;
        }
        if(verificarId(id, personas)){
            System.out.println("Ese id existe");
            sc.next();
            return;
        }

        System.out.println("Ingresa el nombre del nuevo usuario");
        sc.nextLine();
        String name = sc.nextLine();
        if(name.isBlank()){
            System.out.println("No se admite valores vacios");
            return;
        }

        int indiceInsercion= obtenerIndice(personas);
        if(indiceInsercion==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Persona persona1= new Persona(id, name);
        personas[indiceInsercion] = persona1;

        for (Persona persona : personas) {
            System.out.println("________");
            System.out.println(persona);
        }



    }

    public void buscarPorId(Persona[] personas, Scanner sc){
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Dame ID a buscar");
        for(Persona persona: personas){
            if(persona!=null&& persona.isActive()){
                System.out.println(persona);
                return;
            }
        }
    }

    public void bajaLogicaId(Persona[] personas, Scanner sc){
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Baja logíca dame el ID");
        for(Persona persona: personas){
            if(persona!=null&& persona.isActive()){
                System.out.println(persona);
                return;
            }
        }
    }

    




    public boolean verificarId(int id, Persona[] personas){

        for (Persona persona : personas) {
            if(persona!=null && persona.getId()==id) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Persona[] personas){

        for (int i = 0; i < personas.length; i++) {
            if(personas[i]==null){
                return i;
            }
        }
        return -1;
    }

}
