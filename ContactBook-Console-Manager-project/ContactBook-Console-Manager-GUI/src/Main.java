import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(getClass().getClassLoader().getResource("/javafx.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("javafx.fxml"));
		Scene scene = new Scene(root, 470, 315);
		Stage stage = new Stage();
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}