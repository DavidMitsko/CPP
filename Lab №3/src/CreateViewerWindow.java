import Zoo.Viewer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class CreateViewerWindow {

	public void display(Stage primaryStage, Viewer viewer) throws NullPointerException {
		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 360, 130);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(7);

		for (int i = 0; i < 2; i++) {
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100 / 3.0);
			column.setHgrow(Priority.ALWAYS);
			gridpane.getColumnConstraints().add(column);
		}

		ObservableList<String> langs = FXCollections.observableArrayList("", "Ostrich", "Flamingo", "Elephant", "Tiger");
		ComboBox<String> langsComboBox = new ComboBox<String>(langs);
		langsComboBox.setValue("");
		langsComboBox.setTooltip(new Tooltip("Choose who you want to look at!"));
		gridpane.add(langsComboBox, 1, 0);

		Button watch = new Button("Watch");
		gridpane.add(watch, 1, 1);

		Label info = new Label();
		info.setWrapText(true);
		gridpane.add(info, 0, 2, 3, 1);

		watch.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String choice = new String();
				choice = langsComboBox.getValue();
				try {
				if("".equals(choice)) {
					throw new NotChoiceException(null);
				}
				} catch (NotChoiceException n) {
					Alert alert = new Alert(Alert.AlertType.ERROR);

					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("You haven't selected anything!");

					alert.showAndWait();
				}
				if ("Ostrich".equals(choice)) {
					viewer.lookAtAnimal(choice, info);
				}
				if ("Flamingo".equals(choice)) {
					viewer.lookAtAnimal(choice, info);
				}
				if ("Elephant".equals(choice)) {
					viewer.lookAtAnimal(choice, info);
				}
				if ("Tiger".equals(choice)) {
					viewer.lookAtAnimal(choice, info);
				}
			}
		});

		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
