package hrsoftware;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HRSoftwareApp extends Application {

    private TableView<Employee> employeeTable = new TableView<>();
    private EmployeeManager employeeManager = new EmployeeManager();

    // Declare form inputs at the class level
    private TextField idInput = new TextField();
    private TextField nameInput = new TextField();
    private TextField paymentInput = new TextField();
    private TextField clockInInput = new TextField();
    private TextField clockOutInput = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HR Software");

        // Initialize the layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // Define columns for the TableView
        TableColumn<Employee, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, Double> paymentColumn = new TableColumn<>("Payment Per Hour");
        paymentColumn.setCellValueFactory(new PropertyValueFactory<>("paymentPerHour"));

        // Adding columns to the employeeTable
        employeeTable.getColumns().addAll(idColumn, nameColumn, paymentColumn);

        // Form Fields
        Label nameLabel = new Label("Employee Name:");
        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");

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

        Button submitButton = new Button("Submit");

        // Populate the TableView
        ObservableList<Employee> employeeObservableList = FXCollections
                .observableArrayList(employeeManager.getAllEmployees());
        employeeTable.setItems(employeeObservableList);

        // Submit Button Action
        submitButton.setOnAction(e -> {
            String errorMessage = "";

            try {
                int id = Integer.parseInt(idInput.getText().trim());
                String name = nameInput.getText().trim();
                double paymentPerHour = Double.parseDouble(paymentInput.getText().trim());
                String clockIn = clockInInput.getText().trim();
                String clockOut = clockOutInput.getText().trim();

                if (name.isEmpty() || clockIn.isEmpty() || clockOut.isEmpty()) {
                    errorMessage += "All fields must be filled.\n";
                }

                // Further validation logic here

                if (!errorMessage.isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Validation Error", errorMessage);
                    return;
                }

                Employee newEmployee = new Employee(id, name, paymentPerHour);
                // Assuming setters for clockIn and clockOut times
                employeeManager.addEmployee(newEmployee);

                // Update TableView
                ObservableList<Employee> updatedList = FXCollections
                        .observableArrayList(employeeManager.getAllEmployees());
                employeeTable.setItems(updatedList);

                // Clear form fields
                clearFormFields();

            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "ID and Payment per Hour must be numeric.");
            }
        });

        // Layout setup
        layout.getChildren().addAll(nameLabel, nameInput, idLabel, idInput, paymentLabel, paymentInput, clockInLabel,
                clockInInput, clockOutLabel, clockOutInput, submitButton, employeeTable);

        // Scene and Stage setup
        Scene scene = new Scene(layout, 600, 600); // Adjust size as needed
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFormFields() {
        idInput.clear();
        nameInput.clear();
        paymentInput.clear();
        clockInInput.clear();
        clockOutInput.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
