package application.view;

import java.io.IOException;
import java.time.LocalDate;

import application.model.KundenModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {
	@FXML
    private Label lblVorname;
    @FXML
    private Label lblNachname;
    @FXML
    private Label lblStrasse;
    @FXML
    private Label lblPlzOrt;
    @FXML
    private Label lblEmail;	
    @FXML
    private Label lblKundeSeit;
    @FXML
    private Label lblArt;
    @FXML
    private Label lblNewsletter;
	@FXML
	private TableView<KundenModel> tblKunde;
	@FXML
	private TableColumn<KundenModel, String> colvorname;
	@FXML
	private TableColumn<KundenModel, String> colnachname;
	// Referenz zum Primärfenster
	private Stage primaryStage; // NEU: Notwendig, um zu unterscheiden --> Modality
	
	
	public void setStage(Stage s) { // NEU: Wird vom Main.java aufgerufen s = Primary (Haupt) Stage
		this.primaryStage = s;
	}

	private ObservableList<KundenModel> kundenListe = FXCollections.observableArrayList();

	@FXML
	private void showEditView(ActionEvent event) {

		try {
			// Die EditView laden
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EditView.fxml"));
			Parent editView = loader.load();

			// Eine neue Stage für die EditView erstellen
			Stage editStage = new Stage();
			editStage.setTitle("Kunde bearbeiten");
			editStage.initModality(Modality.WINDOW_MODAL);// NEU: Funktioniert nur wenn editStage "unter" primaryStage
															// steht (siehe weiter unten)

			// Die PrimaryStage wird der EditStage mitgeteilt
			editStage.initOwner(this.primaryStage); // NEU: Nur so wird "Kunde bearbeiten" Modal gemacht (siehe weiter
													// oben)

			// Laden des Controller
			EditViewController editController = loader.getController();
			// Übergabe des erstellten Fensters
			editController.setStage(editStage);

			// Eine neue Scene mit der EditView erstellen, der EditStage übergeben und
			// anzeigen
			editStage.setScene(new Scene(editView));

			editStage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void loadData() {
		KundenModel kunde1 = new KundenModel("Hans","Stipe");

		kunde1.strasseProperty().setValue("musterstrasse");
		kunde1.plzProperty().setValue(3000);
		kunde1.ortProperty().setValue("Hamburg");
		kunde1.emailProperty().setValue("Muster@mail.com");
		kunde1.kundeseitProperty().setValue(LocalDate.of(2001, 12, 18));
		kundenListe.add(kunde1);
		
		KundenModel kunde2 = new KundenModel("Meier","stjepan");

		kunde1.strasseProperty().setValue("musterstrasse1233");
		kunde1.plzProperty().setValue(3000);
		kunde1.ortProperty().setValue("Baseö");
		kunde1.emailProperty().setValue("Musterste@mail.com");
		kunde1.kundeseitProperty().setValue(LocalDate.of(3000, 12, 18));
		kundenListe.add(kunde2);
		
		KundenModel kunde3 = new KundenModel("Mensch","stje");

		kunde1.strasseProperty().setValue("bachstrasse12");
		kunde1.plzProperty().setValue(3312);
		kunde1.ortProperty().setValue("hessen");
		kunde1.emailProperty().setValue("Muster12@mail.com");
		kunde1.kundeseitProperty().setValue(LocalDate.of(2001, 12, 12));
		kundenListe.add(kunde3);
		tblKunde.setItems(kundenListe);
	}

	@FXML
	private void initialize() {
		colvorname.setCellValueFactory((cellData) -> cellData.getValue().vornameProperty());
		colnachname.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
		tblKunde.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue) -> showDetails(newValue) );
	}
	
	@FXML
	private void showDetails(KundenModel kunde) {
		
		lblVorname.setText(kunde.vornameProperty().getValue());
		lblNachname.setText(kunde.nachnameProperty().getValue());
	}
}
