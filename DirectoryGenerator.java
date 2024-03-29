import java.io.File;

public class DirectoryGenerator {
    public static void main(String[] args) {
        String rootDir = "HRSoftware";
        
        File srcDir = new File(rootDir + "/src/main/java/hrsoftware");
        File resourcesDir = new File(rootDir + "/src/main/resources");
        File testDir = new File(rootDir + "/src/test/java");
        File libDir = new File(rootDir + "/lib");
        File outDir = new File(rootDir + "/out");
        
        // Create directories
        srcDir.mkdirs();
        resourcesDir.mkdirs();
        testDir.mkdirs();
        libDir.mkdirs();
        outDir.mkdirs();
        
        // Create files
        createFile(srcDir, "Main.java");
        createFile(srcDir, "Employee.java");
        createFile(srcDir, "EmployeeManager.java");
        createFile(srcDir, "ShiftManager.java");
        createFile(srcDir, "PaymentManager.java");
        createFile(srcDir, "GUI.java");
        
        // Create directories inside resources
        new File(resourcesDir, "css").mkdirs();
        new File(resourcesDir, "images").mkdirs();
        
        System.out.println("Directory structure created successfully.");
    }
    
    private static void createFile(File parentDir, String fileName) {
        try {
            File file = new File(parentDir, fileName);
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
