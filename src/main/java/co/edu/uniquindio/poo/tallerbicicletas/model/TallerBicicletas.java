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