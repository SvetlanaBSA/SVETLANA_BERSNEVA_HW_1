package task4_v2;

import task4.Automobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<Vehicle> readAutosFromCsv(String fileName) {
        List<Vehicle> autos = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] autoLine = line.split(",");
                Vehicle auto = createVehicle(autoLine);
                autos.add(auto);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return autos;
    }

    public static List<Truck> readTrucksFromCsv(String fileName) {
        List<Truck> trucks = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] autoLine = line.split(",");
                Truck truck = (Truck) createTruck(autoLine);
                trucks.add(truck);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return trucks;
    }

    public static List<ElectricCar> readElectricCarsFromCsv(String fileName) {
        List<ElectricCar> electricCars = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] autoLine = line.split(",");
                ElectricCar electricCar = (ElectricCar) createElectricCar(autoLine);
                electricCars.add(electricCar);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return electricCars;
    }

    public static List<PetrolCar> readPetrolCarsFromCsv(String fileName) {
        List<PetrolCar> petrolCars = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] autoLine = line.split(",");
                PetrolCar petrolCar = (PetrolCar) createPetrolCar(autoLine);
                petrolCars.add(petrolCar);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return petrolCars;
    }

    private static Vehicle createVehicle(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String brand = metadata[1];
        String createdDate = metadata[2];
        int cost = Integer.parseInt(metadata[3]);
        int litersPerOneHundredKm = Integer.parseInt(metadata[4]);
        int maxSpeed = Integer.parseInt(metadata[5]);
        return new Vehicle(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed);
    }

    private static Truck createTruck(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String brand = metadata[1];
        String createdDate = metadata[2];
        int cost = Integer.parseInt(metadata[3]);
        int litersPerOneHundredKm = Integer.parseInt(metadata[4]);
        int maxSpeed = Integer.parseInt(metadata[5]);
        int maxLoadCapacity = Integer.parseInt(metadata[6]);
        return new Truck(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed, maxLoadCapacity);
    }

    private static ElectricCar createElectricCar(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String brand = metadata[1];
        String createdDate = metadata[2];
        int cost = Integer.parseInt(metadata[3]);
        int litersPerOneHundredKm = Integer.parseInt(metadata[4]);
        int maxSpeed = Integer.parseInt(metadata[5]);
        String typeOfBattery = metadata[6];
        int maxHoursBattery = Integer.parseInt(metadata[7]);
        int maxKmForOneCharge = Integer.parseInt(metadata[8]);
        return new ElectricCar(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed, typeOfBattery,
                maxHoursBattery, maxKmForOneCharge);
    }

    private static PetrolCar createPetrolCar(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String brand = metadata[1];
        String createdDate = metadata[2];
        int cost = Integer.parseInt(metadata[3]);
        int litersPerOneHundredKm = Integer.parseInt(metadata[4]);
        int maxSpeed = Integer.parseInt(metadata[5]);
        String petrolType = metadata[6];
        String engineCapacity = metadata[7];
        return new PetrolCar(id, brand, createdDate, cost, litersPerOneHundredKm, maxSpeed, petrolType,
                engineCapacity);
    }

    public static void printAutosVehicle(List<Vehicle> autos) {
        for (Vehicle a : autos) {
            System.out.println(a);
        }
    }

    public static void printAutosTruck(List<Truck> autos) {
        for (Vehicle a : autos) {
            System.out.println(a);
        }
    }

    public static void printAutosElectricCar(List<ElectricCar> autos) {
        for (Vehicle a : autos) {
            System.out.println(a);
        }
    }

    public static void printPetrolCar(List<PetrolCar> autos) {
        for (Vehicle a : autos) {
            System.out.println(a);
        }
    }

    public static int readInt() {
        return new Scanner(System.in).nextInt();
    }
}
