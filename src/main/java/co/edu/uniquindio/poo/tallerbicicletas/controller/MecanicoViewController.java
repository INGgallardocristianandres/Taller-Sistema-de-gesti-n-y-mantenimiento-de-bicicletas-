package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.Especialidad;
import co.edu.uniquindio.poo.tallerbicicletas.model.Mecanico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MecanicoViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtNumeroCertificado;
    @FXML private ComboBox<Especialidad> cbEspecialidad;

    @FXML private TableView<Mecanico> tblMecanicos;
    @FXML private TableColumn<Mecanico, String> colId;
    @FXML private TableColumn<Mecanico, String> colNombre;
    @FXML private TableColumn<Mecanico, String> colNumeroCertificado;
    @FXML private TableColumn<Mecanico, Especialidad> colEspecialidad;

    private ObservableList<Mecanico> listaMecanicos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Cargar las opciones del enum Especialidad en el ComboBox
        cbEspecialidad.setItems(FXCollections.observableArrayList(Especialidad.values()));

        // Enlazar columnas de la tabla con los atributos reales de Mecanico
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNumeroCertificado.setCellValueFactory(new PropertyValueFactory<>("numeroCertificado"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));

        tblMecanicos.setItems(listaMecanicos);
    }

    @FXML
    void onAgregarMecanico(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String numeroCertificado = txtNumeroCertificado.getText();
        Especialidad especialidad = cbEspecialidad.getValue();

        if (id.isEmpty() || nombre.isEmpty() || numeroCertificado.isEmpty() || especialidad == null) {
            mostrarAlerta("Error", "Campos obligatorios", "Por favor complete todos los campos requeridos.");
            return;
        }

        Mecanico nuevoMecanico = new Mecanico(id, nombre, especialidad, numeroCertificado);
        listaMecanicos.add(nuevoMecanico);

        limpiarCampos();
        mostrarAlerta("Éxito", "Mecánico Registrado", "El mecánico fue registrado correctamente.");
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) txtId.getScene().getWindow();
        stage.close();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtNumeroCertificado.clear();
        cbEspecialidad.setValue(null);
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}