package com.example.logindashboardfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label Bienvenidolbl;

    public void setUsuario(String user) {
        Bienvenidolbl.setText("Bienvenid@ " + user);
    }
}