import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectorySetup {

    public static void main(String[] args) {
        // Define the base directory path for the project
        String baseDir = "HRSoftware"; // Adjust this path as needed

        // List of paths to create. Add more paths as your project grows
        String[] paths = {
                baseDir + "/src/main/java/hrsoftware",
                baseDir + "/src/main/resources/css",
                baseDir + "/src/main/resources/images",
                baseDir + "/src/test/java",
                baseDir + "/lib",
                baseDir + "/out"
        };

        // Create each path
        for (String path : paths) {
            createDirectory(path);
        }

        System.out.println("Directory structure for HR Software project created successfully.");
    }

    // Method to create a single directory
    private static void createDirectory(String path) {
        try {
            Path pathToCreate = Paths.get(path);
            Files.createDirectories(pathToCreate);
            System.out.println("Created directory: " + pathToCreate.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Could not create directory " + path + ": " + e.getMessage());
        }
    }
}
