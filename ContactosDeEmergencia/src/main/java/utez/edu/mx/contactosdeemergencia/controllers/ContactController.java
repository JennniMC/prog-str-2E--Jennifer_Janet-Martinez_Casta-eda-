package utez.edu.mx.contactosdeemergencia.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import utez.edu.mx.contactosdeemergencia.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactController {
    private String[] arrParentescos={"Padre"+
    "Madre\n"+
    "Hermano\n"+
    "Abuelo\n"+
    "Abuela\n"+
    "Tio\n"+
    "Tia\n"};
    @FXML
    private ComboBox<String> cbParentesco;
    private ObservableList<String> listObservableParent= FXCollections.observableArrayList();
    @FXML
    public void initialize(){
        listObservableParent.setAll(arrParentescos);
        cbParentesco.setItems(listObservableParent);
    }
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTel;
    @FXML
    private ListView<Contacto> listViewContacts;
    private ObservableList<Contacto> contactoObservableList =FXCollections.observableArrayList();

    private ContactService service = new CotactService();
    @FXML
    public void onAddContact(){
        String name= txtName.getText().trim();
        String tel= txtTel.getText().trim();
        String parent= cbParentesco.getValue();
        Contacto contact = new Contacto(name, tel, parent);
        service.addContact(contact);
        listObservableContacts.setAll(service.getAllContacts);
        System.out.println(service.getAllContacts());

    }
}
