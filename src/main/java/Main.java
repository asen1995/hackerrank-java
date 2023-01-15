import datastructures.DataStructureChallenges;

public class Main {

	public static void main(String[] args) {

		Class c = Main.class;
		System.out.println(c.getClassLoader());

		System.out.println(DataStructureChallenges.class.getClassLoader());
		System.out.println(Object.class.getClassLoader());
	}

}
