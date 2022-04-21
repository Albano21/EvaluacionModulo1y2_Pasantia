import java.util.ArrayList;

public class Plan {

    private String nombre;
    private float deuda;
    private int cuotas;
    private ArrayList<Pago> pagos;

    public Plan(String nombre, float deuda, int cuotas) {
        //this.id = contadorPlanes++;
        this.nombre = nombre;
        this.deuda = deuda;
        this.cuotas = cuotas;
        this.pagos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public float getDeuda() {
        return deuda;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /*
    public int getId(){
        return id;
    }
    */

    public void agregarPago(Pago p){
        pagos.add(p);
    }

    public boolean estaPagadoTotalmente(){
        if (pagos.size() == cuotas){
            return true;
        }
        else{
            return false;
        }
    }

    public String listadoPagos() {

        StringBuilder sb = new StringBuilder();
        pagos.stream().forEach(p -> sb.append(p));
        return sb.toString();
    }

    public float sumaInteresesCobrados(){

        float sum = 0;

        sum = (float) pagos.stream().mapToDouble(pago -> pago.getInteresesAdicionales()).sum();
        return sum;
    }


}
