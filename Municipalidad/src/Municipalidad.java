import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Municipalidad {

    private ArrayList<Plan> planes;

    public Municipalidad() {
        this.planes = new ArrayList<>();
    }

    public void agregarPlan(Plan plan){
        planes.add(plan);
    }

    public int cantidadPlanesPagados(){
        return (int) planes.stream().filter(plan -> plan.estaPagadoTotalmente()).count();
    }

    public float sumatoriaDeuda(){

        float sum = 0;
        sum = (float) planes.stream().mapToDouble(plan -> plan.getDeuda()).sum();
        return sum;
    }

    public String listaPagosContribuyente(String nombre){

        StringBuilder sb = new StringBuilder();
        sb.append("Listado de pagos del contribuyente: " + nombre);
        planes.stream().filter(plan -> plan.getNombre().equals(nombre))
                .forEach(plan -> sb.append("\n-"+plan.listadoPagos()));
        return sb.toString();
    }

    public float promedioIntereses(){

        float sum = 0;
        sum = (float) planes.stream().mapToDouble(plan ->  plan.sumaInteresesCobrados()).average().getAsDouble();
        return sum;
    }


    public boolean existePlan(String nombre){
        return planes.stream().anyMatch(plan -> plan.getNombre().equals(nombre));
    }

    public Plan getPlan(String nombre){
        return planes.stream().filter(plan -> plan.getNombre().equals(nombre)).findFirst().get();
    }


}
