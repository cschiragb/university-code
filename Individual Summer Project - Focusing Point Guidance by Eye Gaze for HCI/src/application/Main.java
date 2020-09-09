package application;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EyeGazeGuidance.fxml"));
			Pane root = (Pane) loader.load();
			
			Scene scene = new Scene(root, 1280, 735);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // Load the CSS style sheet, no CSS styling being used at the moment.
			
			primaryStage.setTitle("Eye Gaze Guidance"); 											// Give the stage holding the GUI elements a title
			primaryStage.setScene(scene); 															// Add the scene to the stage
			primaryStage.show();
			
			MainController controller = loader.getController();
			controller.init(); 																		// Call the init instance method from the MainController class

			primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>() { 						// Set the behaviour for when the application is closed
				public void handle(WindowEvent we) {
					controller.setClosed();
				}
			}));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
			
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		launch(args);
	}
}
