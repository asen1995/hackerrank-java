package introduction;

import org.junit.Test;

import junit.framework.Assert;

public class StringsChallengesTest {

	
//	@Test
//	public void isAnagram() {
//		Assert.assertFalse(StringsChallenges.isAnagram("Hello", "hello"));
//	}
	
	@Test
	public void getSmallestAndLargest() {
		String smallestAndLargest = StringsChallenges.getSmallestAndLargest("welcometojava", 3);
		Assert.assertTrue(smallestAndLargest.isEmpty());
	}
}
