package task3_v2;

import java.io.File;
import java.util.*;

public class BookList {
    private List<Book> books;

    private boolean booksIsEmpty = true;

    public BookList() {
        this.books = new ArrayList<>();
    }

    public void getBookList() {
        if (booksIsEmpty) {
            getBookListFromCSV();
        }
        booksIsEmpty = false;
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

    private void getBookListFromCSV() {
        File inputFile = new File(Objects.requireNonNull(this.getClass().getResource("/testDataBookList.csv")).getFile());
        String filePath = inputFile.getAbsolutePath();

        FileUtils fileUtils = new FileUtils();
        books = fileUtils.readBooksFromCSV(filePath);
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
