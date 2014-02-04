package ua.com.sourceit.secretsanta;

import org.hsqldb.server.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: alexkorotkikh
 * Date: 1/30/14
 * Time: 5:20 PM
 */
public class DatabasePoolListener implements ServletContextListener {

    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        server = new Server();
        server.setDatabaseName(0, "file:mydb");
        server.setDatabaseName(0, "xdb");
        server.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        server.stop();
    }
}
