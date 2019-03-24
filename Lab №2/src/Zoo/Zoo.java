package Zoo;

public class Zoo {

	private Worker employee;
	private Animal animal;

	public Zoo() {
		employee = new Worker();
		animal = new Animal();
	}

	public Worker getEmployee() {
		return this.employee;
	}

	public void setEmployee(Worker employee) {
		this.employee = employee;
	}

}
