public class NumToWord {

    public static void main(String[] args) {
        numberToWords(100);
    }

    public static final String[] numToWord = new String[10];
    static {
        numToWord[0]="Zero";
        numToWord[1]="One";
        numToWord[2]="Two";
        numToWord[3]="Three";
        numToWord[4]="Four";
        numToWord[5]="Five";
        numToWord[6]="Six";
        numToWord[7]="Seven";
        numToWord[8]="Eight";
        numToWord[9]="Nine";
    }
    public static void numberToWords(int number) {
        String numberStr = number + "";
        for (char a: numberStr.toCharArray()) {
            String word = numToWord[Integer.parseInt(a+"")];
            if(null!=word) {
                System.out.println(word);
            }
        }
    }
}
