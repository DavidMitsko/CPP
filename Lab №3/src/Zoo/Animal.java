package Zoo;

import javafx.scene.control.Label;

public abstract class Animal {
	protected int body;
	
	public Animal() {}
	
	public Animal(int body) {
		this.body = body;
	}
	
	public abstract String eating(Label textField);
	public abstract void getInfo(Label textField);

}
