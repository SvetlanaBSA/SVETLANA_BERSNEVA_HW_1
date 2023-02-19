package task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoPark {
    private List<Automobile> autos;
    public AutoPark() {
        this.autos = new ArrayList<>();
    }
    public static void showAllCarsInTheAutoPark() {
        getAutoParkFromCSV();
    }
    private static void getAutoParkFromCSV() {
        List<Automobile>
                autos = readAutosFromCSV("..\\SVETLANA_BERSNEVA_HW_1\\src\\Task4\\testData.csv");
        System.out.println("All Autos in the AutoPark");
        for (Automobile a : autos) {
            System.out.println(a);
        }
    }
    private static List<Automobile> readAutosFromCSV(String fileName) {
        List<Automobile> autos = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] autoLine = line.split(",");
                Automobile auto = createAuto(autoLine);
                autos.add(auto);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return autos;
    }
    private static Automobile createAuto(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String marka = metadata[1];
        String createdDate = metadata[2];
        int cost = Integer.parseInt(metadata[3]);
        int litersPerOneHandredKm = Integer.parseInt(metadata[4]);
        int maxSpeed = Integer.parseInt(metadata[5]);
        return new Automobile(id, marka, createdDate, cost, litersPerOneHandredKm, maxSpeed);
    }
    public void getAutoParkCost() {
        int autoParkCost = 0;
        List<Automobile>
                autos = readAutosFromCSV("..\\SVETLANA_BERSNEVA_HW_1\\src\\Task4\\testData.csv");
        for (Automobile a : autos) {
            int autoCost = a.getCost();
            autoParkCost =  autoParkCost + autoCost;
        }
        System.out.println("Цена всех машин в автопарке:" + autoParkCost);
    }
    public void sortAutosBylitersPerOneHandredKm() {
        List<Automobile>
                autos = readAutosFromCSV("..\\SVETLANA_BERSNEVA_HW_1\\src\\Task4\\testData.csv");
        int autosCount = autos.size();
        for (int i = 0; i < autosCount-1; i++) {
            for (int j = i; j < autosCount; j++) {
                if (autos.get(i).getLitersPerOneHundredKm() > autos.get(j).getLitersPerOneHundredKm()) {
                    Automobile x = autos.get(j);
                    autos.remove(j);
                    autos.add(i,x);
                }
            }
        }
        System.out.println("AutoPArk After Sorting by litersPerOneHundredKm:");
        for (Automobile a : autos) {
            System.out.println(a);
        }
    }
    public void searchAutosBySpeedRange() {
        List<Automobile>
                autos = readAutosFromCSV("..\\SVETLANA_BERSNEVA_HW_1\\src\\Task4\\testData.csv");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы ищете автомобиль развивающий max скорость в каком диапзоне включительно?");
        System.out.println("Введите min скорость:");
        int minSpeed = scanner.nextInt();
        System.out.println("Введите max скорость:");
        int maxSpeed = scanner.nextInt();
        scanner.close();
        if (minSpeed > maxSpeed) {
            System.out.println("Неверно введены min и max скорости. min > max");
            return;
        }
        System.out.println("Найдены следующие машины:");
        int countAutosByMaxSpeed = 0;
        for (Automobile a: autos) {
            if (minSpeed <= a.getMaxSpeed() && a.getMaxSpeed() <= maxSpeed) {
                System.out.println(a);
                countAutosByMaxSpeed++;
            }
        }
        if (countAutosByMaxSpeed==0) {
            System.out.println("Не найдено ни одной машины с max скоростью в диапазоне с " + minSpeed +
                    " по " + maxSpeed + "км/ч");
        }
    }
}

