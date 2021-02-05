import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {

    public static void main(String[] args) throws IOException {

        try(FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            FileOutputStream fos = new FileOutputStream("src/main/resources/config.properties");) {
            Properties props = new Properties();
            props.load(fis);
            String maxHolidays = props.getProperty("maxHolidays");
            System.out.println(maxHolidays);
            props.setProperty("maxHolidays", "20");
            props.store(fos, "");
            maxHolidays = props.getProperty("maxHolidays");
            System.out.println(maxHolidays);
        } catch (IOException eoe){
            System.out.println(eoe.getMessage());
        }
    }
}
