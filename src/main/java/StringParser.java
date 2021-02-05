public class StringParser {

    public static void main(String[] args) {
        printAcronym("Hello World");
    }

    public static void printAcronym(String string){

        String[] strArray = string.split("\\s+"); // Create an Array ["Hello","World"]
        String acronym = "";
        new String();
        for(String newString:strArray) // Iterate over the array
            acronym = (String)acronym + newString.charAt(0); // Get the first character of your string and cocatenate it with null
        System.out.print(acronym);
    }
}
