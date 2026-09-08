package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ClienteViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDireccion;

    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colId;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colDireccion;

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));


        tblClientes.setItems(listaClientes);
    }

    @FXML
    void onAgregarCliente(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarAlerta("Error", "Campos obligatorios", "Por favor ingrese al menos ID y Nombre.");
            return;
        }

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, direccion);
        listaClientes.add(nuevoCliente);

        limpiarCampos();
        mostrarAlerta("Éxito", "Cliente Registrado", "El cliente fue agregado correctamente.");
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) txtId.getScene().getWindow();
        stage.close();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtDireccion.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}