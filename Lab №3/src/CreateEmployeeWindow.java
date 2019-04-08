import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import Zoo.*;

public class CreateEmployeeWindow {

	public void display(Stage primaryStage, Worker employee) {
		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 420, 170);
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
		RadioButton elephantFood = new RadioButton("Feed an elephant");
		RadioButton flamingoFood = new RadioButton("Feed an flamingo");
		RadioButton tigerFood = new RadioButton("Feed an tiger");

		ToggleGroup groupFood = new ToggleGroup();
		ostrichFood.setToggleGroup(groupFood);
		elephantFood.setToggleGroup(groupFood);
		flamingoFood.setToggleGroup(groupFood);
		tigerFood.setToggleGroup(groupFood);
		gridpane.add(ostrichFood, 0, 0);
		gridpane.add(flamingoFood, 0, 1);
		gridpane.add(elephantFood, 0, 2);
		gridpane.add(tigerFood, 0, 3);

		Button feed = new Button("Feed");
		gridpane.add(feed, 0, 4);

		Label thanksFood = new Label();
		thanksFood.setWrapText(true);
		gridpane.add(thanksFood, 0, 5);

		feed.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					RadioButton selection = (RadioButton) groupFood.getSelectedToggle();
					if ("Feed an ostrich".equals(selection.getText())) {
						try {
							employee.feed("Ostrich", thanksFood);
						} catch (NullPointerException emptyString) {
							exception("You have problem witch string");
						}
					}
					if (selection.getText().equals("Feed an elephant")) {
						try {
							employee.feed("Elephant", thanksFood);
						} catch (NullPointerException emptyString) {
							exception("You have problem witch string");
						}
					}
					if (selection.getText().equals("Feed an flamingo")) {
						try {
							employee.feed("Flamingo", thanksFood);
						} catch (NullPointerException emptyString) {
							exception("You have problem witch string");
						}
					}
					if (selection.getText().equals("Feed an tiger")) {
						try {
							employee.feed("Tiger", thanksFood);
						} catch (NullPointerException emptyString) {
							exception("You have problem witch string");
						}
					}
				} catch (NullPointerException notChoise) {
					exception("You haven't selected anything!");
				}
			}
		});

		RadioButton ostrichCage = new RadioButton("Clean the cage of an ostrich");
		RadioButton elefantCage = new RadioButton("Clean the cage of an elephant");
		RadioButton flamingoCage = new RadioButton("Clean the cage of an flamingo");
		RadioButton tigerCage = new RadioButton("Clean the cage of an tiger");

		ToggleGroup groupCage = new ToggleGroup();
		ostrichCage.setToggleGroup(groupCage);
		elefantCage.setToggleGroup(groupCage);
		flamingoCage.setToggleGroup(groupCage);
		tigerCage.setToggleGroup(groupCage);

		gridpane.add(ostrichCage, 1, 0);
		gridpane.add(flamingoCage, 1, 1);
		gridpane.add(elefantCage, 1, 2);
		gridpane.add(tigerCage, 1, 3);

		Button clean = new Button("Clean");
		gridpane.add(clean, 1, 4);

		Label thanksCage = new Label();
		thanksCage.setWrapText(true);
		gridpane.add(thanksCage, 1, 5);

		clean.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					RadioButton selection = (RadioButton) groupCage.getSelectedToggle();
					if (selection.getText().equals("Clean the cage of an ostrich")) {
						try {
							employee.tidy("Ostrich", thanksCage);
						} catch (NullPointerException emptyString) {
							exception("You have problem with string");
						}
					}
					if (selection.getText().equals("Clean the cage of an flamingo")) {
						try {
							employee.tidy("Flamingo", thanksCage);
						} catch (NullPointerException emptyString) {
							exception("You have problem with string");
						}
					}
					if (selection.getText().equals("Clean the cage of an elephant")) {
						try {
							employee.tidy("Elephant", thanksCage);
						} catch (NullPointerException emptyString) {
							exception("You have problem with string");
						}
					}
					if (selection.getText().equals("Clean the cage of an tiger")) {
						try {
							employee.tidy("Tiger", thanksCage);
						} catch (NullPointerException emptyString) {
							exception("You have problem with string");
						}
					}
				} catch (NullPointerException notChoise) {
					exception("You haven't selected anything!");
				}
			}
		});

		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void exception(String txt) {
		Alert alert = new Alert(Alert.AlertType.ERROR);

		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(txt);

		alert.showAndWait();
	}
}
