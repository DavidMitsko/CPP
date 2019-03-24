package Zoo;

import javafx.scene.control.Label;

public class Animal {
	private String body;
	
	public Animal() {}
	
	public String eating(String animal, Label textField) {
		if (animal == null)
			System.exit(1);
		String ostrichEat = "Ostrich thanks you for the food";
		String elefantEat = "Elefant thanks you for the food";
		if (animal.equals("Ostrich")) {
			textField.setText(ostrichEat);
			return ostrichEat;
		}
		if (animal.equals("Elefant")) {
			textField.setText(elefantEat);
			return elefantEat;
		}
		return "The food did not get to the animals";
	}

}
