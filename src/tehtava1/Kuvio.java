package tehtava1;

public abstract class Kuvio {

    private double x, y;
    private String teksti = "start";

    public Kuvio(double x, double y, String teksti) {
        this.x = x;
        this.y = y;
        this.teksti = teksti;
    }

    public void setTeksti(String teksti) {
        if (teksti == null)
            this.teksti = "";
        else
            this.teksti = teksti;
    }

    public String keskiPisteMj() {
        return "(" + x + ", " + y + ")";
    }

    public abstract double ala();
}



