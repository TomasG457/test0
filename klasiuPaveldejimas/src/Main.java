import bazine.LeidinysImpl;
import isvestine.KnygaImpl;

public class Main {
    public static void main(String[] args) {
        LeidinysImpl leidinys1 = new LeidinysImpl("knyga", false, 500);
        LeidinysImpl leidinys2 = new LeidinysImpl("žurnalas", true, 40);
        LeidinysImpl leidinys3 = new LeidinysImpl("laikraštis", true, 15);
        LeidinysImpl leidinys4 = new LeidinysImpl("knyga", false, 200);
        LeidinysImpl leidinys5 = new LeidinysImpl("knyga", false, 600);

        KnygaImpl knyga1 = new KnygaImpl("knyga", false, 716, "Altorių šešėlyje", true, "grožinė");
        KnygaImpl knyga2 = new KnygaImpl("knyga", false, 512, "Anatomija", true, "mokslinė");
        KnygaImpl knyga3 = new KnygaImpl("knyga", false, 234, "Rūgiuose prie bedugnės", true, "grožinė");
        KnygaImpl knyga4 = new KnygaImpl("knyga", false, 192, "Fizika 10", true, "vadovėlis");
        KnygaImpl knyga5 = new KnygaImpl("knyga", false, 312, "Musių valdovas", true, "grožinė");

        LeidinysImpl[] leidiniai = new LeidinysImpl[10];
        leidiniai[0] = leidinys1;
        leidiniai[1] = leidinys2;
        leidiniai[2] = leidinys3;
        leidiniai[3] = leidinys4;
        leidiniai[4] = leidinys5;
        leidiniai[5] = knyga1;
        leidiniai[6] = knyga2;
        leidiniai[7] = knyga3;
        leidiniai[8] = knyga4;
        leidiniai[9] = knyga5;

        for (LeidinysImpl leidinys : leidiniai) {
            if (leidinys instanceof KnygaImpl) {
                KnygaImpl knyga = (KnygaImpl) leidinys;
                if (knyga.getZanras().equals("grožinė")) {
                        System.out.println(knyga);
                }
            }
        }
//        System.out.println();
//        for (LeidinysImpl leidinys : leidiniai) {
//            System.out.println(leidinys);
//        }
    }
}