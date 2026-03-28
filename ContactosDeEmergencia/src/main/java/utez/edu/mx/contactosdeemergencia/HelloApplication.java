package utez.edu.mx.contactosdeemergencia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/utez/edu/mx/contactosdeemergencia/Views/contact-view.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Contactos de Emergencia");
        stage.setScene(scene);
        stage.show();
    }
}