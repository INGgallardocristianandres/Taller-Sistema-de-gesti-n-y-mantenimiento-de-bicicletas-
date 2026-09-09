package co.edu.uniquindio.poo.tallerbicicletas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrdenServicioTest {

    private OrdenServicio orden;
    private Cliente cliente;
    private Mecanico mecanico;
    private Bicicleta bicicleta;
    private Repuesto repuesto1;
    private Repuesto repuesto2;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("1098765432", "Carlos Pérez", "3101234567", "carlos@email.com");
        mecanico = new Mecanico("11223344", "Juan Rodallega", Especialidad.FRENOS_Y_TRANSMISION, "10001");
        TipoBicicleta tipoBici = TipoBicicleta.values().length > 0 ? TipoBicicleta.values()[0] : null;
        bicicleta = new Bicicleta("SERIAL-999", "Trek", tipoBici, "Negro/Verde", 2023, cliente);
        orden = new OrdenServicio("ORD-001", LocalDate.now(), bicicleta, mecanico, "Mantenimiento General", 50000.0);
        repuesto1 = new Repuesto("REP-01", "Pastillas de Freno", 25000.0, 10, 2);
        repuesto2 = new Repuesto("REP-02", "Cadena 11v", 80000.0, 5, 1);
    }

    @Test
    @DisplayName("Prueba 1: Verificar que un repuesto se agregue correctamente a la orden")
    void agregarRepuesto() {
        assertEquals(0, orden.getRepuestosUtilizados().size(), "La lista de repuestos debe iniciar vacía");
        orden.getRepuestosUtilizados().add(repuesto1);
        assertEquals(1, orden.getRepuestosUtilizados().size(), "Debe haber 1 repuesto agregado en la orden");
        assertTrue(orden.getRepuestosUtilizados().contains(repuesto1), "El repuesto agregado debe estar en la lista");
    }

    @Test
    @DisplayName("Prueba 2: Calcular costo total (Mano de Obra + Repuestos)")
    void calcularCostoTotal() {

        orden.getRepuestosUtilizados().add(repuesto1);
        orden.getRepuestosUtilizados().add(repuesto2);

        double costoEsperado = 50000.0 + 25000.0 + 80000.0;
        double costoTotalCalculado = orden.calcularCostoTotal();


        assertEquals(costoEsperado, costoTotalCalculado, "El costo total debe ser la suma de mano de obra y repuestos");
    }
}