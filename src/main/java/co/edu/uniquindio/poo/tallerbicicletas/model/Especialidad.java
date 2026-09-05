package co.edu.uniquindio.poo.tallerbicicletas.model;
/**
 * Clase encargada de definir las especialidades que puede poseer un mecanico
 *
 * <p><b>Principios SOLIDaplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b> Permite que la responsabilidad de brindar una especialidad quede arraigada a los mecanicos y no interfiera en las otras clases.</li>
 *   <li><b>Open/Closed Principle (OCP):</b> Permite agregar nuevas funcionalidades sin modificar la estructura interna de la clase {@link Mecanico}.</li>
 * </ul>
 *
 * @see Mecanico
 */

public enum Especialidad {
    FRENOS_Y_TRANSMISION,
    SUSPENSION,
    BICICLETAS_ELECTRICAS,
    MANTENIMIENTO_GENERAL
}
