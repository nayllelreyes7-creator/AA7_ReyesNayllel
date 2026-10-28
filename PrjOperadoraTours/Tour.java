import java.util.ArrayList;

public abstract class Tour {
    public static final String PREFIJO_CODIGO = "TOUR-";
    public static final double PORCENTAJE_DESCUENTO_NACIONAL = 0.20;
    public static final int CANTIDAD_PERSONAS_POR_OMISION = 1;

    private static int cantidadTours;

    private String codigo;
    private String nombre;
    protected double precioBase;
    private int cupoMaximo;
    private Guia guia;
    protected ArrayList<Atractivo> atractivos;
    private ArrayList<Reserva> reservas;
    private int consecutivoReservas;

    public Tour(String nombre, double precioBase, int cupoMaximo, Guia guia) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cupoMaximo = cupoMaximo;
        this.guia = guia;
        atractivos = new ArrayList<>();
        reservas = new ArrayList<>();
        consecutivoReservas = 0;
        cantidadTours++;
        codigo = generarCodigo();
    }

    private String generarCodigo() {
        return PREFIJO_CODIGO + cantidadTours;
    }

    public static int getCantidadTours() {
        return cantidadTours;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPrecioPorPersona();

    public void cambiarGuia(Guia nuevaGuia) {
        guia = nuevaGuia;
    }

    public String consultarNombreGuia() {
        return guia.getNombreCompleto();
    }

    public void agregarAtractivo(Atractivo a) {
        if (!atractivos.contains(a)) {
            atractivos.add(a);
        }
    }

    public String consultarNombresAtractivos() {
        String s = "";
        for (int i = 0; i < atractivos.size(); i++) {
            if (i > 0) {
                s += ", ";
            }
            s += atractivos.get(i).getNombre();
        }
        return s;
    }

    public boolean registrarReserva(Cliente cliente) {
        return registrarReserva(cliente, CANTIDAD_PERSONAS_POR_OMISION);
    }

    public boolean registrarReserva(Cliente cliente, int cantidadPersonas) {
        if (!esCantidadValida(cantidadPersonas)) {
            return false;
        }
        consecutivoReservas++;
        double monto = calcularMontoReserva(cliente, cantidadPersonas);
        reservas.add(new Reserva(consecutivoReservas, cliente.getNombre(),
                                 cantidadPersonas, monto));
        return true;
    }

    private boolean esCantidadValida(int cantidadPersonas) {
        return cantidadPersonas > 0 && cantidadPersonas <= calcularCuposDisponibles();
    }

    public final double calcularMontoReserva(Cliente cliente, int cantidadPersonas) {
        double monto = calcularPrecioPorPersona() * cantidadPersonas;
        if (cliente.esNacional()) {
            monto -= monto * PORCENTAJE_DESCUENTO_NACIONAL;
        }
        return monto;
    }

    private int calcularPersonasReservadas() {
        int total = 0;
        for (Reserva r : reservas) {
            total += r.getCantidadPersonas();
        }
        return total;
    }

    public int calcularCuposDisponibles() {
        return cupoMaximo - calcularPersonasReservadas();
    }

    public final double calcularIngresoTotal() {
        double total = 0;
        for (Reserva r : reservas) {
            total += r.getMonto();
        }
        return total;
    }

    private String consultarReservas() {
        String s = "Reservas (" + reservas.size() + "):\n";
        for (Reserva r : reservas) {
            s += "  - " + r + "\n";
        }
        return s;
    }

    public String toString() {
        return "Código: " + codigo + "\n" +
               "Nombre: " + nombre + "\n" +
               "Guía: " + consultarNombreGuia() + "\n" +
               "Precio base: ₡" + precioBase + "\n" +
               "Precio por persona: ₡" + calcularPrecioPorPersona() + "\n" +
               "Cupo máximo: " + cupoMaximo + "\n" +
               "Cupos disponibles: " + calcularCuposDisponibles() + "\n" +
               "Atractivos del recorrido: " + consultarNombresAtractivos() + "\n" +
               consultarReservas() +
               "Ingreso total: ₡" + calcularIngresoTotal() + "\n";
    }
}
