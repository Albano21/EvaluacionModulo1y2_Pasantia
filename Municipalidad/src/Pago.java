import java.util.Date;
import java.util.function.Function;

public class Pago {

    private int demora;
    private float importe;
    private float interesesAdicionales;

    public Pago(int demora, float importe) {
        this.demora = demora;
        this.importe = importe;
        this.interesesAdicionales = (float) (demora * 0.005 * importe);
    }

    public int getDemora() {
        return demora;
    }

    public void setDemora(int demora) {
        this.demora = demora;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getInteresesAdicionales() {
        return interesesAdicionales;
    }

    public void setInteresesAdicionales(float interesesAdicionales) {
        this.interesesAdicionales = interesesAdicionales;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pago{");
        sb.append("demora=").append(demora);
        sb.append(", importe=").append(importe);
        sb.append(", interesesAdicionales=").append(interesesAdicionales);
        sb.append('}');
        return sb.toString();
    }
}
