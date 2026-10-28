public class Persona {
    private String identificacion;
    private String nombreCompleto;
    private Proyecto miProyecto;

    public Persona(String id, String nombre) {
        identificacion = id;
        nombreCompleto = nombre;
    }

    public void asignarProyecto(Proyecto obj) {
        miProyecto = obj;
    }

    public double devolverCostoActualPrj() {
        return miProyecto.calcularCostoActual();
    }

    public String toString() {
        return "Identificación = " + identificacion +
               " Nombre Completo = " + nombreCompleto + "\n";
    }
}
