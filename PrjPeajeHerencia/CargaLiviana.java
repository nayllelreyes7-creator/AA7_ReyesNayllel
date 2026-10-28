public class CargaLiviana extends Vehiculo {
    public static final String TIPO = "carga liviana";
    public static final double MONTO_PEAJE = 200;

    public CargaLiviana(String pPlaca, String pMarca, String pModelo, int pAnnio) {
        super(pPlaca, TIPO, pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
