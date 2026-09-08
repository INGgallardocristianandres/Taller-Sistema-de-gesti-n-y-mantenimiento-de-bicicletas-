package co.edu.uniquindio.poo.tallerbicicletas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controlador para la pantalla principal del taller de bicicletas.
 *
 * @author Cristian
 */
public class MainViewController {

    @FXML
    private Button btnModuloClientes;

    @FXML
    private Button btnModuloMecanicos;

    @FXML
    private Button btnModuloRepuestos;

    @FXML
    void onAbrirClientes(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/tallerbicicletas/ClienteView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestión de Clientes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista ClienteView.fxml: " + e.getMessage());
        }
    }

    @FXML
    void onAbrirMecanicos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/tallerbicicletas/MecanicoView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestión de Mecánicos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista MecanicoView.fxml: " + e.getMessage());
        }
    }

    @FXML
    void onAbrirRepuestos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/tallerbicicletas/RepuestoView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestión de Repuestos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista RepuestoView.fxml: " + e.getMessage());
        }
    }
}