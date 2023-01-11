public class Main {

	public static void main(String[] args) {

		// asen   - nesa

		//

		// a
		// s + a
		// e + s + a
		// n + e + s + a

		String result = reverseString("asen");
		System.out.println(result);
	
	}


	public static String reverseString(String param){

		if(param.length() == 1){
			return param;
		}else {
			final String s = reverseString(param.substring(1, param.length()));
			return s.concat(String.valueOf(param.charAt(0)));
		}

		// e s a
		// sa
		// a


		//concat 1



	}

}
