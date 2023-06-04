package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AutoPark {
    public List<Automobile> autos;

    public AutoPark() {
        autos = new ArrayList<>();
    }

    public void getAutoPark() {
        autos = getAutoParkFromCSV();
    }

    public void showAllCarsInTheAutoPark() {
        System.out.println("Все автомобили в Автопарке");
        printAutoPark(autos);
        System.out.println();
    }

    public void getAutoParkCost() {
        System.out.println("Цена всех машин в автопарке:" + autoParkCostCalculation());
        System.out.println();
    }

    public void sortAutosBylitersPerOneHandredKm() {
        System.out.println("Автопарк после сортировки по litersPerOneHundredKm (от меньшего к большему):");
        printAutoPark(sortingByLitersPerOneHundredKm(autos));
        System.out.println();
    }

    public void searchAutosBySpeedRange() {
        System.out.println("Вы ищете автомобиль развивающий max скорость в каком диапзоне включительно?");
        Scanner scanner = new Scanner(System.in);
        int minSpeed = readSpeed("min");
        int maxSpeed = readSpeed("max");
        scanner.close();

        if (minSpeed > maxSpeed) {
            System.out.println("Неверно введены min и max скорости. min > max");
            return;
        }

        System.out.println("Найдены следующие машины:");
        printAutosWithSpeedBtwMinMax(minSpeed, maxSpeed);
    }

    private List<Automobile> getAutoParkFromCSV() {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("/testDataAutoPark.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        autos = readAutosFromCSV(filePath);
        return autos;
    }

    private List<Automobile> readAutosFromCSV(String fileName) {
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

    private Automobile createAuto(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String marka = metadata[1];
        String createdDate = metadata[2];
        int cost = Integer.parseInt(metadata[3]);
        int litersPerOneHandredKm = Integer.parseInt(metadata[4]);
        int maxSpeed = Integer.parseInt(metadata[5]);
        return new Automobile(id, marka, createdDate, cost, litersPerOneHandredKm, maxSpeed);
    }

    private void printAutoPark(List<Automobile> autos) {
        for (Automobile a : autos) {
            System.out.println(a);
        }
    }

    private int autoParkCostCalculation() {
        int autoParkCost = 0;
        for (Automobile a : autos) {
            int autoCost = a.getCost();
            autoParkCost =  autoParkCost + autoCost;
        }
        return autoParkCost;
    }

    private List<Automobile> sortingByLitersPerOneHundredKm(List<Automobile> autos) {
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
        return autos;
    }

    private int readSpeed(String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите " + type + " скорость:");
        int speed = scanner.nextInt();
        return speed;
    }

    private void printAutosWithSpeedBtwMinMax(int minSpeed, int maxSpeed) {
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

