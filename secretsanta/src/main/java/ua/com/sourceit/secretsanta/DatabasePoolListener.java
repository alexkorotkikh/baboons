package ua.com.sourceit.secretsanta;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: alexkorotkikh
 * Date: 1/30/14
 * Time: 5:20 PM
 */
public class DatabasePoolListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Connections.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
