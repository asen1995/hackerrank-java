import java.io.Serializable;

public class Person implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	static String country = "ITALY";
	private transient int age;
	private transient String name;
	transient int height;


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	public String getName() {
		return name;
	}


	// getters and setters
}
