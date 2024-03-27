package bazine;

import java.util.Comparator;

public class DarbininkasImpl implements Darbininkas, Comparable<DarbininkasImpl> {
        private String darbininkas;
        private String detale;
        private int pagamintasKiekis;
        private double detalesKaina;

    public DarbininkasImpl(String darbininkas, String detale, int pagamintasKiekis, double detalesKaina){
        this.darbininkas = darbininkas;
        this.detale = detale;
        this.pagamintasKiekis = pagamintasKiekis;
        this.detalesKaina = detalesKaina;
    }

    @Override
    public String getDarbininkas() {
        return darbininkas;
    }

    @Override
    public String getDetale() {
        return detale;
    }

    @Override
    public int getPagamintasKiekis() {
        return pagamintasKiekis;
    }

    @Override
    public double getDetalesKaina() {
        return detalesKaina;
    }

    @Override
    public void setDarbininkas(String darbininkas) {
        this.darbininkas = darbininkas;
    }

    @Override
    public void setDetale(String detale) {
        this.detale = detale;
    }

    @Override
    public void setPagamintasKiekis(int pagamintasKiekis) {
        this.pagamintasKiekis = pagamintasKiekis;
    }

    @Override
    public void setDetalesKaina(double detalesKaina) {
        this.detalesKaina = detalesKaina;
    }

    @Override
    public String toString() {
        return  "Darbininkas: " + darbininkas +
                ", detalė: " + detale +
                ", Kiekis: " + pagamintasKiekis +
                ", Kaina: " + detalesKaina + " €";
    }

    @Override
    public int compareTo(DarbininkasImpl o) {
        return Comparator
                .comparing(DarbininkasImpl::getPagamintasKiekis)
                .reversed()
                .thenComparing(DarbininkasImpl::getDetale)
                .compare(this, o);
    }
}
