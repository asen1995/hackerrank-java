package api;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

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

        final byte[] bytes = "something".getBytes(StandardCharsets.UTF_8);

        final byte[] expected = {115, 111, 109, 101, 116, 104, 105, 110, 103};

        for(byte i = 0 ; i < bytes.length ; i++){
            assertEquals(bytes[i], expected[i]);
        }


        assertEquals("something".toLowerCase(Locale.CHINA), "something");
        assertEquals("something".toLowerCase(Locale.ENGLISH), "something");

        assertEquals("something".toUpperCase(Locale.CHINA), "SOMETHING");
        assertEquals("something".toUpperCase(Locale.ENGLISH), "SOMETHING");
    }

}
