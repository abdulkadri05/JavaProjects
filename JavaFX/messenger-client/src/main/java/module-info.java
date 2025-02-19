module com.example.messengerclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.messengerclient to javafx.fxml;
    exports com.example.messengerclient;
}