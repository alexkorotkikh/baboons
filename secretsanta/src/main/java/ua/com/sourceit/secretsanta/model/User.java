package ua.com.sourceit.secretsanta.model;

/**
 * User: alexkorotkikh
 * Date: 2/3/14
 * Time: 7:12 PM
 */
public class User {
    private Long id;

    private String name;

    private Group group;

    public User() {
    }

    public User(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
