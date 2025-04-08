import java.io.*;
import java.util.*;

class StudentInfo {
    String name;
    int age;
    int marks;
    String grade;

    public StudentInfo(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setMarksAndGrade(int marks, String grade)
    {
        this.marks = marks;
        this.grade = grade;
    }

    public String toCSVRow(int id)
    {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeTwoCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<Integer, StudentInfo> studentMap = new HashMap<>();

        try {
            // Read students1.csv
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            String line;
            reader1.readLine(); // skip header

            while ((line = reader1.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                studentMap.put(id, new StudentInfo(name, age));
            }
            reader1.close();

            // Read students2.csv
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            reader2.readLine(); // skip header

            while ((line = reader2.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int marks = Integer.parseInt(data[1]);
                String grade = data[2];

                if (studentMap.containsKey(id)) {
                    studentMap.get(id).setMarksAndGrade(marks, grade);
                }
            }
            reader2.close();

            // Write merged data to new file
            FileWriter writer = new FileWriter(outputFile);
            writer.write("ID,Name,Age,Marks,Grade\n");

            for (Map.Entry<Integer, StudentInfo> entry : studentMap.entrySet()) {
                int id = entry.getKey();
                StudentInfo student = entry.getValue();
                writer.write(student.toCSVRow(id) + "\n");
            }

            writer.close();
            System.out.println("Merged CSV saved as: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
