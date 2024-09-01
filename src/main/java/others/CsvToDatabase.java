package others;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CsvToDatabase {

    public static void main(String[] args) {
        try {
            // Read CSV file
            List<String[]> csvData = readCsv("C:\\Users\\Raghav\\Documents\\Java\\SpringBoot\\sagitDevos\\dataToUploadAsCSV.csv");

            // Persist data to Objects
            persistDataToObjects(csvData);

        } catch (IOException | CsvException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> readCsv(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }

    private static void persistDataToObjects(List<String[]> data) throws SQLException {
        try {
            List<EmployeeDataObject> employeeDataObjects = new ArrayList<>();

            // Iterate over CSV data
            for (String[] row : data) {
                EmployeeDataObject employeeDataObject = new EmployeeDataObject(row[0], row[1]);
                employeeDataObjects.add(employeeDataObject);
            }
            employeeDataObjects.stream().forEach(obj -> System.out.println(obj));
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}

class EmployeeDataObject {
    String name;
    String department;

    public EmployeeDataObject(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDataObject{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
