package ua.com.sourceit.employees;

import java.util.Date;

/**
 * User: alexkorotkikh
 * Date: 12/13/13
 * Time: 9:08 PM
 */
public class Employee {
    private int id;
    private String lastname;
    private String title;
    private Integer managerId;
    private Date startDate;
    private int salary;

    public Employee() {
    }

    public Employee(String lastname, String title, Date startDate, int salary) {
        this.lastname = lastname;
        this.title = title;
        this.startDate = startDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
