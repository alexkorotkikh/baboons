package ua.com.sourceit.secretsanta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.sourceit.secretsanta.model.Group;
import ua.com.sourceit.secretsanta.model.User;

/**
 * User: alexkorotkikh
 * Date: 1/17/14
 * Time: 7:11 PM
 */
public class SecretSantaDao {

    private SessionFactory sessionFactory;

    public SecretSantaDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createGroup(String groupName) {
        final Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.persist(new Group(groupName));
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void createUser(String userName, String groupName) {
        final Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            final Group group =
                    (Group) session.createQuery("select g from Group g where g.name = :name")
                            .setString("name", groupName)
                            .uniqueResult();
            session.persist(new User(userName, group));
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
