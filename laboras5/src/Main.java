public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
//buhalterinės apskaitos programa "Varžtų pasaulis 2.0 versija"
//
//        1. Įmonės cechas darbo dienos gale pateikia sąrašą (bent 10 įrašų). PASTABA: detalių pavadinimas sąraše gali ir turi kartotis, t.y. sąraše turi būti bent keli įrašai su tuo pačiu detalės pavadinimu:
//
//<darbininkas - detalė - pagamintas kiekis - detalės kaina>
//
//        2. Suformuoti ir atspausdinti vartotojui bendrą pagamintų detalių dienos suvestinę, t.y. jeigu buvo keli įrašai su tos pačios detalės pavadinimu, čia turi likti tik vienas įrašas, kuriame bendrai paskaičiuojama tų detalių suma:
//
//<detalė - pagamintas kiekis - suma(kiekis*kaina)>
//
//        3. Surikiuoti ir atspausdinti suvestinę pagal pagamintų detalių kiekį (nuo max iki min), jeigu kiekis vienodas, pagal detalės pavadinimą (nuo A iki Z).
//        4. Dienos norma- 1000 detalių. Jeigu buvo pagaminta 1000 detalių ir daugiau- rezultatuose prie kiekvieno įrašo spausdinti 'NORMA ĮVYKDYTA', priešingu atveju- 'NORMA NEĮVYKDYTA'.
//        5. Pašalinti iš suvestinės tuos įrašus, kuriuose detalės kaina viršija 100 Eur. Atspausdinti pakeistą sąrašą.
//6. SVARBU: prieš atspausdinant pakeistą masyvą būtina nurodyti vartotojui į ekraną koks veiksmas buvo atliktas (pvz.: spausdinami statybininkų atlyginimai A-Z arba spausdinami pašalinti statybininkai, kurių stažas mažiau negu 4m.). Priešingu atveju bus mažinami balai.