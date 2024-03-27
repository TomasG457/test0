package transportas.sausumos.automobilis;

import transportas.sausumos.SausumosTransportasImpl;

public class AutomobilisImpl extends SausumosTransportasImpl implements Automobilis {
    private String marke;
    private int duruSkaicius;
    private boolean isElektrinis;

    public AutomobilisImpl(String tipas, boolean variklis, int metai, String marke, int duruSkaicius, boolean isElektrinis){
        super(tipas, variklis, metai);
        this.marke = marke;
        this.duruSkaicius = duruSkaicius;
        this.isElektrinis = isElektrinis;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }
    public void setDuruSkaicius(int duruSkaicius) {
        this.duruSkaicius = duruSkaicius;
    }
    public void setIsElektrinis(boolean isElektrinis) {
        this.isElektrinis = isElektrinis;
    }
    public String getMarke() {
        return marke;
    }
    public int getDuruSkaicius() {
        return duruSkaicius;
    }
    public boolean isElektrinis() {
        return isElektrinis;
    }

    @Override
    public String toString() {
        String elektra = isElektrinis ? "taip" : "ne";
        return  "Anūko klasės \"Automobilis\" objektas: " +
                "Gamintojas: \"" + marke + "\"" +
                ", durų kiekis: " + duruSkaicius +
                ", elektrmobilis: " + elektra +
                '.';
    }
}
