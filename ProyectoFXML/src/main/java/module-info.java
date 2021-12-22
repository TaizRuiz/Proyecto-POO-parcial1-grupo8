module com.mycompany.ejemplofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.ejemplofx to javafx.fxml;
    exports com.mycompany.ejemplofx;
}
