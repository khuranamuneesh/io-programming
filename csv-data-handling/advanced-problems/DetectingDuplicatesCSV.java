import java.io.*;
import java.util.*;

public class DetectingDuplicatesCSV
{
    public static void main(String[] args)
    {
        String filePath = "students.csv";
        Set<String> uniqueIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();
        List<String> duplicateLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null)
            {
                if (isFirstLine)
                {
                    isFirstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",");
                String id = parts[0];

                if (!uniqueIds.add(id)) {
                    // Already exists → it's a duplicate
                    duplicateIds.add(id);
                    duplicateLines.add(line);
                }
            }

            // Print duplicate results
            if (duplicateLines.isEmpty())
            {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found (by ID):");
                for (String dup : duplicateLines) {
                    System.out.println(dup);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

