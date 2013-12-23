package ua.com.sourceit.employees;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

/**
 * User: alexkorotkikh
 * Date: 12/20/13
 * Time: 7:18 PM
 */
public interface EmployeeDao {
    List<Employee> getAllEmployees() throws ParseException, SQLException;

    Employee getEmployeeById(Integer id) throws ParseException, SQLException;

    Collection<Employee> getEmployeesByTitle(String title) throws ParseException;

    Collection<Employee> getEmployeesWithSalaryHigherTham(Integer salary) throws ParseException;

    Collection<Employee> getEmployeesWithNameStartsWith(String firstLetter) throws ParseException;

    Collection<Employee> getSubordinatesByManagerId(Integer managerId) throws ParseException;

    void saveEmployee(Employee employee) throws SQLException;

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void setManagerForEmployee(Employee employee, Employee manager);

    Collection<Employee> getEmployeesByName(String name) throws SQLException;
}
