package task3;

public class Main {
    public static void main(String[] args) {
        int booksCount = BookList.askCountOfBooks();
        BookList bookList = new BookList(booksCount);
        bookList.enterBooks();
        //Вывести: a) список книг заданного автора;
        bookList.outputByAuthor();
        //b) список книг название которых содержит заданное слово (фразу)
        bookList.outputByBookName();
        //c) список книг, выпущенных за определенный период времени (пр. С 1980 по 2000 гг). (3 балл)
        bookList.outputBooksByPublicationDate();
    }
}
