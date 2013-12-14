package ua.com.sourceit.employees;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 12/14/13
 * Time: 12:16 PM
 */
public class EmployeeDataSourceTest {
    @Test
    public void testGetData() throws Exception {
        //Given
        EmployeeDataSource ds =
                EmployeeDataSource.createDataSourceByFilename("src/main/resources/employees.txt");

        //When
        List<String[]> data = ds.getData();

        //Then
        assertEquals(14, data.size());
        assertEquals(6, data.get(0).length);
    }
}
