package utez.edu.mx.contactosdeemergencia.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import utez.edu.mx.contactosdeemergencia.model.Contacto;
import utez.edu.mx.contactosdeemergencia.services.ContactService;

public class ContactController {


    private String[] arrParentescos = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tio", "Tia"};

    @FXML private ComboBox<String> cbParentesco;
    @FXML private TextField txtName;
    @FXML private TextField txtTel;
    @FXML private ListView<Contacto> listViewContacts;

    private ContactService service = new ContactService();

    @FXML
    public void initialize() {

        cbParentesco.setItems(FXCollections.observableArrayList(arrParentescos));
    }


    @FXML
    public void onAddContact() {
        String name = txtName.getText().trim();
        String tel = txtTel.getText().trim();
        String parent = cbParentesco.getValue();

        if (name.isEmpty() || tel.isEmpty() || parent == null) {
            showAlert("Error", "Complete todos los campos.");
            return;
        }

        if (tel.length() != 10 || !tel.matches("\\d+")) {
            showAlert("Error", "El teléfono debe tener  10 números.");
            return;
        }

        if (service.searchByName(name) != null) {
            showAlert("Error", "Ya existe un contacto con ese nombre.");
            return;
        }

        Contacto contact = new Contacto(name, tel, parent);
        service.addContact(contact);

        updateUI();
        onClear();
    }


    @FXML
    public void onSearch() {
        String nameToSearch = txtName.getText().trim();
        if (nameToSearch.isEmpty()) {
            showAlert("Error", "Escribe un nombre para buscar.");
            return;
        }

        Contacto encontrado = service.searchByName(nameToSearch);
        if (encontrado != null) {
            txtTel.setText(encontrado.getTel());
            cbParentesco.setValue(encontrado.getParent());
        } else {
            showAlert("No encontrado", "El contacto '" + nameToSearch + "' no existe.");
        }
    }


    @FXML
    public void onUpdate() {
        String name = txtName.getText().trim();
        String newTel = txtTel.getText().trim();
        String newParent = cbParentesco.getValue();

        Contacto c = service.searchByName(name);

        if (c != null) {
            if (newTel.length() == 10 && newTel.matches("\\d+")) {

                service.deleteContact(name);
                service.addContact(new Contacto(name, newTel, newParent));

                updateUI();
                showAlert("Éxito", "Contacto actualizado.");
            } else {
                showAlert("Error", "El teléfono debe tener 10 dígitos.");
            }
        } else {
            showAlert("Error", "El contacto que no existe.");
        }
    }


    @FXML
    public void onDelete() {
        String name = txtName.getText().trim();
        if (service.deleteContact(name)) {
            updateUI();
            onClear();
            showAlert("Éxito", "El Contacto a sido eliminado.");
        } else {
            showAlert("Error", "contacto NO  encontrado para eliminar.");
        }
    }


    @FXML
    public void onClear() {
        txtName.clear();
        txtTel.clear();
        cbParentesco.getSelectionModel().clearSelection();
    }


    private void updateUI() {
        listViewContacts.getItems().setAll(service.getAllContacts());
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}