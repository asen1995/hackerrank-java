package introduction;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Test.None;

import junit.framework.Assert;

public class StringsChallengesTest {

	
	@Test
	public void isAnagram() {
		Assert.assertTrue(StringsChallenges.isAnagram("Hello", "hello"));
		Assert.assertTrue(StringsChallenges.isAnagram("cat", "cat"));
		Assert.assertFalse(StringsChallenges.isAnagram("cat6", "cat"));		
		
	}
	
	//expecting to not throw exception
	@Test(expected = None.class)
	public void splitStringIntoTokens() {
		StringsChallenges.splitStringIntoTokens("He is a very very good boy, isn't he?");		
	}
	
	
	
	
	//expecting to not throw exception
	@Test(expected = None.class)
	public void isItAValidPattern() {
		String first = "([A-Z])(.+)";
		String second  ="[AZ[a-z](a-z)";
		String third  ="batcatpat(nat";
		StringsChallenges.isItAValidPattern(Arrays.asList(first,second,third));
	}
	
	
//	@Test
//	public void getSmallestAndLargest() {
//		String smallestAndLargest = StringsChallenges.getSmallestAndLargest("welcometojava", 3);
//		Assert.assertTrue(smallestAndLargest.isEmpty());
//	}
}
