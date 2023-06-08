package task4_v2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoPark {
    public List<Vehicle> autos;

    public List<Truck> trucks;

    public List<ElectricCar> electricCars;

    public List<PetrolCar> petrolCars;

    private boolean autosIsEmpty = true;

    private boolean trucksIsEmpty = true;

    private boolean electricCarsIsEmpty = true;

    private boolean petrolCarsIsEmpty = true;

    public AutoPark() {
        trucks = new ArrayList<>();
        electricCars = new ArrayList<>();
        petrolCars = new ArrayList<>();
        autos = new ArrayList<>();
        getTrucks();
        getElectricCars();
        getPetrolCars();
        getAutoPark();
    }

    public void getTrucks() {
        if (trucksIsEmpty) {
            getTrucksFromCsv();
        }
        trucksIsEmpty = false;
    }

    public void getElectricCars() {
        if (electricCarsIsEmpty) {
            getElectricCarsFromCsv();
        }
        electricCarsIsEmpty = false;
    }

    public void getPetrolCars() {
        if (petrolCarsIsEmpty) {
            getPetrolCarsFromCsv();
        }
        petrolCarsIsEmpty = false;
    }

    public void getAutoPark() {
        if (autosIsEmpty) {
            getAutoParkFromCsv();
        }
        autosIsEmpty = false;
    }

    public void showAllCarsInTheAutoPark() {
        System.out.println("Все автомобили в Автопарке");
        System.out.println("- Все автомобили Грузовые");
        FileUtils.printAutosTruck(trucks);
        System.out.println("- Все легковые электро-автомобили");
        FileUtils.printAutosElectricCar(electricCars);
        System.out.println("- Все легковые автомобили на бензине");
        FileUtils.printPetrolCar(petrolCars);

        System.out.println();
    }

    public void getAutoParkCost() {
        System.out.println("Цена всех машин в автопарке:" + autoParkCostCalculation());
        System.out.println();
    }

    public void sortAutosByLitersPerOneHundredKm() {
        System.out.println("Автопарк после сортировки по litersPerOneHundredKm (от меньшего к большему):");
        FileUtils.printAutosVehicle(sortingByLitersPerOneHundredKm(autos));
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

    private void getTrucksFromCsv() {
        File inputFile = new
                File(Objects.requireNonNull(this.getClass().getResource("/testDataTrucksPark.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        trucks = FileUtils.readTrucksFromCsv(filePath);
    }

    private void getElectricCarsFromCsv() {
        File inputFile = new
                File(Objects.requireNonNull(this.getClass().getResource("/testDataElectricCarsPark.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        electricCars = FileUtils.readElectricCarsFromCsv(filePath);
    }

    private void getPetrolCarsFromCsv() {
        File inputFile = new
                File(Objects.requireNonNull(this.getClass().getResource("/testDataElectricCarsPark.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        petrolCars = FileUtils.readPetrolCarsFromCsv(filePath);
    }

    private void getAutoParkFromCsv() {
        autos.addAll(getVehiclesFromCsv("/testDataTrucksPark.csv"));
        autos.addAll(getVehiclesFromCsv("/testDataElectricCarsPark.csv"));
    }

    private List<Vehicle> getVehiclesFromCsv(String fileName) {
        File inputFile = new
                File(Objects.requireNonNull(this.getClass().getResource(fileName)).getFile());
        String filePath = inputFile.getAbsolutePath();

        return FileUtils.readAutosFromCsv(filePath);
    }

    private int autoParkCostCalculation() {
        int autoParkCost = 0;
        for (Vehicle a : autos) {
            int autoCost = a.getCost();
            autoParkCost =  autoParkCost + autoCost;
        }
        return autoParkCost;
    }

    private List<Vehicle> sortingByLitersPerOneHundredKm(List<Vehicle> autos) {
        List<Vehicle> sortedAutos = new ArrayList<>(autos);
        int autosCount = sortedAutos.size();
        for (int i = 0; i < autosCount-1; i++) {
            for (int j = i; j < autosCount; j++) {
                if (sortedAutos.get(i).getLitersPerOneHundredKm() > sortedAutos.get(j).getLitersPerOneHundredKm()) {
                    Vehicle x = sortedAutos.get(j);
                    sortedAutos.remove(j);
                    sortedAutos.add(i,x);
                }
            }
        }
        return sortedAutos;
    }

    private void printAutosWithSpeedBtwMinMax(int minSpeed, int maxSpeed) {
        int countAutosByMaxSpeed = 0;
        for (Vehicle a: autos) {
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
