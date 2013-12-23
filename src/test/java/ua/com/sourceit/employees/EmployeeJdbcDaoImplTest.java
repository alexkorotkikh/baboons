package ua.com.sourceit.employees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 12/21/13
 * Time: 10:39 AM
 */
public class EmployeeJdbcDaoImplTest {

    private EmployeeDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new EmployeeJdbcDaoImpl(ConnectionDataSource.getConnection("test", "test"));
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        assertEquals(14, dao.getAllEmployees().size());
    }
}
