package task3;

public class Book {
    private int id;
    private String title;
    private String authors;
    private int year;
    private int pagesCount;
    private int price;
    private String type;
    public Book(int id, String title, String authors, int year, int pagesCount, int price, String type){
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.pagesCount = pagesCount;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("id - ").append(id).append("; ");
        out.append("title - ").append(title).append("; ");
        out.append("authors - ").append(authors).append("; ");
        out.append("year - ").append(year).append("; ");
        out.append("pagesCount - ").append(pagesCount).append("; ");
        out.append("price - ").append(price).append("; ");
        out.append("type - ").append(type).append(".");
        return out.toString();
    }

    public String getAuthors() {
        return authors;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
}
