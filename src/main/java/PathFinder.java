import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFinder {

    public static void main(String[] args) {
        String fileName = "abcd_04-04-2020.txt";
        Path filePath = Paths.get(fileName);
        if(filePath.endsWith("txt") || filePath.endsWith("txt.gz")){
            System.out.println(filePath.getFileName());
        }
    }
}
