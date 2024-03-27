package bazine;

public interface Darbininkas {
    String getDarbininkas();
    String getDetale();
    int getPagamintasKiekis();
    double getDetalesKaina();

    void setDarbininkas(String darbininkas);
    void setDetale(String detale);
    void setPagamintasKiekis(int pagamintasKiekis);
    void setDetalesKaina(double detalesKaina);

}
