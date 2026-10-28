public class TourCultural extends Tour {
    public static final String TIPO = "Cultural";

    private String idioma;

    public TourCultural(String nombre, double precioBase, int cupoMaximo,
                        Guia guia, String idioma) {
        super(nombre, precioBase, cupoMaximo, guia);
        this.idioma = idioma;
    }

    public double calcularPrecioPorPersona() {
        return precioBase + calcularTotalEntradas();
    }

    private double calcularTotalEntradas() {
        double total = 0;
        for (Atractivo a : atractivos) {
            total += a.getMontoEntrada();
        }
        return total;
    }

    public String toString() {
        String s = super.toString();
        s = s + "Tipo de tour: " + TIPO + "\n" +
                "Idioma: " + idioma + "\n";
        return s;
    }
}
