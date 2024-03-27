public class Zmogus {
    private boolean isMoteris;
    private String asmensKodas;
    private String vardas;
    private String pavarde;
    private int amzius;
    private double svoris;
    private double ugis;
    private String plaukuSpalva;

    Zmogus(){
    }
    Zmogus(boolean isMoteris, String asmensKodas, String vardas, String pavarde, int amzius, double svoris, double ugis, String plaukuSpalva){
        this.isMoteris = isMoteris;
        this.asmensKodas = asmensKodas;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
        this.svoris = svoris;
        this.ugis = ugis;
        this.plaukuSpalva = plaukuSpalva;
    }
    public void setLytis(boolean lytis){
        this.isMoteris = lytis;
    }

    public boolean isMoteris() {
        return isMoteris;
    }
    public String getAsmensKodas(){
        return asmensKodas;
    }
    public void setVardas(String vardas){
        this.vardas = vardas;
    }
    public String getVardas(){
        return vardas;
    }
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }
    public String getPavarde() {
        return pavarde;
    }
    public void setAmzius(int amzius){
        this.amzius = amzius;
    }
    public int getAmzius() {
        return amzius;
    }
    public void setSvoris(double svoris) {
        this.svoris = svoris;
    }
    public double getSvoris() {
        return svoris;
    }
    public void setUgis(double ugis) {
        this.ugis = ugis;
    }
    public double getUgis() {
        return ugis;
    }
    public void setPlaukuSpalva(String plaukuSpalva) {
        this.plaukuSpalva = plaukuSpalva;
    }

    //    public String toString(){
//        return vardas + " " + pavarde + " " + amzius + ". Lytis " + (isMoteris ? "moteris" : "vyras");
//    }


    @Override
    public String toString() {
        return "Zmogus{" +
                "lytis=" + (isMoteris ? "moteris" : "vyras") +
                ", asmensKodas='" + asmensKodas + '\'' +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", amzius=" + amzius +
                ", svoris=" + svoris +
                ", ugis=" + ugis +
                ", plaukuSpalva='" + plaukuSpalva + '\'' +
                '}';
    }
}

