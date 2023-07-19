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

	public static void setCountry(String country) {
		Person.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// getters and setters
}
