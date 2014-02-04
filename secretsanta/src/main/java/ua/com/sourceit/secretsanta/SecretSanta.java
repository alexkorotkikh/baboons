package ua.com.sourceit.secretsanta;

/**
 * User: alexkorotkikh
 * Date: 1/17/14
 * Time: 6:51 PM
 */
public class SecretSanta {
    SecretSantaDao dao;

    public SecretSanta() {
//        this.dao = new SecretSantaDao(SessionFactorySingleton.getSessionFactory() );
    }

    public SecretSantaCommand createCommand(String input) {
        final int menuItem;
        try {
            menuItem = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Please enter a number of menu item");
        }

        switch (menuItem) {
            case 0:
                return new ExitCommand();
            case 1:
                return new AddGroupCommand(dao);
            case 2:
                return new AddUserCommand(dao);
            // etc
            default:
                throw new IllegalArgumentException("Illegal menu item was entered: " + menuItem);
        }
    }

    public String getMenu() {
        return "0. Exit \n" +
                "1. Add group \n" +
                "2. Add user";
        // etc
    }
}
