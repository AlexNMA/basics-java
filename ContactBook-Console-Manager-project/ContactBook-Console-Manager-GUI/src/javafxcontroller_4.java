import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class javafxcontroller_4 {
	ContactRepositoryInDataBase contactRepository = new ContactRepositoryInDataBase();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnok;

	@FXML
	private TextField textFiledAge;

	@FXML
	private TextField textFiledId;

	@FXML
	private TextField textFiledName;

	@FXML
	void sendButtonNewWindowOKClicked(ActionEvent event) {
		TextField nameField = textFiledName;
		TextField ageField = textFiledAge;
		TextField idField = textFiledId;
		String name = nameField.getText();
		int age = Integer.parseInt(ageField.getText());
		int id = Integer.parseInt(idField.getText());
		Contact contact = new Contact(id, name, age);
		try {
			contactRepository.removeFromDataBase(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stage stage = (Stage) btnok.getScene().getWindow();

		stage.close();
	}

	@FXML
	void initialize() {
		assert btnok != null : "fx:id=\"btnok\" was not injected: check your FXML file 'javafx_3.fxml'.";
		assert textFiledAge != null : "fx:id=\"textFiledAge\" was not injected: check your FXML file 'javafx_3.fxml'.";
		assert textFiledId != null : "fx:id=\"textFiledId\" was not injected: check your FXML file 'javafx_3.fxml'.";
		assert textFiledName != null
				: "fx:id=\"textFiledName\" was not injected: check your FXML file 'javafx_3.fxml'.";

	}

}
