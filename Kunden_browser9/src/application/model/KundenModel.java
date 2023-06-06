package application.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class KundenModel {
	
	private SimpleStringProperty vorname = new SimpleStringProperty();
	private SimpleStringProperty nachname = new SimpleStringProperty();
	private SimpleStringProperty strasse = new SimpleStringProperty();
	private SimpleIntegerProperty plz = new SimpleIntegerProperty();
	
	private SimpleStringProperty ort = new SimpleStringProperty();
	private SimpleStringProperty email = new SimpleStringProperty();
	
	private SimpleObjectProperty<LocalDate> kundeseit = new SimpleObjectProperty<LocalDate>();
	private SimpleBooleanProperty newsletter = new SimpleBooleanProperty();
	
	
		
	public SimpleStringProperty vornameProperty() {
		return vorname;
	}
	
	public SimpleStringProperty nachnameProperty() {
		return nachname;
		
	}
	
	public SimpleStringProperty strasseProperty() {
		return strasse;
	}
	
	public SimpleIntegerProperty plzProperty() {
		return plz;
	}
	
	public SimpleStringProperty ortProperty() {
		return ort;
	}
	
	public SimpleStringProperty emailProperty() {
		return email;
	}
	
	public SimpleObjectProperty<LocalDate> kundeseitProperty(){
		return kundeseit;
	}
	public SimpleBooleanProperty newsletterProperty() {
		return newsletter;
	}
	
	
	public KundenModel() {
		
	}
	
	public KundenModel(String vorname, String nachname) {
		this.vorname.setValue(vorname);
		this.nachname.setValue(nachname);
	}
	
}
