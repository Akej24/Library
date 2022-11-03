package Options;

public class Library{
    private int id;
    private String title;
    private String author;
    private String releaseDate;
    private int numberOfPages;
    private int price;
    private boolean status;

    public Library(int id, String title, String author, String releaseDate, int numberOfPages, int price, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
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
}
