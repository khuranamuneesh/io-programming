import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSVData
{
    public static void main(String[] args) {
        String fileName = "secure_employees.csv";

        // Write with "encryption"
        try (FileWriter writer = new FileWriter(fileName))
        {
            writer.write("ID,Name,Email,Salary\n");

            writer.write("1,Ram," + encode("ram@example.com") + "," + encode("50000") + "\n");
            writer.write("2,Shyam," + encode("shyam@example.com") + "," + encode("48000") + "\n");
            writer.write("3,Mohan," + encode("mohan@example.com") + "," + encode("52000") + "\n");

            System.out.println("Encrypted CSV written to: " + fileName);

        } catch (IOException e)
        {
            System.out.println("Writing error: " + e.getMessage());
        }

        System.out.println("\nDecrypted Records:");

        // Read and decode
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirst = true;

            while ((line = reader.readLine()) != null)
            {
                if (isFirst)
                {
                    System.out.println(line); // Header
                    isFirst = false;
                    continue;
                }

                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                String email = decode(parts[2]);
                String salary = decode(parts[3]);

                System.out.println(id + "," + name + "," + email + "," + salary);
            }

        } catch (IOException e) {
            System.out.println("Reading error: " + e.getMessage());
        }
    }

    // Simple Base64 encoding
    private static String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // Simple Base64 decoding
    private static String decode(String encodedData) {
        return new String(Base64.getDecoder().decode(encodedData));
    }
}

