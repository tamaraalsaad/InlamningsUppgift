package morse;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {
    private static final Map<Character, String> TEXT_To_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_TEXT = new HashMap<>();

    static {
        TEXT_To_MORSE.put('A', ".-");
        TEXT_To_MORSE.put('B', "-...");
        TEXT_To_MORSE.put('C', "-.-.");
        TEXT_To_MORSE.put('D', "-..");
        TEXT_To_MORSE.put('E', ".");
        TEXT_To_MORSE.put('F', "..-.");
        TEXT_To_MORSE.put('G', "--.");
        TEXT_To_MORSE.put('H', "....");
        TEXT_To_MORSE.put('I', "..");
        TEXT_To_MORSE.put('J', ".---");
        TEXT_To_MORSE.put('K', "-.-");
        TEXT_To_MORSE.put('L', ".-..");
        TEXT_To_MORSE.put('M', "--");
        TEXT_To_MORSE.put('N', "-.");
        TEXT_To_MORSE.put('O', "---");
        TEXT_To_MORSE.put('P', ".--.");
        TEXT_To_MORSE.put('Q', "--.-");
        TEXT_To_MORSE.put('R', ".-.");
        TEXT_To_MORSE.put('S', "...");
        TEXT_To_MORSE.put('T', "-");
        TEXT_To_MORSE.put('U', "..-");
        TEXT_To_MORSE.put('V', "...-");
        TEXT_To_MORSE.put('W', ".--");
        TEXT_To_MORSE.put('X', "-..-");
        TEXT_To_MORSE.put('Y', "-.--");
        TEXT_To_MORSE.put('Z', "--..");
        for (Character ch : TEXT_To_MORSE.keySet()) {
            String morse = TEXT_To_MORSE.get(ch);
            MORSE_TO_TEXT.put(morse, ch);

        }

    }

    public String textToMorse(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Du måste skriva in minst ett tecken!");
        }
        text = text.toUpperCase();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') continue;
            String code = TEXT_To_MORSE.get(c);
            if (code == null) {
                throw new IllegalArgumentException("Endast bokstäver A–Z är tillåtna!");
            }


            if (!result.isEmpty()) result += "";
            result += code;

        }
        return result;

    }


    public String morseToText(String morse) throws IllegalArgumentException {
        if (morse == null || morse.trim().isEmpty()) {
            throw new IllegalArgumentException("Du måste skriva in minst ett morsetecken!");

        }
        morse = morse.trim();
        String[] parts = morse.split("\\s+");
        String text = "";
        for (String code : parts) {
            for (char ch : code.toCharArray())
                if (ch != '.' && ch != '-') {

                    throw new IllegalArgumentException("Morse får bara innehålla punkt (.) och streck (-)!");
                }


            Character letter = MORSE_TO_TEXT.get(code);
            if (letter == null) {
                throw new IllegalArgumentException("Okäna morsekod" + code);
            }
            return text;


        }
        return text.toString();
    }

    public String MorseToText(String morse) throws IllegalArgumentException {
        return morseToText(morse);
    }
}


