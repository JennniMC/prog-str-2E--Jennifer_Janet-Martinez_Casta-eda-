package com.example.logindashboardfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label mesage;
    @FXML
    private TextField usuariotext;
    @FXML
    private TextField correotext;
    @FXML
    private PasswordField password;
    @FXML
    private Label Bienvenidolbl;

    @FXML
    protected void onSesion() {
        String user = usuariotext.getText();
        String correo = correotext.getText();
        String pass = password.getText();
        //Validar
        if (user.isEmpty() || user.length() < 4) {
            mesage.setText("!Error! en user por favor escribe almenos 4 letras!");
        } else if (!correo.contains("@") || !correo.contains(".")) {
            mesage.setText("!Error! en correo escriba un correo valido");
        } else if (pass.length() < 6) {
            mesage.setText("!Error! de password Escriba almenos 6 letras");
        } else {
            // SI TODO ESTÁ BIEN, CAMBIAMOS DE PANTALLA
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
                Parent root = loader.load();
                DashboardController dashboardControl = loader.getController();
                dashboardControl.setUsuario(user);


                Stage stage = (Stage) usuariotext.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();



            } catch (IOException e) {
                mesage.setText("Error al cargar la siguiente pantalla");
                e.printStackTrace();
            }

        }
    }
}