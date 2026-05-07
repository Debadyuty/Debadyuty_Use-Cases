package April_Day11;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileOperations {
	public static void main(String[] args) {

        String fileName = "sample.txt";

        try {
            // 1. Create File
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 2. Write to File
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is Java file handling.\n");
            writer.write("Welcome to Eclipse programming.");
            writer.close();
            System.out.println("Data written successfully.");

            // 3. Read File
            FileReader reader = new FileReader(fileName);
            Scanner sc = new Scanner(reader);

            System.out.println("\nReading file content:");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


