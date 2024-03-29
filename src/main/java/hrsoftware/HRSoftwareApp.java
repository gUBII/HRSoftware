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

    @Override
public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("HR Software");

    // Create layout
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));

    // Add UI components here
    Label nameLabel = new Label("Employee Name:");
    TextField nameInput = new TextField();
    nameInput.setPromptText("Name");

    Button addButton = new Button("Add Employee");
    addButton.setOnAction(e -> {
        // Here, you will call your backend logic to add the employee
        System.out.println(nameInput.getText()); // For now, just print the name to the console
        nameInput.clear(); // Clear the input field after adding
    });

    layout.getChildren().addAll(nameLabel, nameInput, addButton);

    Scene scene = new Scene(layout, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}
