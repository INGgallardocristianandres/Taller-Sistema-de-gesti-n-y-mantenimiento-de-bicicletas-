package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.Repuesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AlertasStockViewController {

    @FXML private TableView<Repuesto> tblRepuestosStockBajo;
    @FXML private TableColumn<Repuesto, String> colCodigo;
    @FXML private TableColumn<Repuesto, String> colNombre;
    @FXML private TableColumn<Repuesto, Double> colPrecio;
    @FXML private TableColumn<Repuesto, Integer> colStockActual;
    @FXML private TableColumn<Repuesto, Integer> colStockMinimo;

    private ObservableList<Repuesto> listaAlertas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStockActual.setCellValueFactory(new PropertyValueFactory<>("stockActual"));
        colStockMinimo.setCellValueFactory(new PropertyValueFactory<>("stockMinimo"));

        tblRepuestosStockBajo.setItems(listaAlertas);
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) tblRepuestosStockBajo.getScene().getWindow();
        stage.close();
    }
}