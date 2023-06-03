package service;

import Entity.Book;
import repository.BookRepository;

public class BookService {
    public void addBook(String bookName, int year, int authorId) {
        Book book = new Book(bookName, year, authorId);
        BookRepository.save(book);
        System.out.println("Name : " + bookName + "  Year : " + year + "  authorId : " + authorId);
    }
}
