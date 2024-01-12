module com.example.javafx_foodrecommandation {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;


    opens com.example.javafx_foodrecommandation to javafx.fxml;
    exports com.example.javafx_foodrecommandation;
    exports com.example.javafx_foodrecommandation.presentation;
    exports com.example.javafx_foodrecommandation.dao ;
    opens com.example.javafx_foodrecommandation.presentation to javafx.fxml;
}