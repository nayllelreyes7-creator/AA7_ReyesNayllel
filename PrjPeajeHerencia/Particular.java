public class Particular extends Vehiculo {
    public static final String TIPO = "particular";
    public static final double MONTO_PEAJE = 100;

    public Particular(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, TIPO, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
