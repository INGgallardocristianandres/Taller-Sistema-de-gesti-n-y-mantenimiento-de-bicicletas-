package co.edu.uniquindio.poo.tallerbicicletas.model;
/**
 * Clase que representa al personal encargado del mantenimiento y reparación de bicicletas.
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Liskov Substitution Principle (LSP):</b> Permite actuar como {@link Persona} en cualquier metodo.</li>
 *   <li><b>Single Responsibility Principle (SRP):</b> Se encarga de manejar las funcionalidades de {@link Mecanico} y su especializacion.</li>
 * </ul>
 *
 * @see Persona
 * @see Especialidad
 */
public class Mecanico extends Persona{
    private Especialidad especialidad;
    private String numeroCerficado;

    public Mecanico(String id, String nombre, Especialidad especialidad, String numeroCerficado) {
        super(id, nombre);
        this.especialidad = especialidad;
        this.numeroCerficado = numeroCerficado;
    }

    public Especialidad getEspecialidad() {return especialidad;}
    public void setEspecialidad(Especialidad especialidad) {this.especialidad = especialidad;}
    public String getNumeroCerficado() {return numeroCerficado;}
    public void setNumeroCerficado(String numeroCerficado) {this.numeroCerficado = numeroCerficado;}
}
