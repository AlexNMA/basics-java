import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class javafxcontroller {
	Console console = System.console();
	ContactRepositoryInDataBase contactRepository = new ContactRepositoryInDataBase();
	boolean removeAgreement = false;
	boolean redirected = false;
	Scanner input = new Scanner(System.in);

	@FXML
	public TableView<Contact> tableView = new TableView<Contact>();
	@FXML
	public TableColumn<Contact, String> tableColumnName;
	@FXML
	public TableColumn<Contact, Integer> tableColumnAge;
	@FXML
	public TableColumn<Contact, Integer> tableColumnID;

	public javafxcontroller() {

	}

	@FXML
	public void refresh() {
		tableView.getItems().clear();
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColumnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		ArrayList<Contact> contacts = null;
		try {
			contacts = contactRepository.getAllContacts();
			for (Contact contact : contacts) {
				tableView.getItems().add(contact);
			}
			;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void btn1OKClicked(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoaderbtn = new FXMLLoader(getClass().getResource("javafx_2.fxml"));
		Parent root1 = (Parent) fxmlLoaderbtn.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();
	}

	@FXML
	public void btn2OKClicked(ActionEvent event) {
		refresh();
	}

	@FXML
	public void btn3OKClicked(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoaderbtn3 = new FXMLLoader(getClass().getResource("javafx_3.fxml"));
		Parent root2 = (Parent) fxmlLoaderbtn3.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root2));
		stage.show();

	}

	@FXML
	public void btn4OKClicked(ActionEvent event) throws IOException {

		int input = JOptionPane.showConfirmDialog(
				null, "To delete a contract write the contract id.\n"
						+ "To find out the contract id on the view page.\n" + 
						"You need to be update the viewing page?",
				"Select an Option...", JOptionPane.YES_NO_OPTION);
		if (input == 0) {
			refresh();
		}
		FXMLLoader fxmlLoaderbtn4 = new FXMLLoader(getClass().getResource("javafx_4.fxml"));
		Parent root3 = (Parent) fxmlLoaderbtn4.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root3));
		stage.show();

//		System.out.println("Write the id of the contract you want to delete");
//		int removeID = Integer.parseInt(console.readLine());
//		try {
//			System.out.println(
//					"Are you sure you want to delete " + contactRepository.getFromDataBase(removeID).getName() + " ?");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("yes = y, no = any key");
//		tempString = console.readLine();
//		if (tempString.equals(y)) {
//			removeAgreement = true;
//		}
//		if (!tempString.equals(y)) {
//			removeAgreement = false;
//		}
//		if (removeAgreement) {
//			try {
//				System.out.println(
//						contactRepository.getFromDataBase(removeID).getName() + " has been removed from the list");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				contactRepository.removeFromDataBase(removeID);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	}

	@FXML
	void initialize() {
		assert tableColumnAge != null
				: "fx:id=\"tableColumnAge\" was not injected: check your FXML file 'javafx.fxml'.";
		assert tableColumnID != null : "fx:id=\"tableColumnID\" was not injected: check your FXML file 'javafx.fxml'.";
		assert tableColumnName != null
				: "fx:id=\"tableColumnName\" was not injected: check your FXML file 'javafx.fxml'.";
		assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'javafx.fxml'.";

	}
}