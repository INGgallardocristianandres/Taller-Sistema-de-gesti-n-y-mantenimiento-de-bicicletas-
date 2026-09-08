package co.edu.uniquindio.poo.tallerbicicletas.model;

/**
 * Enum que representa los diferentes tipos de bicicletas
 * que pueden ser registradas en el taller.
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b>
 *   Se encarga únicamente de definir los tipos de bicicleta
 *   disponibles en el sistema.</li>
 *   <li><b>Open/Closed Principle (OCP):</b>
 *   Permite agregar nuevos tipos de bicicleta sin modificar
 *   la estructura de las clases que utilizan este enum.</li>
 * </ul>
 */
public enum TipoBicicleta {

    ELECTRICA,
    MTB,
    URBANA,
    RUTA,
    INFANTIL
}