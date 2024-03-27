import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Knyga {
    private String pavadinimas;

    public Knyga(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }
}

class Rezervacija {
    private Knyga knyga;

    public Rezervacija(Knyga knyga) {
        this.knyga = knyga;
    }

    @Override
    public String toString() {
        return "Rezervuota knyga: " + knyga.getPavadinimas();
    }

    public Knyga getKnyga() {
        return knyga;
    }
}

class Vartotojas {
    private String vartotojoVardas;
    private String slaptazodis;

    public Vartotojas(String vartotojoVardas, String slaptazodis) {
        this.vartotojoVardas = vartotojoVardas;
        this.slaptazodis = slaptazodis;
    }

    public boolean prisijungtiKaipVartotojas(String ivestasVartotojoVardas, String ivestasSlaptazodis) {
        return vartotojoVardas.equals(ivestasVartotojoVardas) && slaptazodis.equals(ivestasSlaptazodis);
    }

    public boolean yraAdmin() {
        return false;
    }

    public static Vartotojas prisijungti(String vartotojoVardas, String slaptazodis) {
        return new Vartotojas(vartotojoVardas, slaptazodis);
    }

    public static Vartotojas prisijungtiAdministratoriumi(String vartotojoVardas, String slaptazodis) {
        if ("admin".equals(vartotojoVardas) && "admin123".equals(slaptazodis)) {
            return new Administratorius(vartotojoVardas, slaptazodis);
        } else {
            return null;
        }
    }
}

class Administratorius extends Vartotojas {
    public Administratorius(String vartotojoVardas, String slaptazodis) {
        super(vartotojoVardas, slaptazodis);
    }

    @Override
    public boolean yraAdmin() {
        return true;
    }
}

public class KnyguRezervacija {
    private List<Knyga> knyguSarasas = new ArrayList<>();
    private List<Rezervacija> rezervacijuSarasas = new ArrayList<>();
    private Vartotojas prisijungesVartotojas;

    public static void main(String[] args) {
        KnyguRezervacija rezervacija = new KnyguRezervacija();
        rezervacija.pradeti();
    }

    private void pradeti() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSveiki atvyke i knygu rezervavimo aplikacija !");
            System.out.println("\nPasirinkite veiksmą:");
            System.out.println("1. Prisijungti");
            System.out.println("2. Registruotis");
            System.out.println("3. Baigti programą");

            int veiksmas = scanner.nextInt();

            switch (veiksmas) {
                case 1:
                    prisijungti(scanner);
                    break;
                case 2:
                    registruotis(scanner);
                    break;
                case 3:
                    System.out.println("Ačiū, kad naudojotės Knygų Rezervacijos Aplikacija. Viso gero!");
                    System.exit(0);
                default:
                    System.out.println("Neteisingas pasirinkimas. Bandykite dar kartą.");
            }
        }
    }

    private void prisijungti(Scanner scanner) {
        System.out.println("Įveskite vartotojo vardą:");
        String ivestasVartotojoVardas = scanner.next();
        System.out.println("Įveskite slaptažodį:");
        String ivestasSlaptazodis = scanner.next();

        prisijungesVartotojas = Vartotojas.prisijungtiAdministratoriumi(ivestasVartotojoVardas, ivestasSlaptazodis);

        if (prisijungesVartotojas == null) {
            prisijungesVartotojas = Vartotojas.prisijungti(ivestasVartotojoVardas, ivestasSlaptazodis);
        }

        if (prisijungesVartotojas != null) {
            System.out.println("Prisijungta sėkmingai.");
            if (prisijungesVartotojas.yraAdmin()) {
                adminMeniu(scanner);
            } else {
                vartotojoMeniu(scanner);
            }
        } else {
            System.out.println("Neteisingas vartotojo vardas arba slaptažodis. Bandykite dar kartą.");
        }
    }

    private void registruotis(Scanner scanner) {
        System.out.println("Įveskite vartotojo vardą:");
        String naujasVartotojoVardas = scanner.next();
        System.out.println("Įveskite slaptažodį:");
        String naujasSlaptazodis = scanner.next();

        @SuppressWarnings("unused")
        Vartotojas naujasVartotojas = new Vartotojas(naujasVartotojoVardas, naujasSlaptazodis);
       //čia reikia pridėti vartotoja į db arba kita saugojimo mechanizma
        System.out.println("Vartotojas sėkmingai sukurtas.");
    }

    private void vartotojoMeniu(Scanner scanner) {
        while (true) {
            System.out.println("\nVartotojo Meniu:");
            System.out.println("1. Peržiūrėti visų knygų sąrašą");
            System.out.println("2. Rezervuoti knygą");
            System.out.println("3. Atiduoti knygą");
            System.out.println("4. Atsijungti");

            int veiksmas = scanner.nextInt();

            switch (veiksmas) {
                case 1:
                    perziuretiKnyguSarasa();
                    break;
                case 2:
                    rezervuotiKnyga(scanner);
                    break;
                case 3:
                    atiduotiKnyga(scanner);
                    break;
                case 4:
                    System.out.println("Atsijungta sėkmingai.");
                    prisijungesVartotojas = null;
                    pradeti();
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas. Bandykite dar kartą.");
            }
        }
    }

    private void adminMeniu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Meniu:");
            System.out.println("1. Pridėti knygą");
            System.out.println("2. Peržiūrėti visų knygų sąrašą");
            System.out.println("3. Atsijungti");

            int veiksmas = scanner.nextInt();

            switch (veiksmas) {
                case 1:
                    pridetiKnyga(scanner);
                    break;
                case 2:
                    perziuretiKnyguSarasa();
                    break;
                case 3:
                    System.out.println("Atsijungta sėkmingai.");
                    prisijungesVartotojas = null;
                    pradeti();
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas. Bandykite dar kartą.");
            }
        }
    }

    private void pridetiKnyga(Scanner scanner) {
        System.out.println("Įveskite naujos knygos pavadinimą:");

        try {
            String pavadinimas = scanner.next();
            Knyga naujaKnyga = new Knyga(pavadinimas);
            knyguSarasas.add(naujaKnyga);
            System.out.println("Nauja knyga pridėta: " + pavadinimas);
        } catch (Exception e) {
            System.out.println("Klaida: " + e.getMessage());
        }
    }

    private void perziuretiKnyguSarasa() {
        System.out.println("\nKnygų sąrašas:");
        for (Knyga knyga : knyguSarasas) {
            System.out.println(knyga.getPavadinimas());
        }
    }

    private void rezervuotiKnyga(Scanner scanner) {
        System.out.println("Įveskite norimos rezervuoti knygos pavadinimą:");
        String pavadinimas = scanner.next();

        Knyga norimaKnyga = rastiKnyga(pavadinimas);
        if (norimaKnyga != null) {
            Rezervacija rezervacija = new Rezervacija(norimaKnyga);
            rezervacijuSarasas.add(rezervacija);
            System.out.println("Knyga rezervuota sėkmingai.");
        } else {
            System.out.println("Tokios knygos nėra.");
        }
    }

    private void atiduotiKnyga(Scanner scanner) {
        System.out.println("Įveskite norimos atiduoti knygos pavadinimą:");
        String pavadinimas = scanner.next();

        Knyga atiduojamaKnyga = rastiKnyga(pavadinimas);
        if (atiduojamaKnyga != null) {
            Rezervacija rezervacija = rastiRezervacija(atiduojamaKnyga);
            if (rezervacija != null) {
                rezervacijuSarasas.remove(rezervacija);
                System.out.println("Knyga atiduota sėkmingai.");
            } else {
                System.out.println("Ši knyga nėra rezervuota.");
            }
        } else {
            System.out.println("Tokios knygos nėra.");
        }
    }

    private Knyga rastiKnyga(String pavadinimas) {
        for (Knyga knyga : knyguSarasas) {
            if (knyga.getPavadinimas().equalsIgnoreCase(pavadinimas)) {
                return knyga;
            }
        }
        return null;
    }

    private Rezervacija rastiRezervacija(Knyga knyga) {
        for (Rezervacija rezervacija : rezervacijuSarasas) {
            if (rezervacija.getKnyga().equals(knyga)) {
                return rezervacija;
            }
        }
        return null;
    }
}
