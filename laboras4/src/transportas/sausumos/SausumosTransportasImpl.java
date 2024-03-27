package transportas.sausumos;

import transportas.TransportasImpl;

public class SausumosTransportasImpl extends TransportasImpl implements SausumosTransportas {
    private int metai;
    public SausumosTransportasImpl(String tipas, boolean variklis, int metai) {
        super(tipas, variklis);
        this.metai = metai;
    }

    @Override
    public void setMetai(int metai) {
        this.metai = metai;
    }
    @Override
    public int getMetai() {
        return metai;
    }

    @Override
    public String toString() {
        return "SausumosTransportasImpl{" +
                "metai=" + metai +
                '}';
    }
}
