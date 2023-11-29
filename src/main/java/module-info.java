module com.example.javafx_foodrecommandation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_foodrecommandation to javafx.fxml;
    exports com.example.javafx_foodrecommandation;
    exports com.example.javafx_foodrecommandation.presentation;
    opens com.example.javafx_foodrecommandation.presentation to javafx.fxml;
}