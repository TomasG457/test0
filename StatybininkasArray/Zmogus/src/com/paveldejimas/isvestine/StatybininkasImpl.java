package com.paveldejimas.isvestine;

import com.paveldejimas.bazine.ZmogusImpl;

import java.util.Comparator;

// Vaiko klase StatybininkasImpl paveldi (praplecia) tevo klase ZmogusImpl
// Ir realizuoja interfeisa Statybininkas

// 1. Norint atlikti rikiavima, pirmiausia reikia realizuoti Comparable interfeisa toje klaseje, kurios objektus sarase noresite rikiuoti
public class StatybininkasImpl extends ZmogusImpl implements Statybininkas, Comparable<StatybininkasImpl>{
    private double stazas;
    private String issilavinimas;
    private String specializacija;
    private double atlyginimas;

    public StatybininkasImpl(
            // tevo klases ZmogusImpl konstruktoriaus parametrai
            String asmensKodas, String vardas, String pavarde, int amzius, double svoris, double ugis, String plaukuSpalva,
            // vaiko klases StatybininkasImpl konstruktoriaus parametrai
            double stazas, String issilavinimas, String specializacija, double atlyginimas) {
                super(asmensKodas, vardas, pavarde, amzius, svoris, ugis, plaukuSpalva);
                // kviecia tevo klases konstruktoriu su super
                this.stazas = stazas;
                this.issilavinimas = issilavinimas;
                this.specializacija = specializacija;
                this.atlyginimas = atlyginimas;
    }

    @Override
    public void setStazas(double stazas) {
        this.stazas = stazas;
    }

    @Override
    public void setIssilavinimas(String issilavinimas) {
        this.issilavinimas = issilavinimas;
    }

    @Override
    public void setSpecializacija(String specializacija) {
        this.specializacija = specializacija;
    }

    @Override
    public void setAtlyginimas(double atlyginimas) {
        this.atlyginimas = atlyginimas;
    }

    @Override
    public double getStazas() {
        return stazas;
    }

    @Override
    public String getIssilavinimas() {
        return issilavinimas;
    }

    @Override
    public String getSpecializacija() {
        return specializacija;
    }

    @Override
    public double getAtlyginimas() {
        return atlyginimas;
    }

    // 2. Reikia realizuoti compareTo metoda
    @Override
    public int compareTo(StatybininkasImpl o) {
        // Comparator = lygintojas
        return Comparator
                // nurodomas pirmas pozymis pagal kuri lyginsite
                .comparing(StatybininkasImpl::getAtlyginimas)
                //rikiavimas nuo Z-A
                .reversed()
                // nurodomas antras ir n-tasis pozymis
                .thenComparing(StatybininkasImpl::getIssilavinimas)
                // obuoliu is kasiko principas
                .compare(this,o);
    }



    public class rikiuotiStatybininkus implements Comparator <StatybininkasImpl> {
        @Override
        public int compare(StatybininkasImpl o1, StatybininkasImpl o2) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "stazas=" + stazas +
                ", issilavinimas='" + issilavinimas + '\'' +
                ", specializacija='" + specializacija + '\'' +
                ", atlyginimas=" + atlyginimas;
    }
}
