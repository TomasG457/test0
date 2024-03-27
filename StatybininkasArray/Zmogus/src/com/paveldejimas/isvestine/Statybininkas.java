package com.paveldejimas.isvestine;

public interface Statybininkas {
    void setStazas(double stazas);
    void setIssilavinimas(String issilavinimas);
    void setSpecializacija(String specializacija);
    void setAtlyginimas(double atlyginimas);
    double getStazas();
    String getIssilavinimas();
    String getSpecializacija();
    double getAtlyginimas();
}
