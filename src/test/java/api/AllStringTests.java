package api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllStringTests {

    @Test
    public void allStringMethodsTest() {
        assertEquals("something".length(), 9);

        assertEquals("something".charAt(0), 's');
        assertEquals("something".charAt(1), 'o');
        assertEquals("something".charAt(2), 'm');

        assertEquals("something".substring(0, 3), "som");
        assertEquals("something".substring(3, 9), "ething");

        assertEquals("something".substring(3), "ething");
        assertEquals("something".substring(0), "something");
        assertEquals("something".substring(5), "hing");

    }

}
