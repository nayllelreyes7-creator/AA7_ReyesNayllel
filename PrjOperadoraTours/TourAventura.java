public class TourAventura extends Tour {
    public static final String TIPO = "Aventura";
    public static final double PORCENTAJE_SEGURO_AVENTURA = 0.15;
    public static final String NIVEL_POR_OMISION = "medio";

    private String nivelDificultad;

    public TourAventura(String nombre, double precioBase, int cupoMaximo,
                        Guia guia, String nivelDificultad) {
        super(nombre, precioBase, cupoMaximo, guia);
        this.nivelDificultad = nivelDificultad;
    }

    public TourAventura(String nombre, double precioBase, int cupoMaximo, Guia guia) {
        this(nombre, precioBase, cupoMaximo, guia, NIVEL_POR_OMISION);
    }

    public double calcularPrecioPorPersona() {
        return precioBase + (precioBase * PORCENTAJE_SEGURO_AVENTURA);
    }

    public String toString() {
        String s = super.toString();
        s = s + "Tipo de tour: " + TIPO + "\n" +
                "Nivel de dificultad: " + nivelDificultad + "\n";
        return s;
    }
}
