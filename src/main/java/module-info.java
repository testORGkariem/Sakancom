module com.example.sakancom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sakancom to javafx.fxml;
    exports com.example.sakancom;
}