package introduction;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "([A-Z])(.+)";
		String second  ="[AZ[a-z](a-z)";
		String third  ="batcatpat(nat";
		StringsChallenges.isItAValidPattern(Arrays.asList(first,second,third));
		
	}

}
