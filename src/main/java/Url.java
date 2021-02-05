
public class Url {

    public static void main(String[] args) {
        String url = "https://www.instagram.com/p/CANseIqFMnf/";
        String name = java.nio.file.Paths.get(url).getFileName().toString();
        System.out.println(name);
    }
}
