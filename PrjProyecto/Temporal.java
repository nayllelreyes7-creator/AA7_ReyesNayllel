public class Temporal extends Proyecto {
    private int duracion;
    private double tipoCambio;

    public Temporal(String nombre, double costoInicial, int duracion, double tipoCambio) {
        super(nombre, costoInicial);
        this.duracion = duracion;
        this.tipoCambio = tipoCambio;
    }

    public double calcularCostoActual() {
        return costoInicial * tipoCambio;
    }

    public String toString() {
        String s = super.toString();
        s = s + "Tipo de proyecto: Temporal\n" +
                "Duración en semanas: " + duracion + "\n" +
                "Valor del dólar: " + tipoCambio + "\n";
        return s;
    }
}
