package ua.com.sourceit.employees;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 12/14/13
 * Time: 12:31 PM
 */
public class EmployeeDaoTest {
    @Test
    public void testGetAllEmployees() throws Exception {
        //Given
        EmployeeDataSource ds =
                EmployeeDataSource.createDataSourceByFilename("src/main/resources/employees.txt");
        EmployeeDao dao = new EmployeeDao(ds);

        //When
        List<Employee> allEmployees = dao.getAllEmployees();

        //Then
        assertEquals(14, allEmployees.size());
        assertEquals("ALLEN", allEmployees.get(1).getLastname());
    }
}
