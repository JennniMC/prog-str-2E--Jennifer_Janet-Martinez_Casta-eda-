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
            if (persona != null) {
                System.out.println(persona);
            }
        }




    }

    public void buscarPorId(Persona[] personas, Scanner sc){
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Dame ID a buscar");

        for(Persona persona : personas){
            if(persona != null && persona.getId() == id && persona.isActive()){
                System.out.println(persona);
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva");
    }


    public void bajaLogicaId(Persona[] personas, Scanner sc){
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Baja lógica, Dame el ID a bajar");

        for(Persona persona : personas){
            if(persona != null && persona.getId() == id && persona.isActive()){
                persona.setActive(false);
                System.out.println("Persona ya esta Dada de baja");
                return;
            }
        }
        System.out.println("Persona  inactiva");
    }

    public void listarActivas(Persona[] personas){
        System.out.println("**** Personas activas ****");
        for(Persona persona : personas){
            if(persona != null && persona.isActive()){
                System.out.println(persona);
            }
        }
    }

    public void actualizarNombrePorId(Persona[] personas, Scanner sc){
        InputValidator input = new InputValidator();
        int id = input.getValidInt(sc, "Dame el Id Para poder actualizar");

        for(Persona persona : personas){
            if(persona != null && persona.getId() == id && persona.isActive()){
                sc.nextLine();
                System.out.println("¿cuál sera el Nuevo nombre? :");
                String nuevoNombre = sc.nextLine();

                if(nuevoNombre.isBlank()){
                    System.out.println("El nombre no puede estar vacío");
                    return;
                }

                persona.setName(nuevoNombre);
                System.out.println("Nombre ha sido actualizado");
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva");
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
