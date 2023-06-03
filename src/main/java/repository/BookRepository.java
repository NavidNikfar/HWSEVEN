package repository;

import Entity.Book;
import connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookRepository {
    public static void save(Book book) {
        try {
            String query = "INSERT INTO book (title, author, year_of_publication) " +
                    "VALUES ( ?, ?, ?)";
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthorId());
            statement.setInt(3, book.getYearOfPublication());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Book load(int bookId) {
        Book book = null;
        try {
            String query = "SELECT * FROM book WHERE id = ?";
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                int authorId = resultSet.getInt("author");
                int yearOfPublication = resultSet.getInt("year_of_publication");
                book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setAuthorId(authorId);
                book.setYearOfPublication(yearOfPublication);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public static void delete(int bookId) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "DELETE FROM book WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
