import java.io.Serializable;

public class Person implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
