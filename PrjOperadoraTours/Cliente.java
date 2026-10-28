public class Cliente {
    public static final String CONDICION_NACIONAL = "nacional";
    public static final String CONDICION_EXTRANJERO = "extranjero";

    private String nombre;
    private String condicion;

    public Cliente(String nombre, String condicion) {
        this.nombre = nombre;
        this.condicion = condicion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esNacional() {
        return CONDICION_NACIONAL.equalsIgnoreCase(condicion);
    }

    public String toString() {
        return "Nombre: " + nombre + " | Condición: " + condicion;
    }
}
