package co.edu.uniquindio.poo.tallerbicicletas.controller;

import co.edu.uniquindio.poo.tallerbicicletas.model.Bicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.model.Mecanico;
import co.edu.uniquindio.poo.tallerbicicletas.model.OrdenServicio;
import co.edu.uniquindio.poo.tallerbicicletas.model.TallerBicicletas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

/**
 * Controller encargado de gestionar la interfaz gráfica
 * correspondiente al registro de órdenes de servicio.
 *
 * <p><b>Principio SOLID aplicado:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b>
 *   El controller se encarga únicamente de gestionar los
 *   eventos y datos de la interfaz de órdenes de servicio.</li>
 * </ul>
 */
public class OrdenServicioController {

    @FXML
    private TextField txtId;

    @FXML
    private DatePicker dpFechaIngreso;

    @FXML
    private ComboBox<Bicicleta> cbBicicleta;

    @FXML
    private ComboBox<Mecanico> cbMecanico;

    @FXML
    private TextArea txtMotivo;

    @FXML
    private TextField txtCostoManoObra;

    private TallerBicicletas taller;

    /**
     * Inicializa el controller.
     */
    @FXML
    public void initialize() {
        dpFechaIngreso.setValue(LocalDate.now());
    }

    /**
     * Permite establecer el taller que será utilizado
     * para registrar la orden de servicio.
     *
     * @param taller Taller de bicicletas.
     */
    public void setTaller(TallerBicicletas taller) {
        this.taller = taller;
        cargarBicicletas();
        cargarMecanicos();
    }

    /**
     * Carga las bicicletas registradas en el ComboBox.
     */
    private void cargarBicicletas() {
        if (taller != null) {
            cbBicicleta.setItems(
                    FXCollections.observableArrayList(
                            taller.getBicicletas()
                    )
            );
        }
    }

    /**
     * Carga los mecánicos registrados en el ComboBox.
     */
    private void cargarMecanicos() {
        if (taller != null) {
            cbMecanico.setItems(
                    FXCollections.observableArrayList(
                            taller.getPersonas()
                                    .stream()
                                    .filter(persona -> persona instanceof Mecanico)
                                    .map(persona -> (Mecanico) persona)
                                    .toList()
                    )
            );
        }
    }

    /**
     * Registra una nueva orden de servicio.
     */
    @FXML
    private void registrarOrden() {

        if (taller == null) {
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No se ha configurado el taller."
            );
            return;
        }

        if (txtId.getText().isBlank()
                || dpFechaIngreso.getValue() == null
                || cbBicicleta.getValue() == null
                || cbMecanico.getValue() == null
                || txtMotivo.getText().isBlank()
                || txtCostoManoObra.getText().isBlank()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Datos incompletos",
                    "Por favor, complete todos los campos."
            );
            return;
        }

        try {

            double costoManoObra =
                    Double.parseDouble(txtCostoManoObra.getText());

            OrdenServicio ordenServicio = new OrdenServicio(
                    txtId.getText(),
                    dpFechaIngreso.getValue(),
                    cbBicicleta.getValue(),
                    cbMecanico.getValue(),
                    txtMotivo.getText(),
                    costoManoObra
            );

            taller.getOrdenes().add(ordenServicio);

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Orden registrada",
                    "La orden de servicio se registró correctamente."
            );

            limpiarCampos();

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Costo inválido",
                    "El costo de mano de obra debe ser un número."
            );
        }
    }

    /**
     * Limpia los campos de la interfaz.
     */
    private void limpiarCampos() {
        txtId.clear();
        dpFechaIngreso.setValue(LocalDate.now());
        cbBicicleta.getSelectionModel().clearSelection();
        cbMecanico.getSelectionModel().clearSelection();
        txtMotivo.clear();
        txtCostoManoObra.clear();
    }

    /**
     * Muestra una alerta al usuario.
     *
     * @param tipo Tipo de alerta.
     * @param titulo Título de la alerta.
     * @param mensaje Mensaje que se mostrará.
     */
    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
