module com.example.logindashboardfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.logindashboardfx to javafx.fxml;
    exports com.example.logindashboardfx;
}