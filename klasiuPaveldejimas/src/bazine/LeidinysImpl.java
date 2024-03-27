package bazine;

public class LeidinysImpl implements Leidinys {
    private String rusis;
    private boolean isPeriodinis;
    private int puslapiuSkaicius;

    public LeidinysImpl(String rusis, boolean isPeriodinis, int puslapiuSkaicius) {
        this.rusis = rusis;
        this.isPeriodinis = isPeriodinis;
        this.puslapiuSkaicius = puslapiuSkaicius;
    }

    public String getRusis() { return rusis; }
    public boolean getPeriodas() { return isPeriodinis; }
    public int getpuslapiuSkaicius() { return puslapiuSkaicius; }
    public void setRusis(String rusis) { this.rusis = rusis; }
    public void setPeriodas(boolean periodas) { this.isPeriodinis = periodas; }
    public void setPuslapiuSkaicius(int puslapiuSkaicius) { this.puslapiuSkaicius = puslapiuSkaicius; }

    public String toString() {
        return  "Leidinys: " + rusis +
                ", periodinis: " + (isPeriodinis ? "taip" : "ne") +
                ", apimtis: " + puslapiuSkaicius + " psl.";
    }
}