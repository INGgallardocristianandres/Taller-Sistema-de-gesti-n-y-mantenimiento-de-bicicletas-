package co.edu.uniquindio.poo.tallerbicicletas.model;
/**
 * Clase encargada de modelar los elementos del inventario requeridos para las reparaciones
 *
 * <p><b>Principios SOLID aplicados:</b></p>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP):</b> Encapsula las propiedades de los repuestos y gestiona de forma autónoma el control de elementos tipo {@link  Repuesto}.</li>
 * </ul>
 *
 */
public class Repuesto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stockActual;
    private int stockMinimo;

    public Repuesto(String codigo, String nombre, double precio, int stockActual, int stockMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }
    /**
     * Evalúa si el stock actual se encuentra  por debajo del límite mínimo permitido.
     * @return {@code true} si el stock es menor al valor minimo, {@code false} en caso contrario.
     */

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean stockInsuficiente(){
        return stockActual <= stockMinimo;
    }

    /**
     * Disminuye las unidades disponibles en el inventario al utilizar el repuesto.
     * Realiza la resta solo si la cantidad solicitada no supera el inventario disponible.
     *
     * @param cantidadUtilizada Número de unidades que se van a descontar del stock.
     */
    public void restarStock(int cantidadUtilizada){
        if(stockActual>= cantidadUtilizada){
            stockActual-= cantidadUtilizada;
        }
    }

    /**
     * Incrementa la cantidad de unidades disponibles en el inventario cuando se reciben nuevos repuestos.
     * Solo realiza el aumento si la cantidad ingresada es un valor positivo mayor a cero.
     *
     * @param cantidadComprada Número de unidades a añadir al stock actual.
     */
    public void aumentarStock(int cantidadComprada){
        if(cantidadComprada>0){
            stockActual+= cantidadComprada;
        }
    }

}
