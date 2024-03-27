package isvestine;

import bazine.LeidinysImpl;

public class KnygaImpl extends LeidinysImpl implements Knyga {
    String pavadinimas;
    boolean virselis;
    String zanras;

    public KnygaImpl(
        String rusis, boolean isPeriodinis, int puslapiuSkaicius,
        String pavadinimas, boolean virselis, String zanras) {
            super(rusis, isPeriodinis, puslapiuSkaicius);
                this.pavadinimas = pavadinimas;
                this.virselis = virselis;
                this.zanras = zanras;
    }

    public String getPavadinimas() { return pavadinimas; }
    public boolean getVirselis() {
        return virselis;
    }
    public String getZanras() {
        return zanras;
    }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }
    public void setVirselis(boolean virselis) { this.virselis = virselis; }
    public void setZanras(String zanras) { this.zanras = zanras; }

    @Override
    public String toString() {
        return "\"" + pavadinimas + "\" - " +
                "rūšis: " + getRusis() +
                ", periodinis: " + (getPeriodas() ? "taip" : "ne") +
                ", apimtis: " + getpuslapiuSkaicius() + " psl." +
                ", viršelis: " + (virselis ? "kietas" : "minkštas") +
                ", žanras: " + zanras + ".";
    }
}