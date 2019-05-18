package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		CreateWindow window = new CreateWindow();
		window.display(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
