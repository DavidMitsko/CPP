package Zoo;

import javafx.scene.control.Label;

public class Elephant extends Mammal {
	private double trunk;
	
	public Elephant(int paws, int body, double trunk) {
		super(paws, body);
		this.trunk = trunk;
	}
	
	public String eating(Label textField) {
		String elefantEat = "Elephant thanks you for the food";
		textField.setText(elefantEat);
		return elefantEat;
	}
	
	public void getInfo(Label textField) {
		textField.setText("This elephant weighs " + body + "kg. He has paws, in quantity " 
				+ paws + ". And her trunk is " + trunk + "m long");
	}

}
