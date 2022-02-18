package introduction;

import org.junit.Test;

import junit.framework.Assert;

public class StringsChallengesTest {

	
	@Test
	public void isAnagram() {
		Assert.assertFalse(StringsChallenges.isAnagram("Hello", "hello"));
		Assert.assertTrue(StringsChallenges.isAnagram("Asen", "asen"));
		Assert.assertFalse(StringsChallenges.isAnagram("Ivan", "ivana"));
	}
}
