public class PrincipalOperadoraTours {
    public static void main(String[] args) {
        System.out.println("Ejecución por parte de: " +
                           "Nayllel Reyes Sojo");
        System.out.println();

        Guia g1, g2;
        Atractivo a1, a2, a3, a4, a5;
        Cliente c1, c2, c3, c4;
        Tour t1, t2, t3; //Los objetos se declaran del super tipo

        g1 = new Guia("1-1234-0567", "Daniela Brenes Mora");
        g2 = new Guia("2-0987-0654", "Esteban Quirós Solís");

        a1 = new Atractivo("A-01", "Teatro Nacional", 3000);
        a2 = new Atractivo("A-02", "Museo del Oro Precolombino", 4000);
        a3 = new Atractivo("A-03", "Museo Nacional", 2500);
        a4 = new Atractivo("A-04", "Bosque Nuboso de Monteverde", 5000);
        a5 = new Atractivo("A-05", "Puentes Colgantes", 3500);

        c1 = new Cliente("Laura Rojas", "nacional");
        c2 = new Cliente("John Smith", "extranjero");
        c3 = new Cliente("Mariana Vargas", "nacional");
        c4 = new Cliente("Emma Schneider", "extranjero");

        //Los objetos se construyen o instancian del subtipo
        t1 = new TourCultural("Centro histórico de San José",
                              15000, 20, g1, "español");
        t2 = new TourAventura("Canopy en Monteverde",
                              30000, 12, g2, "alto");
        t3 = new TourAventura("Caminata nocturna en Monteverde",
                              20000, 10, g2); // Nivel por omisión: medio

        System.out.println("==== ESTADO INICIAL DE LAS GUÍAS ====");
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println();

        System.out.println("==== ESTADO INICIAL DE LOS ATRACTIVOS ====");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        System.out.println(a4.toString());
        System.out.println(a5.toString());
        System.out.println();

        System.out.println("==== ESTADO INICIAL DE LOS CLIENTES ====");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println();

        // Recorridos: el atractivo A-04 forma parte de dos tours
        t1.agregarAtractivo(a1);
        t1.agregarAtractivo(a2);
        t1.agregarAtractivo(a3);
        t1.agregarAtractivo(a1); // Repetido: debe ignorarse

        t2.agregarAtractivo(a4);
        t2.agregarAtractivo(a5);

        t3.agregarAtractivo(a4);

        System.out.println("==== RECORRIDO Y PRECIO DE CADA TOUR ====");
        System.out.println(t1.getNombre() + ": " +
                           t1.consultarNombresAtractivos());
        System.out.println("Precio por persona: " +
                           t1.calcularPrecioPorPersona());
        System.out.println(t2.getNombre() + ": " +
                           t2.consultarNombresAtractivos());
        System.out.println("Precio por persona: " +
                           t2.calcularPrecioPorPersona());
        System.out.println(t3.getNombre() + ": " +
                           t3.consultarNombresAtractivos());
        System.out.println("Precio por persona: " +
                           t3.calcularPrecioPorPersona());
        System.out.println();

        System.out.println("==== GUÍAS ANTES DEL CAMBIO ====");
        System.out.println(t1.getCodigo() + ": " + t1.consultarNombreGuia());
        System.out.println(t2.getCodigo() + ": " + t2.consultarNombreGuia());
        System.out.println(t3.getCodigo() + ": " + t3.consultarNombreGuia());
        System.out.println();

        t3.cambiarGuia(g1);

        // Reservas
        t1.registrarReserva(c1, 2);
        t1.registrarReserva(c2); // Una sola persona
        t1.registrarReserva(c3, 30); // Excede los cupos: no debe registrarse

        t2.registrarReserva(c4, 4);
        t2.registrarReserva(c3, 2);
        t2.registrarReserva(c1, 0); // Inválida: no debe registrarse

        t3.registrarReserva(c2, 3);
        t3.registrarReserva(c1); // Una sola persona
        t3.registrarReserva(c4, 7); // Excede los cupos: no debe registrarse

        System.out.println("==== GUÍAS DESPUÉS DEL CAMBIO ====");
        System.out.println(t1.getCodigo() + ": " + t1.consultarNombreGuia());
        System.out.println(t2.getCodigo() + ": " + t2.consultarNombreGuia());
        System.out.println(t3.getCodigo() + ": " + t3.consultarNombreGuia());
        System.out.println();

        System.out.println("==== ESTADO FINAL DE LOS TOURS ====");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());

        System.out.println("==== INGRESO TOTAL DE CADA TOUR ====");
        System.out.println(t1.getCodigo() + ": " + t1.calcularIngresoTotal());
        System.out.println(t2.getCodigo() + ": " + t2.calcularIngresoTotal());
        System.out.println(t3.getCodigo() + ": " + t3.calcularIngresoTotal());
        System.out.println();

        System.out.println("Tours registrados: " + Tour.getCantidadTours());
    }
}
