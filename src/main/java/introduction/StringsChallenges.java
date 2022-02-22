package introduction;

public class StringsChallenges {

	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;

		int value = 0;
		for (int i = 0; i < a.length(); i++) {
			value += ((int) a.charAt(i)) ^ 2;
			value -= ((int) b.charAt(i)) ^ 2;
		}
		return value == 0;
	}

	
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }
	
}
