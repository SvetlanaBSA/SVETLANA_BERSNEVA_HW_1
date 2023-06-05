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

public class FileUtils {

    public static List<Automobile> readAutosFromCSV(String fileName) {
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

    public static void printAutoPark(List<Automobile> autos) {
        for (Automobile a : autos) {
            System.out.println(a);
        }
    }

    public static int readInt() {
        return new Scanner(System.in).nextInt();
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
}
