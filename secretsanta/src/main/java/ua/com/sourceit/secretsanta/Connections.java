package ua.com.sourceit.secretsanta;

import com.mysql.jdbc.Driver;
import org.apache.commons.dbcp.*;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: alexkorotkikh
 * Date: 1/30/14
 * Time: 5:37 PM
 */
public class Connections {
    private static PoolingDataSource dataSource;

    public static Connection getInstance() throws SQLException {
        return dataSource.getConnection();
    }

    private Connections() {

    }

    public static void init() {
        try {
            Class.forName(Driver.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(DATABASE_URL, null);
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null, null, "SELECT 1", false, true);
        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnectionFactory);
        dataSource = new PoolingDataSource(connectionPool);
    }

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sourceit?user=test&password=test";
}
