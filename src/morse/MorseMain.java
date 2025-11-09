package morse;

import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        MorseTranslator translator=new MorseTranslator();
        System.out.println("  Morse ↔ Text översättare");
        System.out.println("1.Text till Morse");
        System.out.println("2.Morse till Text");
        System.out.println("Välj(1 eler 2)");
        String val=scan.nextLine();
        try {
            if (val.equals("1")) {
                System.out.println("Skriv in text(A-Z):");
                String text = scan.nextLine();
                String mores = translator.textToMorse(text);
                System.out.println("Morsekod:" + mores);
            } else if (val.equals("2")) {
                System.out.println("Skriva in morsekod(separera bokstäver med mellanslag ):");
                String mores = scan.nextLine();
                String text = translator.MorseToText(mores);
                System.out.println("Text:" + text);
            } else {
                System.out.println("Fel : Du måsta välja 1 eller 2");
            }
        } catch (IllegalArgumentException ill){
            System.out.println("Ett fel uppstod:"+ill.getMessage());

        } catch (Exception e) {
            System.out.println("Ett fel uppstod :"+ e.getMessage());
        }
        System.out.println("Programmet är klart.Tack");
    }
}
