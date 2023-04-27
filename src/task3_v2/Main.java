package task3_v2;

public class Main {
    public static void main(String[] args){
        //Создать таксопарк.
        //получение данных с .csv файла с тестовыми данными
        BookList.showAllBooksInTheBookList();
        //Вывести: a) список книг заданного автора;
        BookList.outputByAuthor();
        //b) список книг название которых содержит заданное слово (фразу)
        BookList.outputByBookName();
        //c) список книг, выпущенных за определенный период времени (пр. С 1980 по 2000 гг). (3 балл)
        BookList.outputBooksByPublicationDate();
    }
}
