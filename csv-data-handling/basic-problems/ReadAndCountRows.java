import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file to read
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null)
            {
                if (firstLine) {
                    firstLine = false; // Skip the header row
                    continue;
                }
                count++;
            }

            reader.close();
            System.out.println("Total rows in a CSV File (excluding header): " + count);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
