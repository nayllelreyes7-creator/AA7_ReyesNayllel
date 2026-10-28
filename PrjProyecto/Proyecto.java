import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Proyecto {
    public static final String PREFIJO_CODIGO = "PRY-";

    private String codigo;
    private String nombre;
    protected double costoInicial;
    private String fechaDeInicio;
    private double ingresosAcumulados;
    private Persona encargado;
    private ArrayList<Entregable> entregables;
    private static int cantProyectos;

    public Proyecto(String nombre, double costoInicial) {
        this.nombre = nombre;
        this.costoInicial = costoInicial;
        fechaDeInicio = establecerFechaInicioProyecto();
        ingresosAcumulados = 0.0;
        entregables = new ArrayList<>();
        cantProyectos++;
        codigo = PREFIJO_CODIGO + String.format("%03d", cantProyectos);
    }

    private String establecerFechaInicioProyecto() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(f);
    }

    public abstract double calcularCostoActual();

    public final double calcularBalance() {
        return ingresosAcumulados - calcularCostoActual();
    }

    public void asignarEncargado(Persona p) {
        encargado = p;
        p.asignarProyecto(this);
    }

    public void registrarIngreso(double monto) {
        ingresosAcumulados += monto;
    }

    public void registrarEntregable(Entregable e) {
        entregables.add(e);
    }

    public String toString() {
        String s = "Código del Proyecto: " + codigo +
                   "\nNombre del Proyecto: " + nombre +
                   "\nCosto inicial: " + costoInicial +
                   "\nFecha de inicio: " + fechaDeInicio +
                   "\nIngresos acumulados: " + ingresosAcumulados +
                   "\nCosto actual: " + calcularCostoActual() +
                   "\nBalance: " + calcularBalance() + "\n";

        s = s + "Encargado: " + encargado + "\n";

        s = s + "Entregables (" + entregables.size() + "):\n";
        for (Entregable e : entregables) {
            s = s + "- " + e + "\n";
        }
        return s;
    }
}
