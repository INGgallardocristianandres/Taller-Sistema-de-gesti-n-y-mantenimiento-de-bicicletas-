package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.Bicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.model.Cliente;
import co.edu.uniquindio.poo.tallerbicicletas.model.TipoBicicleta;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BicicletaViewController {

    @FXML private TextField txtSerial;
    @FXML private TextField txtMarca;
    @FXML private ComboBox<TipoBicicleta> cbTipo;
    @FXML private TextField txtColor;
    @FXML private TextField txtAnio;
    @FXML private ComboBox<Cliente> cbPropietario;

    @FXML private TableView<Bicicleta> tblBicicletas;
    @FXML private TableColumn<Bicicleta, String> colSerial;
    @FXML private TableColumn<Bicicleta, String> colMarca;
    @FXML private TableColumn<Bicicleta, TipoBicicleta> colTipo;
    @FXML private TableColumn<Bicicleta, String> colColor; // Se quitó la palabra 'border'
    @FXML private TableColumn<Bicicleta, Integer> colAnio;
    @FXML private TableColumn<Bicicleta, String> colPropietario;

    private ObservableList<Bicicleta> listaBicicletas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cbTipo.setItems(FXCollections.observableArrayList(TipoBicicleta.values()));

        colSerial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colPropietario.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPropietario() != null ? cellData.getValue().getPropietario().getNombre() : "Sin dueño")
        );

        tblBicicletas.setItems(listaBicicletas);
    }

    @FXML
    void onAgregarBicicleta(ActionEvent event) {
        String serial = txtSerial.getText();
        String marca = txtMarca.getText();
        TipoBicicleta tipo = cbTipo.getValue();
        String color = txtColor.getText();
        String anioStr = txtAnio.getText();
        Cliente propietario = cbPropietario.getValue();

        if (serial.isEmpty() || marca.isEmpty() || tipo == null || color.isEmpty() || anioStr.isEmpty()) {
            mostrarAlerta("Error", "Campos Incompletos", "Complete todos los datos de la bicicleta.");
            return;
        }

        try {
            int anio = Integer.parseInt(anioStr);
            Bicicleta nueva = new Bicicleta(serial, marca, tipo, color, anio, propietario);
            listaBicicletas.add(nueva);
            limpiarCampos();
            mostrarAlerta("Éxito", "Bicicleta Registrada", "La bicicleta fue guardada correctamente.");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Formato no válido", "El año debe ser un número entero.");
        }
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) txtSerial.getScene().getWindow();
        stage.close();
    }

    private void limpiarCampos() {
        txtSerial.clear();
        txtMarca.clear();
        cbTipo.setValue(null);
        txtColor.clear();
        txtAnio.clear();
        cbPropietario.setValue(null);
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}