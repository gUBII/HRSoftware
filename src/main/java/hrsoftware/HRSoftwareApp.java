package hrsoftware;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HRSoftwareApp extends Application {
    private final TableView<Employee> employeeTable = new TableView<>();
    private final EmployeeManager employeeManager = new EmployeeManager();

    private final TextField idInput = new TextField();
    private final TextField nameInput = new TextField();
    private final TextField paymentInput = new TextField();
    private final TextField clockInInput = new TextField();
    private final TextField clockOutInput = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HR Software");

        VBox layout = setupLayout();
        setupTableView();
        setupActionsColumn();

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox setupLayout() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        setupFormFields();
        Button submitButton = setupSubmitButton();

        layout.getChildren().addAll(new Label("Employee ID:"), idInput,
                new Label("Employee Name:"), nameInput,
                new Label("Payment per Hour:"), paymentInput,
                new Label("Clock-In Time:"), clockInInput,
                new Label("Clock-Out Time:"), clockOutInput,
                submitButton, employeeTable);
        return layout;
    }

    private void setupFormFields() {
        idInput.setPromptText("ID");
        nameInput.setPromptText("Name");
        paymentInput.setPromptText("Payment per Hour");
        clockInInput.setPromptText("HH:mm");
        clockOutInput.setPromptText("HH:mm");
    }

    private Button setupSubmitButton() {
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> handleSubmit());
        return submitButton;
    }

    private void handleSubmit() {
        String errorMessage = "";

        try {
            int id = Integer.parseInt(idInput.getText().trim());
            String name = nameInput.getText().trim();
            double paymentPerHour = Double.parseDouble(paymentInput.getText().trim());
            // Validate inputs
            if (name.isEmpty() || id <= 0 || paymentPerHour <= 0) {
                errorMessage = "Please ensure all fields are correctly filled.";
            }

            if (!errorMessage.isEmpty()) {
                showAlert("Validation Error", errorMessage);
                return;
            }

            Employee newEmployee = new Employee(id, name, paymentPerHour);
            // Set additional details if present
            employeeManager.addEmployee(newEmployee);
            refreshTable();
            clearFormFields();

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter valid numbers for ID and payment per hour.");
        }
    }

    private void setupTableView() {
        TableColumn<Employee, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Employee, Double> paymentColumn = new TableColumn<>("Payment Per Hour");
        paymentColumn.setCellValueFactory(new PropertyValueFactory<>("paymentPerHour"));

        employeeTable.getColumns().addAll(idColumn, nameColumn, paymentColumn);
        refreshTable();
    }

    private void setupActionsColumn() {
        TableColumn<Employee, Void> actionCol = new TableColumn<>("Actions");

        actionCol.setCellFactory(col -> new TableCell<>() {
            private final Button editBtn = new Button("Edit");
            private final Button deleteBtn = new Button("Delete");
            private final HBox pane = new HBox(5, editBtn, deleteBtn);

            {
                editBtn.setOnAction(event -> editEmployee(getTableView().getItems().get(getIndex())));
                deleteBtn.setOnAction(event -> deleteEmployee(getTableView().getItems().get(getIndex())));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : pane);
            }
        });

        employeeTable.getColumns().add(actionCol);
    }

    private void editEmployee(Employee employee) {
        // Placeholder - Here you'd open a dialog to edit details
        // For demonstration, let's simply log the action
        System.out.println("Edit Employee: " + employee.getName());
        // Refresh to show any potential changes
        refreshTable();
    }

    private void deleteEmployee(Employee employee) {
        employeeManager.removeEmployee(employee.getId());
        refreshTable();
    }

    private void refreshTable() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(employeeManager.getAllEmployees());
        employeeTable.setItems(employees);
    }

    private void clearFormFields() {
        idInput.clear();
        nameInput.clear();
        paymentInput.clear();
        clockInInput.clear();
        clockOutInput.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
