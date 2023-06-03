package repository;

import Entity.Author;
import connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
    public void save(Author author) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO author (first_name, last_name, age)" +
                    " VALUES (?,?,?);");
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt(3, author.getAge());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Author load(int authorId) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String query = "select * from writers where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, authorId);
        ResultSet resultSet = statement.executeQuery();
        connection.close();
        int authorId2=0;
        String firstName=null;
        String lastName=null;
        int age=0;
        while (resultSet.next()) {
            authorId2 = resultSet.getInt("id");
            firstName = resultSet.getString("first_name");
            lastName = resultSet.getString("last_name");
            age = resultSet.getInt("age");
        }
        return new Author(authorId2, firstName, lastName, age);
    }
}
