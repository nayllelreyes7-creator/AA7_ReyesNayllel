public class Atractivo {
    private String codigo;
    private String nombre;
    private double montoEntrada;

    public Atractivo(String codigo, String nombre, double montoEntrada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.montoEntrada = montoEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoEntrada() {
        return montoEntrada;
    }

    public String toString() {
        return "Código: " + codigo +
               " | Nombre: " + nombre +
               " | Monto de entrada: ₡" + montoEntrada;
    }
}
