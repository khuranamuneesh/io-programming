import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchingNameCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;

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

                String name = data[1];

                if (name.equalsIgnoreCase(searchName)) {
                    String department = data[2];
                    String salary = data[3];

                    System.out.println("Employee Found!");
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);
                    found = true;
                    break;
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Employee not found: " + searchName);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
