package task3_v2;

import java.io.File;
import java.util.*;

public class BookList {
    private List<Book> books;

    private boolean booksIsEmpty = true;

    public BookList() {
        this.books = new ArrayList<>();
        getBookListFromCSV();
    }

    public void showAllBooksInTheBookList() {
        System.out.println("All ABooks in the BookList");
        printBooks(books);
        System.out.println();
    }

    public void outputByAuthor() {
        System.out.println("Книги какого автора Вы ищете: ");
        String authorSearchName = FileUtils.getSearchingValue();
        System.out.println("Найдено:");
        searchBooksByAuthorAndPrint(authorSearchName);
        System.out.println();
    }

    public void outputByBookName() {
        System.out.println("Какую книгу вы ищете (название): ");
        String bookSearchName = FileUtils.getSearchingValue();
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

    private void getBookListFromCSV() {
        if (booksIsEmpty) {
            File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("/testDataBookList.csv")).getFile());
            String filePath = inputFile.getAbsolutePath();

            books = FileUtils.readBooksFromCSV(filePath);
            booksIsEmpty = false;
        }
    }

    private void printBooks(List<Book> books) {
        for (Book a : books) {
            System.out.println(a);
        }
    }

    private void searchBooksByAuthorAndPrint(String authorName) {
        int countBooksByAuthor = 0;
        for (Book a : books) {
            String authors = a.getAuthors().toLowerCase();
            int index = authors.indexOf(authorName.toLowerCase());
            if (index>-1) {
                System.out.println(a);
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
                System.out.println(a);
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
                    System.out.println(a);
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
