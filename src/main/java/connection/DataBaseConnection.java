package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    static final String URL = "jdbc:postgresql://localhost:5432/hwseven";
    static final String USER_NAME = "postgres";
    static final String PASSWORD = "myjava123";

    private static Connection connection = null;

    private DataBaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
