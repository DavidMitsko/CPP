package Zoo;

import javafx.scene.control.Label;

public class Ostrich extends Bird {

	public Ostrich(boolean wings, int body) {
		super(wings, body);
	}

	public String eating(Label textField) {
		String ostrichEat = "Ostrich thanks you for the food";
		textField.setText(ostrichEat);
		return ostrichEat;
	}
	
	public void getInfo(Label textField) {
		if(wings == true)
			textField.setText("This ostrich weighs " + body + "kg. She has wings.");
		else
			textField.setText("This ostrich has " + body + "kg. She hasn't wings.");
	}
}
