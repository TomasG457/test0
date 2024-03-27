public class Main {
    public static void main(String[] args) {

        // 4. Sukuriamas moksleivio klases objektas
        // int id, String vardas, String pavarde, String grupe
        // klases pavadinimas, objekto pavadinimas, new (naujas klases objektas, isskiriame vieta atmintyje), konstruktoriaus pavadinimas
        Moksleivis petras = new Moksleivis(1, "Petras", "Petraitis", "23A");
        Moksleivis povilas = new Moksleivis(2, "Povilas", "Povilaitis", "23A");
        Moksleivis adele = new Moksleivis(3, "Adele", "Adelaityte", "23B");
        Moksleivis simona = new Moksleivis(4, "Simona", "Simonaityte", "23C");
        Moksleivis elena = new Moksleivis();

//        System.out.println(petras.getVardas() + " istojo i KITM specializacija" + petras.getGrupe());
//        System.out.println(petras.getVardas() + " kursu eigoje nusprende pakeisti specializacija.");
//        petras.setGrupe(".NET");
//        System.out.println("Dabar jis mokosi " + petras.getGrupe() + " grupeje");


        elena.setGrupe("23A");
        elena.setVardas("Elena");
        elena.setPavarde("Elenaite");
        petras.setPavarde("Petrauskas");
        povilas.setVardas("Pranas");
        adele.setGrupe("23C");

        Zmogus donatas = new Zmogus(false, "49003141789", "Donatas", "Petrauskas", 20, 65, 170, "sviesi");
        Zmogus zivile = new Zmogus(true, "49003141745", "Zivile", "Petrauskaite", 30, 54, 164, "tamsi");
        Zmogus aldona = new Zmogus(true, "49003141747", "Aldona", "Aldonauskaite", 45, 78, 184, "sviesi");
        Zmogus danute = new Zmogus(true, "49003141763", "Danute", "Frankonyte", 60, 61, 174, "tamsi");
        Zmogus antanas = new Zmogus(false, "49003141714", "Antanas", "Petrauskas", 51, 52, 165, "sviesi");
        Zmogus vincas = new Zmogus(false, "49003141723", "Vincas", "Petrauskas", 36, 80, 192, "tamsi");

        donatas.setPavarde("Alisauskas");
        vincas.setAmzius(20);

        System.out.println(zivile);

    }
}