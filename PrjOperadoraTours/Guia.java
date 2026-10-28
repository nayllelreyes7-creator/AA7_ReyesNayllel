public class Guia {
    private String identificacion;
    private String nombreCompleto;

    public Guia(String identificacion, String nombreCompleto) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String toString() {
        return "Identificación: " + identificacion +
               " | Nombre completo: " + nombreCompleto;
    }
}
