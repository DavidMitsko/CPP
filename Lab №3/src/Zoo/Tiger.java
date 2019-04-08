package Zoo;

import javafx.scene.control.Label;

public class Tiger extends Mammal {
	public int stripes;
	
	public Tiger(int stripes, int paws, int body) {
		super (paws, body);
		this.stripes = stripes;
	}

	public String eating(Label textField) {
		String tigerEat = "Tiger thanks you for the food";
		textField.setText(tigerEat);
		return tigerEat;
	}

	public void getInfo(Label textField) {
		textField.setText("This elefant weighs " + body + "kg. He has paws, in quantity " 
				+ paws + ". And he has " + stripes + " stripes.");
	}
}
