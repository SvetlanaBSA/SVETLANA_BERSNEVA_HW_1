package task3_v2;

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

    public static List<Book> readBooksFromCSV(String fileName) {
        List<Book> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] bookLine = line.split(",");
                Book book = createBook(bookLine);
                books.add(book);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return books;
    }

    public static String getSearchingValue() {
        return new Scanner(System.in).nextLine();
    }

    private static Book createBook(String[] metadata) {
        Book newBook = new Book.Builder()
                .withId(Integer.parseInt(metadata[0])) //id
                .withTitle(metadata[1]) //title
                .withAuthors(metadata[2]) //authors
                .withYear(Integer.parseInt(metadata[3])) //year
                .withPagesCount(Integer.parseInt(metadata[4])) //pagesCount
                .withPrice(Integer.parseInt(metadata[5])) //price
                .withType(metadata[6]) //type
                .build();
        return newBook;
    }
}
