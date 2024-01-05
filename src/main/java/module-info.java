module com.pjonas.loginapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;
    requires mysql.connector.j;

    opens com.pjonas.loginapp to javafx.fxml;
    exports com.pjonas.loginapp;
}