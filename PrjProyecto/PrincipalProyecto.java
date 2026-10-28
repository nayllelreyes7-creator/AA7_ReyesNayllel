public class PrincipalProyecto {
    public static void main(String[] args) {
        System.out.println("Ejecución por parte de: Nayllel Reyes Sojo");
        System.out.println();
        //Recuerde que siempre los objetos se declararán del super tipo diseñado por usted
        Persona a, b;
        a = new Persona("123456", "Leopoldo Octavio de Montferrat y Cifuentes");
        b = new Persona("7891011", "Isadora Celeste de Alencourt y Villamediana");

        Proyecto c, d; //Recuerde que los objetos se declaran del super tipo

        c = new Temporal("Implementación ERP", 100, 12, 10.0);
        //Recuerde que siempre los objetos se construyen o instancia del subtipo
        //Un objeto creado con el constructor de Temporal será considerado de los siguientes
        //tipos: Temporal, Proyecto y Object
        d = new Permanente("Mantenimiento Infraestructura", 200, 50, 0.10);

        c.asignarEncargado(a);
        d.asignarEncargado(b);

        c.registrarIngreso(3000);
        c.registrarIngreso(600);
        d.registrarIngreso(800);

        Entregable e1, e2, e3;
        e1 = new Entregable("Módulo Financiero", "A TIEMPO");
        e2 = new Entregable("Módulo Recursos Humanos", "RETRASADO");
        e3 = new Entregable("Revisión Servidores", "A TIEMPO");

        c.registrarEntregable(e1);
        c.registrarEntregable(e2);
        d.registrarEntregable(e3);

        System.out.println(c.toString());
        System.out.println(d.toString());

        System.out.println("La siguiente persona: " + a.toString() + " es encargado-a de un proyecto cuyo costo actual es: " + a.devolverCostoActualPrj());
        System.out.println("La siguiente persona: " + b.toString() + " es encargado-a de un proyecto cuyo costo actual es: " + b.devolverCostoActualPrj());
    }
}
