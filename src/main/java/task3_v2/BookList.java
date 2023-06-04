package task3_v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BookList {
    private static List<Book> books;

    public BookList() {
        this.books = new ArrayList<>();
    }

    public void getBookList() {
        books = getBookListFromCSV();
    }

    public void showAllBooksInTheBookList() {
        getBookListFromCSV();
        System.out.println("All ABooks in the BookList");
        printBooks(books);
        System.out.println();
    }

    public void outputByAuthor() {
        System.out.println("Книги какого автора Вы ищете: ");
        String authorSearchName = getSearchingValue();
        System.out.println("Найдено:");
        searchBooksByAuthorAndPrint(authorSearchName);
        System.out.println();
    }

    public void outputByBookName() {
        System.out.println("Какую книгу вы ищете (название): ");
        String bookSearchName = getSearchingValue();
        System.out.println("Найдено:");
        searchBooksByNameAndPrint(bookSearchName);
        System.out.println();
    }

    public void outputBooksByPublicationDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой период включительно вы ищете книги?");
        System.out.println("Введите начальную дату:");
        int startDate = scanner.nextInt();
        System.out.println("Введите конечную дату:");
        int endDate = scanner.nextInt();
        printBooksWithPublicationDateBtwMinMax(startDate, endDate);
        System.out.println();
    }

    private List<Book> getBookListFromCSV() {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("/testDataBookList.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        books = readBooksFromCSV(filePath);
        return books;
    }

    private List<Book> readBooksFromCSV(String fileName) {
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

    private Book createBook(String[] metadata) {
        Book newBook = new Book.Builder()
                .withId(Integer.parseInt(metadata[0])) //id
                .withTitle(metadata[1]) //title
                .withAuthors(metadata[2]) //authors
                .withYear(Integer.parseInt(metadata[3])) //year
                .withPagesCount(Integer.parseInt(metadata[4])) //pagesCount
                .withPrice(Integer.parseInt(metadata[5])) //price
                .withType(metadata[6]) //type
                .build();
        return(newBook);
    }

    private void printBooks(List<Book> books) {
        for (Book a : books) {
            printBook(a);
        }
    }

    private void printBook(Book book) {
        StringBuilder out = new StringBuilder();
        out.append("id - ").append(book.getId()).append("; ");
        out.append("title - ").append(book.getTitle()).append("; ");
        out.append("authors - ").append(book.getAuthors()).append("; ");
        out.append("year - ").append(book.getYear()).append("; ");
        out.append("pagesCount - ").append(book.getPagesCount()).append("; ");
        out.append("price - ").append(book.getPrice()).append("; ");
        out.append("type - ").append(book.getType()).append(".");
        System.out.println(out);
    }

    private String getSearchingValue() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }

    private void searchBooksByAuthorAndPrint(String authorName) {
        int countBooksByAuthor = 0;
        for (Book a : books) {
            String authors = a.getAuthors().toLowerCase();
            int index = authors.indexOf(authorName.toLowerCase());
            if (index>-1) {
                printBook(a);
                countBooksByAuthor++;
            }
        }
        if (countBooksByAuthor==0) {
            System.out.println("Не найдено ни одной книги с автором: " + authorName);
        }
    }

    private void searchBooksByNameAndPrint(String bookSearch) {
        int countBooksByBookName = 0;
        for (Book a : books) {
            String title = a.getTitle().toLowerCase();
            int index = title.indexOf(bookSearch.toLowerCase());
            if (index>-1) {
                printBook(a);
                countBooksByBookName++;
            }
        }
        if (countBooksByBookName==0) {
            System.out.println("Не найдено ни одной книги которая содержит: " + bookSearch);
        }
    }

    private void printBooksWithPublicationDateBtwMinMax(int startDate, int endDate) {
        if (startDate>endDate) {
            System.out.println("Начальная дата не должна быть меньше конечной");
        } else {
            System.out.println("Найдено:");
            int countBooksByDate = 0;
            for (Book a : books) {
                int bookYear = a.getYear();
                if (startDate <= bookYear && bookYear <= endDate) {
                    printBook(a);
                    countBooksByDate++;
                }
            }
            if (countBooksByDate==0) {
                System.out.println("Не найдено ни одной книги c датой публикации с " + startDate +
                        " по " + endDate);
            }
        }
    }
}
