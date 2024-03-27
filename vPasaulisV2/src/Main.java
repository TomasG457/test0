import bazine.DarbininkasImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DarbininkasImpl darbininkas1 = new DarbininkasImpl("Adas", "Varžtas", 168, 101.00);
        DarbininkasImpl darbininkas2 = new DarbininkasImpl("Petras", "Sraigtas", 264, 0.05);
        DarbininkasImpl darbininkas3 = new DarbininkasImpl("Jonas", "Savisriegis", 98, 0.15);
        DarbininkasImpl darbininkas4 = new DarbininkasImpl("Tadas", "Medsraigtis", 264, 0.9);
        DarbininkasImpl darbininkas5 = new DarbininkasImpl("Mantas", "Kniedė", 50, 0.02 );
        DarbininkasImpl darbininkas6 = new DarbininkasImpl("Lukas", "Varžtas", 50, 101.00);
        DarbininkasImpl darbininkas7 = new DarbininkasImpl("Viktoras", "Sraigtas", 1429, 0.05);
        DarbininkasImpl darbininkas8 = new DarbininkasImpl("Nojus", "Savisriegis", 158, 0.15);
        DarbininkasImpl darbininkas9 = new DarbininkasImpl("Eduardas", "Medsraigtis", 50, 0.9);
        DarbininkasImpl darbininkas10 = new DarbininkasImpl("Bronius", "Kniedė", 1128, 0.02 );

        ArrayList<DarbininkasImpl> darbininkai = new ArrayList<>();
        darbininkai.add(darbininkas1);
        darbininkai.add(darbininkas2);
        darbininkai.add(darbininkas3);
        darbininkai.add(darbininkas4);
        darbininkai.add(darbininkas5);
        darbininkai.add(darbininkas6);
        darbininkai.add(darbininkas7);
        darbininkai.add(darbininkas8);
        darbininkai.add(darbininkas9);
        darbininkai.add(darbininkas10);


        System.out.println("*** Varžtų pasaulis 2.0 ***");
        spausdintiSuvestine(darbininkai);
        Collections.sort(darbininkai);
        System.out.println("\n>>> Atspausdinami surikiuoti rezultatai pagal kiekį (mažėjimo tvarka)\narba pagal pavadinimą (A-Z), jei detalių kiekis vienodas:");
        spausdinti(darbininkai);
        spausdintiNorma(darbininkai);
        trintiPigius(darbininkai);
        System.out.println("\n>>> Atspausdinamos detalės, pigesnės nei 100 Eur:");
        spausdinti(darbininkai);
        System.out.println("\n*** Programos pabaiga ***");
    }
    public static void spausdintiSuvestine(ArrayList<DarbininkasImpl> darbininkai) {
        Map<String, Integer> suvestine = new HashMap<>();
        Map<String, Double> bendraSuma = new HashMap<>();

        for (DarbininkasImpl darbininkas : darbininkai) {
            String detale = darbininkas.getDetale();
            int kiekis = darbininkas.getPagamintasKiekis();
            double kaina = darbininkas.getDetalesKaina();
            double detaleSuma = kiekis * kaina;

            if (suvestine.containsKey(detale)) {
                int esamasKiekis = suvestine.get(detale);
                suvestine.put(detale, esamasKiekis + kiekis);
                double esamaKaina = bendraSuma.get(detale);
                bendraSuma.put(detale, esamaKaina + detaleSuma);
            } else {
                suvestine.put(detale, kiekis);
                bendraSuma.put(detale, detaleSuma);
            }
        }

        System.out.println("\n>>> Bendra pagamintų detalių dienos suvestinė: ");
        for (Map.Entry<String, Integer> entry : suvestine.entrySet()) {
            String detale = entry.getKey();
            double suma = bendraSuma.get(detale);
            System.out.println("Detalė: " + entry.getKey() + " - " + entry.getValue() + " vnt. - Suma: " + suma + " €");
        }
    }

    public static void spausdintiNorma(ArrayList<DarbininkasImpl> darbininkai) {
        System.out.println("\n>>> Atspausdinamas dienos normos vykdymas: ");
        for (DarbininkasImpl darbininkas : darbininkai) {
            if (darbininkas.getPagamintasKiekis() < 1000){
                System.out.println(darbininkas.getDetale() + ": " + darbininkas.getPagamintasKiekis() + " vnt. - NORMA NEĮVYKDYTA.");
            }
            else {
                System.out.println(darbininkas.getDetale() + ": " + darbininkas.getPagamintasKiekis() + " vnt. - NORMA ĮVYKDYTA.");
            }
        }
    }
    public static void trintiPigius(ArrayList<DarbininkasImpl> darbininkai){
        darbininkai.removeIf(darbininkas -> darbininkas.getDetalesKaina() > 100);
    }
    public static void spausdinti(ArrayList<DarbininkasImpl> darbininkai) {
        darbininkai.forEach(System.out::println);
    }
}