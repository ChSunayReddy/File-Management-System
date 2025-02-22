import java.io.*;
import java.util.Scanner;

public class FilemanagementSystem {
    public static void createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to delete file.");
        }
    }
    public static void listFiles(String dirPath) {
        File dir = new File(dirPath);
    
        if (!dir.exists()) {
            System.out.println("Error: The directory does not exist.");
            return;
        }
    
        if (!dir.isDirectory()) {
            System.out.println("Error: The provided path is not a directory.");
            return;
        }
    
        File[] files = dir.listFiles();
        
        if (files == null || files.length == 0) {
            System.out.println("The directory is empty.");
            return;
        }
    
        System.out.println("Files in directory:");
        for (File file : files) {
            System.out.println(file.getAbsolutePath()); // Display full path
        }
    }    
    // public static void listFiles(String dirPath) {
    //     File dir = new File(dirPath);
    //     if (dir.isDirectory()) {
    //         String[] files = dir.list();
    //         if (files != null && files.length > 0) {
    //             System.out.println("Files in directory:");
    //             for (String file : files) {
    //                 System.out.println(file);
    //             }
    //         } else {
    //             System.out.println("Directory is empty.");
    //         }
    //     } else {
    //         System.out.println("Invalid directory.");
    //     }
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== File Management System ===");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Read File");
            System.out.println("4. Delete File");
            System.out.println("5. List Files in Directory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter file path: ");
                    createFile(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter file path: ");
                    String writePath = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    writeFile(writePath, content);
                    break;
                case 3:
                    System.out.print("Enter file path: ");
                    readFile(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter file path: ");
                    deleteFile(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter directory path: ");
                    listFiles(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
