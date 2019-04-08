package Zoo;

import java.util.HashMap;

public class Zoo {

	private Worker employee;
	private HashMap<String, Animal> beast;

	public Zoo(Worker someEmployee, HashMap<String, Animal> beast) {
		this.employee = someEmployee;
		this.beast = beast;
	}
	
	public void setAnimal(Animal animal, String type) {
		beast.put(type, animal);
	}
	
	public Animal receiveVisitor(String beast) {
		return giveAnimal(beast);
	}
	
	private Animal giveAnimal(String animal) {
		return beast.get(animal);
	}
}
