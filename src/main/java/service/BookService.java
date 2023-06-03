package service;

import Entity.Book;
import repository.BookRepository;

import java.sql.SQLException;

public class BookService {
    public void addBook(String bookName, int year, int authorId) {
        Book book = new Book(bookName, year, authorId);
        BookRepository.save(book);
        System.out.println("Name : " + bookName + "  Year : " + year + "  authorId : " + authorId);
    }
    public  Book loadBook(int bookId)  {
        System.out.println(BookRepository.load(bookId));
        return BookRepository.load(bookId);
    }
}
