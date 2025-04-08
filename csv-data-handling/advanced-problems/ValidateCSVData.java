import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args)
    {
        String filePath = "contacts.csv";

        // Regex patterns
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null)
            {
                if (firstLine) {
                    firstLine = false; // skip header
                    continue;
                }

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String email = data[2];
                String phone = data[3];

                boolean valid = true;

                // Validate email
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid email for " + name + ": " + email);
                    valid = false;
                }

                // Validate phone number
                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid phone number for " + name + ": " + phone);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("Record: " + line);
                    System.out.println("--------------------------------");
                }
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
