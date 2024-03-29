package hrsoftware;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HRSoftwareApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HR Software");

        TabPane tabPane = new TabPane();
        BorderPane root = new BorderPane();
        root.setCenter(tabPane);
        
        // Set up scenes, tabs, and other UI components here
        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
