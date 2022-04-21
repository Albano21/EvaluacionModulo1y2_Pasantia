import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private static Municipalidad municipalidad = new Municipalidad();

    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Creo vector de opciones
        Opcion opciones[] = new Opcion[8];

        // Creo objeto municipipalidad


        // faltan crear metodos municipalidad
        opciones[0] = new Opcion(1, "Agregar plan", () -> opcion1());
        opciones[1] = new Opcion(2, "Agregar pago", () -> opcion2());
        opciones[2] = new Opcion(3, "Ver resumen estadistico", () -> opcion3());
        opciones[3] = new Opcion(4, "Ver cantidad de planes pagados", () -> opcion4());
        opciones[4] = new Opcion(5, "Ver sumatoria de deudas registrada", () -> opcion5());
        opciones[5] = new Opcion(6, "Listar todos los pagos de un contribuyente", () -> opcion6());
        opciones[6] = new Opcion(7, "Ver promedio general de intereses adicionales cobrados", () -> opcion7());
        opciones[7] = new Opcion(8, "Salir", null);


        System.out.println("MENU DE OPCIONES: ");
        for (Opcion op : opciones){
            System.out.println(op.getNumero() + ") " + op.getTexto());
        }

        System.out.println("\nIngrese una opcion:");
        int op = sc.nextInt();

        while(op != 8){
            opciones[op-1].ejecutar();

            System.out.println("\nIngrese una opcion:");
            op = sc.nextInt();
        }

        System.out.println("\nHasta pronto!");

    }

    private static void opcion1(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSe registrará un plan de pago");

        System.out.println("Ingrese el nombre del contribuyente: ");
        String nombre = sc.next();

        System.out.println("Ingrese el total de la deuda: ");
        float deuda = sc.nextFloat();

        System.out.println("Ingrese la cantidad de cuotas: ");
        int cuotas = sc.nextInt();

        Plan plan = new Plan(nombre, deuda, cuotas);

        municipalidad.agregarPlan(plan);

    }

    private static void opcion2(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSe registrara un pago");
        System.out.println("Ingrese el nombre del contribuyente del plan: ");
        String nombre = sc.next();


        if (! municipalidad.existePlan(nombre)){
            System.out.println("No existe un contribuyente con ese nombre");
            return;
        }

        Plan planSeleccionado = municipalidad.getPlan(nombre);

        System.out.println("Ingrese la demora en dias del pago: ");
        int demora = sc.nextInt();
        System.out.println("Ingrese el importe pagado: ");
        float importe = sc.nextFloat();

        Pago pago = new Pago(demora, importe);
        planSeleccionado.agregarPago(pago);


    }

    private static void opcion3(){
        System.out.println("\nResumen estadistico: ");
        opcion4();
        opcion5();
        opcion7();
    }

    private static void opcion4(){
        System.out.println("\nCantidad de planes pagados en su totalidad: " + municipalidad.cantidadPlanesPagados());
    }

    private static void opcion5(){
        System.out.println("\nSumatoria de deudas registradas: " + municipalidad.sumatoriaDeuda());
    }

    private static void opcion6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el nombre del contribuyente a buscar: ");
        String nombre = sc.next();
        System.out.println(municipalidad.listaPagosContribuyente(nombre));
    }

    private static void opcion7(){
        System.out.println("Promedio de intereses adicionales cobrados: " + municipalidad.promedioIntereses());
    }

}
