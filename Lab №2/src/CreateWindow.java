import Zoo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class CreateWindow {

	public CreateWindow(Stage primaryStage, Worker employee, Ostrich camelBird, Elefant bishop) {

		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 120);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(7);

		for (int i = 0; i < 1; i++) {
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100 / 2.0);
			column.setHgrow(Priority.ALWAYS);
			gridpane.getColumnConstraints().add(column);
		}

		RadioButton ostrichFood = new RadioButton("Feed an ostrich");
		RadioButton elefantFood = new RadioButton("Feed an elefant");

		ToggleGroup groupFood = new ToggleGroup();
		ostrichFood.setToggleGroup(groupFood);
		elefantFood.setToggleGroup(groupFood);

		gridpane.add(ostrichFood, 0, 0);
		gridpane.add(elefantFood, 0, 1);

		Button feed = new Button("Feed");
		gridpane.add(feed, 0, 2);

		Label thanksFood = new Label();
		thanksFood.setWrapText(true);
		gridpane.add(thanksFood, 0, 3);

		feed.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				RadioButton selection = (RadioButton) groupFood.getSelectedToggle();
				if (selection.getText().equals("Feed an ostrich")) {
					employee.feed("Ostrich", thanksFood, camelBird, bishop);
				}
				if (selection.getText().equals("Feed an elefant"))
					employee.feed("Elefant", thanksFood, camelBird, bishop);
			}
		});
		
		RadioButton ostrichCage = new RadioButton("Clean the cage of an ostrich");
		RadioButton elefantCage = new RadioButton("Clean the cage of an elephant");

		ToggleGroup groupCage = new ToggleGroup();
		ostrichCage.setToggleGroup(groupCage);
		elefantCage.setToggleGroup(groupCage);

		gridpane.add(ostrichCage, 1, 0);
		gridpane.add(elefantCage, 1, 1);

		Button clean = new Button("Clean");
		gridpane.add(clean, 1, 2);

		Label thanksCage = new Label();
		thanksCage.setWrapText(true);
		gridpane.add(thanksCage, 1, 3);

		clean.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				RadioButton selection = (RadioButton) groupCage.getSelectedToggle();
				if (selection.getText().equals("Clean the cage of an ostrich")) {
					employee.tidy("Ostrich", thanksCage);
				}
				if (selection.getText().equals("Clean the cage of an elephant"))
					employee.tidy("Elefant", thanksCage);
			}
		});

		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
