module com.example.proekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proekt to javafx.fxml;
    exports com.example.proekt;
}