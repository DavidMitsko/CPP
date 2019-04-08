package Zoo;

public abstract class Mammal extends Animal {
	protected int paws;
	
	public Mammal(int paws, int body) {
		super (body);
		this.paws = paws;
	}

}
