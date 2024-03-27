package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Airport airport1 = new Airport("Rygos oro uostas", "Liepajas ul.", "Ryga");
//        AirportDao.create(airport1);
//
//        Airport airport2 = new Airport(4, "KITM", "KITM", "KITM");
//        AirportDao.update(airport2);
//
//        int id = 0;
//        Scanner S = new Scanner(System.in);
//        System.out.print("Įrašykite įrašo ID, kurį norite pašalinti: ");
//        id = S.nextInt();
//        AirportDao.delete(id);
        ArrayList<Airport> sarasas = AirportDao.search(1);
        if (sarasas.isEmpty()) {
            System.out.println("Oro uosto su tokiu ID nerasta.");
        }
        else {
            System.out.println(sarasas);
        }
    }
}
/// TODO: 2/6/2024 sukurti paie6kos metoda, grazinanti kelis oro uostus esancius tame paciame mieste. Miestas paduodamas per parametrus.
