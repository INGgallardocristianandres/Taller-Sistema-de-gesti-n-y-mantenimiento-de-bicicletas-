package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.OrdenServicio;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ConsultaViewController {

    @FXML private TextField txtBuscarSerial;
    @FXML private DatePicker dpFechaConsulta;

    @FXML private TableView<OrdenServicio> tblOrdenes;
    @FXML private TableColumn<OrdenServicio, String> colId;
    @FXML private TableColumn<OrdenServicio, LocalDate> colFecha;
    @FXML private TableColumn<OrdenServicio, String> colBicicleta;
    @FXML private TableColumn<OrdenServicio, String> colMecanico;
    @FXML private TableColumn<OrdenServicio, String> colMotivo;

    private ObservableList<OrdenServicio> listaResultado = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        colBicicleta.setCellValueFactory(cell -> new SimpleStringProperty(
                cell.getValue().getBicicleta() != null ? cell.getValue().getBicicleta().getSerial() : "N/A"
        ));
        colMecanico.setCellValueFactory(cell -> new SimpleStringProperty(
                cell.getValue().getMecanico() != null ? cell.getValue().getMecanico().getNombre() : "N/A"
        ));
        colMotivo.setCellValueFactory(new PropertyValueFactory<>("motivo"));

        tblOrdenes.setItems(listaResultado);
    }

    @FXML
    void onBuscarPorSerial(ActionEvent event) {
        String serial = txtBuscarSerial.getText().trim();
        if (serial.isEmpty()) {
            mostrarAlerta("Aviso", "Campo Vacío", "Por favor ingrese el serial de la bicicleta.");
        }
    }

    @FXML
    void onBuscarPorFecha(ActionEvent event) {
        LocalDate fecha = dpFechaConsulta.getValue();
        if (fecha == null) {
            mostrarAlerta("Aviso", "Fecha requerida", "Por favor seleccione una fecha.");
        }
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) txtBuscarSerial.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}