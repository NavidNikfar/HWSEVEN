import service.AuthorService;
import service.BookService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookService bookService = new BookService();
        bookService.loadBook(7);
    }
}
