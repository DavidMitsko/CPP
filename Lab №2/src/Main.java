
import Zoo.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Worker employee = new Worker();
		Ostrich camelBird = new Ostrich();
		Elefant bishop = new Elefant();
		CreateWindow window = new CreateWindow(primaryStage, employee, camelBird, bishop);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
