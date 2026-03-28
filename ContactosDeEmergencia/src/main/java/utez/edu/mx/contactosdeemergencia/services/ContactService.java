package utez.edu.mx.contactosdeemergencia.services;

import utez.edu.mx.contactosdeemergencia.model.Contacto;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contacto> listContacts = new ArrayList<>();


    public List<Contacto> getAllContacts() {
        return listContacts;
    }


    public void addContact(Contacto contacto) {
        listContacts.add(contacto);
    }


    public Contacto searchByName(String name) {
        for (Contacto c : listContacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }


    public boolean deleteContact(String name) {
        Contacto c = searchByName(name);
        if (c != null) {
            return listContacts.remove(c);
        }
        return false;
    }


}