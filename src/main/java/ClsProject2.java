import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;   //imports the java scanner class


public class ClsProject2 {
    static Scanner srcUserInput = new Scanner(System.in); //creates a new scanner
    static int ROWS = 24;
    static int COLUMNS = 7;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        System.out.println("Are your files local or external?: ");

        String strFileLocation = srcUserInput.nextLine();
        strFileLocation.equalsIgnoreCase(strFileLocation);
        String strFileName = "";
        if (strFileLocation.equals("external")) {

            System.out.println("Please provide directory to loanamounts.txt: ");
            String strDirectory = srcUserInput.nextLine();
            strFileName = (strDirectory + "/loanamounts.txt");
            read_data(strFileName);


        } else {
            strFileName = "src/main/resources/loanamounts.txt";
            read_data(strFileName);


        }


    }

    public static float[][] read_data(String strFileName) {
        float[][] fileread = new float[ROWS][COLUMNS];
        File filedata = new File(strFileName);
        try {
            Scanner fileReader = new Scanner(filedata);


            System.out.println(fileReader.nextLine());


            for (int rowCounter = 0; rowCounter < 23; ) {

                System.out.println(fileReader.next());
                System.out.println(fileReader.next());

                for (int counter = 0; counter < 7; ) {


                    fileread[rowCounter][counter] = fileReader.nextFloat();


                    counter++;

                }

                rowCounter++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
        return fileread;
    }
}