package transportas;

public class TransportasImpl implements Transportas {
    private String tipas;
    private boolean variklis;

    public TransportasImpl (String tipas, boolean variklis) {
        this.tipas = tipas;
        this.variklis = variklis;
    }

    @Override
    public void setTipas(String tipas) {
        this.tipas = tipas;
    }
    @Override
    public void setVariklis(boolean variklis) {
        this.variklis = variklis;
    }
    @Override
    public String getTipas() {
        return tipas;
    }
    @Override
    public boolean getVariklis() {
        return variklis;
    }

    @Override
    public String toString() {
        return "TransportasImpl{" +
                "tipas='" + tipas + '\'' +
                ", variklis=" + variklis +
                '}';
    }
}
