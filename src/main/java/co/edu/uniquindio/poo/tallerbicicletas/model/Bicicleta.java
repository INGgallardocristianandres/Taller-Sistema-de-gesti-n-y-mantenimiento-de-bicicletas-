package co.edu.uniquindio.poo.tallerbicicletas.model;


/**
 * Representa una bicicleta registrada dentro del taller.
 *
 * <p>Cada bicicleta pertenece a un único cliente, quien actúa
 * como su propietario.</p>
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b>
 *   Se encarga únicamente de representar la información
 *   correspondiente a una bicicleta y su propietario.</li>
 *
 *   <li><b>Open/Closed Principle (OCP):</b>
 *   El tipo de bicicleta se maneja mediante {@link TipoBicicleta},
 *   permitiendo agregar nuevos tipos sin modificar esta clase.</li>
 * </ul>
 *
 * @see Cliente
 * @see TipoBicicleta
 */
public class Bicicleta {

    private String serial;
    private String marca;
    private TipoBicicleta tipo;
    private String color;
    private int anio;
    private Cliente propietario;

    /**
     * Constructor de la bicicleta.
     *
     * @param serial Número de serie de la bicicleta.
     * @param marca Marca de la bicicleta.
     * @param tipo Tipo de bicicleta.
     * @param color Color de la bicicleta.
     * @param anio Año de la bicicleta.
     * @param propietario Cliente propietario de la bicicleta.
     */
    public Bicicleta(String serial, String marca, TipoBicicleta tipo,
                     String color, int anio, Cliente propietario) {
        this.serial = serial;
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.anio = anio;
        this.propietario = propietario;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoBicicleta getTipo() {
        return tipo;
    }

    public void setTipo(TipoBicicleta tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
    @Override
    public String toString() {
        return marca + " - " + serial + " (" + (propietario != null ? propietario.getNombre() : "Sin propietario") + ")";
    }
}