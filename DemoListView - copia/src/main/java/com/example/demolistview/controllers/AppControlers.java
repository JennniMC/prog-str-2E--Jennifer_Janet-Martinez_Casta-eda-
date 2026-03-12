package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.Provider;
import java.util.List;

public class AppControlers {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;
    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();
    private PersonService service = new PersonService();
    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }
    @FXML
    public void onReload(){
        loadFromFile();
    }
    @FXML
    public void onAdd(){
        try{
            String name=txtName.getText();
            String email=txtEmail.getText();
            String edad=txtEdad.getText();
            service.addPerson(name, email, edad);
            lblMsg.setText("Persona creada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();

        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");


        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error con los datos "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }

    }

    //metodo para convertir obseravble a string
    private void loadFromFile(){
        //Manejar IOException
        try {
            List<String> items =service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos Cargados con exito");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText("Error al cargar los archivos " +e.getLocalizedMessage());//Mostrar el error
            lblMsg.setStyle("-fx-text-fill: red");

        }

    }
}
