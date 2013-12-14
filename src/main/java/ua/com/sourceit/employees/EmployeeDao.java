package ua.com.sourceit.employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: alexkorotkikh
 * Date: 12/13/13
 * Time: 9:08 PM
 */
public class EmployeeDao {
    private final EmployeeDataSource dataSource;

    public EmployeeDao(EmployeeDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Employee> getAllEmployees() throws ParseException {
        List<String[]> data = dataSource.getData();

        List<Employee> employees = new ArrayList<Employee>();
        for (String[] emp : data) {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(emp[0]));
            employee.setLastname(emp[1]);
            employee.setTitle(emp[2]);

            if (emp[3].equals("NULL")) {
                employee.setManagerId(null);
            } else {
                employee.setManagerId(Integer.parseInt(emp[3]));
            }

            employee.setStartDate(sdf.parse(emp[4]));
            employee.setSalary(Integer.parseInt(emp[5]));
            employees.add(employee);
        }

        return employees;
    }

    public Employee getEmployeeById(Integer id) throws ParseException {
        for (Employee employee : getAllEmployees()) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public Collection<Employee> getEmployeesByTitle(String title) throws ParseException {
        Collection<Employee> col = new ArrayList<Employee>();
        for (Employee employee : getAllEmployees()) {
            if (employee.getTitle().equals(title)) {
                col.add(employee);
            }
        }

        return col;
    }

    public Collection<Employee> getEmployeesWithSalaryHigherTham(Integer salary) throws ParseException {
        Collection<Employee> col = new ArrayList<Employee>();
        for (Employee employee : getAllEmployees()) {
            if (employee.getSalary() >= salary) {
                col.add(employee);
            }
        }

        return col;
    }

    public Collection<Employee> getEmployeesWithNameStartsWith(String firstLetter) throws ParseException {
        Collection<Employee> col = new ArrayList<Employee>();
        for (Employee employee : getAllEmployees()) {
            if (employee.getLastname().startsWith(firstLetter)) {
                col.add(employee);
            }
        }

        return col;
    }

    public Collection<Employee> getSubordinatesByManagerId(Integer managerId) throws ParseException {
        Collection<Employee> col = new ArrayList<Employee>();
        for (Employee employee : getAllEmployees()) {
            if (employee.getManagerId().equals(managerId)) {
                col.add(employee);
            }
        }

        return col;
    }

    public void saveEmployee(Employee employee) {

    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

}
