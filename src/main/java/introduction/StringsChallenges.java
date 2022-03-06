package introduction;

public class StringsChallenges {

	
	//examples of ANAGRAM is   CAT = ACT , elbow = below
	static boolean isAnagram(String a, String b) {

		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}

		if (a.length() != b.length()) {
			return false;
		}

		StringBuilder builder = new StringBuilder(b);

		for (int i = 0; i < a.length(); i++) {
			String letter = String.valueOf(a.charAt(i));			
			int indexOfLetterInsideStringBuilder = builder.indexOf(letter);
			if(indexOfLetterInsideStringBuilder != -1) {
				builder.deleteCharAt(indexOfLetterInsideStringBuilder);
			}else {
				return false;
			}
			
		}
		return true;
	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		int lenght = 0;

		smallest = s.substring(lenght, lenght + k);
		lenght++;

		while ((lenght + k) < s.length() - 1) {
			String secondStringForCompare = s.substring(lenght, lenght + k);
			if (secondStringForCompare.compareTo(smallest) < 0) { // smaller
				smallest = secondStringForCompare;
			}
			lenght++;
		}
		// Complete the function
		// 'smallest' must be the lexicographically smallest substring of length 'k'
		// 'largest' must be the lexicographically largest substring of length 'k'

		return smallest + "\n" + largest;
	}

}
