package ua.com.sourceit.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: alexkorotkikh
 * Date: 12/20/13
 * Time: 7:20 PM
 */
public class EmployeeJdbcDaoImpl implements EmployeeDao {

    private final Connection connection;

    public EmployeeJdbcDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getAllEmployees() throws ParseException, SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees");
        ResultSet resultSet = statement.executeQuery();
        List<Employee> employees = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee employee = resultSetToEmployee(resultSet);
            employees.add(employee);
        }

        return employees;
    }


    @Override
    public Employee getEmployeeById(Integer id) throws ParseException, SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSetToEmployee(resultSet);
        } else {
            return null;
        }
    }

    @Override
    public Collection<Employee> getEmployeesByTitle(String title) throws ParseException {
        return null;
    }

    @Override
    public Collection<Employee> getEmployeesWithSalaryHigherTham(Integer salary) throws ParseException {
        return null;
    }

    @Override
    public Collection<Employee> getEmployeesWithNameStartsWith(String firstLetter) throws ParseException {
        return null;
    }

    @Override
    public Collection<Employee> getSubordinatesByManagerId(Integer managerId) throws ParseException {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (name, title, started_date, salary) VALUE (?, ?, ?, ?)");
        statement.setString(1, employee.getLastname());
        statement.setString(2, employee.getTitle());
        statement.setDate(3, new java.sql.Date(employee.getStartDate().getTime()));
        statement.setInt(4, employee.getSalary());
        statement.executeUpdate();
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public void setManagerForEmployee(Employee employee, Employee manager) {

    }

    @Override
    public Collection<Employee> getEmployeesByName(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> employees = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee employee = resultSetToEmployee(resultSet);
            employees.add(employee);
        }

        return employees;
    }

    private Employee resultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setLastname(resultSet.getString("name"));
        employee.setManagerId(resultSet.getInt("manager_id"));
        employee.setSalary(resultSet.getInt("salary"));
        employee.setStartDate(resultSet.getDate("started_date"));
        employee.setTitle(resultSet.getString("title"));
        return employee;
    }

}
