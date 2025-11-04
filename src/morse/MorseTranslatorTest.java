package morse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MorseTranslatorTest{
    private final MorseTranslator tr=new MorseTranslator();
    @Test
    void text_till_morse_HEJ(){
        assertEquals(".... . .---",tr.textToMorse("HEJ"));
    }
    @Test
    void morse_till_text_HEJ(){
        assertEquals("HEJ",tr.MorseToText(".... . .---"));
    }
    @Test
    void text_mellanslag_innoreras(){
        assertEquals(tr.textToMorse("HELLO"),tr.textToMorse("HEL LO"));
    }
    @Test
    void stora_och_små_bokstäver_behandlas_lika(){
        assertEquals(tr.textToMorse("HELLO"),tr.textToMorse("hello"));
    }
    @Test
    void tom_text_kastar_excption() {
        try {
            tr.textToMorse("  ");
        } catch (IllegalArgumentException ill) {
            String expected = "Du måste skriva in minst ett teken!";
            assertEquals(expected, ill.getMessage());
        }
    }
      @Test
        void testOgiltigMoresKod(){
        try {tr.MorseToText("-----_-");
        }catch (IllegalArgumentException ill){
            String expected="Morse får bara innehålla punkt (.) och streck (-)!";
            assertEquals(expected,ill.getMessage());
        }

    }


    }
