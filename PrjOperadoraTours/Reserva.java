public class Reserva {
    private int numero;
    private String nombreCliente;
    private int cantidadPersonas;
    private double monto;

    public Reserva(int numero, String nombreCliente, int cantidadPersonas, double monto) {
        this.numero = numero;
        this.nombreCliente = nombreCliente;
        this.cantidadPersonas = cantidadPersonas;
        this.monto = monto;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public double getMonto() {
        return monto;
    }

    public String toString() {
        return "Reserva #" + numero +
               " | Cliente: " + nombreCliente +
               " | Personas: " + cantidadPersonas +
               " | Monto: ₡" + monto;
    }
}
