package Entity;

public class Book {
    private long id;
    private String title;
    private int authorId;
    private int yearOfPublication;

    public Book() {
    }

    public Book(String title, int yearOfPublication, int authorId) {
        this.title = title;
        this.authorId = authorId;
        this.yearOfPublication = yearOfPublication;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "tittle='" + title + '\'' +
                ", author='" + authorId + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}
