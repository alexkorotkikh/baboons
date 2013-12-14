package ua.com.sourceit.employees;

import ua.com.sourceit.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: alexkorotkikh
 * Date: 12/13/13
 * Time: 10:14 PM
 */
public class EmployeeDataSource {

    private String fileText;

    private EmployeeDataSource(String str) {
        this.fileText = str;
    }

    public static EmployeeDataSource createDataSourceByFilename(String filename) throws IOException {
        String s = Utils.readFromFile(new File(filename));
        return new EmployeeDataSource(s);
    }

    public List<String[]> getData() {
        List<String[]> col = new ArrayList<String[]>();

        String[] employees = fileText.split("\n");
        for (String employee : employees) {
            String[] employeeData = employee.split("\\s+");
            col.add(employeeData);
        }

        return col;
    }

}
