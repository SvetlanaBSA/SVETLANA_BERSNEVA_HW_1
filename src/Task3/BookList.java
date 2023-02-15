package Task3;

import java.util.Scanner;

public class BookList {
    private Book[] books;
    private int booksCount;
    public BookList(int booksCount) {
        books = new Book[booksCount];
        this.booksCount = booksCount;
    }
    public static int askCountOfBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько книг вы хотите добавить?");
        int booksCount = scanner.nextInt();
        return booksCount;
    }
    public void enterBooks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < booksCount; i++) {
            System.out.println("Введите название #" + (i+1) + " книги: ");
            String title = scanner.nextLine();
            System.out.println("Введите имя автора: ");
            String authors = scanner.nextLine();
            System.out.println("год публикации: ");
            int year = scanner.nextInt();
            System.out.println("кол-во страниц: ");
            int pagesCount = scanner.nextInt();
            System.out.println("Цена: ");
            int price = scanner.nextInt();
            System.out.println("Тип переплета: ");
            String type = scanner.next();
            books[i] = new Book((i + 1), title, authors, year, pagesCount, price, type);
            System.out.println(books[i]);
        }
    }
    public void outputByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Книги какого автора Вы ищете: ");
        String authorSearch = scanner.nextLine();
        System.out.println("Найдено:");
        int countBooksByAuthor = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getAuthors().equalsIgnoreCase(authorSearch)) {
                System.out.println(books[i]);
                countBooksByAuthor++;
            }
        }
        if (countBooksByAuthor==0) {
            System.out.println("Не найдено ни одной книги с автором: " + authorSearch);
        }
    }
    public void outputByBookName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую книгу вы ищете (название): ");
        String bookSearch = scanner.nextLine();
        System.out.println("Найдено:");
        int countBooksByBookName = 0;
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().contains(bookSearch)) {
                System.out.println(books[i]);
                countBooksByBookName++;
            }
        }
        if (countBooksByBookName==0) {
            System.out.println("Не найдено ни одной книги которая содержит: " + bookSearch);
        }
    }
    public void outputBooksByPublicationDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой период включительно вы ищете книги?");
        System.out.println("Введите начальную дату:");
        int startDate = scanner.nextInt();
        System.out.println("Введите конечную дату:");
        int endDate = scanner.nextInt();
        System.out.println("Найдено:");
        int countBooksByDate = 0;
        for (int i = 0; i<booksCount; i++) {
            int bookYear = books[i].getYear();
            if (startDate <= bookYear && bookYear <= endDate) {
                System.out.println(books[i]);
                countBooksByDate++;
            }
        }
        if (countBooksByDate==0) {
            System.out.println("Не найдено ни одной книги c датой публикации с " + startDate +
                    " по " + endDate);
        }
    }
}
