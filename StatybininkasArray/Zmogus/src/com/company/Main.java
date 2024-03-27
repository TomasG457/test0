package com.company;

import com.paveldejimas.bazine.ZmogusImpl;
import com.paveldejimas.isvestine.StatybininkasImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {

        StatybininkasImpl petras = new StatybininkasImpl("123456", "Petras", "Petrauskas", 25, 61, 174, "tamsi",
                5.5, "profesinis", "stogdengys", 900);
        StatybininkasImpl antanas = new StatybininkasImpl("123456", "Leonas", "Petrauskas", 25, 61, 174, "sviesi",
                3.9, "profesinis", "betonuotojas", 1000);
        StatybininkasImpl leonas = new StatybininkasImpl("123456", "Stasys", "Petrauskas", 25, 61, 174, "sviesi",
                4, "profesinis", "stogdengys", 1500);
        StatybininkasImpl aloyzas = new StatybininkasImpl("123456", "Aldona", "Petrauskas", 25, 61, 174, "sviesi",
                2, "profesinis", "betonuotojas", 850);
        StatybininkasImpl stasys = new StatybininkasImpl("123456", "Brone", "Petrauskas", 25, 61, 174, "tamsi",
                5.5, "profesinis", "stogdengys", 900);
        StatybininkasImpl anele = new StatybininkasImpl("123456", "Petras", "Petrauskas", 25, 61, 174, "sviesi",
                3.9, "profesinis", "betonuotojas", 1000);
        StatybininkasImpl petronele = new StatybininkasImpl("123456", "Petras", "Petrauskas", 25, 61, 174, "sviesi",
                4, "profesinis", "murininkas", 1500);
        StatybininkasImpl klemensas = new StatybininkasImpl("123456", "Petras", "Petrauskas", 25, 61, 174, "sviesi",
                2, "profesinis", "betonuotojas", 850);
        StatybininkasImpl vytautas = new StatybininkasImpl("123456", "Petras", "Petrauskas", 25, 61, 174, "sviesi",
                4, "profesinis", "stogdengys", 1500);
        StatybininkasImpl skirgaila = new StatybininkasImpl("123456", "Petras", "Petrauskas", 25, 61, 174, "sviesi",
                2, "profesinis", "stogdengys", 850);

        ArrayList<StatybininkasImpl> statybininkai = new ArrayList<>();
        statybininkai.add(petras);
        statybininkai.add(antanas);
        statybininkai.add(leonas);
        statybininkai.add(aloyzas);
        statybininkai.add(stasys);
        statybininkai.add(anele);
        statybininkai.add(petronele);
        statybininkai.add(klemensas);
        statybininkai.add(vytautas);
        statybininkai.add(skirgaila);

//       spausdintiMasyvaForEach(statybininkai);

//        spausdintiMasyvaIterator(statybininkai);

//        spausdintiMasyvaLambda(statybininkai);

//        trintiStatybininkusIterator(statybininkai);
//        System.out.println("Atspauzdinamas masyvas is kurio isimti statybininkai turintys maziau nei 4 metus stazo: ");
//        spausdintiMasyvaForEach(statybininkai);

        trintiStatybininkusLambda(statybininkai);
        System.out.println("Atspauzdinamas masyvas is kurio isimti statybininkai turintys maziau nei 4 metus stazo: ");
        spausdintiMasyvaForEach(statybininkai);

        // 3. Atlikti saraso rikiavima
        Collections.sort(statybininkai);
        System.out.println("Rikiuojamas sarasas pagal atlyginima ir issilavinima: ");
        spausdintiMasyvaForEach(statybininkai);
    }
    public static void spausdintiMasyvaForEach(ArrayList<StatybininkasImpl> statybininkai){
        for (StatybininkasImpl statybininkas : statybininkai) {
            System.out.println(statybininkas);
        }
    }
    public static void spausdintiMasyvaIterator(ArrayList<StatybininkasImpl> statybininkai){
        Iterator<StatybininkasImpl> i = statybininkai.iterator();
        while (i.hasNext()) {
            StatybininkasImpl statybininkas = i.next();
            System.out.println(statybininkas);
        }
    }
    public static void spausdintiMasyvaLambda(ArrayList<StatybininkasImpl> statybininkai) {
        statybininkai.forEach(statybininkas -> {
            System.out.println("Statybininku sarasas " + statybininkas);
        });
    }
    public static void trintiStatybininkusIterator(ArrayList<StatybininkasImpl> statybininkai) {
        Iterator<StatybininkasImpl> i = statybininkai.iterator();
        while (i.hasNext()) {
            StatybininkasImpl statybininkas = i.next();
            if (statybininkas.getStazas() < 4) {
                i.remove();
            }
        }
    }
    public static void trintiStatybininkusLambda(ArrayList<StatybininkasImpl> statybininkai){
        statybininkai.removeIf(statybininkas -> statybininkas.getStazas() < 4);
    }
}