

package application;
	
import application.model.KundenModel;
import application.view.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Laden des Layout Containers via FXMLLoader
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/MainView.fxml"));
			Parent rootLayout = loader.load();
			
		
			// Dem MainViewController wird die PrimaryStage mitgeteilt
			MainViewController mainController = loader.getController(); // NEU
			mainController.setStage(primaryStage);	// NEU		
			mainController.loadData();
			
			//Scene erstellen und anzeigen
			Scene scene = new Scene(rootLayout);
			primaryStage.setTitle("Kunden-Browser");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
