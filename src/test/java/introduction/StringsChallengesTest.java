package introduction;

import org.junit.Test;

import junit.framework.Assert;

public class StringsChallengesTest {

	
	@Test
	public void isAnagram() {
		Assert.assertTrue(StringsChallenges.isAnagram("Hello", "hello"));
		Assert.assertTrue(StringsChallenges.isAnagram("cat", "cat"));
		Assert.assertFalse(StringsChallenges.isAnagram("cat6", "cat"));		
		
	}
	
//	@Test
//	public void getSmallestAndLargest() {
//		String smallestAndLargest = StringsChallenges.getSmallestAndLargest("welcometojava", 3);
//		Assert.assertTrue(smallestAndLargest.isEmpty());
//	}
}
