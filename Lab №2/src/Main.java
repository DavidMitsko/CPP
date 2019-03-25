
import Zoo.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Animal animal = new Animal();
		Worker employee = new Worker(animal);
		CreateWindow window = new CreateWindow();
		window.display(primaryStage, employee);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
