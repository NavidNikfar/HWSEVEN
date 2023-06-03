package service;

import Entity.Author;
import repository.AuthorRepository;
import repository.BookRepository;

import java.sql.SQLException;

public class AuthorService {
    public void register(String firstname, String lastname, int age) throws SQLException  {
        Author author = new Author(firstname,lastname,age);
        AuthorRepository authorRepository = new AuthorRepository();
        authorRepository.save(author);
        System.out.println(author);
    }

    public Author loadAuthor(int id) throws SQLException {
        AuthorRepository authorRepository = new AuthorRepository();
        return authorRepository.load(id);
    }
}
