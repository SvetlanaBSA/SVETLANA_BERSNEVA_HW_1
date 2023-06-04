package task3_v2;

public class Book {
    private int id;
    private String title;
    private String authors;
    private int year;
    private int pagesCount;
    private int price;
    private String type;

    //add getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private Book newBook;

        public Builder() {
            newBook = new Book();
        }

        public Builder withId(int id) {
            newBook.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            newBook.title = title;
            return this;
        }

        public Builder withAuthors(String authors) {
            newBook.authors = authors;
            return this;
        }

        public Builder withYear(int year) {
            newBook.year = year;
            return this;
        }

        public Builder withPagesCount(int pagesCount) {
            newBook.pagesCount = pagesCount;
            return this;
        }

        public Builder withPrice(int price) {
            newBook.price = price;
            return this;
        }

        public Builder withType(String type) {
            newBook.type = type;
            return this;
        }

        public Book build() {
            return newBook;
        }

    }

}
