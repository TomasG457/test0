import transportas.TransportasImpl;
import transportas.sausumos.SausumosTransportasImpl;
import transportas.sausumos.automobilis.AutomobilisImpl;


public class Main {
    public static void main(String[] args) {

        //Sukuriami 3 tėvo, 3 vaiko ir 3 anūko klasių objektai:
        System.out.println("Sukuriami 3 tėvo klasės objektai.");
        TransportasImpl transportas1 = new TransportasImpl("sausumos", true);
        TransportasImpl transportas2 = new TransportasImpl("oro", true);
        TransportasImpl transportas3 = new TransportasImpl("vandens", false);

        System.out.println("Sukuriami 3 vaiko klasės objektai.");
        SausumosTransportasImpl sausumosTransportas1 = new SausumosTransportasImpl("sausumos", true, 1990);
        SausumosTransportasImpl sausumosTransportas2 = new SausumosTransportasImpl("sausumos", true, 2005);
        SausumosTransportasImpl sausumosTransportas3 = new SausumosTransportasImpl("sausumos", true, 2020);

        System.out.println("Sukuriami 3 anūko klasės objektai.");
        AutomobilisImpl automobilis1 = new AutomobilisImpl("sausumos", true, 1988, "Volkswagen", 5, false);
        AutomobilisImpl automobilis2 = new AutomobilisImpl("sausumos", true, 2005, "Audi", 2, false);
        AutomobilisImpl automobilis3 = new AutomobilisImpl("sausumos", true, 2020, "Tesla", 5, true);

        //Į sąrašą sudedami visi objektai
        System.out.println("\nVisi sukurti objektai sudedami į sąrašą.");
        TransportasImpl[] priemones = new TransportasImpl[9];
        priemones[0] = transportas1;
        priemones[1] = transportas2;
        priemones[2] = transportas3;
        priemones[3] = sausumosTransportas1;
        priemones[4] = sausumosTransportas2;
        priemones[5] = sausumosTransportas3;
        priemones[6] = automobilis1;
        priemones[7] = automobilis2;
        priemones[8] = automobilis3;

        //ir atspausdinami anūko klasės objektai, kurie varomi elektra.
        System.out.println("\nAtrinkti anūko klasės objektai, kurie varomi elektra:");
        for (TransportasImpl elektra : priemones) {
            if (elektra instanceof AutomobilisImpl && ((AutomobilisImpl) elektra).isElektrinis()) {
                System.out.println(elektra);
            }
        }

        //Surandamas seniausias automobilis
        System.out.println("\nRandamas seniausias automobilis:");
        TransportasImpl seniausias = priemones[6];
        for (int i = 7; i < priemones.length; i++) {
            if (((AutomobilisImpl) priemones[i]).getMetai() < ((AutomobilisImpl) seniausias).getMetai()) {
                seniausias = priemones[i];
            }
        }
        System.out.println(seniausias);

        //ir pakečiama jo markė į "Rolls-Royce".
        System.out.println("\nPakeičiama seniausio automobilio markė.");
        ((AutomobilisImpl) seniausias).setMarke("Rolls-Royce");

        //Išvedamas vartotojui į ekraną.
        System.out.println("\nĮ ekraną išvedamas seniausias automobilis su pakeista marke:");
        System.out.println(seniausias);

        ////Ieškomas automobilis turintis 2 duris ir markę "Audi", radus, pakeičiami metai į "2000".
        System.out.println("\nIeškomas 2 durų Audi automobilis ir jei toks yra, jo metai pakeičiami į \"2000\".");
        AutomobilisImpl ieskomas = null;
        for (TransportasImpl audi2d : priemones) {
            if (audi2d instanceof AutomobilisImpl && ((AutomobilisImpl) audi2d).getMarke().equals("Audi") && ((AutomobilisImpl) audi2d).getDuruSkaicius() == 2) {
                System.out.println(audi2d + " Pagaminimo metai: " + ((AutomobilisImpl) audi2d).getMetai());
                ieskomas = (AutomobilisImpl) audi2d;
                ((AutomobilisImpl) audi2d).setMetai(2000);
            }
        }

        //Išvedama vartotojui į ekraną.
        System.out.println("\nĮ ekraną išvedamas pakeistas objektas:");
        assert ieskomas != null; // <<<<<<<<<<< naujas dalykas (tikrina ar kintamas kintamojo valydumas be IF sakinio)
        System.out.println(ieskomas + " Pagaminimo metai: " + ieskomas.getMetai());

        //Atspausdinama visa informacija apie automobilius, kurių lyginiai pagaminimo metai.
        System.out.println("\nInformacija apie lyginiais metais pagamintus automoblius:");
        for (TransportasImpl lyginiai : priemones) {
            if (lyginiai instanceof AutomobilisImpl && ((AutomobilisImpl) lyginiai).getMetai() % 2 == 0) {
                System.out.println("Tipas: " + lyginiai.getTipas() +
                        ", gamintojas: " + ((AutomobilisImpl) lyginiai).getMarke() +
                        ", yra variklis: " + (lyginiai.getVariklis() ? "taip" : "ne") +
                        ", elektrinis: " + (((AutomobilisImpl) lyginiai).isElektrinis() ? "taip" : "ne") +
                        ", durų kiekis: " + ((AutomobilisImpl) lyginiai).getDuruSkaicius() +
                        ", pagaminimo metai: " + ((AutomobilisImpl) lyginiai).getMetai() + ".");
            }
        }
    }
}