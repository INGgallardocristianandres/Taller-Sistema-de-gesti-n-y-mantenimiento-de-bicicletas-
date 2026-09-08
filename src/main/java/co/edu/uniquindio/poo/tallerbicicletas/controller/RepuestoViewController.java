package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.Repuesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RepuestoViewController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStockActual;
    @FXML private TextField txtStockMinimo;

    @FXML private TableView<Repuesto> tblRepuestos;
    @FXML private TableColumn<Repuesto, String> colCodigo;
    @FXML private TableColumn<Repuesto, String> colNombre;
    @FXML private TableColumn<Repuesto, Double> colPrecio;
    @FXML private TableColumn<Repuesto, Integer> colStockActual;
    @FXML private TableColumn<Repuesto, Integer> colStockMinimo;

    private ObservableList<Repuesto> listaRepuestos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Mapeo exacto con los nombres de atributos de la clase Repuesto
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStockActual.setCellValueFactory(new PropertyValueFactory<>("stockActual"));
        colStockMinimo.setCellValueFactory(new PropertyValueFactory<>("stockMinimo"));

        tblRepuestos.setItems(listaRepuestos);
    }

    @FXML
    void onAgregarRepuesto(ActionEvent event) {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String precioStr = txtPrecio.getText();
        String stockActualStr = txtStockActual.getText();
        String stockMinimoStr = txtStockMinimo.getText();

        if (codigo.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || stockActualStr.isEmpty() || stockMinimoStr.isEmpty()) {
            mostrarAlerta("Error", "Campos incompletos", "Por favor complete todos los campos requeridos.");
            return;
        }

        try {
            double precio = Double.parseDouble(precioStr);
            int stockActual = Integer.parseInt(stockActualStr);
            int stockMinimo = Integer.parseInt(stockMinimoStr);

            // Llamada correcta al constructor de Repuesto con 5 parámetros
            Repuesto nuevoRepuesto = new Repuesto(codigo, nombre, precio, stockActual, stockMinimo);
            listaRepuestos.add(nuevoRepuesto);

            limpiarCampos();
            mostrarAlerta("Éxito", "Repuesto Registrado", "El repuesto fue agregado al inventario.");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de Formato", "Datos no válidos", "El precio debe ser un número (ej. 15000.0) y los stocks deben ser números enteros.");
        }
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStockActual.clear();
        txtStockMinimo.clear();
    }

    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}