import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateValueCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile);

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    // Write header as-is
                    writer.write(line + "\n");
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                // Increase IT department salaries by 10%
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10; // 10% increase
                }

                // Rebuild and write the updated line
                String updatedLine = data[0] + "," + data[1] + "," + department + "," + String.format("%.2f", salary);
                writer.write(updatedLine + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("Updated file saved as: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
