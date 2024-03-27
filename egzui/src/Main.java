public class Main {
    public static void main(String[] args) {
        String a = "a";
        String b = "bele";
        String c = "c";
        String ats;

        a = b;
        if (b != a)
            ats = c;
        else if (b != c)
            ats = a;
        else
            ats = b;

        System.out.println(ats);
        System.out.println(b);
    }
}