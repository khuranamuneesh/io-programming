import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Step 1: Create Employee class
class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Convert employee data to CSV format
    String toCSV() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class WritingDataToCSV {
    public static void main(String[] args) {
        // Step 2: Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ram", "HR", 45000));
        employees.add(new Employee(2, "Shyam", "IT", 60000));
        employees.add(new Employee(3, "Mohan", "Finance", 52000));
        employees.add(new Employee(4, "Rita", "Marketing", 48000));
        employees.add(new Employee(5, "Geeta", "IT", 58000));

        // Step 3: Write to CSV file
        String filePath = "employees.csv";

        try {
            FileWriter writer = new FileWriter(filePath);

            // Write header
            writer.write("ID,Name,Department,Salary\n");

            // Write employee data
            for (Employee e : employees) {
                writer.write(e.toCSV() + "\n");
            }

            writer.close();
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
