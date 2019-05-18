package GUI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Exception.*;
import Logic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class CreateWindow {

	public void display(Stage primaryStage) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		primaryStage.setResizable(false);
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 300, 200);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		for (int i = 0; i < 2; i++) {
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100 / 3.0);
			column.setHgrow(Priority.ALWAYS);
			gridpane.getColumnConstraints().add(column);
		}

		String fun = new String("f(x)=x^3-(7*x^2)/2-2*x+3/2");
		Label function = new Label("Your function: " + fun);
		gridpane.add(function, 0, 0, 3, 3);

		Label confines = new Label("Please, enter the confines for search!");
		gridpane.add(confines, 0, 2, 3, 3);

		Label from = new Label("From:");
		gridpane.add(from, 0, 4);
		Label to = new Label("To:");
		gridpane.add(to, 2, 4);
		Label min = new Label();
		gridpane.add(min, 0, 8, 3, 3);
		Label max = new Label();
		gridpane.add(max, 0, 10, 3, 3);

		TextField fromEnter = new TextField();
		gridpane.add(fromEnter, 0, 5);
		TextField toEnter = new TextField();
		gridpane.add(toEnter, 2, 5);

		Button check = new Button("Check");
		gridpane.add(check, 1, 6, 1, 1);

		check.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					if (fromEnter.getText().equals("")) {
						throw new EmptyStringException("Error");
					}
					if (toEnter.getText().equals("")) {
						throw new EmptyStringException("Error");
					}
					FindExtremes find = new FindExtremes(Integer.parseInt(fromEnter.getText()),
							Integer.parseInt(toEnter.getText()));
					find.count();
					Point locMin = new Point();
					Point locMax = new Point();
					String minimum = new String();
					String maximum = new String();

					locMin = find.locMin();
					Future<String>  thread1 = executor.submit(new Check(locMin, Integer.parseInt(fromEnter.getText()),
							Integer.parseInt(toEnter.getText())));
					locMax = find.locMax();
					Future<String> thread2 = executor.submit(new Check(locMax, Integer.parseInt(fromEnter.getText()),
							Integer.parseInt(toEnter.getText())));

					minimum = thread1.get();
					maximum = thread2.get();
					min.setText(minimum);
					max.setText(maximum);
				} catch (NumberFormatException f) {
					exception("Incorrect input");
				} catch (EmptyStringException d) {
					exception("Empty string");
				} catch (Exception t) {
					exception("Error");
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
