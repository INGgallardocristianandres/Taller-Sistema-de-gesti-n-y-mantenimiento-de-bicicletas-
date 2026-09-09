package co.edu.uniquindio.poo.tallerbicicletas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepuestoTest {

    private Repuesto repuestoCritico;
    private Repuesto repuestoNormal;

    @BeforeEach
    void setUp() {
        repuestoCritico = new Repuesto("REP-01", "Pastillas de Freno", 25000, 2, 5);

        repuestoNormal = new Repuesto("REP-02", "Cadena 11", 80000, 10, 3);
    }

    @Test
    @DisplayName("Verificar detección de stock insuficiente")
    void stockInsuficiente() {
        assertTrue(repuestoCritico.stockInsuficiente(), "Debe retornar true si el stock actual es menor o igual al mínimo");
        assertFalse(repuestoNormal.stockInsuficiente(), "Debe retornar false si el stock supera el mínimo");
    }

    @Test
    @DisplayName("Verificar disminución de stock")
    void restarStock() {
        repuestoNormal.restarStock(4);

        assertEquals(6, repuestoNormal.getStockActual(), "El stock debe disminuir a 6 unidades");
    }

    @Test
    @DisplayName("Verificar incremento de stock")
    void aumentarStock() {
        repuestoCritico.aumentarStock(8);
        assertEquals(10, repuestoCritico.getStockActual(), "El stock debe incrementarse a 10 unidades");
    }
}