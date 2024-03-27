package org.example;

import java.sql.*;
import java.util.ArrayList;

public class AirportDao {
    public static void create(Airport airport) {
        String querry = "INSERT INTO sb_airports (biz_name, address, city) VALUES (?, ?, ?);";
        String url = "jdbc:mysql://localhost:3306/airports";
        try {
            // 1) sukuriamas prisijungimas prie duomenų bazės:
            Connection connection = DriverManager.getConnection(url, "root", "");
            // 2) sukuriama užklausa:
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            // siekiant išvengti SQL injekcijų,
            preparedStatement.setString(1, airport.getBizName());
            preparedStatement.setString(2, airport.getAddress());
            preparedStatement.setString(3, airport.getCity());
            // 3) įvykdoma užklausa (executeUpdate() metodas naudojamas, kai norime sukurti naują įrašą, redaguoti ir trinti esamą):
            //    įrašo paieškai naudojame executeQuerry() metodą.
            preparedStatement.executeUpdate();
            System.out.println("Pavyko sukurti naują įrašą!");
        } catch (SQLException a) {
            System.out.println("Nepavyko sukurti naujo įrašo!" + " Plačiau: " + a.getMessage());
        }
    }

    public static void update(Airport airport) {
        String querry = "UPDATE sb_airports SET biz_name = ?, address = ?, city = ? WHERE sb_airports.biz_id = ?;";
        String url = "jdbc:mysql://localhost:3306/airports";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, airport.getBizName());
            preparedStatement.setString(2, airport.getAddress());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.setInt(4, airport.getBizId());
            preparedStatement.executeUpdate();
            System.out.println("Duomenys atnaujinti sėkmingai.");
        } catch (SQLException e) {
            System.out.println("Duomenų atnaujinti nepavyko, nes: " + e.getMessage());
        }
    }

    public static void delete(int bizId) {
        String querry = "DELETE FROM sb_airports WHERE biz_id = ?;";
        String url = "jdbc:mysql://localhost:3306/airports";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, bizId);
            preparedStatement.executeUpdate();
            System.out.println("Įrašas ištrintas sėkmingai.");
        } catch (Exception e) {
            System.out.println("Duomenų ištrinti nepavyko, nes: " + e.getMessage());
        }
    }

    public static ArrayList<Airport> search(int bizId) {
        String querry = "SELECT * FROM sb_airports WHERE  biz_id = ?;";
        String url = "jdbc:mysql://localhost:3306/airports";
        ArrayList<Airport> oroUostai = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, bizId);
            try {
                //executeQuery metodas gražina resultSet'ą (neapdirbtą sąrašą)
                ResultSet resultSet = preparedStatement.executeQuery();

                // kol saraše yra elementų
                while (resultSet.next()) {
                    Airport airport = new Airport(resultSet.getInt("biz_Id"), resultSet.getString("biz_name"), resultSet.getString("address"), resultSet.getString("city"));
                    oroUostai.add(airport);
                    // resultSet atitinka Map, kur raktas atitinka DB esančios lentelės stulpelio pavadinimą,
                    // o reikšmė to stulpelio įrašą
                    String bizName = resultSet.getString("biz_name");
                    String address = resultSet.getString("address");
                    String city = resultSet.getString("city");
//                    System.out.println("Paieškos rezulataiai: ");
//                    System.out.println("ID: " + bizId);
//                    System.out.println("Pavadinimas: " + bizName);
//                    System.out.println("Adresas: " + address);
//                    System.out.println("Miestas: " + city);
                }
                // geroji praktika - atlikus užklausą uždaryti prisijungimus prie DB.
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Duomenų su ID " + bizId + " rasti nepavyko, nes: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Duomenų nuskaityti nepavyko, nes: " + e.getMessage());
        }
        return oroUostai;
    }
}
