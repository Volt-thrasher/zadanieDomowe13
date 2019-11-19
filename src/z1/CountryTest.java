package z1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryTest {
    public static void main(String[] args) {
        try {
            Map<String, Country> countryMap = createMap();
            printCountryInfo(countryMap);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printCountryInfo(Map<String, Country> map) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        String code = input.nextLine();
        if (map.containsKey(code.toUpperCase())) {
            System.out.println(map.get(code.toUpperCase()));
        } else {
            System.out.println("Nie znaleziono kraju o podanym kodzie");
        }
        input.close();
    }

    private static Map<String, Country> createMap() throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(new File("countries.csv")));
        String line;
        Map<String, Country> countryMap = new HashMap<>();
        while ((line = bfr.readLine()) != null) {
            String[] countries = line.split(";");
            countryMap.put(countries[0], new Country(countries[0], countries[1], countries[2]));
        }
        return countryMap;
    }
}
