import service.BookService;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        bookService.addBook("harrypoter",2000,1);
    }
}
