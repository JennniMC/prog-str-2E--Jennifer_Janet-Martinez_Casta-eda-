package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    //instancia
    PersonFileRepository repo=new PersonFileRepository();
    //Logíca de negocio (logica)

    public List<String> loadDataForListView() throws IOException {
        List<String> lines= repo.readAllLines();
        List<String>  result = new ArrayList<>();
        for(String line: lines){
            //validar linea vacia, no se procesan
            if(line==null || line.isBlank()) continue;
            String[] parts = line.split(",");
            if (parts.length >= 3) {
            String name= parts[0];
            String email=parts[1];
            String edad=parts[2];
            result.add(name+" - "+email+" - "+edad);
}
        }
        return result;
    }

    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        if(index<0){
            throw new IllegalArgumentException("El indice es invalido");
        }
        List<String> data=getCleanLines(); //Actualizar
        data.set(index, name + " , "+email+ " , "+edad);
        repo.saveFile(data); //Poner información al archivo
    }
    public void removePerson(int index) throws IOException {
        if(index < 0){
            throw new IllegalArgumentException("El índice es inválido");
        }

        List<String> data = getCleanLines();
        data.remove(index); // eliminar
        repo.saveFile(data); // guarda cambios
    }

    private List<String> getCleanLines() throws IOException {
        List<String> lines= repo.readAllLines();
        List<String> cleanLines = new  ArrayList<>();
        for(String line : lines){
            if(line!=null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }


    public void addPerson(String name, String email, String edad) throws IOException{
        validate(name, email, edad);
        repo.appendNewLine(name+" , "+email+" , "+edad);
    }
    private void validate(String name, String email, String edad){
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");

        }
        String em =(email==null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es incorrecto");
        }
        try {
            int ed=  Integer.parseInt(edad.trim());
            if(ed<18){
                throw new IllegalArgumentException("Persona no permitida tiene que ser mayor a 18 años");

            }
            if(ed<0 || ed>120) {
                throw new IllegalArgumentException("Ingrese una edad valida");
            }

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Número NO válido.");
        }

        }

    }

