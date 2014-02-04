package ua.com.sourceit.secretsanta.model;

/**
 * User: alexkorotkikh
 * Date: 2/3/14
 * Time: 7:08 PM
 */
public class Group {
    private Long id;

    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
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
}
