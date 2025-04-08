import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to your CSV file

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

                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                System.out.println("Student ID   : " + id);
                System.out.println("Name         : " + name);
                System.out.println("Age          : " + age);
                System.out.println("Marks        : " + marks);
                System.out.println("------------------------------");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

