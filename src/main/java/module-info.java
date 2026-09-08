module co.edu.uniquindio.poo.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    exports co.edu.uniquindio.poo.tallerbicicletas;
    opens co.edu.uniquindio.poo.tallerbicicletas to javafx.fxml;


    exports co.edu.uniquindio.poo.tallerbicicletas.controller;
    opens co.edu.uniquindio.poo.tallerbicicletas.controller to javafx.fxml;

    exports co.edu.uniquindio.poo.tallerbicicletas.model;
    opens co.edu.uniquindio.poo.tallerbicicletas.model to javafx.fxml, javafx.base;
}