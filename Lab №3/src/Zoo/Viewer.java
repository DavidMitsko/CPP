package Zoo;

import javafx.scene.control.Label;

public class Viewer {
	private Zoo zoo;
	
	public Viewer(Zoo zoo) {
		this.zoo = zoo;
	}
	
	public void lookAtAnimal(String animal, Label textField) {
		//Animal animal = new Animal();
		Animal beast = zoo.receiveVisitor(animal);
		beast.getInfo(textField);
	}
}
