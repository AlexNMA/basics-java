import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class javafxcontroller_2 {
	
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
    private TextField textFiledName;

    @FXML
    void sendButtonNewWindowOKClicked(ActionEvent event) {
		TextField nameField = textFiledName;
		TextField ageField = textFiledAge;
		String name = nameField.getText();
		int age = Integer.parseInt(ageField.getText());
		Contact contact = new Contact(name, age);
		try {
			contactRepository.addInDataBase(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) btnok.getScene().getWindow();
		stage.close();
    }

    @FXML
    void initialize() {
        assert btnok != null : "fx:id=\"btnok\" was not injected: check your FXML file 'javafx_2.fxml'.";
        assert textFiledAge != null : "fx:id=\"textFiledAge\" was not injected: check your FXML file 'javafx_2.fxml'.";
        assert textFiledName != null : "fx:id=\"textFiledName\" was not injected: check your FXML file 'javafx_2.fxml'.";

    }

}
