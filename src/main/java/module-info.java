module co.edu.uniquindio.poo.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.poo.tallerbicicletas to javafx.fxml;
    exports co.edu.uniquindio.poo.tallerbicicletas;
}