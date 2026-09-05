package co.edu.uniquindio.poo.tallerbicicletas.model;
/**
 * Clase abstracta que define la estructura base y los atributos compartidos por cualquier persona(Mecanico o Cliente) dentro del sistema.
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b> La informacion (ID y nombre) es exclusiva de los actores del sistema.</li>
 *   <li><b>Open/Closed Principle (OCP):</b> Permite extender nuevos tipos de roles sin alterar la lógica de las clases hijas.</li>
 * </ul>
 *
 */
public abstract class Persona {
    protected String id;
    protected String nombre;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {return id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
