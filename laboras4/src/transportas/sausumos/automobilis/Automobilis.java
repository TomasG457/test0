package transportas.sausumos.automobilis;

public interface Automobilis {
    void setMarke (String marke);
    void setDuruSkaicius (int duruSkaicius);
    void setIsElektrinis (boolean isElektrinis);
    String getMarke();
    int getDuruSkaicius();
    boolean isElektrinis();
}
