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

    public String textToMorse(String text) {
        String result = "";
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') continue;
            String morse = TEXT_To_MORSE.get(c);
            if (morse == null) {
                return "Fel: Endast bokstäver A-Z ";
            }
            if (!result.isEmpty()) {
                result += " ";
            }
            result +=morse;
        }return result;
    }
    public String MorseToText(String mores){
        if (mores == null) return "Fel: Okänd morsekod ''";
        mores = mores.trim();
        if (mores.isEmpty()) return "Fel: Okänd morsekod ''";
        String result = "";
        String[] parts = mores.split("\\s+");

        for (String code : parts) {
            for (int i = 0; i < code.length(); i++) {
                char ch = code.charAt(i);
                if (ch != '.' && ch != '-') {
                    return "Fel: Okänd morsekod '" + code + "'";
                }
            }

            Character letter = MORSE_TO_TEXT.get(code);
            if (letter == null) {
                return "Fel: Okänd morsekod '" + code + "'";
            }
            result += letter;
        }

        return result;

    }
}
