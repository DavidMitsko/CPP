package Zoo;

import javafx.scene.control.Label;

public class Worker {

	private Animal beast;

	public Worker(Animal someBeast) {
		this.beast = someBeast;
	}

	public void feed(String animal, Label textField) {
		if (animal.equals(null))
			System.exit(1);
		if (animal.equals("Ostrich"))
			beast.eating(animal, textField);
		if (animal.equals("Elefant"))
			beast.eating(animal, textField);
	}

	public String tidy(String animal) {
		if (animal.equals(null))
			System.exit(1);
		String elefantCage = "Elephant's cage removed";
		String ostrichCage = "Ostrich's cage removed";
		if (animal.equals("Ostrich"))
			return ostrichCage;
		if (animal.equals("Elefant"))
			return elefantCage;
		return "You don't clean cage";

	}

}
