package Options;

public class Library{
    private int id;
    private final String title;
    private final String author;
    private final String releaseDate;
    private final int numberOfPages;
    private final int price;
    private boolean status;

    public Library(String title, String author, String releaseDate, int numberOfPages, int price) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
    public Library(int id, String title, String author, String releaseDate, int numberOfPages, int price, boolean status) {
        this(title,author,releaseDate,numberOfPages,price);
        this.id = id;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
