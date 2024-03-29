package hrsoftware;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HRSoftwareApp extends Application {

    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HR Software");

        // Initialize the layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // Existing Name Field (Assuming you already have this)
        Label nameLabel = new Label("Employee Name:");
        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");

        // Additional Fields
        Label idLabel = new Label("Employee ID:");
        TextField idInput = new TextField();
        idInput.setPromptText("ID");

        Label paymentLabel = new Label("Payment per Hour:");
        TextField paymentInput = new TextField();
        paymentInput.setPromptText("Payment per Hour");

        Label clockInLabel = new Label("Clock-In Time:");
        TextField clockInInput = new TextField();
        clockInInput.setPromptText("HH:mm");

        Label clockOutLabel = new Label("Clock-Out Time:");
        TextField clockOutInput = new TextField();
        clockOutInput.setPromptText("HH:mm");

        // Submit Button
        Button submitButton = new Button("Submit");

        // Button Action Handler
        submitButton.setOnAction(e -> {
            try {
                // Validate inputs and create an Employee object...
                Employee newEmployee = new Employee(/* parameters */);
                employeeManager.addEmployee(newEmployee);

                // Clear fields, update UI as needed
            } catch (NumberFormatException ex) {
                // Handle input format errors
            } catch (IllegalArgumentException ex) {
                // Handle other input errors
            }
        });

        // Add all components to the layout
        layout.getChildren().addAll(nameLabel, nameInput, idLabel, idInput, paymentLabel, paymentInput, clockInLabel,
                clockInInput, clockOutLabel, clockOutInput, submitButton);

        // Finalize and show the stage
        Scene scene = new Scene(layout, 400, 600); // Adjust size as needed
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
