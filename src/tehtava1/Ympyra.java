package tehtava1;

public class Ympyra extends Kuvio {

    private double sade;

    public Ympyra(double x, double y, String teksti, double sade) {
        super(x, y, teksti);
        this.sade = sade;
    }

    public double getSade() {
        return sade;
    }

    @Override
    public String toString() {
        return "Ympyra{" +
                keskiPisteMj() +
                "sade=" + sade +
                '}';
    }

    @Override
    public double ala() {
        return Math.PI * Math.pow(getSade(), 2);
    }
}
