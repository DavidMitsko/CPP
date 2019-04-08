package Zoo;

public abstract class Bird extends Animal {
	protected boolean wings;
	
	public Bird(boolean wings, int body) {
		super (body);
		this.wings = wings;
	}

}
