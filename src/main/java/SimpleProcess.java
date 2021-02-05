import java.io.IOException;

public class SimpleProcess {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("ls");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
    }
}
