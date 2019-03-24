package Zoo;

import javafx.scene.control.Label;

public class Worker {

	//private Animal beast;

	public Worker() {
		//beast = new Animal();
	}

	public void feed(String animal, Label textField, Ostrich camelBird, Elefant bishop) {
		if (animal.equals(null))
			System.exit(1);
		if (animal.equals("Ostrich"))
			camelBird.eating(animal, textField);
		if (animal.equals("Elefant"))
			bishop.eating(animal, textField);
	}

	public void tidy(String animal, Label textField) {
		if (animal.equals(null))
			System.exit(1);
		String elefantCage = "Elephant's cage removed";
		String ostrichCage = "Ostrich's cage removed";
		if (animal.equals("Ostrich"))
			textField.setText(ostrichCage);
		if (animal.equals("Elefant"))
			textField.setText(elefantCage);

	}

}
