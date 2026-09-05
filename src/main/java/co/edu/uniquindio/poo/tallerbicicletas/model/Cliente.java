package co.edu.uniquindio.poo.tallerbicicletas.model;
/**
 * Representa a un cliente dentro del taller, extendiendose de la clase {@link Persona}.
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Liskov Substitution Principle (LSP):</b> Puede sustituir a {@link Persona} en cualquier método sin alterar el comportamiento del sistema.</li>
 *   <li><b>Single Responsibility Principle (SRP):</b> Encapsula únicamente los datos de contacto y la información personal del cliente.</li>
 * </ul>
 *
 * @see Persona
 */
public class Cliente extends Persona{
    private String telefono;
    private String direccion;

    public Cliente(String id, String nombre, String telefono, String direccion) {
        super(id, nombre);
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
}
