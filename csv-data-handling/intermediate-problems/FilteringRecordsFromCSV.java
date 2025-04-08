import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilteringRecordsFromCSV {
    public static void main(String[] args)
    {
        String filePath = "students.csv";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            System.out.println("Students with marks > 80:");
            System.out.println();

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");

                String name = data[1];
                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println("Name  : " + name);
                    System.out.println("Marks : " + marks);
                    System.out.println("------------------------------");
                }
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}

