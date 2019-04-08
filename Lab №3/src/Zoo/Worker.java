package Zoo;

import java.util.HashMap;

import javafx.scene.control.Label;

public class Worker {
	private HashMap<String, Animal> beast;

	public Worker(HashMap<String, Animal> beast) {
		this.beast = beast;
	}

	public void feed(String animal, Label textField) {
		Animal buf = beast.get(animal);
		buf.eating(textField);
	}

	public void tidy(String animal, Label textField) {
		String elephantCage = "Elephant's cage removed";
		String ostrichCage = "Ostrich's cage removed";
		String tigerCage = "Tiger's cage removed";
		String flamingoCage = "Flamingo's cage removed";
		if ("Ostrich".equals(animal))
			textField.setText(ostrichCage);
		if ("Elephant".equals(animal))
			textField.setText(elephantCage);
		if ("Tiger".equals(animal)) 
			textField.setText(tigerCage);
		if ("Flamingo".equals(animal))
			textField.setText(flamingoCage);
	}

}
