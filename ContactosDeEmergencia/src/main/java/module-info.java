module utez.edu.mx.contactosdeemergencia {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;


    opens utez.edu.mx.contactosdeemergencia to javafx.fxml;
    opens utez.edu.mx.contactosdeemergencia.controllers to javafx.fxml;
    opens utez.edu.mx.contactosdeemergencia.model to javafx.fxml;


    exports utez.edu.mx.contactosdeemergencia;
    exports utez.edu.mx.contactosdeemergencia.controllers;
    exports utez.edu.mx.contactosdeemergencia.model;
    exports utez.edu.mx.contactosdeemergencia.services;
}