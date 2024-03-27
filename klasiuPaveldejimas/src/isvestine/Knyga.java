package isvestine;

public interface Knyga {
    String getPavadinimas();
    boolean getVirselis();
    String getZanras();
    void setPavadinimas(String pavadinimas);
    void setVirselis(boolean virselis);
    void setZanras(String zanras);
}