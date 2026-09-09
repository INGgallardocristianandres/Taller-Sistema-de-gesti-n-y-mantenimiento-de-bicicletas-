package co.edu.uniquindio.poo.tallerbicicletas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TallerBicicletasTest {

    private TallerBicicletas taller;
    private Cliente cliente;
    private Mecanico mecanico;
    private Bicicleta bicicleta;
    private Repuesto repuestoBajo;
    private Repuesto repuestoOk;
    private OrdenServicio orden;

    @BeforeEach
    void setUp() {
        taller = new TallerBicicletas();

        cliente = new Cliente("1098765432", "Carlos Pérez", "3101234567", "carlos@email.com");
        Especialidad esp = Especialidad.values().length > 0 ? Especialidad.values()[0] : null;
        mecanico = new Mecanico("11223344", "Juan Rodallega", esp, "10002");
        TipoBicicleta tipoBici = TipoBicicleta.values().length > 0 ? TipoBicicleta.values()[0] : null;
        bicicleta = new Bicicleta("SERIAL-999", "Trek", tipoBici, "Negro/Verde", 2023, cliente);
        repuestoBajo = new Repuesto("REP-01", "Pastillas Freno", 25000.0, 2, 5); // Stock Bajo
        repuestoOk = new Repuesto("REP-02", "Cadena 11v", 80000.0, 10, 3);       // Stock OK
        orden = new OrdenServicio("ORD-001", LocalDate.now(), bicicleta, mecanico, "Mantenimiento General", 50000.0);
    }

    @Test
    @DisplayName("Registrar persona en el taller")
    void registrarPersona() {
        assertEquals(0, taller.getPersonas().size());
        taller.registrarPersona(cliente);
        taller.registrarPersona(mecanico);
        assertEquals(2, taller.getPersonas().size());
        assertTrue(taller.getPersonas().contains(cliente));
    }

    @Test
    @DisplayName("Registrar bicicleta en el taller")
    void registrarBicicleta() {
        assertEquals(0, taller.getBicicletas().size());
        taller.registrarBicicleta(bicicleta);
        assertEquals(1, taller.getBicicletas().size());
        assertEquals("SERIAL-999", taller.getBicicletas().get(0).getSerial());
    }

    @Test
    @DisplayName("Agregar repuesto al inventario")
    void agregarRepuesto() {
        assertEquals(0, taller.getRepuestos().size());
        taller.agregarRepuesto(repuestoOk);
        assertEquals(1, taller.getRepuestos().size());
        assertEquals("REP-02", taller.getRepuestos().get(0).getCodigo());
    }

    @Test
    @DisplayName("Crear y guardar orden de servicio")
    void crearOrden() {
        assertEquals(0, taller.getOrdenes().size());
        taller.crearOrden(orden);
        assertEquals(1, taller.getOrdenes().size());
        assertEquals("ORD-001", taller.getOrdenes().get(0).getId());
    }

    @Test
    @DisplayName("Buscar persona por ID")
    void buscarPersonaPorId() {
        taller.registrarPersona(cliente);
        Persona encontrada = taller.buscarPersonaPorId("1098765432");
        assertNotNull(encontrada);
        assertEquals("Carlos Pérez", encontrada.getNombre());
        Persona noEncontrada = taller.buscarPersonaPorId("999999");
        assertNull(noEncontrada);
    }

    @Test
    @DisplayName("Buscar historial de órdenes por serial de bicicleta")
    void buscarHistorialPorSerial() {
        taller.crearOrden(orden);
        List<OrdenServicio> historial = taller.buscarHistorialPorSerial("SERIAL-999");
        assertEquals(1, historial.size());
        assertEquals("SERIAL-999", historial.get(0).getBicicleta().getSerial());
    }

    @Test
    @DisplayName("Buscar órdenes por fecha de ingreso")
    void buscarOrdenesPorFecha() {
        LocalDate hoy = LocalDate.now();
        taller.crearOrden(orden);
        List<OrdenServicio> ordenesFecha = taller.buscarOrdenesPorFecha(hoy);
        assertFalse(ordenesFecha.isEmpty());
        assertEquals(hoy, ordenesFecha.get(0).getFechaIngreso());
    }

    @Test
    @DisplayName("Obtener lista de repuestos con stock bajo")
    void obtenerRepuestosConStockBajo() {
        taller.agregarRepuesto(repuestoBajo);
        taller.agregarRepuesto(repuestoOk);
        List<Repuesto> conStockBajo = taller.obtenerRepuestosConStockBajo();

        assertEquals(1, conStockBajo.size());
        assertEquals("REP-01", conStockBajo.get(0).getCodigo());
    }
}