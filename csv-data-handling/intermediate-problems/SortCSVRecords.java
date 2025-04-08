import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void printInfo() {
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Salary     : " + salary);
        System.out.println("---------------------------");
    }
}

public class SortCSVRecords
{
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                employees.add(new Employee(id, name, department, salary));
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Sort in descending order of salary
        employees.sort((a, b) -> Double.compare(b.salary, a.salary));

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest Paid Employees:");
        System.out.println("---------------------------");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            employees.get(i).printInfo();
        }
    }
}
