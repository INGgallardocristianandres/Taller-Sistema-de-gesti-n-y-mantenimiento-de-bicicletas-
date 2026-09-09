package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal encargada de gestionar la información
 * del taller de bicicletas.
 *
 * <p>Contiene las listas de personas, bicicletas, repuestos
 * y órdenes de servicio registradas en el taller.</p>
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b>
 *   Centraliza la gestión de las colecciones principales
 *   del taller.</li>
 * </ul>
 */
public class TallerBicicletas {

    private List<Persona> personas;
    private List<Bicicleta> bicicletas;
    private List<Repuesto> repuestos;
    private List<OrdenServicio> ordenes;

    /**
     * Constructor del taller.
     *
     * Inicializa las listas que almacenan las personas,
     * bicicletas, repuestos y órdenes de servicio.
     */
    public TallerBicicletas() {
        this.personas = new ArrayList<>();
        this.bicicletas = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.ordenes = new ArrayList<>();
    }

    /**
     * Registra una persona en el taller.
     *
     * @param persona Persona que será registrada.
     */
    public void registrarPersona(Persona persona) {
        if (persona != null) {
            personas.add(persona);
        }
    }

    /**
     * Registra una bicicleta en el taller.
     *
     * @param bicicleta Bicicleta que será registrada.
     */
    public void registrarBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            bicicletas.add(bicicleta);
        }
    }

    /**
     * Registra un nuevo repuesto en el inventario del taller.
     *
     * @param repuesto Repuesto a registrar.
     */
    public void agregarRepuesto(Repuesto repuesto) {
        if (repuesto != null) {
            repuestos.add(repuesto);
        }
    }

    /**
     * Crea y registra una nueva orden de servicio en el taller.
     *
     * @param orden Orden de servicio a registrar.
     */
    public void crearOrden(OrdenServicio orden) {
        if (orden != null) {
            ordenes.add(orden);
        }
    }

    /**
     * Busca una persona (Cliente o Mecánico) por su número de identificación.
     *
     * @param id Identificación de la persona a buscar.
     * @return {@link Persona} encontrada o {@code null} si no existe.
     */
    public Persona buscarPersonaPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        for (Persona persona : personas) {
            if (persona.getId().equalsIgnoreCase(id)) {
                return persona;
            }
        }
        return null;
    }

    /**
     * Obtiene el historial de órdenes asociadas al serial de una bicicleta.
     */
    public List<OrdenServicio> buscarHistorialPorSerial(String serial) {
        List<OrdenServicio> resultado = new ArrayList<>();
        if (serial == null || serial.isBlank()) return resultado;

        for (OrdenServicio orden : ordenes) {
            if (orden.getBicicleta() != null && orden.getBicicleta().getSerial().equalsIgnoreCase(serial)) {
                resultado.add(orden);
            }
        }
        return resultado;
    }

    /**
     * Obtiene las órdenes registradas en una fecha específica.
     */
    public List<OrdenServicio> buscarOrdenesPorFecha(java.time.LocalDate fecha) {
        List<OrdenServicio> resultado = new ArrayList<>();
        if (fecha == null) return resultado;

        for (OrdenServicio orden : ordenes) {
            if (orden.getFechaIngreso() != null && orden.getFechaIngreso().equals(fecha)) {
                resultado.add(orden);
            }
        }
        return resultado;
    }

    /**
     * Funcionalidad propia: Filtra los repuestos con alerta de stock insuficiente.
     */
    public List<Repuesto> obtenerRepuestosConStockBajo() {
        List<Repuesto> resultado = new ArrayList<>();
        for (Repuesto repuesto : repuestos) {
            if (repuesto.stockInsuficiente()) {
                resultado.add(repuesto);
            }
        }
        return resultado;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(List<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }

    public List<Repuesto> getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(List<Repuesto> repuestos) {
        this.repuestos = repuestos;
    }

    public List<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenServicio> ordenes) {
        this.ordenes = ordenes;
    }
}