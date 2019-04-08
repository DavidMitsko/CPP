
import java.util.HashMap;

import Zoo.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Animal elephant = new Elephant(4, 6000, 1.5);
		Animal tiger = new Tiger(100, 4, 310);
		Animal flamingo = new Flamingo(true, 4);
		Animal ostrich = new Ostrich(true, 120);
		
		HashMap<String, Animal> map = new HashMap<String, Animal>();
		map.put("Elephant", elephant);
		map.put("Tiger", tiger);
		map.put("Flamingo", flamingo);
		map.put("Ostrich", ostrich);
		
		Worker employee = new Worker(map);
		Zoo zoo = new Zoo(employee, map);
		Viewer viewer = new Viewer(zoo);
		
		ChoiñeRoles window = new ChoiñeRoles();
		window.display(primaryStage, employee, viewer);
			
	}

	public static void main(String[] args) {
		launch(args);
	}
}
