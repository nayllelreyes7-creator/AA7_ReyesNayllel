public class Carga extends Vehiculo {
    public static final String TIPO = "carga";
    public static final double MONTO_PEAJE = 500;

    public Carga(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, TIPO, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
