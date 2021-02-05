import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MorseCodeReader {

        public static void main(String[]arg) throws IOException
        {
            FileReader file = new FileReader("src/main/resources/morse.txt");
            Scanner sc = new Scanner(file);
            sc.useDelimiter(" ");
            Map<String,Character> morseCodeMap = new HashMap<>();
            while (sc.hasNextLine())
            {
                String morseCode = sc.nextLine();
                String[] tempArray = morseCode.split(" ");
                morseCodeMap.put(tempArray[1].trim(),tempArray[0].trim().charAt(0));
            }
            file.close();
            sc.close();

            System.out.println(morseCodeMap);

            int totalRow = 52;
            Scanner userInput = new Scanner(System.in);

            for (int f = 0; f < totalRow; f++) {
                System.out.println("Please type in what you want to say in Morse Code: ");
                String input = userInput.next();
                input = input.toUpperCase();
                if(morseCodeMap.containsKey(input)){
                    System.out.println(morseCodeMap.get(input));
                } else {
                    System.out.println("Invalid morse code");
                }

            }
            List ll = new ArrayList();
        }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
