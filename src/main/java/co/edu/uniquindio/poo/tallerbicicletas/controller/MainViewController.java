package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.TallerBicicletas;
import co.edu.uniquindio.poo.tallerbicicletas.controller.OrdenServicioViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainViewController {

    @FXML private Button btnModuloClientes;
    @FXML private Button btnModuloBicicletas;
    @FXML private Button btnModuloMecanicos;
    @FXML private Button btnModuloRepuestos;
    @FXML private Button btnModuloOrdenes;
    @FXML private Button btnModuloConsultas;
    @FXML private Button btnModuloAlertas;

    // Se corrige el constructor: TallerBicicletas() no recibe parámetros
    private TallerBicicletas taller = new TallerBicicletas();

    public void setTaller(TallerBicicletas taller) {
        if (taller != null) {
            this.taller = taller;
        }
    }

    @FXML
    void onAbrirClientes(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/poo/tallerbicicletas/ClienteView.fxml", "Gestión de Clientes");
    }

    @FXML
    void onAbrirBicicletas(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/poo/tallerbicicletas/BicicletaView.fxml", "Gestión de Bicicletas");
    }

    @FXML
    void onAbrirMecanicos(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/poo/tallerbicicletas/MecanicoView.fxml", "Gestión de Mecánicos");
    }

    @FXML
    void onAbrirRepuestos(ActionEvent event) {
        abrirVentana("/co/edu/uniquindio/poo/tallerbicicletas/RepuestoView.fxml", "Gestión de Repuestos");
    }

    @FXML
    void onAbrirOrdenServicio(ActionEvent event) {
        abrirVentanaConTaller("/co/edu/uniquindio/poo/tallerbicicletas/OrdenServicioView.fxml", "Crear Orden de Servicio");
    }

    @FXML
    void onAbrirConsultas(ActionEvent event) {
        abrirVentanaConTaller("/co/edu/uniquindio/poo/tallerbicicletas/ConsultaView.fxml", "Consultas e Historial");
    }

    @FXML
    void onAbrirAlertasStock(ActionEvent event) {
        abrirVentanaConTaller("/co/edu/uniquindio/poo/tallerbicicletas/AlertasStock.fxml", "Alertas de Inventario");
    }

    private void abrirVentana(String fxmlPath, String titulo) {
        try {
            URL location = getClass().getResource(fxmlPath);
            if (location == null) {
                System.err.println("No se encontró el archivo FXML: " + fxmlPath);
                return;
            }
            FXMLLoader loader = new FXMLLoader(location);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirVentanaConTaller(String fxmlPath, String titulo) {
        try {
            URL location = getClass().getResource(fxmlPath);
            if (location == null) {
                System.err.println("No se encontró el archivo FXML: " + fxmlPath);
                return;
            }
            FXMLLoader loader = new FXMLLoader(location);
            Parent root = loader.load();

            Object controller = loader.getController();
            if (controller instanceof OrdenServicioViewController) {
                ((OrdenServicioViewController) controller).setTaller(taller);
            }

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}