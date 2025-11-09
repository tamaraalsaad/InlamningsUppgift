package morse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseTranslatorTest {
    private final MorseTranslator tr = new MorseTranslator();

    @Test
    void text_till_morse_HEJ() throws IllegalAccessException {
        assertEquals(".... . .---", tr.textToMorse("HEJ"));
    }

    @Test
    void morse_till_text_HEJ() throws IllegalAccessException {
        assertEquals("HEJ", tr.MorseToText(".... . .---"));
    }

    @Test
    void text_mellanslag_innoreras() throws IllegalAccessException {
        assertEquals(tr.textToMorse("HELLO"), tr.textToMorse("HEL LO"));
    }

    @Test
    void stora_och_små_bokstäver_behandlas_lika()throws IllegalAccessException {
        assertEquals(tr.textToMorse("HELLO"), tr.textToMorse("hello"));
    }

    @Test
    void tom_text_kastar_excption() {
        assertThrows(IllegalArgumentException.class, () -> {
            tr.morseToText(" ");
        });
    }

    @Test
    void testOgiltigMoresKod() {
        assertThrows(IllegalArgumentException.class, () -> {
            tr.morseToText("----");
        });


    }
}





