import Zoo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChoiñeRoles {

	public void display(Stage primaryStage, Worker employee, Viewer viewer) {
		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 100, 100);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(7);

		ObservableList<String> langs = FXCollections.observableArrayList("", "Employee", "Viewer");
		ComboBox<String> langsComboBox = new ComboBox<String>(langs);
		langsComboBox.setValue("");
		langsComboBox.setTooltip(new Tooltip("Choose what you do today in our zoo!"));
		gridpane.add(langsComboBox, 0, 0);

		Button rool = new Button("Choice");
		gridpane.add(rool, 0, 1);

		rool.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String choice = new String();
				choice = langsComboBox.getValue();
				try {
					if("".equals(choice)) {
						throw new NotChoiceException(null);
					}
				} catch (NotChoiceException notChoice) {
					Alert alert = new Alert(Alert.AlertType.ERROR);

					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("You haven't selected anything!");

					alert.showAndWait();
				}
				if ("Employee".equals(choice)) {
					CreateEmployeeWindow employeeWindow = new CreateEmployeeWindow();
					employeeWindow.display(primaryStage, employee);
				}
				if ("Viewer".equals(choice)) {
					CreateViewerWindow viewerWindow = new CreateViewerWindow();
					viewerWindow.display(primaryStage, viewer);
				}
			}
		});

		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
