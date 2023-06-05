package task4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoPark {
    public List<Automobile> autos;

    private boolean autosIsEmpty = true;

    public AutoPark() {
        autos = new ArrayList<>();
    }

    public void getAutoPark() {
        if (autosIsEmpty) {
            getAutoParkFromCSV();
        }
        autosIsEmpty = false;
    }

    public void showAllCarsInTheAutoPark() {
        System.out.println("Все автомобили в Автопарке");
        FileUtils.printAutoPark(autos);
        System.out.println();
    }

    public void getAutoParkCost() {
        System.out.println("Цена всех машин в автопарке:" + autoParkCostCalculation());
        System.out.println();
    }

    public void sortAutosBylitersPerOneHandredKm() {
        System.out.println("Автопарк после сортировки по litersPerOneHundredKm (от меньшего к большему):");
        FileUtils.printAutoPark(sortingByLitersPerOneHundredKm(autos));
        System.out.println();
    }

    public void searchAutosBySpeedRange() {
        System.out.println("Вы ищете автомобиль развивающий max скорость в каком диапзоне включительно?");
        System.out.println("Введите min скорость:");
        int minSpeed = FileUtils.readInt();
        System.out.println("Введите max скорость:");
        int maxSpeed = FileUtils.readInt();

        if (minSpeed > maxSpeed) {
            System.out.println("Неверно введены min и max скорости. min > max");
            return;
        }

        System.out.println("Найдены следующие машины:");
        printAutosWithSpeedBtwMinMax(minSpeed, maxSpeed);
    }

    private void getAutoParkFromCSV() {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("/testDataAutoPark.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        autos = FileUtils.readAutosFromCSV(filePath);
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
        List<Automobile> sortedAutos = new ArrayList<>(autos);
        int autosCount = sortedAutos.size();
        for (int i = 0; i < autosCount-1; i++) {
            for (int j = i; j < autosCount; j++) {
                if (sortedAutos.get(i).getLitersPerOneHundredKm() > sortedAutos.get(j).getLitersPerOneHundredKm()) {
                    Automobile x = sortedAutos.get(j);
                    sortedAutos.remove(j);
                    sortedAutos.add(i,x);
                }
            }
        }
        return sortedAutos;
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

