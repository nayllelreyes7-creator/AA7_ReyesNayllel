public class PrincipalCasetaPeaje {
    public static void main(String[] args) {
        System.out.println("Ejecución por parte de: Nayllel Reyes Sojo");
        Vehiculo a, b, c, d, e, f, g;

        a = new Particular("ABC123", "Toyota", "Corolla", 2018);
        b = new CargaLiviana("DEF456", "Isuzu", "NPR", 2020);
        c = new Moto("GHI789", "Honda", "CBR", 2022);
        d = new Carga("TRK789", "Freightliner", "M2", 2021);
        e = new Moto("MOT321", "Yamaha", "FZ", 2022);
        f = new Particular("ZZZ111", "Honda", "Civic", 2018);
        g = new Particular("EVC999", "Tesla", "Model 3", 2025);

        CasetaPeaje unaCaseta, otraCaseta;
        unaCaseta = new CasetaPeaje("Ruta 32 al Caribe de Costa Rica");
        otraCaseta = new CasetaPeaje("Ruta 32 al Caribe de Costa Rica");

        unaCaseta.cobrarPeaje(a);
        unaCaseta.cobrarPeaje(b);
        unaCaseta.cobrarPeaje(c);

        otraCaseta.cobrarPeaje(d);
        otraCaseta.cobrarPeaje(e);
        otraCaseta.cobrarPeaje(f);
        otraCaseta.cobrarPeaje(g);

        System.out.println("La primera caseta: ");
        System.out.println(unaCaseta);
        //La línea de código anterior fuerza al objeto unaCaseta a ejecutar
        //su método toString() y por eso lo dejé así.

        System.out.println("La segunda caseta: ");
        System.out.println(otraCaseta.toString());
        //En la línea de código anterior es innecesario llamar al método toString()

        System.out.println("Casetas creadas: " + CasetaPeaje.getCantidadDeCasetasPeaje());

        //El estado del primer vehículo
        System.out.println("Primer vehículo creado");
        System.out.println(a);
    }
}
