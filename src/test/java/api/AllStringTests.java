package api;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.junit.Assert.*;

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
        assertEquals("something".substring(5), "hing");

        final byte[] bytes = "something".getBytes(StandardCharsets.UTF_8);

        final byte[] expected = {115, 111, 109, 101, 116, 104, 105, 110, 103};

        for(byte i = 0 ; i < bytes.length ; i++){
            assertEquals(bytes[i], expected[i]);
        }


        assertEquals("something".toLowerCase(Locale.CHINA), "something");
        assertEquals("something".toLowerCase(Locale.ENGLISH), "something");

        assertEquals("something".toUpperCase(Locale.CHINA), "SOMETHING");
        assertEquals("something".toUpperCase(Locale.ENGLISH), "SOMETHING");

        //split example
        final String[] split = "something".split("e");
        assertEquals(split[0], "som");
        assertEquals(split[1], "thing");

        //replace example
        assertEquals("something".replace("e", "a"), "somathing");
        assertEquals("something".replace("e", ""), "somthing");

        //endsWith example
        assertTrue("something".endsWith("ing"));
        assertFalse("something".endsWith("ingg"));

        //contains example
        assertTrue("something".contains("ing"));
        assertFalse("something".contains("ingg"));

        // isEmpty example
        assertEquals("something".isEmpty(), false);
        assertEquals("".isEmpty(), true);


        // compareTo example
        assertEquals("something".compareTo("something"), 0);
        assertEquals("something".compareTo("somethin"), 1);
        assertEquals("something".compareTo("somethingg"), -1);

        // matches example

        assertTrue("asen.nikolaev95@gmail.com".matches(".*@.*"));
        assertTrue("something".matches(".*thing"));
        assertFalse("something".matches(".*thingg"));



    }

}
