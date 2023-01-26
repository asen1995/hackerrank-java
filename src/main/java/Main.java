public class Main {

	public static void main(String[] args) {


		final int n = 100000;

		long start = System.currentTimeMillis();

		String string = "a";
		for(int i = 0; i< n; i++) {
			string = string + "a";
		}

		long end = System.currentTimeMillis();
		System.out.println("String concatenation took " + (end-start) + " ms");



		String formatString = "a%s";

		start = System.currentTimeMillis();

		for(int i = 0; i< n; i++) {
			formatString = String.format(formatString, "a%s");
		}

		end = System.currentTimeMillis();

		System.out.println("String format took " + (end-start) + " ms");


		StringBuilder sb = new StringBuilder("a");
		start = System.currentTimeMillis();

		for(int i = 0; i< n; i++) {
			sb.append("a");
		}

		end = System.currentTimeMillis();
		System.out.println("StringBuilder took " + (end-start) + " ms");

	}
}
