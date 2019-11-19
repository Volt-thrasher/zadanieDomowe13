package z2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TechStation {
    public static void main(String[] args) {
        try {
            serviceApp();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void serviceApp() throws IOException {
        Scanner input = new Scanner(System.in);
        Queue<Vehicle> service = new LinkedList<>();
        BufferedReader bfr = new BufferedReader(new FileReader("service-queue.txt"));
        String line;
        while ((line=bfr.readLine())!=null){
            String[] vehicles = line.split(";");
            service.offer(new Vehicle(vehicles[0],vehicles[1],vehicles[2],
                    Integer.parseInt(vehicles[3]),vehicles[4],vehicles[5]));
        }
        String command = null;
        while (!"0".equals(command)) {
            System.out.println("Wybierz dzialnie:\n" +
                    "0 - wyjscie\n" + "1 - dodac nowy pojazd do kolejki\n" +
                    "2 - nastepny pojazd do serwisu");

            command = input.nextLine();
            switch (command) {
                case "0":
                    if (service.isEmpty()) {
                        break;
                    } else {
                        try (BufferedWriter bwr = new BufferedWriter(new FileWriter
                                (new File("service-queue.txt")));) {
                            for (Vehicle v : service) {
                                bwr.write(v.toCsv());
                                bwr.newLine();
                            }
                        }
                        break;
                    }
                case "1":
                    System.out.println("Dodaj pojazd do kolejki:\n " +
                            "Typ, marka, model, rocznik, przebieg, vin");
                    service.offer(new Vehicle(input.nextLine(), input.nextLine(), input.nextLine(),
                            Integer.valueOf(input.nextLine()), input.nextLine(), input.nextLine()));
                    System.out.println("Pojazd dodano.");
                    break;
                case "2":
                    System.out.println("Nastepny pojazd do obslugi: ");
                    System.out.println(service.peek().toCsv());
                    break;
                default:
                    System.out.println("Nieprawidlowa komenda");
            }
        }
        input.close();
    }
}
