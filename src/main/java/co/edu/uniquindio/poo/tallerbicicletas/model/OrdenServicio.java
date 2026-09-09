package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una orden de servicio realizada en el taller
 * para una bicicleta.
 *
 * <p>Una orden relaciona una bicicleta con el mecánico encargado
 * y permite registrar los repuestos utilizados y el costo de
 * la mano de obra.</p>
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b>
 *   Se encarga de representar y gestionar la información
 *   correspondiente a una orden de servicio.</li>
 *
 *   <li><b>Open/Closed Principle (OCP):</b>
 *   Los repuestos se manejan mediante objetos {@link Repuesto},
 *   permitiendo ampliar el sistema sin modificar la estructura
 *   principal de la orden.</li>
 * </ul>
 *
 * @see Bicicleta
 * @see Mecanico
 * @see Repuesto
 */
public class OrdenServicio {

    private String id;
    private LocalDate fechaIngreso;
    private Bicicleta bicicleta;
    private Mecanico mecanico;
    private String motivo;
    private List<Repuesto> repuestosUtilizados;
    private double costoManoObra;

    public OrdenServicio(String id, LocalDate fechaIngreso,
                         Bicicleta bicicleta, Mecanico mecanico,
                         String motivo, double costoManoObra) {

        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.bicicleta = bicicleta;
        this.mecanico = mecanico;
        this.motivo = motivo;
        this.costoManoObra = costoManoObra;
        this.repuestosUtilizados = new ArrayList<>();
    }

    /**
     * Agrega un repuesto a la lista de repuestos utilizados
     * en la orden y descuenta una unidad de su inventario.
     *
     * @param repuesto Repuesto utilizado en el servicio.
     */
    public void agregarRepuesto(Repuesto repuesto) {
        if (repuesto != null) {
            repuestosUtilizados.add(repuesto);
            repuesto.restarStock(1);
        }
    }

    /**
     * Calcula el costo total de la orden sumando el costo
     * de la mano de obra y el precio de todos los repuestos utilizados.
     *
     * @return Costo total de la orden de servicio.
     */
    public double calcularCostoTotal() {
        double costoRepuestos = 0;

        for (Repuesto repuesto : repuestosUtilizados) {
            costoRepuestos += repuesto.getPrecio();
        }

        return costoManoObra + costoRepuestos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<Repuesto> getRepuestosUtilizados() {
        return repuestosUtilizados;
    }

    public void setRepuestosUtilizados(List<Repuesto> repuestosUtilizados) {
        this.repuestosUtilizados = repuestosUtilizados;
    }

    public double getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(double costoManoObra) {
        this.costoManoObra = costoManoObra;
    }
}