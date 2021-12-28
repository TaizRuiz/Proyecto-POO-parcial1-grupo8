module com.grupo8p04.proyectofxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.grupo8p04.proyectofxml to javafx.fxml;
    opens modelo.clases;
    exports com.grupo8p04.proyectofxml;
}
