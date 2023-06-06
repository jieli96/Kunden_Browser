package application.view;

import javafx.event.*;
import javafx.fxml.*;
import javafx.stage.*;

public class EditViewController {
	
	//Zum speichern der Referenz auf das Fenster
	private Stage stage;
	
	public void setStage(Stage s){
		this.stage = s;
	}
	
	/**
	 * Schliesst das Fenster
	 */
	@FXML
	private void saveButtonPressed(ActionEvent event) {
		this.stage.close();
	}
	
	/**
	 * Schliesst das Fenster
	 */
	@FXML
	private void cancelButtonPressed(ActionEvent event) {
		this.stage.close();
	}

}
