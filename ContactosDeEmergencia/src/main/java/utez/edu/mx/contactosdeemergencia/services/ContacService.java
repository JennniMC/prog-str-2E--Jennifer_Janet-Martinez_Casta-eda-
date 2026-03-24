package utez.edu.mx.contactosdeemergencia.services;

import utez.edu.mx.contactosdeemergencia.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContacService {
    private List<Contacto> listContacts = new ArrayList<>();
    public List<Contacto> getAllContacts(){
        return listContacts;
    }
    public void addContact(Contacto contacto){
        listContacts.add(contacto);
    }
}
