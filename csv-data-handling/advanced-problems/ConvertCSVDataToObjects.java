import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 1️⃣ Create Student class
class Student {
    int id;
    String name;
    int age;
    int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public void printInfo() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
        System.out.println("----------------------");
    }
}

public class ConvertCSVDataToObjects {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> studentList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            // 2️⃣ Read CSV and create Student objects
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // 3️⃣ Print all students
        System.out.println("List of Students:");
        System.out.println();
        for (Student s : studentList) {
            s.printInfo();
        }
    }
}
