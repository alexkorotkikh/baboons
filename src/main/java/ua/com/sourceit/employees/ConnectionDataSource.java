package ua.com.sourceit.employees;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * User: alexkorotkikh
 * Date: 12/20/13
 * Time: 7:23 PM
 */
public class ConnectionDataSource {
    private static Connection connection;

    private ConnectionDataSource() {
    }

    public static Connection getConnection(String login, String password) throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceit" +
                    "?user=" + login +
                    "&password=" + password);
        }
        return connection;
    }
}
