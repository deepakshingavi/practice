import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CurlCall {

    public static void main(String[] args) throws IOException {
        // "curl -X PATCH -d '{\"title\":\"food\"}' https://jsonplaceholder.typicode.com/posts/1"
        String curlStr = "curl -H \"Authorization: token xxxxxxxxxx\" -X PATCH -d '{\"title\":\"food\"}' https://jsonplaceholder.typicode.com/posts/1";
        Process proc = Runtime.getRuntime().exec(curlStr);
        InputStream inputStream = proc.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;

        while ((line = br.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            System.out.println("Line entered : " + line);
        }

        System.out.println(proc.exitValue());
    }
}
