package Zoo;

import javafx.scene.control.Label;

public class Flamingo extends Bird {
	
	public Flamingo(boolean wings, int body) {
		super(wings, body);
	}
	
	public String eating(Label textField) {
		String flamingoEat = "Flamingo thanks you for the food";
		textField.setText(flamingoEat);
		return flamingoEat;
	}
	
	public void fly() {
		
	}
	
	public void getInfo(Label textField) {
		if(wings == true)
			textField.setText("This flamingo weighs " + body + "kg. She has wings.");
		else
			textField.setText("This flamingo weighs " + body + ". She hasn't wings.");
	}

}
